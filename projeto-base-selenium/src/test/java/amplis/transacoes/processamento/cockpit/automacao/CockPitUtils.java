package amplis.transacoes.processamento.cockpit.automacao;


import org.junit.jupiter.api.Assertions;
import servico.leitorDeArquivo.config_json.LeitorJson;

import amplis.transacoes.processamento.cockpit.pagina.PaginaCockPit;
import webdriver.base.navegacao.automacao.MenuNavegacao;
import servico.utils.UtilitarioProcessamento;

import static webdriver.componentes.Evidencia.*;


public class CockPitUtils extends UtilitarioProcessamento<CockPit> {

    public CockPitUtils(String caminhoArquivo) {
        super(caminhoArquivo);
    }

    private PaginaCockPit pagina = new PaginaCockPit();

    @Override
    protected void preencheDados(CockPit dados, int posicao) {
        dados = LeitorJson.carregarDados(getCaminhoArquivo(), posicao, CockPit.class);
        preenche(pagina.dataProcessamento, dados.dataProcessamento());
        selecionaUm(pagina.tipoProcessamennto, dados.tipoProcessamennto());
        selecionaUm(pagina.filtroCarteira, dados.filtroCarteira());
        preenche(pagina.carteira, dados.carteira());
        selecionaUm(pagina.statusProcessamento, dados.statusProcessamento());
    }

    @Override
    protected String transacao() {
        return "Transações > Processamento > Carteira > Cockpit";
    }


    public UtilitarioProcessamento executar(CockPit dados, int posicao) {
        acessaPagina();
        capturaTelaInfo("capturaTelaMenuTransacoes", transacao());
        preencheDados(dados, posicao);
        capturaTelaInfo("capturaTelaDadosCockpit", "Foram preenchidos os dados para Cockpit.");
        pesquisaResultado();
        return this;
    }


    public void pesquisaResultado() {
        confirma();
        clicar(pagina.resultado);
        clicar(pagina.check);
        capturaTelaInfo("capturaTelaResultado", "Validando resultado");
        Assertions.assertEquals("Processada", pagina.mensagemAtual.getText());
        logSucesso("Teste finalizado com sucesso.");
    }
}
