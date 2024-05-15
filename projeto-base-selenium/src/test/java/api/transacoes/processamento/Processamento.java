package api.transacoes.processamento;

import api.componente.EntradaSimples;
import api.componente.SelecionaUm;
import api.componente.SelecionaVarios;
import api.componente.TestCase;

public interface Processamento extends TestCase {
    SelecionaVarios modulos(String... opcoes);

    SelecionaVarios tipoDeProcessamento(String... opcoes);

    EntradaSimples dataInicial(String valor);

    EntradaSimples dataFinal(String valor);

    SelecionaUm filtroCarteira(String valor);

    EntradaSimples carteira(String valor);
}
