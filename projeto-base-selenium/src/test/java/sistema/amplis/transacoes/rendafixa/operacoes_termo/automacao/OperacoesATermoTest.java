package sistema.amplis.transacoes.rendafixa.operacoes_termo.automacao;

import io.cucumber.java.es.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import sistema.amplis.transacoes.rendafixa.operacoes_termo.pagina.PaginaOperacoesATermo;

import static org.junit.Assert.assertNotNull;

public class OperacoesATermoTest /*extends BaseTeste*/ {
    private OperacoesATermoUtils op = new OperacoesATermoUtils("transacoes/rendafixa/operacoes_termo/automacao/OperacoesATermo.json");
    private OperacoesATermo dados;

//    @Test
//    public void teste01() {
//        new OperacoesATermoUtils("OperacoesATermoTest").executar(opTermo, 1);
//    }

    @Dado("que acesse a página Transações > Renda Fixa > Movimentação > Operações a Termo")
    public void acessarPagina() {
        op.acessa();
    }

    @Quando("preencher os dados válidos e executar a operação")
    public void preencherDados() {
        op.preencheDados( dados, 1);
    }

    @Então("deverá lançar uma mensagem de sucesso")
    public void confirmarOperacao() {
        confirmarOperacao();
        assertNotNull(this.dados);
    }
}
