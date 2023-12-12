package WEBDRIVER.config.menu.propriedades;

import WEBDRIVER.base.basePage.BasePage;
import WEBDRIVER.componentes.EntradaSimples;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginAmplisPage extends BasePage {

    @FindBy(id = "loginForm:userLoginInput:campo") private WebElement inputEmail;
    @FindBy(id = "loginForm:userPasswordInput") private WebElement inputSenha;
    @FindBy(id = "loginForm:botaoOk") private WebElement entrar;

    public void executarLogin(String email,String senha){
        new EntradaSimples().preencheDados(inputEmail,email);
        new EntradaSimples().preencheDados(inputSenha,senha);
        entrar.click();
    }
}
