package webdriver.componentes;

import org.openqa.selenium.By;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.LogUtil.info;
import static webdriver.fabrica.FabricaDeDriver.getDriver;

/**
 * Classe responsável por interagir com campos de texto em uma página web.
 * Essa classe oferece métodos para preencher campos de texto, obter o valor de
 * um campo de texto e lidar com
 * elementos que podem se tornar obsoletos (StaleElementReferenceException).
 */

public class CaixaTexto {
    private final Espera espera = new Espera();
    private final JsExecutor js = new JsExecutor();

    /**
     * Preenche um campo de texto usando um `By` (como `By.id`, `By.name`, etc.) e um valor.
     *
     * @param by    O localizador do campo de texto.
     * @param valor O valor a ser inserido no campo de texto.
     */
    public void preenche(By by, String valor) {
        getDriver().findElement(by).clear();
        getDriver().findElement(by).sendKeys(valor);
    }


    /**
     * Preenche um elemento da página web com um valor.
     *
     * <p>Essa função realiza as seguintes ações:</p>
     * <ul>
     *  <li>Rola a página até que o elemento seja visível.</li>
     *  <li>Espera até que o elemento esteja visível na tela.</li>
     *  <li>Verifica se o elemento está habilitado e se o valor não está vazio.</li>
     *  <li>Espera até que o elemento esteja habilitado.</li>
     *  <li>Limpa o conteúdo do elemento e insere o valor.</li>
     *  <li>Espera até que o valor inserido esteja presente no elemento.</li>
     *  <li>Verifica se o valor atual do elemento é igual ao valor inserido.</li>
     *  <li>Se o valor não foi persistido após o número máximo de tentativas, lança uma exceção.</li>
     *  <li>Se o elemento não estiver mais visível na tela, lança uma exceção.</li>
     * </ul>
     *
     * @param elemento O elemento da página web a ser preenchido.
     * @param valor    O valor a ser inserido no elemento.
     */
    public void preenche(WebElement elemento, String valor) {
        info(elemento.getTagName() + ":" + valor);
        espera.esperaAjaxTerminar();
        js.rolarParaBaixoAteEncontrar(elemento);
        espera.esperaAteElementoAparecerNaTela(elemento);

        if (valor.isEmpty() || valor == null) {
            return;
        }
        if (validaValorElementoDesabilitado(elemento, valor)) {
            return;
        }

        if (!elemento.isEnabled() || !elemento.isDisplayed()) {
            throw new ElementNotInteractableException("O elemento não está habilitado ou visível." + elemento);
        }

        int tentativas = 0;
        int maxTentativas = 5;
        boolean valorPersistido = false;

        while (tentativas < maxTentativas && !valorPersistido) {
            elemento.clear();
            elemento.sendKeys(valor);

            valorPersistido = estaPreenchido(elemento, valor);
            if (!valorPersistido) {
                tentativas++;
            }
        }

        if (!valorPersistido) {
            throw new ElementNotInteractableException("Erro ao tentar preencher: [" + valor + "] no elemento: " + elemento);
        }
    }


    public void preencheDuplicado(WebElement elemento, String valor) {
        info(elemento.getTagName() + ":" + valor);
        if (elemento.isDisplayed() && elemento.isEnabled()) {
            for (int i = 0; i < 2; i++) {
                try {
                    elemento.clear();
                    elemento.sendKeys(valor);
                    espera.esperaPor(2000);
                    if (estaPreenchido(elemento, valor)) {
                        return;
                    }
                } catch (StaleElementReferenceException e) {
                    elemento.getLocation();
                }
            }
        }
    }

    public void preencheNativo(WebElement elemento, String valor) {
        info(elemento.getTagName() + ":" + valor);
        espera.esperaPaginaCarregar();
        js.rolarParaBaixoAteEncontrar(elemento);

        if (elemento.isEnabled() && !valor.isEmpty()) {
            if (elemento.isDisplayed()) {
                espera.esperaAteElementoEstarHabilitado(elemento);

                int tentativas = 0;
                int maxTentativas = 15;
                boolean valorPersistido = false;

                while (tentativas < maxTentativas && !valorPersistido) {
                    try {
                        elemento.clear();
                        js.preenche(elemento, valor);
//
                    } catch (Exception e) {
                        espera.esperaPor(800);
                        Actions actions = new Actions(getDriver());
                        actions.click(elemento).sendKeys(valor.trim()).build().perform();
                        valorPersistido = estaPreenchido(elemento, valor);
                        if (valorPersistido)
                            return;
                    }
                    tentativas++;
                }
                if (!valorPersistido) {
                    throw new RuntimeException("O valor não foi persistido: " + valor);
                }
            } else {
                throw new RuntimeException("O elemento não está visível na tela.");
            }
        } else {
            throw new RuntimeException("No campo texto o elemento está desabilitado ou o valor está vazio. Valor: " + valor);
        }
    }


