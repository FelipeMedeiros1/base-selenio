package sistema.amplis.transacoes.rendafixa.operacoes_definitivas.automacao;


import sistema.servicos.leitorDeArquivo.config_json.LeitorJson;
import sistema.servicos.utils.UtilitarioCadastro;

import sistema.amplis.transacoes.rendafixa.operacoes_definitivas.pagina.PaginaOperacoesDefinitivas;

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

//        preencheAutoComplete(pagina.dadosDaMovimentacao().carteira, dados.carteira());
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
    public OperacoesDefinitivasFixUtils incluir(OperacoesDefinitivas dados, int posicao) {
        acessaPagina();
        inserir();
        preencheDados(dados, posicao);
        confirmaOperacao();
        return this;
    }

    @Override
    public void consultar(OperacoesDefinitivas dados, int posicao) {
        dados = LeitorJson.carregarDados(getCaminhoArquivo(), posicao, OperacoesDefinitivas.class);

    }

    @Override
    public OperacoesDefinitivasFixUtils atualizar(OperacoesDefinitivas dados, int posicao) {
        return this;
    }

    @Override
    public void excluir(OperacoesDefinitivas dados, int posicao) {

    }

    @Override
    public void acessaPagina() {
        pagina.acessa();

    }


}
