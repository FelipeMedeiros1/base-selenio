package sistema.transacoes.fundos.movimentacao.pagina;


import webdriver.base.BasePagina;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaginaMovimentacao extends BasePagina {
    //region
    @FindBy(id = "mainForm:j_id_1z:11:j_id_2w:5:j_id_2z:1:j_id_36")
    public WebElement movimentacao;
    @FindBy(id = "mainForm:dataMovimentacaoCalendar:campoInputDate")
    public WebElement dataDoMovimento;
    @FindBy(id = "mainForm:carteiraDropdownInput")
    public WebElement carteira;
    @FindBy(id = "mainForm:fundoDropdownInput")
    public WebElement fundo;
    @FindBy(id = "mainForm:fundoFechadoPorNotaDropdown:campo")
    public WebElement NegociacaoDeCotaAMercado;
    @FindBy(id = "mainForm:modalidadeMovimentoDropdown:campo")
    public WebElement modalidadeDoMovimento;
    @FindBy(id = "mainForm:subSegmentosPREVICDropdown:campo")
    public WebElement subsegmentoPREVIC;
    @FindBy(id = "mainForm:dataAplicacaoCalendar:campoInputDate")
    public WebElement dataDaAplicacao;
    @FindBy(id = "mainForm:dataCotizacaoCalendar:campoInputDate")
    public WebElement dataDeCotizacao;
    @FindBy(id = "mainForm:dataLiquidacaoCalendar:campoInputDate")
    public WebElement liquidacaoDoMovimento;
    @FindBy(id = "mainForm:estoqueSuggestionInput")
    public WebElement estoque;
    @FindBy(id = "mainForm:quantidadeTextField:campo")
    public WebElement quantidade;
    @FindBy(id = "mainForm:financeiroTextField:campo")
    public WebElement financeiro;

    //endregion

}
