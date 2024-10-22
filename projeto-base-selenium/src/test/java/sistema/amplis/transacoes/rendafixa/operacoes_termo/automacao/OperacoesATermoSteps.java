package sistema.amplis.transacoes.rendafixa.operacoes_termo.automacao;

import io.cucumber.java.es.Dado;
import io.cucumber.java.pt.Quando;

public class OperacoesATermoSteps {
    private String json = "transacoes/rendafixa/operacoes_termo/automacao/OperacoesATermo.json";
    private OperacoesATermo dados;


    @Dado("que acesse a página Transações > Renda Fixa > Movimentação > Operações a Termo")
    public void acessarPagina() {

    }

    @Quando("preencher dados válidos para a operação")
    public void preencherDados() {
        new OperacoesATermoFixUtils(json).incluir(dados, 1);
    }


}
