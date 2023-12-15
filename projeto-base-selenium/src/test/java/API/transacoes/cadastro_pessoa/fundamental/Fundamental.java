package API.transacoes.cadastro_pessoa.fundamental;

import API.componente.TestCase;

public interface Fundamental extends TestCase {

    void pessoa(String valor);

    void codigo(String valor);

    void localidade(String valor);

    void grupoDeCarteiras(String... valores);

     ApropriacaoAgentesAba apropriacao();

}
