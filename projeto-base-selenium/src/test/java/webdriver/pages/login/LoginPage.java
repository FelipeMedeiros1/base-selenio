package webdriver.pages.login;

import webdriver.base.BasePage;
import webdriver.componentes.CampoTexto;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    //region
    @FindBy(id = "loginForm:userLoginInput:campo")
    private WebElement inputEmail;
    @FindBy(id = "loginForm:userPasswordInput")
    private WebElement inputSenha;
    @FindBy(id = "loginForm:botaoOk")
    private WebElement entrar;
    //endregion

    public void executarLogin(String email, String senha) {
        new CampoTexto().preenche(inputEmail, email);
        new CampoTexto().preenche(inputSenha, senha);
        entrar.click();
    }
}
