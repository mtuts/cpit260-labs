package lab04;

import lab03.SleepUtilities;

import java.util.Date;

public class Consumer implements Runnable {
  private Channel mbox;

  public Consumer(Channel c) {
    mbox = c;
  }

  @Override
  public void run() {
    Date message;
    while (true) {
      SleepUtilities.nap();
      System.out.println("Consumer wants to consume");
      message = (Date) mbox.receive();
      if (message != null) {
        System.out.printf("Consumer consumed %s\n", message);
      }
    }
  }
}
