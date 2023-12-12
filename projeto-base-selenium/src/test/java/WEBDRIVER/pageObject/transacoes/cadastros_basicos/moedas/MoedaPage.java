package WEBDRIVER.pageObject.transacoes.cadastros_basicos.moedas;


import WEBDRIVER.base.basePage.BasePage;
import WEBDRIVER.config.menu.painel_acoes.Acessa;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MoedaPage extends BasePage {
    //region
    @FindBy(id = "mainForm:mnemonicTextField:campo") private WebElement inputCodigo;
    @FindBy(id = "mainForm:nameTextField:campo") private WebElement inputNome;
    @FindBy(id = "mainForm:symbolTextField:campo") private WebElement inputSimbolo;
    @FindBy(id = "mainForm:statusDropdown:campo") private WebElement selectStatus;
    //endregion

    public MoedaPage acessaPaginaMoedas() {
        new Acessa().moedas();
        inserir();
        return this;
    }
    public MoedaPage codigo(String codigo){
        preenche(inputCodigo,codigo);
        return this;
    }
    public MoedaPage nome(String nome){
       preenche(inputNome,nome);
        return this;
    }
    public MoedaPage simbolo(String simbolo){
        preenche(inputSimbolo,simbolo);
        return this;
    }
    public MoedaPage status(String tipo){
        selecionaUm(selectStatus,tipo);
        return this;
    }
}
