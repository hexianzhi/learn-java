package src.thread;

public class Daemon {

  public static void main(String[] args) {
    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        while (true) {
          System.out.println("Daemon thread is running...");
          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    });

    thread.setDaemon(true); // 将线程设置为守护线程
    thread.start(); // 启动线程

    try {
      Thread.sleep(3000); // 主线程休眠3秒
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("Main thread ends.");
    // 当主线程结束时，守护线程也会自动结束
  }

}
