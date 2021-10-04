package lab04;

public class Factory {
  public static void main(String[] args) {
    Channel mailBox = new MessageQueue();

    Thread producerThread = new Thread(new Producer(mailBox));
    Thread consumerThread = new Thread(new Consumer(mailBox));
    producerThread.start();
    consumerThread.start();
  }
}
