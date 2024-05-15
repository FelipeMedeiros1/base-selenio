package api.transacoes.renda_fixa.operacoes_compromissadas;

import api.componente.TestCase;

public interface OperacoesCompromissadas extends TestCase {
    DadosDaMovimentacaoAba dadosDaMovimentacao();
    LastroDeCompraAba lastroDeCompra();
    LastroDeVendaAba lastroDeVenda();
}
