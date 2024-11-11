package webdriver.base.navegacao.automacao;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import webdriver.componentes.Espera;

import static webdriver.fabrica.FabricaDeDriver.getDriver;

public class Navegacao {
    public void navegarParaPagina(WebElement menu, WebElement modulo, WebElement pagina) {
        Actions acoes = new Actions(getDriver());
        Espera espera = new Espera();
        espera.esperaAjaxTerminar();
        espera.esperaElementoSerClicavel(menu);
        acoes.moveToElement(menu).perform();
        acoes.moveToElement(modulo).perform();
        acoes.click(pagina).perform();
        espera.esperaPor(1500);


    }
}
