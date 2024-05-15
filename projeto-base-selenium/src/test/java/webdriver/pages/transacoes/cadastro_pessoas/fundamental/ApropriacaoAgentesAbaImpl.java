package webdriver.pages.transacoes.cadastro_pessoas.fundamental;

import api.componente.EntradaSimples;
import api.transacoes.cadastro_pessoa.fundamental.ApropriacaoAgentesAba;
import api.componente.Aba;
import webdriver.base.BasePage;
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
    public EntradaSimples administrador(String valor) {
       return preencheAutoComplete(administrador, valor);
    }

    @Override
    public EntradaSimples gestor(String valor) {
       return preencheAutoComplete(gestor, valor);
    }

    @Override
    public EntradaSimples custodiante(String valor) {
        return preencheAutoComplete(custodiante, valor);
    }

    @Override
    public Aba seleciona() {
        return selecionaAba(apropriacaoAgentes);
    }

}
