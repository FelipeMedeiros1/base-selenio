package sistema.amplis.transacoes.processamento.processamento.automacao;

import sistema.servicos.leitorDeArquivo.config_json.LeitorJson;


import sistema.amplis.transacoes.processamento.processamento.pagina.PaginaProcessamento;
import sistema.servicos.utils.UtilitarioProcessamento;


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
        selecionaUm(pagina.filtroCarteira, dados.filtroCarteira());
        preenche(pagina.carteira, dados.carteira());
    }

    public ProcessamentoUtils executar(Processamento dadosProcessamento, int posicao) {
        this.acessaPagina();
        preencheDados(dadosProcessamento, posicao);
        executarProcessamento();
        return this;
    }

    @Override
    public void acessaPagina() {
        pagina.acessa();
    }


}