package amplis.transacoes.processamento.bloqueio_liberacao.pagina;

import webdriver.base.BasePagina;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaginaBloqueioELiberacao extends BasePagina {
    //region
    @FindBy(id = "mainForm:j_id_1z:18:j_id_2w:0:j_id_2z:3:j_id_36")
    public WebElement bloqueioELiberacao;
    @FindBy(id = "mainForm:dataCalendar:campoInputDate")
    public WebElement dataBloqueioLiberacao;
    @FindBy(id = "mainForm:tipoDropdown:campo")
    public WebElement tipo;
    @FindBy(id = "mainForm:carteira_mnemonicCriteria:criteriaOperator:campo")
    public WebElement filtroCarteira;
    @FindBy(id = "mainForm:carteira_mnemonicCriteria:criteriaInputText:campo")
    public WebElement carteira;
    @FindBy(id = "mainForm:dataTable:0:checkboxBloqueado")
    public WebElement bloqueado;
    @FindBy(id = "mainForm:dataTable:0:checkboxLibContabil")
    public WebElement liberacaoContabil;
    @FindBy(id = "mainForm:dataTable:0:motivoBloqueioTextField:campo")
    public WebElement motivoDoBloqueio;
    @FindBy(id = "mainForm:dataTable:0:motivoDesbloqueioTextField:campo")
    public WebElement motivoDoDesbloqueio;
//endregion


}
