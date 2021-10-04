package lab03;

import java.util.Date;

/**
 * This is the consumer thread for the bounded buffer problem.
 */
public class Consumer implements Runnable {

  private Buffer buffer;

  public Consumer(Buffer b) {
    buffer = b;
  }
  @Override
  public void run() {
    Date message;
    while (true) {
      System.out.println("lab03.Consumer napping");
      SleepUtilities.nap();

      // consume an item from buffer
      System.out.println("lab03.Consumer wants to consume");

      message = (Date) buffer.remove();
    }
  }
}
