package lojinha.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webdriver.base.BasePagina;

public class PaginaLogin extends BasePagina {

    @FindBy(id = "usuario")
    public WebElement usuario;

    @FindBy(id = "senha")
    public WebElement senha;


}
