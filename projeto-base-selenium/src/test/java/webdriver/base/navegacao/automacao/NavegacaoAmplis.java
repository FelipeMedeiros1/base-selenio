package webdriver.base.navegacao.automacao;

public class NavegacaoAmplis extends MenuNavegacao {


    public void navegarPara(String pagina) {
        switch (pagina) {
            case "Transações > Cadastros Básicos > Localidades" ->  transacoesCadastroBasico("mainForm:j_id_1z:3:j_id_2w:1:j_id_5b");
            case "Transações > Cadastros Básicos > Moedas" -> transacoesCadastroBasico( "mainForm:j_id_1z:3:j_id_2w:4:j_id_5b");
            case "Transações > Taxas > Taxas Administrativas > Perfil de Taxas Administrativas" -> transacoesTaxas("mainForm:j_id_1z:4:j_id_2w:0:j_id_2z:0:j_id_36");
            case "Transações > Cadastros de Pessoas > Pessoas" ->transacoesCadastroDePessoas("mainForm:j_id_1z:6:j_id_2w:0:j_id_5b");
            case "Transações > Cadastros de Pessoas > Carteiras > Cadastros > Fundamental" ->transacoesCadastroDePessoas( "mainForm:j_id_1z:6:j_id_2w:3:j_id_2z:0:j_id_3p:0:j_id_3w");
            case "Transações > Cadastros de Pessoas > Carteiras > Cadastros > Patrimônio" -> transacoesCadastroDePessoas( "mainForm:j_id_1z:6:j_id_2w:3:j_id_2z:0:j_id_3p:1:j_id_3w");
            case "Transações > Cadastros de Pessoas > Carteiras > Cadastros > Fundos" -> transacoesCadastroDePessoas("mainForm:j_id_1z:6:j_id_2w:3:j_id_2z:0:j_id_3p:4:j_id_3w" );
            case "Transações > Cadastros de Pessoas > Carteiras > Cadastros > Renda Fixa" -> transacoesCadastroDePessoas("mainForm:j_id_1z:6:j_id_2w:3:j_id_2z:0:j_id_3p:2:j_id_3w" );
            case "Transações > Cadastros de Pessoas > Carteiras > Cadastros > Renda Variável"-> transacoesCadastroDePessoas("mainForm:j_id_1z:6:j_id_2w:3:j_id_2z:0:j_id_3p:3:j_id_3w" );
            case "Transações > Cadastros de Pessoas > Carteiras > Cadastros > Derivativos"-> transacoesCadastroDePessoas( "mainForm:j_id_1z:6:j_id_2w:3:j_id_2z:0:j_id_3p:5:j_id_3w");
            case "Transações > Cadastros de Pessoas > Carteiras > Cadastros > Swap"-> transacoesCadastroDePessoas("mainForm:j_id_1z:6:j_id_2w:3:j_id_2z:0:j_id_3p:6:j_id_3w");
            case "Transações > Renda Fixa > Movimentação > Operações Definitivas" -> transacoesRendaFixa("mainForm:j_id_1z:8:j_id_2w:2:j_id_2z:1:j_id_36");
            case "Transações > Renda Fixa > Movimentação > Operações a Termo" -> transacoesRendaFixa("mainForm:j_id_1z:8:j_id_2w:2:j_id_2z:2:j_id_36");
            case "Transações > Renda Fixa > Movimentação > Operações Compromissadas" -> transacoesRendaFixa( "mainForm:j_id_1z:8:j_id_2w:2:j_id_2z:3:j_id_36");
            case "Transações > Fundos > Movimentação > Movimentação" -> transacoesFundos("mainForm:j_id_1z:11:j_id_2w:5:j_id_2z:1:j_id_36");
            case "Transações > Processamento > Carteira > Processamento" -> transacoesProcessamento("mainForm:j_id_1z:18:j_id_2w:0:j_id_2z:1:j_id_36");
            case "Transações > Processamento > Carteira > Bloqueio de Processamento e Liberação Contábil" -> transacoesProcessamento("mainForm:j_id_1z:18:j_id_2w:0:j_id_2z:3:j_id_36");
            case "Transações > Processamento > Carteira > Cockpit" -> transacoesProcessamento("mainForm:j_id_1z:18:j_id_2w:0:j_id_2z:4:j_id_36");
            case "Transações > Processamento > Contábil > Processamento" -> transacoesProcessamento("mainForm:j_id_1z:18:j_id_2w:2:j_id_2z:0:j_id_36");
            case "Transações > Processamento > Contábil > Bloqueio de Processamento Contábil" -> transacoesProcessamento("mainForm:j_id_1z:18:j_id_2w:2:j_id_2z:1:j_id_36");

            case "Relatórios > Patrimônio > Carteira Diária" -> relatoriosPatrimonio("mainForm:j_id_62:2:j_id_6n:0:j_id_82");
            case "Relatórios > Patrimônio > Demonstrativo de Caixa" -> relatoriosPatrimonio("mainForm:j_id_62:2:j_id_6n:1:j_id_82");
            case "Relatórios > Renda Fixa > Movimentação" -> relatoriosRendaFixa("mainForm:j_id_62:1:j_id_6n:0:j_id_82");
            case "Relatórios > Renda Fixa > Rendimentos" -> relatoriosRendaFixa("mainForm:j_id_62:1:j_id_6n:1:j_id_82");

            // Adicionar outras entidades conforme necessário
            default -> throw new IllegalArgumentException("Entidade desconhecida ou não implementada: " + pagina);

        }

    }
}
