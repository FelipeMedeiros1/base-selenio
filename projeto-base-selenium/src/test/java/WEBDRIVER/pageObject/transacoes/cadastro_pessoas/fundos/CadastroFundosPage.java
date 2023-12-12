package WEBDRIVER.pageObject.transacoes.cadastro_pessoas.fundos;

import WEBDRIVER.base.basePage.BasePage;
import WEBDRIVER.config.menu.painel_acoes.Acessa;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CadastroFundosPage extends BasePage {
    //region
    @FindBy(id = "mainForm:carteiraDropdownInput")private WebElement carteira;
    @FindBy(id = "mainForm:formaCondominioDropdown:campo")private WebElement condominio;
    @FindBy(id = "mainForm:classificacaoCarteiraDropdown:campo")private WebElement tipoFundos;
    //endregion
    public CadastroFundosPage acessaPaginaFundos(){
        new Acessa().cadastroFundos();
        inserir();
        return this;
    }
    public CadastroFundosPage carteira(String valor){
        preencheAutoComplete(carteira,valor);
        inserir();
        esperaPor(1000);
        return this;
    }
    public CadastroFundosPage formaDeCondominio(String opcao){
        selecionaUm(condominio,opcao);
        return this;
    }
    public CadastroFundosPage tipoDeFundos(String opcao){
        selecionaUm(tipoFundos,opcao);
        return this;
    }

}
