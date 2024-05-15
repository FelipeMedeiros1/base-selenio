package api.relatorio.renda_fixa;

import api.componente.EntradaSimples;
import api.componente.SelecionaUm;
import api.componente.SelecionaVarios;
import api.componente.TestCase;

public interface Rendimentos extends TestCase {
    EntradaSimples dataInicial(String valor);

    EntradaSimples dataFinal(String valor);

    SelecionaVarios carteira(String... valores);

    SelecionaUm saida(String valor);

    SelecionaUm moeda(String valor);
}
