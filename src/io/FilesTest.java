import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilesTest {
    public static void main(String[] args) throws Exception {
        // byte[] data = Files.readAllBytes(new File("src/io/test.txt").toPath());
        byte[] data = Files.readAllBytes(Path.of("src/io/test.txt"));
        System.out.println(new String(data));
    }
}