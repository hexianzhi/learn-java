package src.thread;

public class StopTest {
  public static void main(String[] args) {
    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          while (!Thread.currentThread().isInterrupted()) {
            System.out.println("Thread is running...");
            Thread.sleep(1000);
          }
        } catch (InterruptedException e) {
          System.out.println("Thread was interrupted!");
        }
      }
    });

    thread.start(); // 启动线程

    try {
      Thread.sleep(3000); // 主线程休眠3秒
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    thread.interrupt(); // 中断线程
  }

  // public static void main(String[] args) throws InterruptedException {
  // Thread t = new MyThread();
  // t.start();
  // Thread.sleep(200);
  // t.interrupt(); // 中断t线程
  // t.join(); // 等待t线程结束
  // System.out.println("end");
  // }

}

class MyThread extends Thread {
  public void run() {
    Thread hello = new HelloThread();
    hello.start(); // 启动hello线程
    try {
      hello.join(); // 等待hello线程结束
    } catch (InterruptedException e) {
      System.out.println("interrupted!");
    }
    hello.interrupt();
  }
}

class HelloThread extends Thread {
  public void run() {
    int n = 0;
    System.out.println(n + " hello!");
    // while (!isInterrupted()) {
    // n++;
    // try {
    // Thread.sleep(100);
    // } catch (InterruptedException e) {
    // System.out.println("Thread interrupted!");
    // this.interrupt(); // 再次设置中断标志
    // return;
    // }
    // }
  }
}
