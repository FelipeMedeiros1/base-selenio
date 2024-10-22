package sistema.amplis.transacoes.processamento.bloqueio_liberacao.automacao;


import sistema.servicos.leitorDeArquivo.config_json.LeitorJson;

import sistema.amplis.transacoes.processamento.bloqueio_liberacao.pagina.PaginaBloqueioELiberacao;
import sistema.servicos.utils.UtilitarioProcessamento;


public class BloqueioELiberacaoUtils extends UtilitarioProcessamento<BloqueioELiberacao> {

    public BloqueioELiberacaoUtils(String caminhoArquivo) {
        super(caminhoArquivo);
    }

    private PaginaBloqueioELiberacao pagina = new PaginaBloqueioELiberacao();

    @Override
    protected void preencheDados(BloqueioELiberacao dados, int posicao) {
        dados = LeitorJson.carregarDados(getCaminhoArquivo(), posicao, BloqueioELiberacao.class);
        preenche(pagina.dataBloqueioLiberacao, dados.dataBloqueioLiberacao());
        selecionaUm(pagina.tipo, dados.tipo());
        selecionaUm(pagina.filtroCarteira, dados.fitroCarteira());
        preenche(pagina.carteira, dados.carteira());
        confirma();
        if (dados.bloqueado().equals("true")) {
            selecionaChekBox(pagina.bloqueado, Boolean.valueOf(dados.bloqueado()));
            selecionaChekBox(pagina.liberacaoContabil, Boolean.valueOf(dados.liberacaoContabil()));
        }
        if (dados.bloqueado().equals("false") && dados.liberacaoContabil().equals("false")) {
            selecionaChekBox(pagina.liberacaoContabil, Boolean.valueOf(dados.liberacaoContabil()));
            selecionaChekBox(pagina.bloqueado, Boolean.valueOf(dados.bloqueado()));
        }
        preenche(pagina.motivoDoBloqueio, dados.motivoDoBloqueio());
        preenche(pagina.motivoDoDesbloqueio, dados.motivoDoDesbloqueio());
    }

    @Override
    public BloqueioELiberacaoUtils executar(BloqueioELiberacao dados, int posicao) {
        acessaPagina();
        preencheDados(dados, posicao);
        confirmaOperacao();
        return this;
    }

    @Override
    public void acessaPagina() {
        pagina.acessa();
    }


}
