package sistema.servicos.leitorDeArquivo.config_csv;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Arquivo {
    public static void moverArquivo(Path source, Path target) throws IOException {
        try {
            java.nio.file.Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
