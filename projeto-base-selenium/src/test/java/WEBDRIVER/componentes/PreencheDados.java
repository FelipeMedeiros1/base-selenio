package WEBDRIVER.componentes;

import API.componente.EntradaSimples;
import WEBDRIVER.config.menu.painel_acoes.AcaoMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static WEBDRIVER.fabrica.FabricaDeDriver.getDriver;


public class PreencheDados implements EntradaSimples {
    public void preenche(By by, String text) {
        getDriver().findElement(by).clear();
        getDriver().findElement(by).sendKeys(text);
    }

    public void preenche(WebElement input, String texto) {
        input.clear();
        input.sendKeys(texto.trim());
    }
    public void preenche(String id, String texto) {
        preenche(By.id(id), texto);
    }

    public void preencheDados_class(String className, String texto) {
        preenche(By.className(className), texto);
    }

    public void preencheDados_css(String css, String texto) {
        preenche(By.cssSelector(css), texto);
    }

    public String obterValorCampo(WebElement element, String value) {
        return element.getAttribute(value);
    }

    public String obterValorCampo(String id_campo, String valor) {
        return getDriver().findElement(By.id(id_campo)).getAttribute(valor);
    }

    public void preenche(String id) {
        getDriver().findElement(By.id(id)).clear();
        getDriver().findElement(By.id(id));
    }
}
