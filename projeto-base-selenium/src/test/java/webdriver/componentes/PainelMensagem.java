package webdriver.componentes;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;

import static sistema.servicos.utils.LogUtil.*;
import static webdriver.componentes.Assertivas.obterMensagemAtual;
import static webdriver.fabrica.FabricaDeDriver.getDriver;

public class PainelMensagem {

    private static Botao botao = new Botao();

    public static void validaMensagemCadastro() {
        try {
            String mensagemAtual = obterMensagemAtual("messageContent");
            boolean mensagensAceitaveis = mensagemAtual.startsWith("Operação realizada com sucesso!")
                    || mensagemAtual.startsWith("Valor da chave duplicado!")
                    || mensagemAtual.startsWith("CNPJ Duplicado");
            assertTrue("A mensagem atual: " + mensagemAtual + ",  não corresponde a nenhuma das mensagens esperadas.", mensagensAceitaveis);

            clicarOk();
            info(mensagemAtual);
            if (mensagemAtual.startsWith("Valor da chave duplicado!") || mensagemAtual.startsWith("CNPJ Duplicado")) {
                warn("Verificar se o que está cadastrado é o mesmo que está tentando incluir!");
            }
            info("Teste finalizado com sucesso!");

        } catch (AssertionError e) {
            warn("Não foi possível cadastrar: " + e.getMessage());
            info("Teste finalizado com erro!");
            throw e;
        }
    }

    public static void validaMensagemExcluir() {
        try {
            simAceitarMensagem();
            String mensagemAtual = obterMensagemAtual("messageContent");
            boolean mensagemEsperada = mensagemAtual.endsWith("sucesso.");
            assertTrue("A mensagem atual: " + mensagemAtual + " , não corresponde a mensagem esperada:", mensagemEsperada);
            clicarOk();
            info(mensagemAtual);
            info("Teste finalizado com sucesso!");

        } catch (AssertionError e) {
            info("Não é possível excluir elemento: " + e.getMessage());
            throw e;
        }
    }

    public static void validaMensagemProcessamento() {
        String mensagemEsperada = "Processamento";
        String mensagemEsperadaDuploControle = "Existe(m) Pendência(s) de Duplo Controle";

        String mensagemAtual = obterMensagemAtual("messageContent");

        boolean mensagensAceitaveis = mensagemAtual.startsWith(mensagemEsperada) || mensagemAtual.startsWith(mensagemEsperadaDuploControle);
        assertTrue("A mensagem atual não corresponde a nenhuma das mensagens esperadas.", mensagensAceitaveis);
        if (mensagemAtual.startsWith(mensagemEsperada)) {
            info(mensagemAtual);
            clicarOk();
        } else if (mensagemAtual.startsWith(mensagemEsperadaDuploControle)) {
            info(mensagemAtual);
            simAceitarMensagem();
            clicarOk();
        }
        info("Teste finalizado com sucesso!");
    }

    public static void validaMensagemPorTipoDeOperacao(String tipoDeOperacao) {
        try {
            if (tipoDeOperacao.equalsIgnoreCase("cadastrar")
                    || tipoDeOperacao.equalsIgnoreCase("inclusao")
                    || tipoDeOperacao.equalsIgnoreCase("atualizar")) {
                validaMensagemCadastro();

            }
            if (tipoDeOperacao.equalsIgnoreCase("excluir")) {
                validaMensagemExcluir();

            } else if (tipoDeOperacao.equalsIgnoreCase("processamento")) {
                validaMensagemProcessamento();
            }

        } catch (AssertionError e) {
            info("Não foi possível validar a mensagem! Verificar tipo.");
            throw e;
        }
    }

    public void validaMensagem() {

        String mensagem = obterMensagemAtual("messageContent");
        String mensagemEsperada = "Operação realizada com sucesso! Código do Ativo: ";
        assertTrue(mensagem.startsWith(mensagemEsperada));
        String[] codigos = mensagem.replace(mensagemEsperada, "").replace(".", "").trim().toString()
                .split(" Código da Operação: ");
        String ativo = codigos[0];
        String codigoDaOperacao = codigos[1];
//         setAtivo(codigos[0]);
//         setCodigoDaOperacao(codigos[1]);

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
}
