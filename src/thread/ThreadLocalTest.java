package src.thread;

public class ThreadLocalTest {
  // 创建线程局部变量
  public static ThreadLocal<String> threadLocal = new ThreadLocal<>();

  public static void main(String[] args) {
    // 在主线程中设置 threadLocal
    threadLocal.set("Hello, world!");

    // 新建一个子线程
    Thread thread = new Thread(() -> {
      // 在子线程中访问 threadLocal
      System.out.println("thread: " + threadLocal.get());
    });
    thread.start();

    // 在主线程中访问 threadLocal
    System.out.println("main: " + threadLocal.get());
  }
}
