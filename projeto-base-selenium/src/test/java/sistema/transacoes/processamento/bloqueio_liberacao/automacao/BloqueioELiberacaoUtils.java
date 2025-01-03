package sistema.transacoes.processamento.bloqueio_liberacao.automacao;

import utils.leitorDeArquivo.config_json.LeitorJson;
import sistema.servico.utils.UtilitarioProcessamento;
import sistema.transacoes.processamento.bloqueio_liberacao.pagina.PaginaBloqueioELiberacao;


public class BloqueioELiberacaoUtils extends UtilitarioProcessamento<BloqueioELiberacao> {

    public BloqueioELiberacaoUtils(String caminhoArquivo) {
        super(caminhoArquivo);
    }

    private final PaginaBloqueioELiberacao pagina = new PaginaBloqueioELiberacao();

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
    protected String transacao() {
        return "Transações > Processamento > Carteira > Bloqueio de Processamento e Liberação Contábil";
    }




}
