package SISTEMA.propriedades.leitorplanilha;

import java.net.URL;
public class CaminhoPlanilha {

    public static String obterCaminhoDaPlanilhaPelaClasse(Class<?> classe) {
        String nomeDaClasse = classe.getSimpleName();
        String nomeDaPlanilha = nomeDaClasse + ".xlsx"; // Substitua pela extensão da planilha que você está usando

        // Obtém o ClassLoader da classe atual
        ClassLoader classLoader = classe.getClassLoader();

        // Tente carregar o recurso da planilha
        URL resourceUrl = classLoader.getResource(nomeDaPlanilha);

        if (resourceUrl != null) {
            // Obtém o caminho do arquivo da planilha
            String caminhoDaPlanilha = resourceUrl.getPath();
            return caminhoDaPlanilha;
        } else {
            // Se o recurso não for encontrado, retorne null ou uma mensagem de erro
            return null;
        }
    }

    public static void main(String[] args) {
        // Substitua "MinhaClasse" pelo nome da classe da qual você deseja obter o caminho da planilha
        String nomeDaClasse = "FundamentalTest";

        try {
            // Carregue a classe pelo nome
            Class<?> classe = Class.forName(nomeDaClasse);

            // Obtenha o caminho da planilha usando a classe
            String caminhoDaPlanilha = obterCaminhoDaPlanilhaPelaClasse(classe);

            if (caminhoDaPlanilha != null) {
                System.out.println("Caminho da planilha para a classe " + nomeDaClasse + ": " + caminhoDaPlanilha);
            } else {
                System.out.println("Planilha não encontrada para a classe " + nomeDaClasse);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Classe não encontrada: " + nomeDaClasse);
        }
    }
}










