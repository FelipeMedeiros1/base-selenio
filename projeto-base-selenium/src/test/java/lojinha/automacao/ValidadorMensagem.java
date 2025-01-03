package lojinha.automacao;

import webdriver.componentes.Assertivas;

import static org.junit.Assert.assertTrue;
import static webdriver.componentes.Evidencia.*;

public class ValidadorMensagem {

    public static void validaMensagem(String mensagemEsperada) {

        try {
            String mensagem = obterMensagemAtual();
            boolean mensagensAtual = mensagem.equalsIgnoreCase(mensagemEsperada);

            capturaTelaSucesso("LogMensagemInclusaoSucesso", mensagem);
            assertTrue("Mensagem: " + mensagem + ",  não corresponde a mensagem esperada.", mensagensAtual);


            logSucesso("Teste finalizado com sucesso!");
        } catch (AssertionError e) {
            capituraTelaFalha("LogMensagemInclusaoFallha", "Teste finalizado com erro!");
            logAlerta("Não foi possível cadastrar: " + e.getMessage());
            throw e;
        }
    }

    public static String obterMensagemAtual() {
        return Assertivas.obterMensagemAtual( "toast-container");
    }


}
