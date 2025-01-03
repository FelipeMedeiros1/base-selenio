package sistema.servico.base.crud;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Então;
import sistema.servico.utils.UtilitarioCadastro;
import webdriver.componentes.PainelMensagem;


public class CrudSteps {
    private UtilitarioCadastro<?> utilitarioCadastro;
    private Object dados;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public CrudSteps() {
    }



    @Dado("que o usuário acessa a página {string}, {string}")
    public void que_o_usuário_acessa_a_página(String pagina, String nomeDoArquivo)
   {
    }
    @Quando("o usuário preenche os campos com os dados do arquivo {string} na posição {int} do arquivo json")
    public void o_usuário_preenche_os_campos_com_os_dados_na_posição_do_arquivo_json(String string, Integer int1) {

    }
    @Então("a nova operação deverá ser incluída com sucesso no sistema")
    public void a_nova_operação_deverá_ser_incluída_com_sucesso_no_sistema() {

    }




    @Dado("que acesse a página {string}")
    public void que_acesse_a_página(String pagina) {
    }

//    @Quando("executar a operação de inclusão e preencher os dados da pagina {string} na posição {int} do arquivo json")
//    public void executar_a_operação_de_inclusão_e_preencher_os_dados_da_pagina_na_posição_do_arquivo_json(M pagina, int posicao) {
////        Moedas moeda = LeitorJson.converteParaJson(pagina, Moedas.class);
//        utilitarioCadastro.incluir(pagina, posicao); // Passa a posição para o método incluir
//    }
    @Então("deverá exibir uma mensagem de {string}:")
    public void deverá_exibir_uma_mensagem_de(String string) {

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
                utilitarioCadastro.alterar(null, 0);
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
