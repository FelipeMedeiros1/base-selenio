package webdriver.componentes;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;

import static servico.utils.LogUtil.*;

import static webdriver.componentes.Evidencia.*;
import static webdriver.fabrica.FabricaDeDriver.getDriver;

public class PainelMensagem {

    private static Botao botao = new Botao();

    public static void validaMensagemInclusao() {
        try {
            String mensagemAtual = obterMensagemAtual();
            boolean mensagensAceitaveis = mensagemAtual.startsWith("Operação realizada com sucesso!")
                    || mensagemAtual.startsWith("Valor da chave duplicado!")
                    || mensagemAtual.startsWith("CPF Duplicado");
            capturaTelaSucesso("LogMensagemInclusaoSucesso", mensagemAtual);
            assertTrue("Mensagem: " + mensagemAtual + ",  não corresponde a nenhuma das mensagens esperadas.", mensagensAceitaveis);
            clicarOk();
            if (mensagemAtual.startsWith("Valor da chave duplicado!") || mensagemAtual.startsWith("CNPJ Duplicado")) {
                logAlerta("Verificar se o que está cadastrado é o mesmo que deseja incluir!");
            }
            logSucesso("Teste finalizado com sucesso!");
        } catch (AssertionError e) {
            capituraTelaFalha("LogMensagemInclusaoFallha", "Teste finalizado com erro!");
            logAlerta("Não foi possível cadastrar: " + e.getMessage());
            throw e;
        }
    }

    public static void validaMensagemExclusao() {
        try {
            simAceitarMensagem();
            String mensagemAtual = obterMensagemAtual();
            boolean mensagemEsperada = mensagemAtual.endsWith("sucesso.");
            if (mensagemEsperada) {
                capturaTelaSucesso("LogMensagemExclusaoSucesso", mensagemAtual);
                assertTrue("Mensagem: " + mensagemAtual + " , não corresponde a mensagem esperada:", mensagemEsperada);
                clicarOk();
                logSucesso("Teste finalizado com sucesso!");
            } else {
                logAlerta("LogExclusaoFallha", "Não foi possível excluir: " + mensagemAtual);
                logFalha("Teste finalizado com erro!");
                throw new AssertionError("Não foi possível excluir: " + mensagemAtual);
            }
        } catch (AssertionError e) {

        }
    }

    public static void validaMensagemProcessamento() {
        String mensagemEsperada = "Processamento";
        String mensagemEsperadaDuploControle = "Existe(m) Pendência(s) de Duplo Controle";

        String mensagemAtual = obterMensagemAtual();
        boolean mensagensAceitaveis = mensagemAtual.startsWith(mensagemEsperada) || mensagemAtual.startsWith(mensagemEsperadaDuploControle);
        assertTrue("A mensagem atual não corresponde a nenhuma das mensagens esperadas.", mensagensAceitaveis);
        if (mensagemAtual.startsWith(mensagemEsperada)) {
            capturaTelaSucesso("LogProcessamentoSucesso", mensagemAtual);
            clicarOk();
        } else if (mensagemAtual.startsWith(mensagemEsperadaDuploControle)) {
            simAceitarMensagem();
            capturaTelaSucesso("LogProcessamentoSucesso", "Processamento(s) Iniciado(s).");
            clicarOk();
        }
    }

    public static void validaMensagemPorTipoDeOperacao(String tipoDeOperacao) {
        try {
            if (tipoDeOperacao.equalsIgnoreCase("cadastrar")
                    || tipoDeOperacao.equalsIgnoreCase("inclusao")
                    || tipoDeOperacao.equalsIgnoreCase("atualizar")) {
                validaMensagemInclusao();

            }
            if (tipoDeOperacao.equalsIgnoreCase("excluir")) {
                validaMensagemExclusao();

            } else if (tipoDeOperacao.equalsIgnoreCase("processamento")) {
                validaMensagemProcessamento();
            }

        } catch (AssertionError e) {
            info("Não foi possível validar a mensagem! Verificar tipo.");
            throw e;
        }
    }

    private static void simAceitarMensagem() {
        botao.clicar("messageForm:painelMensagensConfirmDialogButton");
    }

    private static void naoAceitarMensagem() {
        botao.clicar("messageForm:painelMensagensConfirmDialogButton");
    }

    private static void clicarOk() {
        botao.clicar("messageForm:painelMensagensOkActionDialogButton");
    }

    public boolean estaVisivel() {
        try {
            WebElement painelMensagem = getDriver().findElement(By.id("messageContent"));
            return painelMensagem.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public static String obterMensagemAtual() {
        return Assertivas.obterMensagemAtual("messageContent");
    }

    public void validaMensagem() {

        String mensagem = obterMensagemAtual();
        String mensagemEsperada = "Operação realizada com sucesso! Código do Ativo: ";
        assertTrue(mensagem.startsWith(mensagemEsperada));
        String[] codigos = mensagem.replace(mensagemEsperada, "").replace(".", "").trim().toString()
                .split(" Código da Operação: ");
        String ativo = codigos[0];
        String codigoDaOperacao = codigos[1];
//         setAtivo(codigos[0]);
//         setCodigoDaOperacao(codigos[1]);

    }
}
