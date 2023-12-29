package WEBDRIVER.pageObject.transacoes.cadastro_pessoas.fundamental;


import API.componente.EntradaSimples;
import API.componente.SelecionaUm;
import API.componente.SelecionaVarios;
import API.transacoes.cadastro_pessoa.fundamental.ApropriacaoAgentesAba;
import API.transacoes.cadastro_pessoa.fundamental.Fundamental;
import WEBDRIVER.base.basePage.BasePage;
import WEBDRIVER.config.menu.painel_acoes.Acessa;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FundamentalPage extends BasePage implements Fundamental {
    //region
    @FindBy(id = "mainForm:peopleSuggestionInput")
    private WebElement inputPessoa;
    @FindBy(id = "mainForm:mnemonicTextField:campo")
    private WebElement inputCodigo;
    @FindBy(id = "mainForm:siteDropdown:campo")
    private WebElement selectLocalidade;
    @FindBy(id = "mainForm:grupoCarteira_PickList:firstSelect")
    private WebElement seleciona;
    @FindBy(id = "mainForm:grupoCarteira_PickList:includeSelected")
    private WebElement incluir;
    @FindBy(id = "mainForm:grupoCarteira_PickList:includeAll")
    private WebElement selecionaTodos;

    //endregion
    ApropriacaoAgentesAba apropriacaoAgentesAba;

    @Override
    public void acessaPagina() {
        new Acessa().cadastroFundamental();
        inserir();
    }

    @Override
    public EntradaSimples pessoa(String pessoa) {
        return preencheAutoComplete(inputPessoa, pessoa);
    }

    @Override
    public EntradaSimples codigo(String codigo) {
        return preenche(inputCodigo, codigo);
    }

    @Override
    public SelecionaUm localidade(String valor) {
        return selecionaUm(selectLocalidade, valor);
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



