package WEBDRIVER.pageObject.transacoes.cadastro_pessoas.renda_variavel;

import WEBDRIVER.base.BasePage;
import WEBDRIVER.config.menu.painel_acoes.Acessa;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CadastroRendaVariavelPage extends BasePage {
    //region
    @FindBy(id = "mainForm:carteiraDropdownInput")private WebElement caerteira;
    //endregion

    public CadastroRendaVariavelPage aceesaPaginaRendaVariavel(){
        new Acessa().cadastroRendaVariavel();
        inserir();
        return this;
    }
    public CadastroRendaVariavelPage carteira(String valor){
        preencheAutoComplete(caerteira,valor);
        return this;
    }
}
