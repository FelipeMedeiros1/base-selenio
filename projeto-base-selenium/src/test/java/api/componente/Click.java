package api.componente;

import org.openqa.selenium.WebElement;

public interface Click {
    void clicar(WebElement elemento);
    void clicar(String id);
}
