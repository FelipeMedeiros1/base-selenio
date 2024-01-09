package API.transacoes.renda_fixa.operacoes_compromissadas;

import API.componente.TestCase;

public interface OperacoesCompromissadas extends TestCase {
    DadosDaMovimentacaoAba dadosDaMovimentacao();
    LastroDeCompraAba lastroDeCompra();
    LastroDeVendaAba lastroDeVenda();
}
