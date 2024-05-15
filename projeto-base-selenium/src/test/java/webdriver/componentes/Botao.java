package webdriver.componentes;

import api.componente.Click;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static webdriver.fabrica.FabricaDeDriver.getDriver;

public class Botao implements Click {
    public void clicar(String id) {
        getDriver().findElement(By.id(id)).click();
    }
    public void clicarBotao_class(String className) {
        getDriver().findElement(By.className(className)).click();
    }
    public void clicar(By by) {
        getDriver().findElement(by).click();
    }
    public void clicar(WebElement element) {
        element.click();
    }


    public String obterValor(WebElement element, String value) {
        return element.getAttribute(value);
    }
    public String obterValor(String id, String valor) {
        return getDriver().findElement(By.id(id)).getAttribute(valor);
    }

}

