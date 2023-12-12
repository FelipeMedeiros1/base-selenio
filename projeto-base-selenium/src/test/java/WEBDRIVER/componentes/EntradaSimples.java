package WEBDRIVER.componentes;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static WEBDRIVER.fabrica.FabricaDeDriver.getDriver;


public class EntradaSimples {
    public void preencheDados(By by, String text) {
        getDriver().findElement(by).clear();
        getDriver().findElement(by).sendKeys(text);
    }
    public void preencheDados(WebElement input, String text) {
        input.clear();
        input.sendKeys(text + Keys.TAB);
    }

    public void preencheDadosAutoComplete(WebElement input, String text) {
        input.clear();
        input.sendKeys(text);
    }
    public void preencheDados(String id, String texto){
        preencheDados(By.id(id), texto);
    }
    public void preencheDados_class(String className, String texto){
        preencheDados(By.className(className), texto);
    }
    public void preencheDados_css(String css, String texto){
        preencheDados(By.cssSelector(css), texto);
    }
    public String obterValorCampo(WebElement element, String value) {
        return element.getAttribute(value);
    }
    public String obterValorCampo(String id_campo,String valor) {
        return getDriver().findElement(By.id(id_campo)).getAttribute(valor);
    }
    public void preencheDados(String id) {
        getDriver().findElement(By.id(id)).clear();
        getDriver().findElement(By.id(id));
    }
}
