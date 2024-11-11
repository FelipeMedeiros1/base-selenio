package amplis.transacoes.rendafixa.operacoes_definitivas.automacao;


import servico.leitorDeArquivo.config_json.LeitorJson;
import webdriver.base.navegacao.automacao.MenuNavegacao;
import servico.utils.UtilitarioCadastro;

import amplis.transacoes.rendafixa.operacoes_definitivas.pagina.PaginaOperacoesDefinitivas;

public class OperacoesDefinitivasFixUtils extends UtilitarioCadastro<OperacoesDefinitivas> {
    private PaginaOperacoesDefinitivas pagina = new PaginaOperacoesDefinitivas();

    public OperacoesDefinitivasFixUtils(String nomeDaPlanilha) {
        super(nomeDaPlanilha);
    }

    @Override
    public void preencheDados(OperacoesDefinitivas dados, int posicao) {
        dados = LeitorJson.carregarDados(getCaminhoArquivo(), posicao, OperacoesDefinitivas.class);

        selecionaAba(pagina.dadosDaMovimentacao().dadosDaMovimentacao);
        selecionaUm(pagina.dadosDaMovimentacao().modalidadeDoMovimento, dados.modalidadeDomovimento());
        preenche(pagina.dadosDaMovimentacao().dataDoMovimento, dados.dataDoMovimento());
        if (!dados.dataDaCompra().equals("")) {
            preenche(pagina.dadosDaMovimentacao().dataDaCompra, dados.dataDaCompra());
        }

        preencheDuplicado(pagina.dadosDaMovimentacao().carteira, dados.carteira()).esperaPor(1000);
        selecionaUm(pagina.dadosDaMovimentacao().titulo, dados.titulo()).esperaPor(1000);
        selecionaUm(pagina.dadosDaMovimentacao().emissao, dados.emissao()).esperaPor(1000);
        if (dados.modalidadeDomovimento().equalsIgnoreCase("Venda a Vista Coberta") || dados.modalidadeDomovimento().equalsIgnoreCase("Retirada a Vista Coberta")) {
            preencheAutoComplete(pagina.dadosDaMovimentacao().estoque, dados.estoque());
        }
        selecionaUm(pagina.dadosDaMovimentacao().ativaPassiva, dados.ativaPassiva());
        selecionaUm(pagina.dadosDaMovimentacao().categoria, dados.categoria());
        selecionaUm(pagina.dadosDaMovimentacao().riscoBeneficio, dados.riscoBeneficio());
        if (!dados.condicoesDeNegociacao().equalsIgnoreCase("")) {
            selecionaUm(pagina.dadosDaMovimentacao().condicoesDeNegociacao, dados.condicoesDeNegociacao());
        }
        preenche(pagina.dadosDaMovimentacao().pu, dados.pu());
        preenche(pagina.dadosDaMovimentacao().quantidade, dados.quantidade());
        clicar(pagina.dadosDaMovimentacao().calcular);
        preenche(pagina.dadosDaMovimentacao().financeiro, dados.financeiro());
        selecionaUm(pagina.dadosDaMovimentacao().rendimento, dados.rendimento());
        selecionaUm(pagina.dadosDaMovimentacao().eventoEmAtraso, dados.eventoEmAtraso());

    }

    @Override
    public void consultar(OperacoesDefinitivas dados, int posicao) {
        dados = LeitorJson.carregarDados(getCaminhoArquivo(), posicao, OperacoesDefinitivas.class);
        preencheFiltroPesquisa("Carteira", dados.carteira());
        confirmaConsulta();
    }

    @Override
    public void acessaPagina() {
        new MenuNavegacao().transacoesRendaFixa(pagina.opDefinitivas);

    }

    @Override
    protected String transacao() {
        return null;
    }


}
