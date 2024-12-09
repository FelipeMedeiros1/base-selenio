package amplis.transacoes.cadastropessoas.rendaFixa.automacao;

import amplis.transacoes.cadastropessoas.rendaFixa.pagina.PaginaCadastroRendaFixa;
import servico.leitorDeArquivo.config_json.LeitorJson;
import servico.utils.UtilitarioCadastro;

public class CadastroRendaFixaUtils extends UtilitarioCadastro<CadastroRendaFixa> {
    public CadastroRendaFixaUtils(String caminhoArquivo) {
        super(caminhoArquivo);
    }

    private PaginaCadastroRendaFixa pagina = new PaginaCadastroRendaFixa();

    @Override
    public void preencheDados(CadastroRendaFixa dados, int posicao) {
        LeitorJson.carregarDados(getCaminhoArquivo(), posicao, CadastroRendaFixa.class);
        preencheAutoComplete(pagina.carteira, dados.carteira());
        selecionaAba(pagina.negociacao().negociacao);
        selecionaUm(pagina.negociacao().mtm, dados.mtm());
        confirmaOperacao();
    }
    @Override
    public void consultar(CadastroRendaFixa dados, int posicao) {
        dados = LeitorJson.carregarDados(getCaminhoArquivo(), posicao, CadastroRendaFixa.class);
        preencheFiltroPesquisa("Carteira", dados.carteira());
        confirmaConsulta();
    }
    @Override
    protected String transacao() {
        return "Transações > Cadastros de Pessoas > Carteiras > Cadastros > Renda Fixa";
    }

}
