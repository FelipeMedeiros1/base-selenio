package webdriver.pages.transacoes.cadastro_pessoas.renda_fixa;

import webdriver.base.BasePage;
import webdriver.config.acesso.Acessa;
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
