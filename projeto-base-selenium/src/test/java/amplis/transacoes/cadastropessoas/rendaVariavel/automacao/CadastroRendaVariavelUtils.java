package amplis.transacoes.cadastropessoas.rendaVariavel.automacao;

import amplis.transacoes.cadastropessoas.rendaFixa.pagina.PaginaCadastroRendaFixa;
import amplis.transacoes.cadastropessoas.rendaVariavel.pagina.PaginaCadastroRendaVariavel;
import servico.leitorDeArquivo.config_json.LeitorJson;
import servico.utils.UtilitarioCadastro;

public class CadastroRendaVariavelUtils extends UtilitarioCadastro<CadastroRendaVariavel> {
    public CadastroRendaVariavelUtils(String caminhoArquivo) {
        super(caminhoArquivo);
    }

    private PaginaCadastroRendaVariavel pagina = new PaginaCadastroRendaVariavel();

    @Override
    public void preencheDados(CadastroRendaVariavel dados, int posicao) {
        LeitorJson.carregarDados(getCaminhoArquivo(), posicao, CadastroRendaVariavel.class);

    }
    @Override
    public void consultar(CadastroRendaVariavel dados, int posicao) {
        dados = LeitorJson.carregarDados(getCaminhoArquivo(), posicao, CadastroRendaVariavel.class);
        preencheFiltroPesquisa("Carteira", dados.carteira());
        confirmaConsulta();
    }
    @Override
    protected String transacao() {
        return "Transações > Cadastros de Pessoas > Carteiras > Cadastros > Renda Variável";
    }

}
