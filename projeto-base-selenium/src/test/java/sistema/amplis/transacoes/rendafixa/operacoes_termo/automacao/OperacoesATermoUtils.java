package sistema.amplis.transacoes.rendafixa.operacoes_termo.automacao;


import sistema.servicos.leitorDeArquivo.config_json.LeitorJson;
import sistema.servicos.utils.UtilitarioCadastroTestCase;

import sistema.amplis.transacoes.rendafixa.operacoes_termo.pagina.PaginaOperacoesATermo;


public class OperacoesATermoUtils extends UtilitarioCadastroTestCase<OperacoesATermo> {

    private PaginaOperacoesATermo pagina = new PaginaOperacoesATermo();

    public OperacoesATermoUtils(String caminhoArquivo) {
        super(caminhoArquivo);
    }

    @Override
    public void preencheDados(OperacoesATermo dados, int posicao) {
        dados = LeitorJson.carregarDados(getCaminhoArquivo(), posicao, OperacoesATermo.class);

        pagina.selecionaUm(pagina.dadosDaMovimentacao().modalidadeDoMovimento, dados.modalidadeDoMovimento());
        pagina.preenche(pagina.dadosDaMovimentacao().dataDoMovimento, dados.dataDoMovimento());
        pagina.preenche(pagina.dadosDaMovimentacao().dataDaCompra, dados.dataDaCompra());
        pagina.preenche(pagina.dadosDaMovimentacao().dataDoVencimentoDoTermo, dados.dataDoVencimentoDoTermo());
        pagina.preenche(pagina.dadosDaMovimentacao().carteira, dados.carteira());
        pagina.selecionaUm(pagina.dadosDaMovimentacao().titulo, dados.titulo());
        pagina.selecionaUm(pagina.dadosDaMovimentacao().emissao, dados.emissao());
        pagina.selecionaUm(pagina.dadosDaMovimentacao().subsegmentoPrevic, dados.subsegmentoPrevic());
        pagina.preenche(pagina.dadosDaMovimentacao().estoque, dados.estoque());
        pagina.selecionaUm(pagina.dadosDaMovimentacao().nivelDeRisco, dados.nivelDeRisco());
        pagina.selecionaUm(pagina.dadosDaMovimentacao().ativaPassiva, dados.ativaPassiva());
        pagina.selecionaUm(pagina.dadosDaMovimentacao().categoria, dados.categoria());
        pagina.selecionaUm(pagina.dadosDaMovimentacao().riscoBeneficio, dados.riscoBeneficio());
        pagina.selecionaUm(pagina.dadosDaMovimentacao().condicaoDeNegociacao, dados.condicaoDeNegociacao());
        pagina.preenche(pagina.dadosDaMovimentacao().taxaDeNegociacao, dados.taxaDeNegociacao());
        pagina.preenche(pagina.dadosDaMovimentacao().pu, dados.pu());
        pagina.preenche(pagina.dadosDaMovimentacao().quantidade, dados.quantidade());
        pagina.clicar(pagina.dadosDaMovimentacao().calcular);
        pagina.selecionaUm(pagina.dadosDaMovimentacao().rendimento, dados.rendimento());
        pagina.preenche(pagina.dadosDaMovimentacao().irDaOperacao, dados.irDaOperacao());
        pagina.preenche(pagina.dadosDaMovimentacao().iofDaOperacao, dados.iofDaOperacao());
        pagina.selecionaUm(pagina.dadosDaMovimentacao().eventoEmAtraso, dados.eventoEmAtraso());

        pagina.selecionaUm(pagina.custodia().custodiante, dados.custodiante());
        pagina.selecionaUm(pagina.custodia().localDeCustodia, dados.localDeCustodia());
        pagina.selecionaUm(pagina.custodia().contaDeCustodia, dados.contaDeCustodia());

    }

    @Override
    public void acessa() {
        pagina.acessa();
    }

    @Override
    public void confirmaOperacao() {
        pagina.confirmaOperacao();
    }

    @Override
    public OperacoesATermoUtils executar(OperacoesATermo dados, int posicao) {
        acessa();
        preencheDados(dados, posicao);
        confirmaOperacao();
        return this;
    }

    @Override
    protected void consulta(OperacoesATermo dados, int posicao) {

    }

    @Override
    protected OperacoesATermoUtils atualizar(OperacoesATermo dados, int posicao) {
        return this;
    }

    @Override
    protected void excluir(OperacoesATermo dados, int posicao) {

    }


}
