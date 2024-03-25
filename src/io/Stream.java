import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Stream {

  public static void main(String[] args) {
    try (InputStream input = Stream.class.getClassLoader().getResourceAsStream("default.properties")) {
      System.out.println(input);
      if (input != null) {
        int n;
        while ((n = input.read()) != -1) {
          System.out.println(n);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    // String classpath = System.getProperty("java.class.path");
    // System.out.println("Classpath is " + classpath);
    // try {
    // // Create a FileInputStream object by providing the path to the file
    // writefile("E:\\work\\project\\learn-java\\src\\io\\test.txt", "hello");

    // } catch (IOException e) {
    // e.printStackTrace();
    // }

    // try {
    // // Create a FileInputStream object by providing the path to the file
    // String n = readFileStr("E:\\work\\project\\learn-java\\src\\io\\test.txt");
    // System.out.println("file text is " + n);
    // } catch (IOException e) {
    // e.printStackTrace();
    // }
  }

  public static void writefile(String path, String content) throws IOException {
    OutputStream output = null;
    try {
      output = new FileOutputStream(path);
      output.write(content.getBytes("utf-8"));
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (output != null)
        output.close();
      System.out.println("file text end ");
    }
  }

  public static String readFileStr(String path) throws IOException {
    InputStream input = null;
    String s = "";
    try {

      int n;
      input = new FileInputStream(path);
      StringBuilder sb = new StringBuilder();
      while ((n = input.read()) != -1) {
        char test = (char) n;
        System.out.println("test   is " + test);
        sb.append(test);
      }
      s = sb.toString();

      return s;
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    } finally {
      if (input != null)
        input.close();
    }
  }
}
