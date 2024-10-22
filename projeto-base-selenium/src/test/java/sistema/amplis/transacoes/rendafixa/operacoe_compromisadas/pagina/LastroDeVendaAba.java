package sistema.amplis.transacoes.rendafixa.operacoe_compromisadas.pagina;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LastroDeVendaAba extends PaginaOperacoesCompromissadas {
    @FindBy(id = "")
    public WebElement lastroDeVenda;
    @FindBy(id = "mainForm:dataTable2:0:securityDelivery_dropdown:campo")
    public WebElement tituloSelicPu550TituloVenda;
    @FindBy(id = "mainForm:dataTable2:0:securityIssueDelivery_dropdown:campo")
    public WebElement emissaoVenda;
    @FindBy(id = "mainForm:dataTable2:0:fixAssetSuggestionDeliveryInput")
    public WebElement codigoDaOperacaoVenda;
    @FindBy(id = "mainForm:dataTable2:0:issueDate2_calendar:campoInputDate")
    public WebElement dataDeEmissaoVenda;
    @FindBy(id = "mainForm:dataTable2:0:maturityDate2_calendar:campoInputDate")
    public WebElement dataDeVencimentoVenda;
    @FindBy(id = "mainForm:dataTable2:0:campoCalculadoLastroVendaCompromissadaDropdown:campo")
    public WebElement calcularVenda;
    @FindBy(id = "mainForm:dataTable2:0:grossValueDelivery_textField:campo")
    public WebElement financeiroIdaVenda;
    @FindBy(id = "mainForm:dataTable2:0:price550_textField:campo")
    public WebElement pu550PuVenda;
    @FindBy(id = "mainForm:dataTable2:0:quantityDelivery_textField:campo")
    public WebElement quantidadeVenda;
    @FindBy(id = "mainForm:dataTable2:0:grossValueCalculated_textField:campo")
    public WebElement financeiroDeIdaCalculadoVenda;
    @FindBy(id = "mainForm:dataTable2:0:ISINcodeDelivery_textField:campo")
    public WebElement isinVenda;
    @FindBy(id = "mainForm:dataTable2:0:codigoSelicCetipVenda_textField:campo")
    public WebElement codigoSelicCetipVenda;
    @FindBy(id = "mainForm:dataTable2:0:codigoCBLC_textField:campo")
    public WebElement codigoCBLCVenda;
}
