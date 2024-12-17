package webdriver.componentes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static webdriver.fabrica.FabricaDeDriver.getDriver;

/**
 * Classe responsável por gerenciar as esperas em testes automatizados.
 *
 * <p>Essa classe fornece métodos para esperar até que elementos estejam
 * visíveis, clicáveis, habilitados, tenham um determinado valor de atributo
 * ou até que o AJAX termine. Ela também inclui métodos para esperar por
 * um determinado tempo e para finalizar as esperas implícitas.</p>
 */
public class Espera {

    private FluentWait<WebDriver> esperaFluida;

    public void finalizaEspera() {
        getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    /**
     * Espera até que um elemento esteja visível na tela.
     *
     * <p>Esse método usa uma espera explícita para verificar se o elemento
     * está visível na tela. A espera é configurada para um tempo limite de
     * 30 segundos. Se o elemento não estiver visível após 30 segundos,
     * uma exceção será lançada.</p>
     *
     * @param elemento O elemento a ser esperado.
     */
    public void esperaAteElementoAparecerNaTela(WebElement elemento) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(elemento)));

    }

    public WebElement esperaAteElementoAparecerNaTela1(By by) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
      return   wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf((WebElement) by)));

    }
    public WebElement esperaAteElementoAparecerNaTela(By locator) {
        WebDriverWait espera = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        return espera.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Espera por um determinado tempo em milissegundos.
     *
     * @param miliSegundos O tempo de espera em milissegundos.
     */
    public void esperaPor(int miliSegundos) {
        try {
            new Thread();
            Thread.sleep(miliSegundos);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Espera até que o texto esteja presente no valor do elemento.
     *
     * @param elemento O elemento que você deseja verificar.
     * @param texto    O texto que você espera encontrar.
     * @return O elemento se o texto estiver presente, null caso contrário.
     */
    public WebElement esperaTextoEstarPresente(WebElement elemento, String texto) {
        new JsExecutor().executarScript("arguments[0].value = arguments[1];", elemento, texto);
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.textToBePresentInElementValue(elemento, texto));
        if (texto.equals(elemento.getAttribute("value"))) {
            return elemento;
        }
        return null;
    }

    /**
     * Espera até que o texto esteja presente no valor do elemento.
     *
     * @param id    O elemento que você deseja verificar.
     * @param texto O texto que você espera encontrar.
     * @return O elemento se o texto estiver presente, null caso contrário.
     */
    public String esperaTextoEstarPresente(String id, String texto) {
        WebElement elemento = getDriver().findElement(By.id(id));
        new JsExecutor().executarScript("arguments[0].value = arguments[1];", elemento, texto);
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.textToBePresentInElementValue(elemento, texto));
        String valorAtual = elemento.getAttribute("value");
        if (texto.equals(valorAtual)) {
            return valorAtual;
        }
        return null;
    }

    /**
     * Espera até que o elemento esteja clicável.
     *
     * @param elemento O elemento que você deseja esperar.
     */
    public void esperaElementoSerClicavel(WebElement elemento) {
        new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(elemento));
    }

    /**
     * Espera até que o elemento esteja clicável.
     *
     * @param id O elemento que você deseja esperar.
     */
    public void esperaElementoSerClicavel(String id) {
        WebElement elemento = getDriver().findElement(By.id(id));
        new WebDriverWait(getDriver(), Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(elemento));
    }

    /**
     * Espera até que a página carregue completamente.
     */
    public void esperaPaginaCarregar() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
    }

    /**
     * Espera até que o elemento esteja habilitado.
     *
     * @param elemento O elemento que você deseja verificar.
     */
    public void esperaAteElementoEstarHabilitado(WebElement elemento) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        wait.until(driver -> {
            boolean estaHabilitado = (boolean) ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(
                    "return arguments[0].disabled === false && arguments[0].style.display != 'none' && arguments[0].style.visibility != 'hidden'",
                    elemento
            );
            return estaHabilitado;
        });
    }

    /**
     * Espera até que o elemento tenha o valor do atributo especificado.
     *
     * @param elemento O elemento que você deseja verificar.
     * @param valor    O valor do atributo que você espera encontrar.
     */
    public void esperarAteQueElementoTenhaValorDoAtributo(WebElement elemento, String valor) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.attributeToBe(elemento, "value", valor));
    }


    public void esperaAjaxTerminar() {
        try {
            esperaFluida.until(paginaCarregada());
            esperaFluida.until(requisicaoAjaxConcluida());
            esperaFluida.until(mensagemAguardeSumida());
        } catch (Exception e) {
            // Logue o erro ou trate-o de acordo com a necessidade do seu projeto
        }
    }

    /**
     * @return Condição que devolve true quando a página html está totalmente
     * carregada.
     */
    private static ExpectedCondition<Boolean> paginaCarregada() {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return new JsExecutor().executarScript("return document.readyState").equals("complete");
            }
        };
    }

    /**
     * @return Condição que devolve true quando o painel Aguarde... NÃO está
     * visível.
     */
    private static ExpectedCondition<Boolean> requisicaoAjaxConcluida() {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {

                WebElement element = d.findElement(By.className("rf-st-start"));
                if (element.isDisplayed()) {

                    return false;
                } else {
                    JsExecutor jsExecutor = (JsExecutor) d;
                    return (boolean) new JsExecutor().executarScript("return jQuery.active == 0;");
                }
            }
        };
    }

    /**
     * @return Condição que devolve true quando o painel Aguarde... NÃO está
     * visível.
     */
    private static ExpectedCondition<Boolean> mensagemAguardeSumida() {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                WebElement element = d.findElement(By.id("mensagemAguarde"));
                if (element.isDisplayed())
                    return Boolean.FALSE;
                return Boolean.TRUE;
            }
        };
    }

}
