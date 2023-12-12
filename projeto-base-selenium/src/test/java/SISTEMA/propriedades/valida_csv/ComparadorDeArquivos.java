package SISTEMA.propriedades.valida_csv;

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

    public static void main(String[] args) {
        trocaArquivoDeDiretorio("Downloads","C:\\Projetos\\ws_robo\\projeto-base-selenium\\target\\arquivos-gerados");
    }


}


