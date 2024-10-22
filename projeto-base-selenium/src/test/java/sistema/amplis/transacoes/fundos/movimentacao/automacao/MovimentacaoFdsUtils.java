package sistema.amplis.transacoes.fundos.movimentacao.automacao;


import sistema.servicos.leitorDeArquivo.config_json.LeitorJson;
import sistema.servicos.utils.UtilitarioCadastro;

import sistema.amplis.transacoes.fundos.movimentacao.pagina.PaginaMovimentacao;


public class MovimentacaoFdsUtils extends UtilitarioCadastro<Movimentacao> {
    public MovimentacaoFdsUtils(String caminhoArquivo) {
        super(caminhoArquivo);
    }

    private PaginaMovimentacao pagina = new PaginaMovimentacao();

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
        acessaPagina();
        selecionaUm(pagina.consulta().filtroCarteira, dados.filtroCarteiraConsulta());
        preenche(pagina.consulta().carteiraConsulta, dados.carteiraConsulta());
        confirmaConsulta();
    }

    @Override
    public MovimentacaoFdsUtils atualizar(Movimentacao dados, int posicao) {
        consultar(dados, posicao);
        alterar();
        preencheDados(dados, posicao);
        confirmaOperacao();
        return this;

    }

    @Override
    public void excluir(Movimentacao dados, int posicao) {
        consultar(dados, posicao);
        excluir();
    }

    @Override
    public void acessaPagina() {
        pagina.acessa();

    }



}
