package WEBDRIVER.pageObject.transacoes.cadastro_pessoas.fundamental;

import API.transacoes.cadastro_pessoa.fundamental.ApropriacaoAgentesAba;
import API.componente.Aba;
import WEBDRIVER.base.basePage.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ApropriacaoAgentesAbaImpl extends BasePage implements ApropriacaoAgentesAba {
    //region
    @FindBy(id = "mainForm:tab1:header")
    private WebElement apropriacaoAgentes;
    @FindBy(id = "mainForm:dataTable1:0:administradorSuggestionInput")
    private WebElement administrador;
    @FindBy(id = "mainForm:dataTable1:0:advisorSuggestionInput")
    private WebElement gestor;
    @FindBy(id = "mainForm:dataTable1:0:custodianSuggestionInput")
    private WebElement custodiante;



    //endregion

    @Override
    public void administrador(String valor) {
        preencheAutoComplete(administrador, valor);
    }

    @Override
    public void gestor(String valor) {
        preencheAutoComplete(gestor, valor);
    }

    @Override
    public void custodiante(String valor) {
        preencheAutoComplete(custodiante, valor);
    }

    @Override
    public Aba seleciona() {
        return selecionaAba(apropriacaoAgentes);
    }

}
