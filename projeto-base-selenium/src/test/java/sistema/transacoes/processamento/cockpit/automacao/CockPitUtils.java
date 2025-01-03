package sistema.transacoes.processamento.cockpit.automacao;


import org.junit.jupiter.api.Assertions;
import utils.leitorDeArquivo.config_json.LeitorJson;
import sistema.servico.utils.UtilitarioProcessamento;
import sistema.transacoes.processamento.cockpit.pagina.PaginaCockPit;

import static webdriver.componentes.Evidencia.*;


public class CockPitUtils extends UtilitarioProcessamento<CockPit> {

    public CockPitUtils(String caminhoArquivo) {
        super(caminhoArquivo);
    }

    private final PaginaCockPit pagina = new PaginaCockPit();

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
