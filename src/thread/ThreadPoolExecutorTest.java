package src.thread;

import java.util.concurrent.*;

public class ThreadPoolExecutorTest {
  private static final int CORE_POOL_SIZE = 5;
  private static final int MAX_POOL_SIZE = 100;
  private static final int QUEUE_CAPACITY = 100;
  private static final Long KEEP_ALIVE_TIME = 1L;

  public static void main(String[] args) {
    // 创建线程池
    ThreadPoolExecutor executor = new ThreadPoolExecutor(
        CORE_POOL_SIZE,
        MAX_POOL_SIZE,
        KEEP_ALIVE_TIME,
        TimeUnit.SECONDS,
        new ArrayBlockingQueue<>(QUEUE_CAPACITY),
        new ThreadPoolExecutor.CallerRunsPolicy());

    // 模拟处理100个HTTP请求
    for (int i = 0; i < 100; i++) {
      executor.execute(new Worker(i));
    }

    // 关闭线程池
    executor.shutdown();
    while (!executor.isTerminated()) {
      // 等待所有任务完成
    }
    System.out.println("Finished all threads");
  }

  // 工作线程，模拟处理HTTP请求
  static class Worker implements Runnable {
    private int requestId;

    public Worker(int requestId) {
      this.requestId = requestId;
    }

    @Override
    public void run() {
      System.out.println("Start processing request " + requestId);
      // 模拟I/O操作
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("Finish processing request " + requestId);
    }
  }
}
