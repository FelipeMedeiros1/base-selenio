package sistema.transacoes.rendafixa.operacoe_compromisadas.pagina;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import sistema.transacoes.rendafixa.operacoe_compromisadas.pagina.PaginaOperacoesCompromissadas;


public class LastroDeCompraAba extends PaginaOperacoesCompromissadas {


    @FindBy(id = "mainForm:tab_fixRepoCollateralReceive:header")
    public WebElement lastroDeCompra;
    @FindBy(id = "mainForm:dataTable1:0:securitySelicPU550_textField:campo")
    public WebElement tituloSelicPu550Titulo;
    @FindBy(id = "mainForm:dataTable1:0:tituloDropdown:campo")
    public WebElement titulo;
    @FindBy(id = "mainForm:dataTable1:0:emissaoDropdown:campo")
    public WebElement emissao;
    @FindBy(id = "mainForm:dataTable1:0:issueDate_calendar:campoInputDate")
    public WebElement dataDaEmissao;
    @FindBy(id = "mainForm:dataTable1:0:maturityDate_calendar:campoInputDate")
    public WebElement dataDeVencimento;
    @FindBy(id = "mainForm:dataTable1:0:campoCalculadoLastroCompromissadaDropdown:campo")
    public WebElement calcular;
    @FindBy(id = "mainForm:dataTable1:0:grossValueReceive_textField:campo")
    public WebElement financeiroIda;
    @FindBy(id = "mainForm:dataTable1:0:price550Receive_textField:campo")
    public WebElement pu550Pu;
    @FindBy(id = "mainForm:dataTable1:0:quantityReceive_textField:campo")
    public WebElement quantidade;
    @FindBy(id = "mainForm:dataTable1:0:grossValueCalculatedReceive_textField:campo")
    public WebElement financeiroDeIdaCalculado;
    @FindBy(id = "mainForm:dataTable1:0:ISINcodeReceive_textField:campo")
    public WebElement isin;
    @FindBy(id = "mainForm:dataTable1:0:codigoSelicCetip_textField:campo")
    public WebElement codigoSelicCetipCompra;
    @FindBy(id = "mainForm:dataTable1:0:sphere_dropdown:campo")
    public WebElement esferaDaEmissao;
    @FindBy(id = "mainForm:dataTable1:0:relatedCompany_dropdown:campo")
    public WebElement empresaLigada;
    @FindBy(id = "mainForm:dataTable1:0:descricaoBacen_dropdown:campo")
    public WebElement descricaoBacen;
    @FindBy(id = "mainForm:dataTable1:0:codigoCBLC_textField:campo")
    public WebElement codigoCBLCCompra;
    @FindBy(id = "mainForm:dataTable1:0:site_dropdown:campo")
    public WebElement localidade;
    @FindBy(id = "mainForm:dataTable1:0:secutityIssuePerfilMensal_dropdown2:campo")
    public WebElement emissorParaPerfilMensal;

}
