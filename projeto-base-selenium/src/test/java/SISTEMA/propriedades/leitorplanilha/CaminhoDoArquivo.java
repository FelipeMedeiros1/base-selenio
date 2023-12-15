package SISTEMA.propriedades.leitorplanilha;

import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.io.IOException;
import java.util.EnumSet;

public class CaminhoDoArquivo {
    static Path caminhoCompleto = null;
    public static Path encontrarCaminhoDoArquivo(String nomeArquivo) throws IOException {
        Path diretorioInicial = Paths.get("C:\\Users\\felipem.medeiros\\Documents\\02-cursos\\java\\base-selenio\\projeto-base-selenium\\src\\test\\java"); // Substitua pelo seu diretório inicial
        EnumSet<FileVisitOption> options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);

        Files.walkFileTree(diretorioInicial, options, Integer.MAX_VALUE, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path arquivo, BasicFileAttributes attrs) throws IOException {
                if (arquivo.getFileName().toString().equals(nomeArquivo)) {
                    caminhoCompleto = arquivo.toAbsolutePath();
                    return FileVisitResult.TERMINATE;
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path arquivo, IOException exc) throws IOException {
                return FileVisitResult.CONTINUE;
            }
        });

        return caminhoCompleto;
    }

    public static void main(String[] args) {
        try {
            String nomeArquivo = "aTest.xlsx";
            Path caminhoArquivo = encontrarCaminhoDoArquivo(nomeArquivo);

            if (caminhoArquivo != null) {
                System.out.println("Caminho completo do arquivo: " + caminhoArquivo.toString());
            } else {
                System.out.println("Arquivo não encontrado.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
