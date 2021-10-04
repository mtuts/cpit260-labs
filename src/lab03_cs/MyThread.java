package lab03_cs;

public class MyThread extends Thread {

  private String id;

  public static int counter = 0;
  private Object obj;

  public MyThread(String id, Object obj) {
    this.id = id;
    this.obj = obj;
  }

  @Override
  public void run() {
    int c = 0;
    for (int i = 0; i < 1000000; i++) {
      // this is a critical section, don't allow shared process enter
      // this block until this thread finish its work
      // lock

      synchronized (obj) {
        counter++;
      }

      // unlock
      // end of cs
      c++;
    }

    System.out.printf("%s completes %d iterations\n", id, c);
    // counter should be 1000000 after the loop
  }
}
