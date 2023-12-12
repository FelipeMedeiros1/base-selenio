package API.componente;

import org.openqa.selenium.WebElement;

public interface SelecionaVarios <T>{

     void seleciona(T... opcoes);
     void selecionaTodos();


}
