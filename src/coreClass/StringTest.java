package src.coreClass;

import java.util.StringJoiner;

// 字符串拼接
public class StringTest {
  public static void main(String[] args) {
    //
    String[] names = { "Bob", "Alice", "Grace" };
    var s = String.join(", ", names);

    // String[] names = { "Bob", "Alice", "Grace" };
    // var sb = new StringBuilder();
    // sb.append("Hello ");
    // for (String name : names) {
    // sb.append(name).append(", ");
    // }

    // String[] names = { "Bob", "Alice", "Grace" };
    // var sj = new StringJoiner(", ");
    // for (String name : names) {
    // sj.add(name);
    // }

  }
}
