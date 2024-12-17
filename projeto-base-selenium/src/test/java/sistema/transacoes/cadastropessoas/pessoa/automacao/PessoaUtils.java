package sistema.transacoes.cadastropessoas.pessoa.automacao;


import servico.leitorDeArquivo.config_json.LeitorJson;
import servico.utils.UtilitarioCadastro;
import sistema.transacoes.cadastropessoas.pessoa.pagina.PaginaPessoa;

public class PessoaUtils extends UtilitarioCadastro<Pessoa> {

    public PessoaUtils(String nomeDaPlanilha) {
        super(nomeDaPlanilha);
    }

    private final PaginaPessoa pagina = new PaginaPessoa();

    @Override
    public void preencheDados(Pessoa dados, int posicao) {
        dados = LeitorJson.carregarDados(getCaminhoArquivo(), posicao, Pessoa.class);
        preenche(pagina.codigo, dados.codigo());
        selecionaUm(pagina.tipoDaPessoa, dados.tipoDaPessoa());
        preenche(pagina.razaoSocial, dados.razaoSocial());
        preenche(pagina.nomeFantasia, dados.nomeFantasia());
        preenche(pagina.cnpjCpf, dados.cnpjCpf());
        selecionaUm(pagina.localidade, dados.localidade());
        selecionaUm(pagina.setorDeAtividade, dados.setorDeAtividade());
        selecionaUm(pagina.status, dados.status());
    }

    @Override
    public void consultar(Pessoa dados, int posicao) {
        dados = LeitorJson.carregarDados(getCaminhoArquivo(), posicao, Pessoa.class);
        preencheFiltroPesquisa("Código", dados.codigo());
        confirmaConsulta();
    }



    @Override
    protected String transacao() {
        return null;
    }
}
