package API.relatorio.patrimonio;

import API.componente.EntradaSimples;
import API.componente.SelecionaUm;
import API.componente.SelecionaVarios;
import API.componente.TestCase;

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
