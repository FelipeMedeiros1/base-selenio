package WEBDRIVER.pageObject.transacoes.renda_fixa.operacoesdefinitivas;

import API.transacoes.renda_fixa.operacoes_definitivas.DadosDaMovimentacaoAba;
import API.transacoes.renda_fixa.operacoes_definitivas.OperacoesDefinitivas;
import WEBDRIVER.base.basePage.BasePage;
import WEBDRIVER.config.menu.painel_acoes.Acessa;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OperacoesDefinitivasPage extends BasePage implements OperacoesDefinitivas {
    private DadosDaMovimentacaoAba dadosDaMovimentacao;
    @Override
    public void acessaPagina() {
        new Acessa().operacoesDefinitivas();
        inserir();
    }

    @Override
    public DadosDaMovimentacaoAba dadosDaMovimentacao() {
        if (dadosDaMovimentacao == null) {
            dadosDaMovimentacao = new DadosDaMovimentacaoAbaImpl();
            dadosDaMovimentacao.seleciona();
        }
        return dadosDaMovimentacao;
    }
}
