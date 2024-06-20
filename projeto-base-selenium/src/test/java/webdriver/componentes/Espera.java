package webdriver.componentes;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static webdriver.fabrica.FabricaDeDriver.getDriver;

public class Espera {

    public void finalizaEspera() {
        getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    public void esperaAteElementoAparecerNaTela(WebElement elemento) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(elemento)));

    }

    public void esperaPor(int miliSegundos) {
        try {
            new Thread().sleep(miliSegundos);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void esperaAjaxTerminar() {

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        WebElement elemento = getDriver().findElement(By.xpath("//*[@id='waitMessageBox']/div/div"));
        wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(elemento)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='waitMessageBox']/div/div")));

    }

    public WebElement esperaTextoEstarPresente(WebElement elemento, String texto) {
        new JS().executarScript("arguments[0].value = arguments[1];", elemento, texto);
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.textToBePresentInElementValue(elemento, texto));
        if (texto.equals(elemento.getAttribute("value"))) {
            return elemento;
        }
        return null;
    }
    public String esperaTextoEstarPresente(String id, String texto) {
        WebElement elemento = getDriver().findElement(By.id(id));

        new JS().executarScript("arguments[0].value = arguments[1];", elemento, texto);
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.textToBePresentInElementValue(elemento, texto));

        String valorAtual = elemento.getAttribute("value");

        if (texto.equals(valorAtual)) {
            return valorAtual;
        }

        return null;
    }


    public void esperaElementoSerClicavel(WebElement elemento) {
        new WebDriverWait(getDriver(), Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(elemento));
    }
    public void esperaElementoSerClicavel(String id) {
        WebElement elemento = getDriver().findElement(By.id(id));
        new WebDriverWait(getDriver(), Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(elemento));
    }
    private void esperaPaginaCarregar() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
    }

}
