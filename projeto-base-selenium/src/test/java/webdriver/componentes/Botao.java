package webdriver.componentes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static webdriver.fabrica.FabricaDeDriver.getDriver;

public class Botao {
    private Espera espera = new Espera();

    public void clicar(String id) {
        espera.esperaElementoSerClicavel(id);
        getDriver().findElement(By.id(id)).click();
    }

    public void clicar(By by) {

        getDriver().findElement(by).click();
    }

    public void clicar(WebElement elemento) {
        espera.esperaElementoSerClicavel(elemento);
        elemento.click();
    }

    public String obterValor(WebElement element, String value) {
        return element.getAttribute(value);
    }

    public String obterValor(String id, String valor) {
        return getDriver().findElement(By.id(id)).getAttribute(valor);
    }

}

