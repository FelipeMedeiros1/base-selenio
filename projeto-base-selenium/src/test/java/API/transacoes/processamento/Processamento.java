package API.transacoes.processamento;

public interface Processamento {
    void modulos(String... opcoes);

    void tipoDeProcessamento(String... opcoes);

    void dataInicial(String valor);

    void dataFinal(String valor);

    void carteira(String valor);
}
