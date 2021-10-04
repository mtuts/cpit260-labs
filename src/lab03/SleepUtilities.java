package lab03;

/**
 * Utilities for causing a thread to sleep.
 * Note, we should be handling interrupted exceptions
 * but choose not to do so for code clarity.
 */
public class SleepUtilities {
  private static final int NAP_TIME = 5;

  /**
   * Nap between zero and duration seconds
   *
   */
  public static void nap() {
    nap(NAP_TIME);
  }

  public static void nap(int duration) {
    int sleep_time = (int) (NAP_TIME * Math.random());
    try {
      Thread.sleep(sleep_time * 1000);
    } catch (InterruptedException ignore) {    }
  }
}
