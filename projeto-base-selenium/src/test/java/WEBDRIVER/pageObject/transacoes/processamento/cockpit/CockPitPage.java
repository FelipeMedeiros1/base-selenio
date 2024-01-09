package WEBDRIVER.pageObject.transacoes.processamento.cockpit;

import WEBDRIVER.base.basePage.BasePage;
import WEBDRIVER.componentes.CapturaDeTela;
import WEBDRIVER.config.menu.painel_acoes.Acessa;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CockPitPage extends BasePage {
    //region
    @FindBy(id="mainForm:dtCriteriaTextField:campoInputDate")private WebElement dataInicial;
    @FindBy(id = "mainForm:tipoPosicaoDropdown:campo")private WebElement tipo;
    @FindBy(id = "mainForm:mnemonicCriteria:criteriaOperator:campo")private WebElement filtro;
    @FindBy(id = "mainForm:mnemonicCriteria:criteriaInputText:campo")private WebElement nomeCarteira;
    @FindBy(id = "mainForm:statusCriteria:criteriaOperator:campo")private WebElement status;
    @FindBy(css ="#mainForm\\:clientTree\\:0\\:j_id_ah_2_5y > div > span.rf-trn-hnd-colps.rf-trn-hnd")private WebElement resultado;
    @FindBy(css = "#mainForm\\:clientTree\\:0\\.0\\:j_id_ah_2_67 > div > span.rf-trn-hnd-colps.rf-trn-hnd")private WebElement check;
    @FindBy(id = "mainForm:clientTree:0.0.0:dataTablePatrimonio:0:mensagensPatrimonio")private WebElement msg;
    //endregion

    public CockPitPage acessaPaginaCockPit(){
        new Acessa().cockPit();
        return this;
    }

    public CockPitPage dataProcessamento(String data){
        esperaPor(2000);
        preenche(dataInicial,data);
        return this;
    }
    public CockPitPage tipoProcessamennto(String valor){
        selecionaUm(tipo,valor);
        return this;
    }

    public CockPitPage carteira(String valor){
        selecionaUm(filtro,"Igual");
        preenche(nomeCarteira,valor);
        return this;
    }

    public CockPitPage statusProcessamento(String valor){
        selecionaUm(status,valor);
        return this;
    }

    public void pesquisaResultado(){
        confirmar();
        scrollParaBaixoAteEncontrar(resultado);
        esperaElementoSerClicavel(resultado);
        resultado.click();
        scrollParaBaixoAteEncontrar(check);
        check.click();
        new CapturaDeTela().evidencia("CockPit","Finalizando-teste");
        scrollParaBaixoAteEncontrar(msg);
//        validaMensagem("Processamento realizado com sucesso.",msg);
    }
}
