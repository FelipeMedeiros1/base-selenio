package webdriver.componentes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static webdriver.fabrica.FabricaDeDriver.getDriver;

public class LinkText {
    public void clicar(WebElement el) {
        el.click();
    }
    public void clicarLink(String link) {
        getDriver().findElement(By.linkText(link)).click();
    }
    public void clicar(String css) {
        getDriver().findElement(By.cssSelector(css)).click();
    }

}
