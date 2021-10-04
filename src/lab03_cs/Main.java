package lab03_cs;

public class Main {

  public static void main(String[] args) {
    Object obj = new Object();
//    MyClass m1 = new MyClass("T1", obj);
//    MyClass m2 = new MyClass("T2", obj);
//
//    Thread t1 = new Thread(m1);
//    Thread t2 = new Thread(m2);

    MyThread t1 = new MyThread("T1", obj);
    MyThread t2 = new MyThread("T2", obj);

    t1.start();
    t2.start();

    try {
      t1.join();
      t2.join();
    } catch (InterruptedException e) {
      System.err.println(e.getMessage());
    }

    System.out.printf("Both thread finished and counter = %d\n", MyThread.counter);
//    System.out.printf("Both thread finished and counter = %d\n", MyClass.counter);
  }
}
