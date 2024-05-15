package webdriver.pages.transacoes.processamento.bloqueio_liberacao;

import webdriver.base.BasePage;
import webdriver.config.acesso.Acessa;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BloqueioELiberacaoPage extends BasePage {
    @FindBy(id = "mainForm:dataCalendar:campoInputDate")private WebElement data;
    @FindBy(id = "mainForm:tipoDropdown:campo")private WebElement tipo;
    @FindBy(id ="mainForm:carteira_mnemonicCriteria:criteriaOperator:campo")private WebElement filtro;
    @FindBy(id = "mainForm:carteira_mnemonicCriteria:criteriaInputText:campo")private WebElement carteira;
    @FindBy(id = "mainForm:dataTable:0:checkboxBloqueado")private WebElement chkB;
    @FindBy(id = "mainForm:dataTable:0:checkboxLibContabil")private WebElement chkL;
    @FindBy(id ="mainForm:dataTable:0:motivoBloqueioTextField:campo" )private WebElement motivo;
    @FindBy(id = "mainForm:dataTable:0:motivoDesbloqueioTextField:campo")private WebElement motivoDesbloq;


    public void acessaPaginaBloqueioELiberacao(){
        new Acessa().bloqueioELiberacao();
    }
    public void dataBloqueioLiberacao(String valor){
        preenche(data,valor);
    }
    public void tipo(String valor){
        selecionaUm(tipo,valor);
    }
    public void carteira(String valor){ selecionaUm(filtro,"Igual"); preenche(carteira,valor); confirmar();}
    public void bloqueado(Boolean boleano){ selecionaChekBox(chkB,boleano);}
    public void liberacaoContabil(Boolean boleano){
        selecionaChekBox(chkL,boleano);
    }
    public void motivoDoBloqueio(String valor){preenche(motivo,valor);}
    public void motivoDoDesbloqueio(String valor){
        preenche(motivoDesbloq,valor);
    }
}
