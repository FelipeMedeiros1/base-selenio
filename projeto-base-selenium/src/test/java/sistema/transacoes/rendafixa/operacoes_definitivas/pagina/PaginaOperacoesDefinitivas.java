package sistema.transacoes.rendafixa.operacoes_definitivas.pagina;

import webdriver.base.BasePagina;

public class PaginaOperacoesDefinitivas extends BasePagina {

    private DadosDaMovimentacaoAba dadosDaMovimentacao;

    public DadosDaMovimentacaoAba dadosDaMovimentacao() {

        if (dadosDaMovimentacao == null) {
            dadosDaMovimentacao = new DadosDaMovimentacaoAba();
        }
        return dadosDaMovimentacao;
    }
}
