package amplis.transacoes.rendafixa.operacoes_termo.automacao;


import servico.leitorDeArquivo.config_json.LeitorJson;
import webdriver.base.navegacao.automacao.MenuNavegacao;
import servico.utils.UtilitarioCadastro;

import amplis.transacoes.rendafixa.operacoes_termo.pagina.PaginaOperacoesATermo;


public class OperacoesATermoFixUtils extends UtilitarioCadastro<OperacoesATermo> {

    private PaginaOperacoesATermo pagina = new PaginaOperacoesATermo();

    public OperacoesATermoFixUtils(String caminhoArquivo) {
        super(caminhoArquivo);
    }

    @Override
    public void preencheDados(OperacoesATermo dados, int posicao) {
        dados = LeitorJson.carregarDados(getCaminhoArquivo(), posicao, OperacoesATermo.class);
        selecionaAba(pagina.dadosDaMovimentacao().dadosDaMovimentacao);
        selecionaUm(pagina.dadosDaMovimentacao().modalidadeDoMovimento, dados.modalidadeDoMovimento());
        preenche(pagina.dadosDaMovimentacao().dataDoMovimento, dados.dataDoMovimento());
        preenche(pagina.dadosDaMovimentacao().dataDaCompra, dados.dataDaCompra());
        preenche(pagina.dadosDaMovimentacao().dataDoVencimentoDoTermo, dados.dataDoVencimentoDoTermo());
        preenche(pagina.dadosDaMovimentacao().carteira, dados.carteira());
        selecionaUm(pagina.dadosDaMovimentacao().titulo, dados.titulo());
        selecionaUm(pagina.dadosDaMovimentacao().emissao, dados.emissao());
        selecionaUm(pagina.dadosDaMovimentacao().subsegmentoPrevic, dados.subsegmentoPrevic());
        preenche(pagina.dadosDaMovimentacao().estoque, dados.estoque());
        selecionaUm(pagina.dadosDaMovimentacao().nivelDeRisco, dados.nivelDeRisco());
        selecionaUm(pagina.dadosDaMovimentacao().ativaPassiva, dados.ativaPassiva());
        selecionaUm(pagina.dadosDaMovimentacao().categoria, dados.categoria());
        selecionaUm(pagina.dadosDaMovimentacao().riscoBeneficio, dados.riscoBeneficio());
        selecionaUm(pagina.dadosDaMovimentacao().condicaoDeNegociacao, dados.condicaoDeNegociacao());
        preenche(pagina.dadosDaMovimentacao().taxaDeNegociacao, dados.taxaDeNegociacao());
        preenche(pagina.dadosDaMovimentacao().pu, dados.pu());
        preenche(pagina.dadosDaMovimentacao().quantidade, dados.quantidade());
        clicar(pagina.dadosDaMovimentacao().calcular);
        selecionaUm(pagina.dadosDaMovimentacao().rendimento, dados.rendimento());
        preenche(pagina.dadosDaMovimentacao().irDaOperacao, dados.irDaOperacao());
        preenche(pagina.dadosDaMovimentacao().iofDaOperacao, dados.iofDaOperacao());
        selecionaUm(pagina.dadosDaMovimentacao().eventoEmAtraso, dados.eventoEmAtraso());

        selecionaAba(pagina.custodia().custodia);
        selecionaUm(pagina.custodia().custodiante, dados.custodiante());
        selecionaUm(pagina.custodia().localDeCustodia, dados.localDeCustodia());
        selecionaUm(pagina.custodia().contaDeCustodia, dados.contaDeCustodia());

    }

    @Override
    public void consultar(OperacoesATermo dados, int posicao) {
        dados = LeitorJson.carregarDados(getCaminhoArquivo(), posicao, OperacoesATermo.class);
        preencheFiltroPesquisa("Carteira", dados.carteira());
        confirmaConsulta();
    }



    @Override
    protected String transacao() {
        return null;
    }
}
