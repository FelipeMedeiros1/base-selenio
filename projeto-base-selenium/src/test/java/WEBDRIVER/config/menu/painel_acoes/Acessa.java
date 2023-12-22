package WEBDRIVER.config.menu.painel_acoes;

import WEBDRIVER.base.basePage.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static WEBDRIVER.fabrica.FabricaDeDriver.getDriver;

public class Acessa extends BasePage {

    /*### TRANSAÇÕES ### */
    public void moedas() {
       navegarPara(transacoes, cadastroBasico, moedas);
    }

    public void processamento() {
        navegarPara(transacoes, processamento, processamentoTela);
    }

    public void processamentoContabil() {
        navegarPara(transacoes, processamento, processamentoContabil);
    }

    public void cockPit() {
        navegarPara(transacoes, processamento, cockPit);
    }

    public void bloqueioELiberacao() {
        navegarPara(transacoes, processamento, bloqueioELiberacao);
    }

    public void cadastroFundamental() {
        navegarPara(transacoes, cadastroDePessoas, fundamental);
    }

    public void cadastroPatrimonio() {
        navegarPara(transacoes, cadastroDePessoas, cadPatrimonio);
    }

    public void cadastroRendaFixa() {
        navegarPara(transacoes, cadastroDePessoas, cadRendaFixa);
    }

    public void cadastroRendaVariavel() {
        navegarPara(transacoes, cadastroDePessoas, cadRendaVariavel);
    }

    public void cadastroFundos() {
        navegarPara(transacoes, cadastroDePessoas, cadFundos);
    }

    public void cadastroPessoas() {
        navegarPara(transacoes, cadastroDePessoas, cadPessoas);
    }

    public void operacoesDefinitivas() {
        navegarPara(transacoes, rendaFixa, opDefinitivas);
    }

    public void operacoesATermo() {
        navegarPara(transacoes, rendaFixa, opTermo);
    }

    /*### RELATÓRIOS ###*/
    public void relCarteiraDiaria() {
        navegarPara(relatorios, relPatrimonio, relCarteiraDiaria);
    }

    public void relMovimentacaoRendaFixa() {
        navegarPara(relatorios, relRendaFixa, relMovimentacaoRendaFixa);
    }

    public void relRendimentosRendaFixa() {
        navegarPara(relatorios, relRendaFixa, relRendimentos);
    }

    private void navegarPara(WebElement menu, WebElement modulo, WebElement tela) {
        Actions acoes = new Actions(getDriver());
        esperaElementoSerClicavel(menu);
        acoes.moveToElement(menu).perform();
        acoes.moveToElement(modulo).perform();
        acoes.click(tela).perform();
        esperaPor(1500);
    }


    //region
    @FindBy(id = "menuButton")
    private WebElement transacoes;
    @FindBy(linkText = "Renda Fixa")
    private WebElement rendaFixa;
    @FindBy(id = "mainForm:j_id_1z:8:j_id_2w:2:j_id_2z:1:j_id_36")
    private WebElement opDefinitivas;
    @FindBy(id = "mainForm:j_id_1z:8:j_id_2w:2:j_id_2z:2:j_id_36")
    private WebElement opTermo;
    @FindBy(linkText = "Processamento")
    private WebElement processamento;
    @FindBy(id = "mainForm:j_id_1z:18:j_id_2w:0:j_id_2z:1:j_id_36")
    private WebElement processamentoTela;
    @FindBy(id = "mainForm:j_id_1z:18:j_id_2w:0:j_id_2z:4:j_id_36")
    private WebElement cockPit;
    @FindBy(id = "mainForm:j_id_1z:18:j_id_2w:0:j_id_2z:3:j_id_36")
    private WebElement bloqueioELiberacao;
    @FindBy(id = "mainForm:j_id_1z:18:j_id_2w:2:j_id_2z:0:j_id_36")
    private WebElement processamentoContabil;
    @FindBy(linkText = "Cadastros Básicos")
    private WebElement cadastroBasico;
    @FindBy(id = "mainForm:j_id_1z:3:j_id_2w:4:j_id_5b")
    private WebElement moedas;
    @FindBy(linkText = "Cadastros de Pessoas")
    private WebElement cadastroDePessoas;
    @FindBy(id = "mainForm:j_id_1z:6:j_id_2w:3:j_id_2z:0:j_id_3p:0:j_id_3w")
    private WebElement fundamental;
    @FindBy(id = "mainForm:j_id_22:6:j_id_2z:3:j_id_32:0:j_id_3s:1:j_id_3z")
    private WebElement cadPatrimonio;
    @FindBy(id = "mainForm:j_id_22:6:j_id_2z:3:j_id_32:0:j_id_3s:2:j_id_3z")
    private WebElement cadRendaFixa;
    @FindBy(id = "mainForm:j_id_22:6:j_id_2z:3:j_id_32:0:j_id_3s:3:j_id_3z")
    private WebElement cadRendaVariavel;
    @FindBy(id = "mainForm:j_id_22:6:j_id_2z:3:j_id_32:0:j_id_3s:4:j_id_3z")
    private WebElement cadFundos;
    @FindBy(id = "mainForm:j_id_1z:6:j_id_2w:0:j_id_5b")
    private WebElement cadPessoas;

    /*Relatorios*/
    @FindBy(id = "menuRelatoriosButtonSpan")
    private WebElement relatorios;
    @FindBy(linkText = "Patrimônio")
    private WebElement relPatrimonio;
    @FindBy(id = "mainForm:j_id_62:2:j_id_6n:0:j_id_82")
    private WebElement relCarteiraDiaria;
    @FindBy(linkText = "Renda Fixa")
    private WebElement relRendaFixa;
    @FindBy(id = "mainForm:j_id_62:1:j_id_6n:0:j_id_82")
    private WebElement relMovimentacaoRendaFixa;
    @FindBy(id = "mainForm:j_id_62:1:j_id_6n:1:j_id_82")
    private WebElement relRendimentos;

    //endregion

}
