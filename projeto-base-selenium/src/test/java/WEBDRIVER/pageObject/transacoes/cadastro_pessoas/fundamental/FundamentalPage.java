package WEBDRIVER.pageObject.transacoes.cadastro_pessoas.fundamental;


import API.componente.EntradaSimples;
import API.componente.SelecionaUm;
import API.componente.SelecionaVarios;
import API.transacoes.cadastro_pessoa.fundamental.ApropriacaoAgentesAba;
import API.transacoes.cadastro_pessoa.fundamental.Fundamental;
import WEBDRIVER.base.BasePage;
import WEBDRIVER.config.menu.painel_acoes.Acessa;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FundamentalPage extends BasePage implements Fundamental {
    //region
    @FindBy(id = "mainForm:peopleSuggestionInput")
    private WebElement pessoa;
    @FindBy(id = "mainForm:mnemonicTextField:campo")
    private WebElement codigo;
    @FindBy(id = "mainForm:siteDropdown:campo")
    private WebElement localidade;
    @FindBy(id = "mainForm:grupoCarteira_PickList:firstSelect")
    private WebElement seleciona;
    @FindBy(id = "mainForm:grupoCarteira_PickList:includeSelected")
    private WebElement incluir;
    @FindBy(id = "mainForm:grupoCarteira_PickList:includeAll")
    private WebElement selecionaTodos;

    //endregion
    private ApropriacaoAgentesAba apropriacaoAgentesAba;

    @Override
    public void acessaPagina() {
        new Acessa().cadastroFundamental();
        inserir();
    }

    @Override
    public EntradaSimples pessoa(String valor) {
        return preencheAutoComplete(this.pessoa, valor);
    }

    @Override
    public EntradaSimples codigo(String valor) {
        return preenche(codigo, valor);
    }

    @Override
    public SelecionaUm localidade(String valor) {
        return selecionaUm(localidade, valor);
    }

    @Override
    public SelecionaVarios grupoDeCarteiras(String... valores) {
        return selecionaVarios(seleciona, valores);
    }
    public void selecionaTodos() {
        clicar(selecionaTodos);
    }

    @Override
    public ApropriacaoAgentesAba apropriacao() {
        if (apropriacaoAgentesAba == null) {
            apropriacaoAgentesAba = new ApropriacaoAgentesAbaImpl();
            apropriacaoAgentesAba.seleciona();
        }
        return apropriacaoAgentesAba;
    }
}



