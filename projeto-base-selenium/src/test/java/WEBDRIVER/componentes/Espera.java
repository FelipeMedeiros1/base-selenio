package WEBDRIVER.componentes;

import org.openqa.selenium.By;
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



    public void esperaAteElementoDesaparecerDaTela(String imgId) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(imgId)));
    }


    public void esperaPor(int miliSegundos)  {
        try {
            new Thread().sleep(miliSegundos);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
