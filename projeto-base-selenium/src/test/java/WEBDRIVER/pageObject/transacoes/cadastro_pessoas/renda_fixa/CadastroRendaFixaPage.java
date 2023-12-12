package WEBDRIVER.pageObject.transacoes.cadastro_pessoas.renda_fixa;

import WEBDRIVER.base.basePage.BasePage;
import WEBDRIVER.config.menu.painel_acoes.Acessa;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CadastroRendaFixaPage extends BasePage {
    //region
    @FindBy(id = "mainForm:carteiraDropdownInput")private WebElement carteira;
    @FindBy(id = "mainForm:carteiraDropdownButton")private WebElement btn;
    //endregion
    public CadastroRendaFixaPage acessaPaginaRendaFixa(){
        new Acessa().cadastroRendaFixa();
        return this;
    }
    public NegociacaoAba carteira(String valor){
        preencheAutoComplete(carteira, valor);
        return new NegociacaoAba();

    }
 }