    /**
     * Preenche um elemento da página web com um valor, com espera e tratamento de exceções.
     *
     * <p>Essa função tenta preencher um elemento da página web com um valor,
     * realizando várias tentativas em caso de exceções do tipo
     * `StaleElementReferenceException`. A função também inclui esperas explícitas
     * para garantir que o elemento esteja visível, habilitado e tenha o valor
     * esperado.</p>
     *
     * @param elemento O elemento da página web a ser preenchido.
     * @param valor    O valor a ser inserido no elemento.
     * @throws RuntimeException Se falhar ao preencher o campo após várias tentativas.
     */
    public void preencheDevagar(WebElement elemento, String valor) {
        info(elemento.getTagName() + ":" + valor);
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        js.rolarParaBaixoAteEncontrar(elemento);
        for (int tentativa = 0; tentativa < 3; tentativa++) {
            try {
                espera.esperaAteElementoAparecerNaTela(elemento);
                String valorAtual = elemento.getAttribute("value");
                if (!valorAtual.equals(valor)) {
                    if (elemento.isEnabled() && !valor.isEmpty()) {
                        elemento.clear();
                        espera.esperarAteQueElementoTenhaValorDoAtributo(elemento, valor);
                        for (int i = 0; i < valor.length(); i++) {
                            elemento.sendKeys(String.valueOf(valor.charAt(i)));
                        }

                        wait.until(ExpectedConditions.attributeToBe(elemento, "value", valor));
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                return;
            } catch (StaleElementReferenceException e) {
                System.out.println("Tentativa " + (tentativa + 1) + " falhou devido a um StaleElementReferenceException. Tentando novamente...");
            }
        }
        throw new RuntimeException("Falhou ao preencher o campo após várias tentativas devido a StaleElementReferenceException.");
    }

    /**
     * Preenche um campo de texto na página web, localizado por seu ID.
     *
     * <p>Essa função limpa o conteúdo do campo e, em seguida,
     * insere o texto fornecido no campo.</p>
     *
     * @param id    O ID do campo de texto.
     * @param valor O texto a ser inserido no campo.
     */
    public void preenche(String id, String valor) {
        info("Preenchendo o campo com valor: " + valor);
        preenche(By.id(id), valor);
    }

    /**
     * Obtém o valor de um atributo de um elemento da página web.
     *
     * @param elemento O elemento da página web.
     * @param valor    O nome do atributo a ser obtido.
     * @return O valor do atributo.
     */
    public String obterValorCampo(WebElement elemento, String valor) {
        return elemento.getAttribute(valor);
    }

    /**
     * Obtém o valor de um atributo de um elemento da página web,
     * localizado por seu ID.
     *
     * @param id_campo O ID do elemento.
     * @param valor    O nome do atributo a ser obtido.
     * @return O valor do atributo.
     */
    public String obterValorCampo(String id_campo, String valor) {
        return getDriver().findElement(By.id(id_campo)).getAttribute(valor);
    }

    /**
     * Obtém o objeto `By` que representa a localização de um elemento.
     *
     * <p>Essa função analisa a representação textual de um `WebElement`
     * para determinar o tipo de localizador (ID, nome, tag, classe, etc.)
     * e o valor do localizador. Em seguida, ela cria um objeto `By`
     * correspondente ao tipo de localizador e retorna esse objeto.</p>
     *
     * @param elemento O elemento da página web.
     * @return O objeto `By` que representa a localização do elemento.
     * @throws IllegalArgumentException Se o tipo de localizador não for suportado.
     */
    private By obterLocalizacaoDoElemento(WebElement elemento) {
        // Obter o método de localização do elemento
        String tipoLocalizador = elemento.toString().split(": ")[0];

        // Obter o valor do locator
        String valorLocalizador = elemento.toString().split(": ")[1];

        // Criar o objeto By com base no tipo de locator
        switch (tipoLocalizador) {
            case "By.id":
                return By.id(valorLocalizador);
            case "By.name":
                return By.name(valorLocalizador);
            case "By.tagName":
                return By.tagName(valorLocalizador);
            case "By.className":
                return By.className(valorLocalizador);
            case "By.linkText":
                return By.linkText(valorLocalizador);
            case "By.partialLinkText":
                return By.partialLinkText(valorLocalizador);
            case "By.cssSelector":
                return By.cssSelector(valorLocalizador);
            case "By.xpath":
                return By.xpath(valorLocalizador);
            default:
                throw new IllegalArgumentException("Tipo de locator não suportado: " + tipoLocalizador);
        }
    }

    public boolean estaPreenchido(WebElement elemento, String valor) {
        espera.esperaTextoEstarPresente(elemento, valor);
        String valorAtual = elemento.getAttribute("value");
        return valorAtual != null && valorAtual.trim().equals(valor.trim());
    }

    private boolean validaValorElementoDesabilitado(WebElement elemento, String valor) {

        String valorAtual = elemento.getText();

        if (!elemento.isEnabled() && valorAtual.contains(valor)) {
            return true;
        }
        if (!elemento.isEnabled() && !valorAtual.contains(valor)) {
            throw new RuntimeException(String.format(
                    "O valor do elemento [%s] não contém o valor passado no parâmetro: [%s]. Valor atual: [%s]",
                    elemento.getAttribute("id"), valor, valorAtual));

        }

        return false;
    }

}
