package api.transacoes.cadastro_pessoa.fundamental;

import api.componente.EntradaSimples;
import api.componente.SelecionaUm;
import api.componente.SelecionaVarios;
import api.componente.TestCase;

public interface Fundamental extends TestCase {

    EntradaSimples pessoa(String valor);

    EntradaSimples codigo(String valor);

    SelecionaUm localidade(String valor);

    SelecionaVarios grupoDeCarteiras(String... valores);

     ApropriacaoAgentesAba apropriacao();

}
