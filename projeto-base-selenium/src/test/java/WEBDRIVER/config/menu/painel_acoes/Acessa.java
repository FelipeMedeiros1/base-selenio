package WEBDRIVER.config.menu.painel_acoes;

import WEBDRIVER.base.basePage.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static WEBDRIVER.fabrica.FabricaDeDriver.getDriver;

public  class Acessa extends BasePage {
    //region
    @FindBy(id = "menuButton") private WebElement transacoes;
    @FindBy(linkText = "Renda Fixa") private WebElement rendaFixa;
    @FindBy(id ="mainForm:j_id_1z:8:j_id_2w:2:j_id_2z:1:j_id_36")private WebElement opDefinitivas;
    @FindBy(linkText = "Processamento")private WebElement processamento;
    @FindBy(id = "mainForm:j_id_1z:18:j_id_2w:0:j_id_2z:1:j_id_36")private WebElement processamentoTela;
    @FindBy(id = "mainForm:j_id_1z:18:j_id_2w:0:j_id_2z:4:j_id_36")private WebElement cockPit;
    @FindBy(id = "mainForm:j_id_1z:18:j_id_2w:0:j_id_2z:3:j_id_36")private WebElement bloqueioELiberacao;
    @FindBy(id = "mainForm:j_id_1z:18:j_id_2w:2:j_id_2z:0:j_id_36")private WebElement processamentoContabil;
    @FindBy(linkText = "Cadastros Básicos")private WebElement cadastroBasico;
    @FindBy(id = "mainForm:j_id_1z:3:j_id_2w:4:j_id_5b")private WebElement moedas;
    @FindBy(linkText = "Cadastros de Pessoas")private WebElement cadastroDePessoas;
    @FindBy(id = "mainForm:j_id_1z:6:j_id_2w:3:j_id_2z:0:j_id_3p:0:j_id_3w")private WebElement fundamental;
    @FindBy(id = "mainForm:j_id_22:6:j_id_2z:3:j_id_32:0:j_id_3s:1:j_id_3z")private WebElement cadPatrimonio;
    @FindBy(id = "mainForm:j_id_22:6:j_id_2z:3:j_id_32:0:j_id_3s:2:j_id_3z")private WebElement cadRendaFixa;
    @FindBy(id = "mainForm:j_id_22:6:j_id_2z:3:j_id_32:0:j_id_3s:3:j_id_3z")private WebElement cadRendaVariavel;
    @FindBy(id = "mainForm:j_id_22:6:j_id_2z:3:j_id_32:0:j_id_3s:4:j_id_3z")private WebElement cadFundos;
   @FindBy(id = "mainForm:j_id_22:6:j_id_2z:0:j_id_5e")private WebElement cadPessoas;
    /*Relatorios*/
    @FindBy(id = "menuRelatoriosButtonSpan")private WebElement relatorios;
   @FindBy(linkText = "Patrimônio")private WebElement relatorioPatrimonio;
   @FindBy(id = "mainForm:j_id_62:2:j_id_6n:0:j_id_82")private WebElement carteiraDiaria;
    @FindBy(linkText = "Renda Fixa")private WebElement relatorioRendaFixa;
    @FindBy(id = "mainForm:j_id_62:1:j_id_6n:0:j_id_82")private WebElement relMovimentacaoRendaFixa;
    @FindBy(id = "mainForm:j_id_62:1:j_id_6n:1:j_id_82")private WebElement relRendimentos;

    //endregion
    /* TRANSAÇÕES */
    private void pagina(WebElement menu, WebElement modulo, WebElement tela){
        Actions acoes = new Actions(getDriver());
        esperaElementoSerClicavel(menu);
        acoes.moveToElement(menu).perform();
        acoes.moveToElement(modulo).perform();
        acoes.click(tela).perform();
        esperaPor(1500);
    }

    /* TRANSAÇÕES */
    public void moedas(){ pagina(transacoes,cadastroBasico,moedas);}
    public void processamento() { pagina(transacoes,processamento,processamentoTela);}
    public void processamentoContabil(){ pagina(transacoes,processamento,processamentoContabil);}
    public void cockPit(){ pagina(transacoes,processamento,cockPit);}
    public void bloqueioELiberacao(){ pagina(transacoes,processamento, bloqueioELiberacao);}
    public void cadastroFundamental(){ pagina(transacoes,cadastroDePessoas,fundamental);}
    public void cadastroPatrimonio(){ pagina(transacoes,cadastroDePessoas, cadPatrimonio);}
    public void cadastroRendaFixa(){pagina(transacoes,cadastroDePessoas,cadRendaFixa);}
    public void cadastroRendaVariavel(){ pagina(transacoes,cadastroDePessoas,cadRendaVariavel);}
    public void cadastroFundos(){ pagina(transacoes,cadastroDePessoas,cadFundos);}
    public void cadastroPessoas(){ pagina(transacoes,cadastroDePessoas,cadPessoas);}
    public void operacoesDefinitivas(){ pagina(transacoes,rendaFixa,opDefinitivas);}

   /* RELATÓRIOS */
    public void carteiraDiaria(){ pagina(relatorios,relatorioPatrimonio,carteiraDiaria);}
    public void relMovimentacaoRendaFixa(){ pagina(relatorios,relatorioRendaFixa,relMovimentacaoRendaFixa);}
    public void relRendimentosRendaFixa(){ pagina(relatorios,relatorioRendaFixa,relRendimentos);}


}
