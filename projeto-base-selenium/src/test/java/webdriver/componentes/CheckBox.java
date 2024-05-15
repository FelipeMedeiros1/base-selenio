package webdriver.componentes;

import api.componente.Flag;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static webdriver.fabrica.FabricaDeDriver.getDriver;

public class CheckBox implements Flag {


    public boolean seleciona(WebElement chk, Boolean boleano) {
        if (boleano == true) {
            new Espera().esperaAjaxTerminar();
            if (!chk.isSelected()) {
                chk.click();
            }
        }
        new Espera().esperaPor(1000);
        return false;
    }

    @Override
    public boolean seleciona(String id, Boolean boleano) {
        WebElement chk = getDriver().findElement(By.id(id));
        if (boleano == true) {
            new Espera().esperaAjaxTerminar();
            if (!chk.isSelected()) {
                chk.click();
            }
        } else {
            chk.click();
        }
        new Espera().esperaPor(1000);
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
