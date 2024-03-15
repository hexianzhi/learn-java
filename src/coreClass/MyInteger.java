package src.coreClass;

import java.math.BigInteger;

public class MyInteger {
  public static void main(String[] args) {
    // int n = 111;
    // Integer n2 = Integer.valueOf(n);
    // Integer n3 = Integer.valueOf(n);
    // System.out.println(n == n2);
    // System.out.println(n2.equals(n3));

    BigInteger n = new BigInteger("999999").pow(99);
    float f = n.floatValue();

    System.out.println(n.toString());
  }
}
