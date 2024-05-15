package api.relatorio.renda_fixa;

import api.componente.EntradaSimples;
import api.componente.SelecionaUm;
import api.componente.SelecionaVarios;
import api.componente.TestCase;

public interface Movimentacao extends TestCase {
    EntradaSimples dataInicio(String valor);

    EntradaSimples dataFinal(String valor);

    SelecionaVarios modalidadeDeMovimento(String... valores);

    SelecionaUm titulo(String valor);

    SelecionaUm emissao(String valor);

    SelecionaVarios carteira(String... valores);

    SelecionaUm saida(String valor);

    SelecionaUm idioma(String valor);

    SelecionaUm moeda(String valor);

    SelecionaUm tipoRelatorio(String valor);
}
