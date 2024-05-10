
package SISTEMA.config.servicos.leitorDeArquivo.config_json;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;

public class BuscadorArquivoJson {
    @Test
    public static String caminhoJson(String nomeArquivo) {
        Path start = Paths.get("projeto-base-selenium/src/test/");
        final String[] result = {""};

        try {
            Files.walkFileTree(start, EnumSet.noneOf(FileVisitOption.class), Integer.MAX_VALUE, new SimpleFileVisitor<>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs){
                    if (file.getFileName().toString().equals(nomeArquivo)) {
                        result[0] = file.toAbsolutePath().toString();
                        return FileVisitResult.TERMINATE;
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return result[0];
    }
    public static void main(String[] args) {
        String filePath = caminhoJson("Proc.json");
        if (!filePath.isEmpty()) {
            System.out.println("Arquivo encontrado em: " + filePath);
        } else {
            System.out.println("Arquivo não encontrado.");
        }

    }
}


