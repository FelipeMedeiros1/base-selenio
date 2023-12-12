package WEBDRIVER.pageObject.transacoes.cadastro_pessoas.fundamental;


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

    public void aceesaPaginaFundamental() {
        new Acessa().cadastroFundamental();
        inserir();

    }

    public void pessoa(String pessoa) {
        preencheAutoComplete(inputPessoa, pessoa);

    }

    public void codigo(String codigo) {
        preenche(inputCodigo, codigo);

    }

    public void localidade(String valor) {
        selecionaUm(selectLocalidade, valor);

    }

    public void grupoDeCarteiras(String... valores) {
        selecionaVarios(seleciona, incluir, valores);
        clicar(selecionaTodos);

    }

    @Override
    public ApropriacaoAgentesAba apropriacao() {
        ApropriacaoAgentesAba apropriacaoAgentesAba = new ApropriacaoAgentesAbaImpl();
        apropriacaoAgentesAba.seleciona();
        return apropriacaoAgentesAba;
    }

}

