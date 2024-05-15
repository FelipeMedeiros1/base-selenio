package webdriver.pages.transacoes.renda_fixa.operacoes_definitivas;

import api.transacoes.renda_fixa.operacoes_definitivas.DadosDaMovimentacaoAba;
import api.transacoes.renda_fixa.operacoes_definitivas.OperacoesDefinitivas;
import webdriver.base.BasePage;
import webdriver.config.acesso.Acessa;

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
