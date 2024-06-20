package sistema.amplis.relatorios.renda_fixa.movimentacao.automacao;


import sistema.servicos.leitorDeArquivo.config_json.LeitorJson;
import sistema.servicos.utils.UtilitarioRelatorioTestCase;

import sistema.amplis.relatorios.renda_fixa.movimentacao.pagina.PaginaMovimentacao;

public class MovimentacaoUtils extends UtilitarioRelatorioTestCase<Movimentacao> {
    public MovimentacaoUtils(String caminhoArquivo) {
        super(caminhoArquivo);
    }

    private PaginaMovimentacao pagina = new PaginaMovimentacao();


    protected void preencheDados( Movimentacao dados, int posicao) {
        dados = LeitorJson.carregarDados(getCaminhoArquivo(), posicao, Movimentacao.class);
        pagina.preenche(pagina.dataInicio, dados.dataInicio());
        pagina.preenche(pagina.dataFinal, dados.dataFinal());
        pagina.selecionaVarios(pagina.modalidadeDeMovimento, pagina.incluirModalidade, dados.modalidadeDeMovimento());
        pagina.selecionaUm(pagina.titulo, dados.titulo());
        pagina.selecionaUm(pagina.emissao, dados.emissao());
        pagina.selecionaVarios(pagina.carteira, pagina.incluirCarteira, dados.carteira());
        pagina.selecionaUm(pagina.saida, dados.saida());
        pagina.selecionaUm(pagina.idioma, dados.idioma());
        pagina.selecionaUm(pagina.moeda, dados.moeda());
        pagina.selecionaUm(pagina.tipoRelatorio, dados.tipoRelatorio());
    }

    @Override
    protected MovimentacaoUtils gerarRelatorio(Movimentacao dados, int posicao) {
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
        pagina.confirma();
    }
}
