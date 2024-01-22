package API.componente;

import org.openqa.selenium.WebElement;

public interface EntradaSimples {
     void preenche(WebElement element ,String valor);
     void preenche(String id ,String valor);

}
