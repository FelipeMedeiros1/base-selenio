package API.transacoes.processamento;

import API.componente.TestCase;

public interface Processamento extends TestCase {
    void modulos(String... opcoes);

    void tipoDeProcessamento(String... opcoes);

    void dataInicial(String valor);

    void dataFinal(String valor);

    void carteira(String valor);
}
