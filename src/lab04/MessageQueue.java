package lab04;

import java.util.Vector;

public class MessageQueue implements Channel {

  private Vector queue;

  public MessageQueue() {
    queue = new Vector();
  }

  @Override
  public void send(Object item) {
    queue.addElement(item);
  }

  @Override
  public Object receive() {
    if (queue.size() == 0) {
      return null;
    }
    return queue.remove(0);
  }
}
