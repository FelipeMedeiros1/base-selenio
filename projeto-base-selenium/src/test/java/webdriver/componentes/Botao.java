package webdriver.componentes;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import sistema.servicos.utils.LogUtil;

import java.util.NoSuchElementException;
import java.util.Optional;

import static sistema.servicos.utils.LogUtil.info;
import static webdriver.fabrica.FabricaDeDriver.getDriver;

/**
 * Classe responsável por encapsular as ações de interação com botões em uma página web.
 * Utiliza o Selenium para encontrar e clicar em botões, além de oferecer métodos para obter valores de atributos de um botão.
 */
public class Botao {
    private Espera espera = new Espera();
    private JavascriptExecutor js = new JavascriptExecutor();

    /**
     * Clica no botão com o ID especificado.
     * Antes de clicar, espera que o botão esteja visível e clicável na página.
     *
     * @param id O ID do botão a ser clicado.
     */


    public void clicar(String id) {
        boolean encontrou = false;

        WebElement elemento = getDriver().findElement(By.id(id));
        try {
            if (elemento.isDisplayed() && elemento.isDisplayed()) ;
            encontrou = true;
        } catch (NoSuchElementException e) {
            // Se o elemento não for encontrado, a pesquisa não teve sucesso
            info("Elemento com ID '" + id + "' não encontrado.");
        }
        if (encontrou) {

            espera.esperaElementoSerClicavel(id);
            if (elemento.isDisplayed() && elemento.isEnabled() && (elemento.getAttribute("hidden") == null || !elemento.getAttribute("hidden").equals("true"))) {
                elemento.click();
            } else {
                info("Elemento com ID '" + id + "' está oculto ou desabilitado.");
            }
            espera.esperaPor(500);
        }
    }

    /**
     * Clica no botão localizado pelo objeto By fornecido.
     *
     * @param by Um objeto By que identifica o botão a ser clicado.
     */
    public void clicar(By by) {
        getDriver().findElement(by).click();
    }

    /**
     * Clica no botão representado pelo elemento WebElement fornecido.
     * Antes de clicar, rola a página para que o botão fique visível, espera que o botão esteja visível e clicável na página.
     *
     * @param elemento O elemento WebElement que representa o botão a ser clicado.
     */
    public void clicar(WebElement elemento) {
        info(elemento.getText());
        boolean encontrou = false;
        js.rolarParaBaixoAteEncontrar(elemento);
        espera.esperaAteElementoAparecerNaTela(elemento);
        espera.esperaElementoSerClicavel(elemento);
        try {
            if (elemento.isDisplayed() && elemento.isDisplayed()) ;
            encontrou = true;
        } catch (NoSuchElementException e) {
            // Se o elemento não for encontrado, a pesquisa não teve sucesso
            info("Elemento com ID '" + elemento + "' não encontrado.");
        }
        if (encontrou) {

            espera.esperaElementoSerClicavel(elemento);
            if (elemento.isDisplayed() && elemento.isEnabled() && (elemento.getAttribute("hidden") == null || !elemento.getAttribute("hidden").equals("true"))) {
                elemento.click();
            } else {
                info("Elemento com ID '" + elemento + "' está oculto ou desabilitado.");
            }

        }
    }


    /**
     * Seleciona a aba representada pelo elemento WebElement fornecido.
     * Antes de clicar, rola a página para que a aba fique visível, espera que a aba esteja visível e clicável na página.
     *
     * @param elemento O elemento WebElement que representa a aba a ser selecionada.
     */
    public void selecionaAba(WebElement elemento) {
        info("Aba selecionada: " + elemento.getText());
        js.rolarParaCimaAteEncontrar(elemento);
        espera.esperaAteElementoAparecerNaTela(elemento);
        espera.esperaPor(500);
        espera.esperaElementoSerClicavel(elemento);
        clicar(elemento);
    }

    public void clicarEspecial(String locator, Keys... keys) {
        WebElement element = getDriver().findElement(By.id(locator));
        Actions actions = new Actions(getDriver());
        actions.click(element);

        // Simula a combinação de teclas Ctrl+O
        if (keys.length > 0) {
            actions.keyDown(Keys.CONTROL);
            actions.sendKeys(keys);
        }
        actions.perform();
    }

    public void duploClique(WebElement elemento) {
        info(elemento.getText());
        int tentativas = 0;

        while (tentativas < 10) {
            try {
                if (elemento.isDisplayed() && elemento.isEnabled()) {
                    // Realiza o duplo clique
                    Actions actions = new Actions(getDriver());
                    actions.doubleClick(elemento).perform();
                    return;
                } else {
                    throw new Exception("Elemento não está clicável: " + elemento.toString());
                }
            } catch (NoSuchElementException | TimeoutException e) {
                tentativas++;
                System.out.println("Elemento não encontrado ou timeout na tentativa " + tentativas + ". Tentando novamente...");
                try {
                    Thread.sleep(1000); // Aguarda 1 segundo antes de tentar novamente
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        try {
            throw new Exception("Não foi possível realizar o duplo clique no elemento após " + tentativas + " segundos: " + elemento.toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void clickActions(WebElement menu, WebElement modulo, WebElement pagina) {
        Actions acoes = new Actions(getDriver());
        Espera espera = new Espera();
        espera.esperaElementoSerClicavel(menu);
        acoes.moveToElement(menu).perform();
        acoes.moveToElement(modulo).perform();
        acoes.click(pagina).perform();
        espera.esperaPor(1500);
    }


    public String obterValor(WebElement elemento, String valor) {
        return elemento.getAttribute(valor);
    }

    public String obterValor(String id, String valor) {
        return getDriver().findElement(By.id(id)).getAttribute(valor);
    }

}

