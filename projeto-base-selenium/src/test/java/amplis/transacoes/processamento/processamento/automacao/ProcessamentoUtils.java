package amplis.transacoes.processamento.processamento.automacao;

import servico.leitorDeArquivo.config_json.LeitorJson;


import amplis.transacoes.processamento.processamento.pagina.PaginaProcessamento;
import webdriver.base.navegacao.automacao.MenuNavegacao;
import servico.utils.UtilitarioProcessamento;


public class ProcessamentoUtils extends UtilitarioProcessamento<Processamento> {
    public ProcessamentoUtils(String nomeDaPlanilha) {
        super(nomeDaPlanilha);
    }

    private final PaginaProcessamento pagina = new PaginaProcessamento();

    protected void preencheDados(Processamento dados, int posicao) {
        dados = LeitorJson.carregarDados(getCaminhoArquivo(), posicao, Processamento.class);
        selecionaPickList(pagina.modulos, dados.modulos());
        selecionaPickList(pagina.tipoDeProcessamento, dados.tipoDeProcessamento());
        preenche(pagina.dataInicial, dados.dataInicial());
        preenche(pagina.dataFinal, dados.dataFinal());
        preencheFiltroPesquisa("Carteira", dados.carteira());
    }

    @Override
    public void acessaPagina() {
        new MenuNavegacao().transacoesProcessamento(pagina.processamento);
    }

    @Override
    protected String transacoes() {
        return "Transações > Processamento > Carteira > Processamento";
    }


}