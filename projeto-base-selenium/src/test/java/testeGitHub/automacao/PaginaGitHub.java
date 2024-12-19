package testeGitHub.automacao;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webdriver.base.BasePagina;

public class PaginaGitHub extends BasePagina {

    @FindBy(id = "qa")
    public WebElement qa;


}
