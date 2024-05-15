package webdriver.componentes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static webdriver.fabrica.FabricaDeDriver.getDriver;

public class Radio {

    public void seleciona(WebElement element) {
        element.click();
    }
    public void seleciona(String id) {
        getDriver().findElement(By.id(id)).click();
    }

    public boolean estaSelecionado(WebElement element) {
        return element.isSelected();
    }
    public boolean estaSelecionado(String id){
        return getDriver().findElement(By.id(id)).isSelected();
    }


}
