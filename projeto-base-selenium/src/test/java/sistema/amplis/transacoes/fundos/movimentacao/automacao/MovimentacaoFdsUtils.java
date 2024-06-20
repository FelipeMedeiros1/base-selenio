package sistema.amplis.transacoes.fundos.movimentacao.automacao;


import sistema.servicos.leitorDeArquivo.config_json.LeitorJson;
import sistema.servicos.utils.UtilitarioCadastroTestCase;

import sistema.amplis.transacoes.fundos.movimentacao.pagina.PaginaMovimentacao;


public class MovimentacaoFdsUtils extends UtilitarioCadastroTestCase<Movimentacao> {
    public MovimentacaoFdsUtils(String caminhoArquivo) {
        super(caminhoArquivo);
    }

    private PaginaMovimentacao pagina = new PaginaMovimentacao();

    @Override
    protected void preencheDados(Movimentacao dados, int posicao) {
        dados =
                LeitorJson.carregarDados(getCaminhoArquivo(), posicao, Movimentacao.class);
        pagina.preenche(pagina.dataDoMovimento, dados.dataDoMovimento());
        pagina. preencheDevagar(pagina.carteira, dados.carteira());
        pagina.preencheAutoComplete(pagina.fundo, dados.fundo());
        pagina.selecionaUm(pagina.NegociacaoDeCotaAMercado, dados.NegociacaoDeCotaAMercado());
        pagina.selecionaUm(pagina.modalidadeDoMovimento, dados.modalidadeDoMovimento());
        pagina.selecionaUm(pagina.subsegmentoPREVIC, dados.subsegmentoPREVIC());
        pagina.preenche(pagina.dataDaAplicacao, dados.dataDaAplicacao());
        pagina.preenche(pagina.dataDeCotizacao, dados.dataDeCotizacao());
        pagina.preenche(pagina.liquidacaoDoMovimento, dados.liquidacaoDoMovimento());
        if (dados.estoque() != "" || dados.estoque() != null) {
            pagina.preenche(pagina.estoque, dados.estoque());
        }
        pagina.preenche(pagina.quantidade, dados.quantidade());
        pagina.preenche(pagina.financeiro, dados.financeiro());
    }

    @Override
    public MovimentacaoFdsUtils executar(Movimentacao dados, int posicao) {
        acessa();
        preencheDados(dados, posicao);
        confirmaOperacao();
        return this;
    }

    @Override
    protected void consulta(Movimentacao dados, int posicao) {
        dados = LeitorJson.carregarDados(getCaminhoArquivo(), posicao, Movimentacao.class);
        pagina.consulta().acessaConsulta();
        pagina.selecionaUm(pagina.consulta().filtroCarteira, dados.filtroCarteiraConsulta());
        pagina.preenche(pagina.consulta().carteiraConsulta, dados.carteiraConsulta());
        pagina.confirma();
        pagina.selecionaNaGrid(0);
    }

    @Override
    protected MovimentacaoFdsUtils atualizar(Movimentacao dados, int posicao) {
        consulta(dados, posicao);
        pagina.alterar();
        preencheDados(dados, posicao);
        confirmaOperacao();
        return this;

    }

    @Override
    protected void excluir(Movimentacao dados, int posicao) {
        consulta(dados, posicao);
        pagina.excluir();
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
