package sistema.amplis.transacoes.processamento.bloqueio_liberacao.automacao;


import sistema.servicos.leitorDeArquivo.config_json.LeitorJson;
import sistema.servicos.utils.UtilitarioCadastroTestCase;

import sistema.amplis.transacoes.processamento.bloqueio_liberacao.pagina.PaginaBloqueioELiberacao;
import sistema.servicos.utils.UtilitarioProcessamentoTestCase;


public class BloqueioELiberacaoUtils extends UtilitarioProcessamentoTestCase<BloqueioELiberacao> {

    public BloqueioELiberacaoUtils(String caminhoArquivo) {
        super(caminhoArquivo);
    }

    private PaginaBloqueioELiberacao pagina = new PaginaBloqueioELiberacao();

    @Override
    protected void preencheDados(BloqueioELiberacao dados, int posicao) {
        dados = LeitorJson.carregarDados(getCaminhoArquivo(), posicao, BloqueioELiberacao.class);
        pagina.preenche(pagina.dataBloqueioLiberacao, dados.dataBloqueioLiberacao());
        pagina.selecionaUm(pagina.tipo, dados.tipo());
        pagina.selecionaUm(pagina.filtroCarteira, dados.fitroCarteira());
        pagina.preenche(pagina.carteira, dados.carteira()).confirma();
        if (dados.bloqueado().equals("true")) {
            pagina.selecionaChekBox(pagina.bloqueado, Boolean.valueOf(dados.bloqueado()));
            pagina.selecionaChekBox(pagina.liberacaoContabil, Boolean.valueOf(dados.liberacaoContabil()));
        }
        if (dados.bloqueado().equals("false") && dados.liberacaoContabil().equals("false")) {
            pagina.selecionaChekBox(pagina.liberacaoContabil, Boolean.valueOf(dados.liberacaoContabil()));
            pagina.selecionaChekBox(pagina.bloqueado, Boolean.valueOf(dados.bloqueado()));
        }
        pagina.preenche(pagina.motivoDoBloqueio, dados.motivoDoBloqueio());
        pagina.preenche(pagina.motivoDoDesbloqueio, dados.motivoDoDesbloqueio());
    }

    @Override
    public BloqueioELiberacaoUtils executar(BloqueioELiberacao dados, int posicao) {
        acessa();
        preencheDados(dados, posicao);
        confirmaOperacao();
        return this;
    }

    @Override
    public void acessa() {
        pagina.acessa();
    }

    @Override
    public void confirmaOperacao() {
        pagina.confirmaOperacao();
    }
}
