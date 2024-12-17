package sistema.transacoes.fundos.movimentacao.automacao;


import servico.leitorDeArquivo.config_json.LeitorJson;
import servico.utils.UtilitarioCadastro;
import sistema.transacoes.fundos.movimentacao.pagina.PaginaMovimentacao;


public class MovimentacaoFdsUtils extends UtilitarioCadastro<Movimentacao> {
    public MovimentacaoFdsUtils(String caminhoArquivo) {
        super(caminhoArquivo);
    }

    private final PaginaMovimentacao pagina = new PaginaMovimentacao();

    @Override
    public void preencheDados(Movimentacao dados, int posicao) {
        dados =
                LeitorJson.carregarDados(getCaminhoArquivo(), posicao, Movimentacao.class);
        preenche(pagina.dataDoMovimento, dados.dataDoMovimento());
        preencheDuplicado(pagina.carteira, dados.carteira());
        preencheAutoComplete(pagina.fundo, dados.fundo());
        selecionaUm(pagina.NegociacaoDeCotaAMercado, dados.NegociacaoDeCotaAMercado());
        selecionaUm(pagina.modalidadeDoMovimento, dados.modalidadeDoMovimento());
        selecionaUm(pagina.subsegmentoPREVIC, dados.subsegmentoPREVIC());
        preenche(pagina.dataDaAplicacao, dados.dataDaAplicacao());
        preenche(pagina.dataDeCotizacao, dados.dataDeCotizacao());
        preenche(pagina.liquidacaoDoMovimento, dados.liquidacaoDoMovimento());
        if (dados.estoque() != "" || dados.estoque() != null) {
            preenche(pagina.estoque, dados.estoque());
        }
        preenche(pagina.quantidade, dados.quantidade());
        preenche(pagina.financeiro, dados.financeiro());
    }

    @Override
    public MovimentacaoFdsUtils incluir(Movimentacao dados, int posicao) {
        acessaPagina();
        inserir();
        preencheDados(dados, posicao);
        this.confirmaOperacao();
        return this;
    }

    @Override
    public void consultar(Movimentacao dados, int posicao) {
        dados = LeitorJson.carregarDados(getCaminhoArquivo(), posicao, Movimentacao.class);
        preencheFiltroPesquisa("Carteira", dados.carteira());
        confirmaConsulta();
    }




    @Override
    protected String transacao() {
        return null;
    }


}
