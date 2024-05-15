package webdriver.componentes;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static webdriver.fabrica.FabricaDeDriver.getDriver;

public class JS {
     public Object executarScript(String cmd, Object... param) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        return js.executeScript(cmd, param);
    }
    public JS encontraElementoNoInferiorDaTela(WebElement element) {
        executarScript("window.scrollBy(0,arguments[0])", element.getLocation().y--);
        return null;
    }
    public JS encontraElementoNoSuperiorDaTela(WebElement element) {
        executarScript("window.scrollBy(0,arguments[0])", element.getLocation().y++);
        return null;
    }
    public void encontraElemento(WebElement elemento, int x, int y){

        executarScript("window.scrollBy(0,arguments[0])", elemento.getLocation().moveBy(x,y));
    }


    public JS zoom(int porcentagem) {
        executarScript("document.body.style.zoom = '"+porcentagem+"%';");
        return null;
    }



}
