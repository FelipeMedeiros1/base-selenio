package webdriver.componentes;

import org.openqa.selenium.WebElement;

import static webdriver.fabrica.FabricaDeDriver.getDriver;

/**
 * Classe utilitária para executar scripts JavaScript no navegador.
 * <p>
 * Fornece métodos para realizar ações que não são diretamente suportadas pela API do Selenium,
 * como rolar a página, destacar elementos, controlar o zoom e executar scripts JavaScript personalizados.
 */
public class JavascriptExecutor {
    /**
     * Executa um script JavaScript no navegador.
     *
     * @param cmd   O comando JavaScript a ser executado.
     * @param param Os parâmetros para o comando JavaScript.
     * @return O resultado da execução do script JavaScript.
     */
    public Object executarScript(String cmd, Object... param) {
        org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) getDriver();
        return js.executeScript(cmd, param);
    }
    public void preenche(WebElement elemento, String valor){
        executarScript("arguments[0].value = arguments[1];", elemento, valor.trim());
    }

    /**
     * Rolar a página para baixo até o final.
     */
    public void rolarParaFimDaPagina() {
        executarScript("window.scrollTo(0, document.documentElement.scrollHeight)");
    }

    /**
     * Rolar a página para um ponto específico.
     *
     * @param yOffset O offset vertical para rolar a página.
     */
    public void rolarAtePontoEspecifico(int yOffset) {
        executarScript("window.scrollTo(0, " + yOffset + ")");
    }

    /**
     * Rolar a página para baixo até que o elemento esteja visível.
     *
     * @param elemento O elemento que você deseja rolar até.
     */
    public void rolarParaBaixoAteEncontrar(WebElement elemento) {
        executarScript("arguments[0].scrollIntoView(true);", elemento);
    }

    /**
     * Rolar a página para baixo até que o elemento esteja visível na parte inferior da tela.
     *
     * @param element O elemento que você deseja rolar até.
     */
    public void encontraElementoNoInferiorDaTela(WebElement element) {
        executarScript("window.scrollBy(0,arguments[0])", element.getLocation().y--);
    }

    /**
     * Rolar a página para cima até que o elemento esteja visível.
     *
     * @param elemento O elemento que você deseja rolar até.
     */
    public void rolarParaCimaAteEncontrar(WebElement elemento) {
        executarScript("window.scrollBy(0,arguments[0])", elemento.getLocation().y++);
    }

    /**
     * Rolar a página até um ponto específico em relação a um elemento.
     *
     * @param elemento O elemento de referência.
     * @param x        O offset horizontal em pixels.
     * @param y        O offset vertical em pixels.
     */
    public void encontraElemento(WebElement elemento, int x, int y) {
        executarScript("window.scrollBy(0,arguments[0])", elemento.getLocation().moveBy(x, y));
    }

    /**
     * Destaca um elemento na página com uma borda vermelha.
     *
     * @param elemento O elemento que você deseja destacar.
     */
    public void destacarElemento(WebElement elemento) {
        org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].setAttribute('style', 'border: 3px solid red;')", elemento);
    }

    /**
     * Define o zoom da página.
     *
     * @param porcentagem A porcentagem de zoom desejada.
     */
    public void zoom(int porcentagem) {
        executarScript("document.body.style.zoom = '" + porcentagem + "%';");
    }


}
