package SISTEMA.transacoes.renda_fixa.operacoes_termo;


import SISTEMA.config.servicos.leitorDeArquivo.config_xls.LeitorXls;
import SISTEMA.config.servicos.utils.UtilitarioCadastroTestCase;

import WEBDRIVER.pageObject.transacoes.renda_fixa.operacoes_termo.OperacoesATermoPage;

import static SISTEMA.config.servicos.utils.RelatorioEvidenciaDeTeste.logDeFalha;
import static SISTEMA.config.servicos.utils.RelatorioEvidenciaDeTeste.evidencia;


public class OperacoesATermoUtils extends UtilitarioCadastroTestCase<OperacoesATermo, OperacoesATermoPage> {

    public OperacoesATermoUtils(String nomeDaPlanilha) {
        super(nomeDaPlanilha);
    }


    @Override
    protected void preencheDados(OperacoesATermoPage page, OperacoesATermo modeloDeCadastro, String chavePrimaria) {
        modeloDeCadastro = LeitorXls.carregarDados(getNomeDaPlanilha(), chavePrimaria, "OperacoesATermo", OperacoesATermo.class);

        page.dadosDaMovimentacao().modalidadeDoMovimento(modeloDeCadastro.getModalidadeDoMovimento());
        evidencia("OperacoesATermo", "modalidadeDoMovimento");
        page.dadosDaMovimentacao().dataDoMovimento(modeloDeCadastro.getDataDoMovimento());
        evidencia("OperacoesATermo", "dataDoMovimento");
        page.dadosDaMovimentacao().dataDaCompra(modeloDeCadastro.getDataDaCompra());
        evidencia("OperacoesATermo", "dataDaCompra");
        page.dadosDaMovimentacao().dataDoVencimentoDoTermo(modeloDeCadastro.getDataDoVencimentoDoTermo());
        evidencia("OperacoesATermo", "dataDoVencimentoDoTermo");
        page.dadosDaMovimentacao().carteira(modeloDeCadastro.getCarteira());
        evidencia("OperacoesATermo", "carteira");
        page.dadosDaMovimentacao().titulo(modeloDeCadastro.getTitulo());
        evidencia("OperacoesATermo", "titulo");
        page.dadosDaMovimentacao().emissao(modeloDeCadastro.getEmissao());
        evidencia("OperacoesATermo", "emissao");
        page.dadosDaMovimentacao().subsegmentoPrevic(modeloDeCadastro.getSubsegmentoPrevic());
        evidencia("OperacoesATermo", "subsegmentoPrevic");
        page.dadosDaMovimentacao().estoque(modeloDeCadastro.getEstoque());
        evidencia("OperacoesATermo", "estoque");
        page.dadosDaMovimentacao().nivelDeRisco(modeloDeCadastro.getNivelDeRisco());
        evidencia("OperacoesATermo", "nivelDeRisco");
        page.dadosDaMovimentacao().ativaPassiva(modeloDeCadastro.getAtivaPassiva());
        evidencia("OperacoesATermo", "ativaPassiva");
        page.dadosDaMovimentacao().categoria(modeloDeCadastro.getCategoria());
        evidencia("OperacoesATermo", "categoria");
        page.dadosDaMovimentacao().riscoBeneficio(modeloDeCadastro.getRiscoBeneficio());
        evidencia("OperacoesATermo", "riscoBeneficio");
        page.dadosDaMovimentacao().condicaoDeNegociacao(modeloDeCadastro.getRiscoBeneficio());
        evidencia("OperacoesATermo", "condicaoDeNegociacao");
        page.dadosDaMovimentacao().taxaDeNegociacao(modeloDeCadastro.getTaxaDeNegociacao());
        evidencia("OperacoesATermo", "taxaDeNegociacao");
        page.dadosDaMovimentacao().pu(modeloDeCadastro.getPu());
        evidencia("OperacoesATermo", "pu");
        page.dadosDaMovimentacao().quantidade(modeloDeCadastro.getQuantidade());
        evidencia("OperacoesATermo", "quantidade");
        page.dadosDaMovimentacao().calcular();
        page.dadosDaMovimentacao().rendimento(modeloDeCadastro.getRendimento());
        evidencia("OperacoesATermo", "rendimento");
        page.dadosDaMovimentacao().irDaOperacao(modeloDeCadastro.getIrDaOperacao());
        evidencia("OperacoesATermo", "irDaOperacao");
        page.dadosDaMovimentacao().iofDaOperacao(modeloDeCadastro.getIofDaOperacao());
        evidencia("OperacoesATermo", "iofDaOperacao");
        page.dadosDaMovimentacao().eventoEmAtraso(modeloDeCadastro.getEventoEmAtraso());
        evidencia("OperacoesATermo", "eventoEmAtraso");
        page.custodia().custodiante(modeloDeCadastro.getCustodiante());
        evidencia("OperacoesATermo", "custodiante");
        page.custodia().localDeCustodia(modeloDeCadastro.getLocalDeCustodia());
        evidencia("OperacoesATermo", "localDeCustodia");
        page.custodia().contaDeCustodia(modeloDeCadastro.getContaDeCustodia());
        evidencia("OperacoesATermo", "contaDeCustodia");
    }

    @Override
    public OperacoesATermoUtils executarTeste(OperacoesATermo modeloDeCadastro, String chavePrimaria) {
        try {
            OperacoesATermoPage page = new OperacoesATermoPage();
            page.acessaPagina();
            preencheDados(page, modeloDeCadastro, chavePrimaria);
            page.confirmaOperacao("OperacoesATermo");

        } catch (Exception e) {
            e.printStackTrace();
            logDeFalha("OperacoesATermo");
        }
        return this;
    }
}
