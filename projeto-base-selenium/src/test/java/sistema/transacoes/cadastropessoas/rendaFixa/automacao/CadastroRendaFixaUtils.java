package sistema.transacoes.cadastropessoas.rendaFixa.automacao;


import utils.leitorDeArquivo.config_json.LeitorJson;
import sistema.servico.utils.UtilitarioCadastro;
import sistema.transacoes.cadastropessoas.rendaFixa.pagina.PaginaCadastroRendaFixa;

public class CadastroRendaFixaUtils extends UtilitarioCadastro<CadastroRendaFixa> {
    public CadastroRendaFixaUtils(String caminhoArquivo) {
        super(caminhoArquivo);
    }

    private final PaginaCadastroRendaFixa pagina = new PaginaCadastroRendaFixa();

    @Override
    public void preencheDados(CadastroRendaFixa dados, int posicao) {
        LeitorJson.carregarDados(obterCaminhoArquivo(), posicao, CadastroRendaFixa.class);
        preencheAutoComplete(pagina.carteira, dados.carteira());
        selecionaAba(pagina.negociacao().negociacao);
        selecionaUm(pagina.negociacao().mtm, dados.mtm());
        confirmaOperacao();
    }
    @Override
    public void consultar(CadastroRendaFixa dados, int posicao) {
        dados = LeitorJson.carregarDados(obterCaminhoArquivo(), posicao, CadastroRendaFixa.class);
        preencheFiltroPesquisa("Carteira", dados.carteira());
        confirmaConsulta();
    }
    @Override
    protected String transacao() {
        return "Transações > Cadastros de Pessoas > Carteiras > Cadastros > Renda Fixa";
    }

}
