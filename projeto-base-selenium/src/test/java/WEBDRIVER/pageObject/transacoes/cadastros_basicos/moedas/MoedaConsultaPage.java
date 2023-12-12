package WEBDRIVER.pageObject.transacoes.cadastros_basicos.moedas;


import WEBDRIVER.base.basePage.BasePage;
import WEBDRIVER.config.menu.painel_acoes.Acessa;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MoedaConsultaPage extends BasePage {
    //region
    @FindBy(id = "mainForm:mnemonicCriteria:criteriaOperator:campo")private WebElement tipo;
    @FindBy(id = "mainForm:mnemonicCriteria:criteriaInputText:campo")private WebElement codigoConsulta;
    //endregion
    public MoedaConsultaPage acessaPaginaMoedasConsulta() {
        new Acessa().moedas();
        return this;
    }
    public MoedaConsultaPage codigoDaPesquisa(String codigo){
        selecionaUm(tipo,"Igual");
        esperaPor(500);
        preenche(codigoConsulta,codigo);
        confirmar();
        return this;
    }
    public MoedaConsultaPage selecionaGrid(int index){
        selecionaNaGrid(index);
        return this;
    }

}
