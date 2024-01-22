package WEBDRIVER.componentes;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static WEBDRIVER.fabrica.FabricaDeDriver.getDriver;

public class Espera {
    public void esperaElementoAparecerNaTela(int time) {
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void finalizaEspera() {
        getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    public void esperaAteElementoAparecerNaTela(String id) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.id(id))));
        try {
            new Thread().sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void esperaPor(int miliSegundos) {
        try {
            new Thread().sleep(miliSegundos);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public ExpectedCondition<Boolean> esperaAjaxTerminar() {
        WebElement ajax = getDriver().findElement(By.id("waitOuter"));

        return driver -> {
            WebDriverWait wait = new WebDriverWait(driver,  30);
            wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
            wait.until(ExpectedConditions.invisibilityOf(ajax));
            return true;
        };
    }

    public WebElement esperaTextoEstarPresente(WebElement elemento, String texto) {
        new JS().executarScript("arguments[0].value = arguments[1];", elemento, texto);
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.textToBePresentInElementValue(elemento, texto));
        if (texto.equals(elemento.getAttribute("value"))) {
            return elemento;
        }
        return null;
    }
    public String esperaTextoEstarPresente(String id, String texto) {
        WebElement elemento = getDriver().findElement(By.id(id));

        new JS().executarScript("arguments[0].value = arguments[1];", elemento, texto);
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.textToBePresentInElementValue(elemento, texto));

        String valorAtual = elemento.getAttribute("value");

        if (texto.equals(valorAtual)) {
            return valorAtual;
        }

        return null;
    }


    public void esperaElementoSerClicavel(WebElement elemento) {
        new WebDriverWait(getDriver(), 15).until(ExpectedConditions.elementToBeClickable(elemento));
    }
    public void esperaElementoSerClicavel(String id) {
        WebElement elemento = getDriver().findElement(By.id(id));
        new WebDriverWait(getDriver(), 15).until(ExpectedConditions.elementToBeClickable(elemento));
    }


}
