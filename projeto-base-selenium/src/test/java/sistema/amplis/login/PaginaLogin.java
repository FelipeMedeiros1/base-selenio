package sistema.amplis.login;

import sistema.servicos.utils.LogUtil;
import webdriver.base.BasePagina;
import webdriver.componentes.Botao;
import webdriver.componentes.CampoTexto;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaginaLogin extends BasePagina {
    private CampoTexto pagina = new CampoTexto();

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
    //endregion

    public PaginaLogin temPainelMensagem(){
        if (painelMensagem.isDisplayed()){
            new Botao().clicar(painelMensagem);
        }
        return this;
    }


    public void executarLogin(String email, String senha) {
        LogUtil.info("Versão: " + versao.getText());
        pagina.preenche(inputEmail, email);
        pagina.preenche(inputSenha, senha);
        entrar.click();
    }

    @Override
    public void acessa() {

    }
}
