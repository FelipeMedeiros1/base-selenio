package API.relatorio.renda_fixa;

import API.componente.EntradaSimples;
import API.componente.SelecionaUm;
import API.componente.SelecionaVarios;
import API.componente.TestCase;

public interface Rendimentos extends TestCase {
    EntradaSimples dataInicial(String valor);

    EntradaSimples dataFinal(String valor);

    SelecionaVarios carteira(String... valores);

    SelecionaUm saida(String valor);

    SelecionaUm moeda(String valor);
}
