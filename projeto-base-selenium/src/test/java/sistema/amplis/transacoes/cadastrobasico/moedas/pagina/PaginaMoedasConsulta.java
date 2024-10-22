package sistema.amplis.transacoes.cadastrobasico.moedas.pagina;

import sistema.servicos.navegacao.Acessa;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaginaMoedasConsulta extends PaginaMoedas {
    //region
    @FindBy(id = "mainForm:mnemonicCriteria:criteriaOperator:campo")
    public WebElement filtroConsulta;
    @FindBy(id = "mainForm:mnemonicCriteria:criteriaInputText:campo")
    public WebElement codigoConsulta;
    @FindBy(id = "mainForm:filterDataTable:0:linkmnemonicLinkSemAjax")
    public WebElement selecionaGrid;

    //endregion


}
