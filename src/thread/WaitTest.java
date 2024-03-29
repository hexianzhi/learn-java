package src.thread;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class WaitTest {
  public static void main(String[] args) throws InterruptedException {
    var q = new TaskQueue();
    var ts = new ArrayList<Thread>();
    for (int i = 0; i < 5; i++) {
      var t = new Thread() {
        public void run() {
          // 执行task:
          while (true) {
            try {
              String s = q.getTask();
              long id = Thread.currentThread().threadId();
              System.out.println("get task id: " + id + ", number: " + s);
            } catch (InterruptedException e) {
              return;
            }
          }
        }
      };
      t.start();
      ts.add(t);
    }
    var add = new Thread(() -> {
      for (int i = 0; i < 10; i++) {
        // 放入task:
        String s = "t-" + Math.random();
        // System.out.println("add task: " + s);
        long id = Thread.currentThread().threadId();
        System.out.println("add task id: " + id + ", number: " + s);
        q.addTask(s);
        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
        }
      }
    });
    add.start();
    add.join();
    Thread.sleep(100);
    for (var t : ts) {
      t.interrupt();
    }
  }
}

class TaskQueue {
  Queue<String> queue = new LinkedList<>();

  public synchronized void addTask(String s) {
    this.queue.add(s);
    this.notifyAll();
  }

  public synchronized String getTask() throws InterruptedException {
    while (queue.isEmpty()) {
      this.wait();
    }
    return queue.remove();
    // System.out.println(queue.isEmpty());
    // String item = "";
    // if (queue.isEmpty()) {
    // this.wait();
    // } else {
    // item = queue.remove();
    // }
    // return item;
  }
}