package WEBDRIVER.pageObject.transacoes.cadastros_basicos.moedas;


import WEBDRIVER.base.basePage.BasePage;
import WEBDRIVER.config.menu.painel_acoes.Acessa;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MoedaAlteracaoPage extends BasePage {
    //region
    @FindBy(id = "mainForm:mnemonicCriteria:criteriaOperator:campo")private WebElement filtro;
    @FindBy(id = "mainForm:mnemonicTextField:campo") private WebElement inputCodigo;
    @FindBy(id = "mainForm:nameTextField:campo") private WebElement inputNome;
    @FindBy(id = "mainForm:symbolTextField:campo") private WebElement inputSimbolo;
    @FindBy(id = "mainForm:mnemonicCriteria:criteriaInputText:campo")private WebElement codigoAlteracao;

    @FindBy(id = "mainForm:filterDataTable:0:linkmnemonicLinkSemAjax")private WebElement clickGrid;
    //endregion
    public MoedaAlteracaoPage acessaPaginaMoedasAlteracao() {
        new Acessa().moedas();
        return this;
    }
    public MoedaAlteracaoPage codigoPesquisa(String codigo){
        selecionaUm(filtro,"Igual");
        preenche(codigoAlteracao,codigo);
        confirmar();
        return this;
    }
    public MoedaAlteracaoPage codigo(String codigo) {
        preenche(inputCodigo,codigo);
        return this;
    }
    public MoedaAlteracaoPage nome(String nome) {
        preenche(inputNome, nome);
        return this;
    }
    public MoedaAlteracaoPage simbolo(String simbolo){
        preenche(inputSimbolo,simbolo);
        return this;
    }
    public MoedaAlteracaoPage selecionaGrid(int index){
        selecionaNaGrid(index);
        return this;
    }
    public MoedaAlteracaoPage clicarGrid(){
        clicar(clickGrid);
        return this;
    }

}
