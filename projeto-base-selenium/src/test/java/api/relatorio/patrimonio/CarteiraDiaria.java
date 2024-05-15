package api.relatorio.patrimonio;

import api.componente.EntradaSimples;
import api.componente.SelecionaUm;
import api.componente.SelecionaVarios;
import api.componente.TestCase;

public interface CarteiraDiaria extends TestCase {
    EntradaSimples dataInicio(String valor);

    EntradaSimples dataFinal(String valor);

    SelecionaVarios tipoDePosicao(String... valores);

    SelecionaUm tipoDeConsolidacao(String valor);

    SelecionaUm custoMedio(String valor);

    SelecionaVarios carteira(String... valores);

    SelecionaUm tipoDoRelatorio(String valor);

    SelecionaUm saida(String valor);

}
