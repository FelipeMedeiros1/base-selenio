package test.java.webdriver.base;

import test.java.webdriver.componentes.*;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static test.java.webdriver.fabrica.FabricaDeDriver.getDriver;

public abstract class BasePagina {

    public BasePagina() {
        new Espera().esperaPaginaCarregar();
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(getDriver(), 10);
        PageFactory.initElements(factory, this);
    }

}
