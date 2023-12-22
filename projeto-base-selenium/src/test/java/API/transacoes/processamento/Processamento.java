package API.transacoes.processamento;

import API.componente.EntradaSimples;
import API.componente.SelecionaUm;
import API.componente.SelecionaVarios;
import API.componente.TestCase;

public interface Processamento extends TestCase {
    SelecionaVarios modulos(String... opcoes);

    SelecionaVarios tipoDeProcessamento(String... opcoes);

    EntradaSimples dataInicial(String valor);

    EntradaSimples dataFinal(String valor);

    SelecionaUm filtroCarteira(String valor);

    EntradaSimples carteira(String valor);
}
