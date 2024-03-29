package src.thread;

public class NewTest {
  public static void main(String[] args) throws InterruptedException {
    Thread t = new MyThread();
    t.start();
    Thread.sleep(20); // 暂停1毫秒
    t.interrupt(); // 中断t线程
    t.join(); // 等待t线程结束
    System.out.println("end");
  }
  // public static void main(String[] args) throws InterruptedException {
  // Thread t = new Thread(() -> {
  // System.out.println("hello");
  // });
  // System.out.println("start");
  // t.start();
  // t.join();
  // System.out.println("end");
  // }
  // public static void main(String[] args) {
  // System.out.println("main start...");
  // Thread t = new Thread() {
  // public void run() {
  // System.out.println("thread run...");
  // System.out.println("thread end.");
  // }
  // };
  // t.start();
  // System.out.println("main end...");
  // }
}

class MyThread extends Thread {
  public void run() {
    int n = 0;
    while (!isInterrupted()) {
      n++;
      System.out.println(n + " hello!");
    }
  }
}