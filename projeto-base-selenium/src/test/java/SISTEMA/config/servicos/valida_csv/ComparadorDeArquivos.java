package SISTEMA.config.servicos.valida_csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class ComparadorDeArquivos {
    public static void trocaArquivoDeDiretorio(String origem, String destino) {
        Path sourcePath = FileSystems.getDefault().getPath(origem);
        Path targetPath = FileSystems.getDefault().getPath(destino);

        try {
            Arquivo.moverArquivo(sourcePath, targetPath);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public static void validadorCSV(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 0;
            while ((line = br.readLine()) != null) {
                lineNumber++;
                String[] columns = line.split(","); // Assumindo que o CSV está separado por vírgula

                // Validar o número de colunas
                if (columns.length != 3) { // Supondo que o CSV deve ter três colunas
                    System.out.println("Erro na linha " + lineNumber + ": Número incorreto de colunas");
                    continue;
                }

                // Validar o formato dos dados em cada coluna
                String name = columns[0];
                if (!name.matches("[A-Za-z]+")) { // Validar se o nome contém apenas letras
                    System.out.println("Erro na linha " + lineNumber + ": Nome inválido");
                }

                // Validar o formato do número
                try {
                    int number = Integer.parseInt(columns[1]);
                } catch (NumberFormatException e) {
                    System.out.println("Erro na linha " + lineNumber + ": Número inválido");
                }

                // Outras validações conforme necessário

                // Se chegou até aqui, os dados são válidos
                System.out.println("Linha " + lineNumber + " válida");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        trocaArquivoDeDiretorio("Downloads","C:\\Projetos\\ws_robo\\projeto-base-selenium\\target\\arquivos-gerados");
        validadorCSV("arquivo.csv"); // Substitua "arquivo.csv" pelo caminho do seu arquivo CSV
    }


}


