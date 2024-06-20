package sistema.amplis.transacoes.fundos.movimentacao.pagina;


import webdriver.base.Interagivel;
import sistema.servicos.navegacao.Acessa;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaginaMovimentacao extends Interagivel {
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
    private PaginaMovimentacaoConsulta consulta;

    @Override
    public void acessa() {
        new Acessa().transacoesFundos(movimentacao);
        inserir();
    }

    public PaginaMovimentacaoConsulta consulta() {
        if (consulta == null) {
            consulta = new PaginaMovimentacaoConsulta();
        }
        return consulta;
    }
}
