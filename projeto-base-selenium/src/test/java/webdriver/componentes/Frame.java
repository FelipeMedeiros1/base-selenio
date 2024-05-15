package webdriver.componentes;

import static webdriver.fabrica.FabricaDeDriver.getDriver;

public class Frame {
    public void entrarFrame(String id) {
        getDriver().switchTo().frame(id);
    }
    public void sairFrame() {
        getDriver().switchTo().defaultContent();
    }
    public void trocarJanela(String id) {
        getDriver().switchTo().window(id);
    }
}
