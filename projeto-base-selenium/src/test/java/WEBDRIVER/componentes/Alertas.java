package WEBDRIVER.componentes;

import org.openqa.selenium.WebElement;

import static WEBDRIVER.fabrica.FabricaDeDriver.getDriver;

public class Alertas {

    public String obterTexto(WebElement alert) {
        alert = (WebElement) getDriver().switchTo().alert();
        return alert.getText();
    }
    public String obterTexto(){
        org.openqa.selenium.Alert alert = getDriver().switchTo().alert();
        return alert.getText();
    }
    public String obterTexo(WebElement alert) {
        return alert.getText();
    }
    public String obterTextoEAceitar() {
        var alert = getDriver().switchTo().alert();
        String value = alert.getText();
        alert.accept();
        return value;
    }
    public String obterTextoERejeitar() {
        var alert = getDriver().switchTo().alert();
        String value = alert.getText();
        alert.dismiss();
        return value;
    }
    public void alertEscrever(String value) {
        var alert = getDriver().switchTo().alert();
        alert.sendKeys(value);
        alert.accept();
    }
}
