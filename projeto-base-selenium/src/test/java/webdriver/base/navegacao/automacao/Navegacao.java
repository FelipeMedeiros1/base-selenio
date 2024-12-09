package webdriver.base.navegacao.automacao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.componentes.Espera;

import java.time.Duration;

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

    public void navegarParaPagina(WebElement menu, WebElement modulo, String id) {

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        Espera espera = new Espera();
        espera.esperaAjaxTerminar();
        espera.esperaElementoSerClicavel(menu);

        new Actions(getDriver()).moveToElement(menu).perform();

        espera.esperaElementoSerClicavel(modulo);
        new Actions(getDriver()).moveToElement(modulo).perform();

        WebElement pagina = wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
        pagina.click();

        espera.esperaPor(500);
    }


}
