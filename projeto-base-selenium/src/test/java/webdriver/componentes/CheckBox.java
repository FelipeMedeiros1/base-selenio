package webdriver.componentes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static webdriver.fabrica.FabricaDeDriver.getDriver;

public class CheckBox {
    private Espera espera = new Espera();

    public boolean seleciona(WebElement elemento, Boolean boleano) {
        if (boleano && !estaSelecionado(elemento)) {
            espera.esperaAjaxTerminar();
            elemento.click();
        }
        if (!boleano && estaSelecionado(elemento)) {
            espera.esperaAjaxTerminar();
            elemento.click();
        }
        new Espera().esperaPor(1000);
        return false;
    }


    public boolean seleciona(String id, Boolean boleano) {
        WebElement chk = getDriver().findElement(By.id(id));
        if (boleano == true) {
            espera.esperaAjaxTerminar();
            if (!estaSelecionado(chk)) {
                chk.click();
            }
        } else {
            chk.click();
        }
        espera.esperaPor(1000);
        return false;
    }

    public void seleciona(String id) {
        getDriver().findElement(By.id(id)).click();
    }

    public void esperaPorIndex(WebElement elemento, int posicao) {
        new Select(elemento).selectByIndex(posicao);
    }

    public boolean estaSelecionado(WebElement element) {
        return element.isSelected();
    }

    public boolean estaSelecionado(String id) {
        return getDriver().findElement(By.id(id)).isSelected();
    }
}
