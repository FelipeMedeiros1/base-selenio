package sistema.amplis.transacoes.cadastrobasico.moedas.automacao;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import webdriver.componentes.PainelMensagem;


public class MoedasSteps {

    private Moedas dados;
    private String json = "transacoes/cadastrobasico/moedas/automacao/Moedas.json";
    private MoedasUtils moedas = new MoedasUtils(json);

    @Dado("que acesse a página Transações > Cadastros Básicos > Moedas")
    public void acessaPaginaMoedas() {

        moedas.acessaPagina();
    }

    @Quando("preencher dados válidos para cada operação")
    public void preencherDadosValidos() {
        moedas.incluir(dados, 1)
        ;
    }

    @Então("deverá exibir uma mensagem de sucesso:")
    public void validarMensagemSucesso() {
        PainelMensagem.validaMensagemPorTipoDeOperacao("Inclusao");
    }

}