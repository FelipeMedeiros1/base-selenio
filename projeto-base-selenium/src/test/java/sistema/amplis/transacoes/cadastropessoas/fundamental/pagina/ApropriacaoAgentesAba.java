package sistema.amplis.transacoes.cadastropessoas.fundamental.pagina;

import webdriver.componentes.Aba;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ApropriacaoAgentesAba extends PaginaFundamental implements Aba {
    //region
    @FindBy(id = "mainForm:tab1:header")
    public WebElement apropriacaoAgentes;
    @FindBy(id = "mainForm:dataTable1:0:administradorSuggestionInput")
    public WebElement administrador;
    @FindBy(id = "mainForm:dataTable1:0:advisorSuggestionInput")
    public WebElement gestor;
    @FindBy(id = "mainForm:dataTable1:0:custodianSuggestionInput")
    public WebElement custodiante;
    //endregion
    @Override
    public Aba seleciona() {
        return selecionaAba(apropriacaoAgentes);
    }

}
