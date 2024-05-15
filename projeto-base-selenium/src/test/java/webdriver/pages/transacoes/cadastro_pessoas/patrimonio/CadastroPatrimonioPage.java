package webdriver.pages.transacoes.cadastro_pessoas.patrimonio;

import webdriver.base.BasePage;
import webdriver.config.acesso.Acessa;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CadastroPatrimonioPage extends BasePage {
    //region
    @FindBy(id = "mainForm:carteiraDropdownInput")private WebElement carteira;
    @FindBy(id = "mainForm:valorCotaInicialTextField:campo")private WebElement cota;
    //endregion

    public CadastroPatrimonioPage acessaPaginaPatrimonio(){
        new Acessa().cadastroPatrimonio();
        inserir();
        return this;
    }
    public CadastroPatrimonioPage carteira(String valor){
        preencheAutoComplete(carteira,valor);
        return this;
    }
    public CadastroPatrimonioPage valorDaCotaInicial(String valor){
        preenche(cota,valor);
        return this;
    }
  }
