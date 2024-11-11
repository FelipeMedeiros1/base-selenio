package amplis.transacoes.cadastropessoas.fundamental.pagina;


import webdriver.base.BasePagina;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaginaFundamental extends BasePagina {
    //region
    @FindBy(id = "mainForm:j_id_1z:6:j_id_2w:3:j_id_2z:0:j_id_3p:0:j_id_3w")
    public WebElement fundamental;
    @FindBy(id = "mainForm:peopleSuggestionInput")
    public WebElement pessoa;
    @FindBy(id = "mainForm:mnemonicTextField:campo")
    public WebElement codigo;
    @FindBy(id = "mainForm:siteDropdown:campo")
    public WebElement localidade;
    @FindBy(id = "mainForm:statusDropdown:campo")
    public WebElement status;
    @FindBy(id = "mainForm:grupoCarteira_PickList")
    public WebElement grupoDeCarteiras;
    @FindBy(id = "mainForm:grupoCarteira_PickList:includeSelected")
    public WebElement incluir;
    @FindBy(id = "mainForm:grupoCarteira_PickList:includeAll")
    public WebElement selecionaTodos;

    //endregion
    private ApropriacaoAgentesAba apropriacaoAgentesAba;
    public ApropriacaoAgentesAba apropriacao() {
        if (apropriacaoAgentesAba == null) {
            apropriacaoAgentesAba = new ApropriacaoAgentesAba();
        }
        return apropriacaoAgentesAba;
    }

}