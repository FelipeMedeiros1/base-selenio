package webdriver.pages.transacoes.cadastros_basicos.moedas;


import webdriver.base.BasePage;
import webdriver.config.acesso.Acessa;
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
