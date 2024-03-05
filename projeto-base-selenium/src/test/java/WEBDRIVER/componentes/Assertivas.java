package WEBDRIVER.componentes;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static WEBDRIVER.fabrica.FabricaDeDriver.getDriver;

public class Assertivas {


    private static String PASSOU = "<font class=\"status pass\">O resultado da comparação de valores.\r\n<br><b>Esperado: xxx \r\n<br>Atual: yyy</b>\r\n<br>Estão corretos.</font>";
    private static String FALHOU = "<font class=\"status fail\">O resultado da comparação de valores.\r\n<br><b>Esperado: xxx \r\n<br>Atual: yyy</b>\r\n<br>Estão incorretos.</font>";


    public static String validaMensagem(By by) {
        return getDriver().findElement(by).getText();
    }


    public static final void assertivas(String esperado, String atual) {
        Assert.assertEquals(esperado, validaMensagem(atual));
    }

    public static final void assertivas(String esperado, WebElement atual) {
        Assert.assertEquals(esperado, validaMensagem(atual));

    }

    public static String validaMensagem(WebElement element) {
        return element.getText();
    }

    public static String validaMensagem(String id) {
        return validaMensagem(By.id(id));
    }


    private static final String montaTexto(String texto, String expected, String actual) {
        String info = texto.replace("xxx", expected).replace("yyy", actual);

        return info;
    }
}

