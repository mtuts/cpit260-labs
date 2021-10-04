package lab03;

public class Main {

  public static void main(String[] args) {
    Buffer b = new BoundedBuffer();
    Consumer consumer = new Consumer(b);
    Producer producer = new Producer(b);
    Thread t1 = new Thread(consumer);
    Thread t2 = new Thread(producer);
    t1.start();
    t2.start();
  }
}
