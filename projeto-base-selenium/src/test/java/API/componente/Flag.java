package API.componente;

import org.openqa.selenium.WebElement;

public interface Flag {
    boolean seleciona(WebElement chk, Boolean aBoolean);
    boolean seleciona(String id, Boolean aBoolean);

}
