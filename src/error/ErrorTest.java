import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class ErrorTest {
  public static void main(String[] args) {
    Person p = new Person();
    System.out.println(p.address.city.toLowerCase());
  }
  // public static void main(String[] args) {
  // try {
  // process1();
  // } catch (Exception e) {
  // e.printStackTrace();
  // }
  // }

  static void process1() {
    try {
      process2();
    } catch (NullPointerException e) {
      throw new IllegalArgumentException(e);
    }
  }

  static void process2() {
    throw new NullPointerException();
  }

  // public static void main(String[] args) {
  // byte[] bs = toGBK("中文");
  // System.out.println(Arrays.toString(bs));
  // }
  static byte[] toGBK(String s) {
    try {
      // 用指定编码转换String为byte[]:
      return s.getBytes("GBK");
    } catch (UnsupportedEncodingException e) {
      // 如果系统不支持GBK编码，会捕获到UnsupportedEncodingException:
      System.out.println(e); // 打印异常信息
      return s.getBytes(); // 尝试使用用默认编码
    }
  }
}

class Person {
  String[] name = new String[2];
  Address address = new Address();
}

class Address {
  String city;
  String street;
  String zipcode;
}