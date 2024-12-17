package sistema.transacoes.processamento.processamento.automacao;

import servico.leitorDeArquivo.config_json.LeitorJson;

import servico.utils.UtilitarioProcessamento;
import sistema.transacoes.processamento.processamento.pagina.PaginaProcessamento;


public class ProcessamentoUtils extends UtilitarioProcessamento<Processamento> {
    public ProcessamentoUtils(String nomeDaPlanilha) {
        super(nomeDaPlanilha);
    }

    private final PaginaProcessamento pagina = new PaginaProcessamento();
    @Override
    protected void preencheDados(Processamento dados, int posicao) {
        dados = LeitorJson.carregarDados(getCaminhoArquivo(), posicao, Processamento.class);
        selecionaPickList(pagina.modulos, dados.modulos());
        selecionaPickList(pagina.tipoDeProcessamento, dados.tipoDeProcessamento());
        preenche(pagina.dataInicial, dados.dataInicial());
        preenche(pagina.dataFinal, dados.dataFinal());
        preencheFiltroPesquisa("Carteira", dados.carteira());
    }

    @Override
    protected String transacao() {
        return "Transações > Processamento > Carteira > Processamento";
    }




}