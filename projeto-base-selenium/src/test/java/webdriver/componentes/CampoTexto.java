package webdriver.componentes;

import org.openqa.selenium.By;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static webdriver.fabrica.FabricaDeDriver.getDriver;


public class CampoTexto {
    public void preenche(By by, String text) {
        getDriver().findElement(by).clear();
        getDriver().findElement(by).sendKeys(text);
    }

    public void preenche(WebElement elemento, String valor) {
        elemento.clear();
        elemento.sendKeys(valor.trim());
    }


    public void preencheDevagar(WebElement elemento, String valor) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        for (int tentativa = 0; tentativa < 3; tentativa++) {
            try {
                wait.until(ExpectedConditions.visibilityOf(elemento));
                String valorAtual = elemento.getAttribute("value");
                if (!valorAtual.equals(valor)) {
                    elemento.clear();
                    wait.until(ExpectedConditions.attributeToBe(elemento, "value", ""));
                    for (int i = 0; i < valor.length(); i++) {
                        elemento.sendKeys(String.valueOf(valor.charAt(i)));
                    }

                    wait.until(ExpectedConditions.attributeToBe(elemento, "value", valor));
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                return; // Saia do método se a operação foi bem-sucedida
            } catch (StaleElementReferenceException e) {
                // Tentar novamente se encontrar um StaleElementReferenceException
                System.out.println("Tentativa " + (tentativa + 1) + " falhou devido a um StaleElementReferenceException. Tentando novamente...");
            }
        }
        throw new RuntimeException("Falhou ao preencher o campo após várias tentativas devido a StaleElementReferenceException.");
    }

    public void preenche(String id, String texto) {
        preenche(By.id(id), texto);
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
