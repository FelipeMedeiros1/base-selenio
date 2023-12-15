package WEBDRIVER.componentes;

import API.componente.Flag;
import WEBDRIVER.config.menu.painel_acoes.AcaoMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static WEBDRIVER.fabrica.FabricaDeDriver.getDriver;

public class CheckBox implements Flag {


    public boolean seleciona(WebElement chk, Boolean aBoolean) {
        if (aBoolean == true) {
            new AcaoMenu().espereAteOElementoFicarInvisivel();
            if (!chk.isSelected()) {
                chk.click();
            }
        } else {
            chk.click();
        }
        new AcaoMenu().esperaPor(1000);
        return false;
    }

    public void seleciona(String id) {
        getDriver().findElement(By.id(id)).click();
    }

    public boolean estaSelecionado(WebElement element) {
        return element.isSelected();
    }

    public boolean estaSelecionado(String id) {
        return getDriver().findElement(By.id(id)).isSelected();
    }
}
