package sistema.servicos.base.crud;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Então;
import sistema.servicos.utils.UtilitarioCadastro;
import sistema.servicos.utils.UtilitarioCadastroFabrica;
import webdriver.componentes.PainelMensagem;


public class CrudSteps {
    private UtilitarioCadastro<?> utilitarioCadastro;
    private Object dados;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public CrudSteps() {
    }

    @Dado("que abra o navegador e acesse a página especificada {string} com o arquivo {string}")
    public void que_abra_o_navegador_e_acesse_a_pagina_especificada_com_o_arquivo(String pagina, String caminhoJson) {
        this.utilitarioCadastro = UtilitarioCadastroFabrica.getUtilitarioCadastro(pagina, caminhoJson);

    }

    @Quando("preencher os dados da pagina {string} e executar a operação CRUD especificada {string} na posição Json {int}")
    public void preencher_os_dados_da_pagina_e_executar_a_operação_crud_especificada_na_posição_json(String operacao, String  pagina, Integer int1) {
        switch (operacao.toLowerCase()) {
            case "cadastrar":
                utilitarioCadastro.incluir(null, 0);
                break;
            case "consultar":
                utilitarioCadastro.consultar(null, 0);
                break;
            case "atualizar":
                utilitarioCadastro.atualizar(null, 0);
                break;
            case "excluir":
                utilitarioCadastro.excluir(null, 0);
                break;
            default:
                throw new IllegalArgumentException("Operação desconhecida: " + operacao);
        }
    }
    private Object converterDados(String dadosJson, Class<?> tipoDeDados) {
        try {
            return objectMapper.readValue(dadosJson, tipoDeDados);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao converter dados: " + e.getMessage(), e);
        }
    }

    @Então("verifica se a mensagem pelo tipo de operação {string}")
    public void verifica_se_a_mensagem_esperada_e_exibida(String tipoDeOperacao) {
        PainelMensagem.validaMensagemPorTipoDeOperacao(tipoDeOperacao);

    }
}
