import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilterReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

public class Reader {
    public static void main(String[] args) throws IOException {
        try (Writer writer = new FileWriter("readme.txt", true)) {
            writer.write('H'); // 写入单个字符
            writer.write("Hello".toCharArray()); // 写入char[]
            writer.write("Hello"); // 写入String
        }

        // FileReader reader = new FileReader("src/io/test.txt",
        // StandardCharsets.UTF_8);
        // int n;
        // while ((n = reader.read()) != -1) {
        // System.out.println((char) n);
        // }
        // reader.close();
    }
}
