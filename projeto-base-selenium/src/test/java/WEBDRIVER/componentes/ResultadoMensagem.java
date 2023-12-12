package WEBDRIVER.componentes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static WEBDRIVER.fabrica.FabricaDeDriver.getDriver;

public class ResultadoMensagem {
    public String validaMensagem(By by) {
        return getDriver().findElement(by).getText();
    }

    public String validaMensagem(String id) {
        return validaMensagem(By.id(id));
    }
    public String validaMensagem(WebElement element) {
        return element.getText();
    }
}

