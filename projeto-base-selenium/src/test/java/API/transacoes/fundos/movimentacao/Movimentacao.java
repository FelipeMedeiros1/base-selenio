package API.transacoes.fundos.movimentacao;

import API.componente.EntradaSimples;
import API.componente.SelecionaUm;
import API.componente.TestCase;

public interface Movimentacao extends TestCase {
    EntradaSimples dataDoMovimento(String valor);

    EntradaSimples carteira(String valor);

    EntradaSimples fundo(String valor);

    SelecionaUm modalidadeDoMovimento(String valor);

    SelecionaUm subsegmentoPREVIC(String valor);

    EntradaSimples dataDaAplicacao(String valor);

    EntradaSimples dataDeCotizacao(String valor);

    EntradaSimples liquidacaoDoMovimento(String valor);

    EntradaSimples estoque(String valor);

    EntradaSimples quantidade(String valor);

    EntradaSimples financeiro(String valor);

}
