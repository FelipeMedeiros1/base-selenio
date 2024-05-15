package webdriver.pages.transacoes.cadastro_pessoas.renda_variavel;

import webdriver.base.BasePage;
import webdriver.config.acesso.Acessa;
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
