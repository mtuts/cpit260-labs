package lab03_cs;

import java.util.concurrent.locks.Lock;

public class OtherSolution extends Thread {

  private String id;

  public static int counter = 0;
  Lock l1;

  public OtherSolution(String id, Lock l1) {
    this.id = id;
    this.l1 = l1;
  }

  @Override
  public void run() {
    int c = 0;
    for (int i = 0; i < 1000000; i++) {
      // this is a critical section, don't allow shared process enter
      // this block until this thread finish its work
      // lock

      l1.lock();

      counter++;

      l1.unlock();

      // unlock
      // end of cs
      c++;
    }

    System.out.printf("%s completes %d iterations\n", id, c);
    // counter should be 1000000 after the loop
  }
}
