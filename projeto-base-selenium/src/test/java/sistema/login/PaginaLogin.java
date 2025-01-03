package sistema.login;

import webdriver.base.BasePagina;
import webdriver.componentes.Botao;
import webdriver.componentes.CaixaTexto;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.leitorDeArquivo.LeitorPropriedade.getLogin;
import static utils.leitorDeArquivo.LeitorPropriedade.getSenha;
import static webdriver.componentes.Evidencia.*;

public class PaginaLogin extends BasePagina {
    private final CaixaTexto pagina = new CaixaTexto();

    //region
    @FindBy(id = "loginForm:userLoginInput:campo")
    private WebElement inputEmail;
    @FindBy(id = "loginForm:userPasswordInput")
    private WebElement inputSenha;
    @FindBy(id = "loginForm:botaoOk")
    private WebElement entrar;
    @FindBy(id = "loginForm:versaoOutputText")
    public WebElement versao;

    @FindBy(id = "loginForm:painelMensagensOkActionDialogButton")
    public WebElement painelMensagem;


    private String login = getLogin();
    private String senha = getSenha();

    //endregion

    public PaginaLogin temPainelMensagem() {
        if (painelMensagem.isDisplayed()) {
            new Botao().clicar(painelMensagem);
        }
        return this;
    }


    private void executarLogin(String email, String senha) {
        logInfo("Versão do sistema: " + versao.getText());
        pagina.preenche(inputEmail, email);
        pagina.preenche(inputSenha, senha);
        entrar.click();
        capturaTelaSucesso("PaginaLogin", "Validando a página de login");
    }
    public void executarLogin(){
        executarLogin(getLogin(),getSenha());
    }


}
