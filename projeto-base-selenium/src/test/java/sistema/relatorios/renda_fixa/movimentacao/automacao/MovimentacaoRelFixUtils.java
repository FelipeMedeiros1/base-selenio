package sistema.relatorios.renda_fixa.movimentacao.automacao;

import servico.leitorDeArquivo.config_json.LeitorJson;
import servico.utils.UtilitarioRelatorio;
import sistema.relatorios.renda_fixa.movimentacao.pagina.PaginaMovimentacao;

public class MovimentacaoRelFixUtils extends UtilitarioRelatorio<MovimentacaoRelFix> {
    public MovimentacaoRelFixUtils(String caminhoArquivo) {
        super(caminhoArquivo);
    }

    private final PaginaMovimentacao pagina = new PaginaMovimentacao();


    protected void preencheDados(MovimentacaoRelFix dados, int posicao) {
        dados = LeitorJson.carregarDados(getCaminhoArquivo(), posicao, MovimentacaoRelFix.class);
        preenche(pagina.dataInicio, dados.dataInicio());
        preenche(pagina.dataFinal, dados.dataFinal());
        selecionaPickList(pagina.modalidadeDeMovimento, dados.modalidadeDeMovimento());
        selecionaUm(pagina.titulo, dados.titulo());
        selecionaUm(pagina.emissao, dados.emissao());
        selecionaPickList(pagina.carteira, dados.carteira());
        selecionaUm(pagina.saida, dados.saida());
        selecionaUm(pagina.idioma, dados.idioma());
        selecionaUm(pagina.moeda, dados.moeda());
        selecionaUm(pagina.tipoRelatorio, dados.tipoRelatorio());
    }

    @Override
    protected MovimentacaoRelFixUtils gerarRelatorio(MovimentacaoRelFix dados, int posicao) {
        acessaPagina();
        preencheDados(dados, posicao);
        confirma();
        return this;
    }

    @Override
    protected String relatorio() {
        return "Relatórios > Renda Fixa > Movimentação";
    }


}
