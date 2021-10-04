package lab03;

import java.util.Date;

public class Producer implements Runnable {

  private Buffer buffer;

  public Producer(Buffer b) {
    buffer = b;
  }

  @Override
  public void run() {
    Date message;
    while (true) {
      System.out.println("lab03.Producer napping");
      SleepUtilities.nap();

      message = new Date();
      System.out.printf("lab03.Producer produced %s\n", message);

      buffer.insert(message);
    }
  }
}
