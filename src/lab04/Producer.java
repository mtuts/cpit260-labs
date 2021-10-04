package lab04;

import lab03.SleepUtilities;

import java.util.Date;

public class Producer implements Runnable {
  private Channel mbox;

  public Producer(Channel b) {
    mbox = b;
  }

  @Override
  public void run() {
    Date message;
    while (true) {
      SleepUtilities.nap();
      message = new Date();
      System.out.printf("Producer produced %s\n", message);
      mbox.send(message);
    }
  }
}
