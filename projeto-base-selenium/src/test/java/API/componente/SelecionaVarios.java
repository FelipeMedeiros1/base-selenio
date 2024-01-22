package API.componente;

import org.openqa.selenium.WebElement;

public interface SelecionaVarios <T>{

     String[] selecionaVarios(WebElement element,String... opcoes);
     String[] selecionaVarios(String id,String... opcoes);
     void selecionaTodos();


}
