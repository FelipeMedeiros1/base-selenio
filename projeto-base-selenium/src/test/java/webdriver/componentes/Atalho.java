package webdriver.componentes;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import static webdriver.fabrica.FabricaDeDriver.getDriver;

public class Atalho {

    /**
     * Simula a combinação de teclas Ctrl + letra especificada no corpo da página.
     *
     * @param letra A letra a ser combinada com Ctrl.
     * @throws Exception Se a combinação de teclas falhar após as tentativas.
     */
    public void pressionarCtrlMaisLetra(char letra) {
        WebElement elemento = null;
        int tentativas = 0;

        while (tentativas < 10) {
            try {
                elemento = getDriver().findElement(By.tagName("body"));

                if (elemento.isDisplayed()) {

                    Actions actions = new Actions(getDriver());
                    actions.keyDown(Keys.CONTROL)
                            .sendKeys(String.valueOf(letra))
                            .keyUp(Keys.CONTROL)
                            .perform();
                    return;
                } else {
                    throw new Exception("Elemento corpo da página não está visível.");
                }
            } catch (Exception e) {
                tentativas++;
                try {
                    Thread.sleep(1000); // Aguarda 1 segundo antes de tentar novamente
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }

        try {
            throw new Exception("Não foi possível realizar a combinação de teclas Ctrl + " + letra + " após " + tentativas + " tentativas.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void pressionarAltMaisLetra(char letra) {
        WebElement elemento = null;
        int tentativas = 0;

        while (tentativas < 10) {
            try {
                elemento = getDriver().findElement(By.tagName("body"));

                if (elemento.isDisplayed()) {

                    Actions actions = new Actions(getDriver());
                    actions.keyDown(Keys.ALT)
                            .sendKeys(String.valueOf(letra))
                            .keyUp(Keys.ALT)
                            .perform();
                    return;
                } else {
                    throw new Exception("Elemento corpo da página não está visível.");
                }
            } catch (Exception e) {
                tentativas++;
                try {
                    Thread.sleep(1000); // Aguarda 1 segundo antes de tentar novamente
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }

        try {
            throw new Exception("Não foi possível realizar a combinação de teclas Ctrl + " + letra + " após " + tentativas + " tentativas.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

