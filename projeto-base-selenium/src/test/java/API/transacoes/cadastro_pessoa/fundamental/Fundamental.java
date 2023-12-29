package API.transacoes.cadastro_pessoa.fundamental;

import API.componente.EntradaSimples;
import API.componente.SelecionaUm;
import API.componente.SelecionaVarios;
import API.componente.TestCase;

public interface Fundamental extends TestCase {

    EntradaSimples pessoa(String valor);

    EntradaSimples codigo(String valor);

    SelecionaUm localidade(String valor);

    SelecionaVarios grupoDeCarteiras(String... valores);

     ApropriacaoAgentesAba apropriacao();

}
