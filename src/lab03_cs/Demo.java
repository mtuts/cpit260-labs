package lab03_cs;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo {
  public static void main(String[] args) {

    Lock l1 = new ReentrantLock();

    OtherSolution t1 = new OtherSolution("T1", l1);
    OtherSolution t2 = new OtherSolution("T2", l1);

    t1.start();
    t2.start();

    try {
      t1.join();
      t2.join();
    } catch (InterruptedException e) {
      System.err.println(e.getMessage());
    }

    System.out.printf("Both thread finished and counter = %d\n", OtherSolution.counter);
  }
}
