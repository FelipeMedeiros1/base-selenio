package sistema.transacoes.cadastrobasico.moedas.automacao;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import webdriver.componentes.PainelMensagem;


public class MoedasSteps {

    private Moedas dados;
    private final MoedasUtils moedas = new MoedasUtils("amplis/transacoes/cadastrobasico/moedas/automacao/Moedas.json");

    @Dado("que acesse a página Transações > Cadastros Básicos > Moedas")
    public void acessaPaginaMoedas() {

    }

    @Quando("preencher dados válidos para cada operação")
    public void preencherDadosValidos() {
        moedas.incluir(dados, 1)
        ;
    }

    @Então("deverá exibir uma mensagem de sucesso:")
    public void validarMensagemSucesso() {
        PainelMensagem.validaMensagemInclusao();
    }

}