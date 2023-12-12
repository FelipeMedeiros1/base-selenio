package API.transacoes.cadastro_pessoa.fundamental;

public interface Fundamental {

    void pessoa(String valor);

    void codigo(String valor);

    void localidade(String valor);

    void grupoDeCarteiras(String... valores);

     ApropriacaoAgentesAba apropriacao();

}
