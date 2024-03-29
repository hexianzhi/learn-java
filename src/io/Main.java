package src.io;

import java.io.*;

public class Main {
  // public static void main(String[] args) throws IOException {
  // File f1 = new File("C:\\Windows");
  // File f2 = new File("C:\\Windows\\notepad.exe");
  // File f3 = new File("D:\\frontEnigeer\\project\\learn-java\\.project");
  // System.out.println(f1.isFile());
  // System.out.println(f1.isDirectory());
  // System.out.println(f2.isFile());
  // System.out.println(f2.isDirectory());
  // System.out.println(f3.isFile());
  // System.out.println(f3.isDirectory());
  // }

  public static void main(String[] args) throws IOException {
    File f = File.createTempFile("tmp-", ".txt"); // 提供临时文件的前缀和后缀
    f.deleteOnExit(); // JVM退出时自动删除
    System.out.println(f.isFile());
    System.out.println(f.getAbsolutePath());
  }
}
