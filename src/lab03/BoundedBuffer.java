package lab03;

/**
 * This program implements the bounded buffer using shared memory.
 * Note that this solutions is NOT thread-safe. It will be used
 * to illustrate thread safety using Java synchronization in Chapter 7.
 */
public class BoundedBuffer implements Buffer {
  private static final int BUFFER_SIZE = 3;

  private volatile int count;
  private int in; // points to the next free position in the buffer
  private int out; // points to the next full position in the buffer
  private Object[] buffer;

  public BoundedBuffer() {
    count = 0;
    in = 0;
    out = 0;

    buffer = new Object[BUFFER_SIZE];
  }

  public void insert(Object item) {
    while (count == BUFFER_SIZE); // do nothing

    ++count;
    buffer[in] = item;
    in = (in + 1) % BUFFER_SIZE;

    if (count == BUFFER_SIZE) {
      System.out.printf("lab03.Producer Entered %s buffer FULL\n", item);
    } else {
      System.out.printf("lab03.Producer Entered %s buffer size %d\n", item, count);
    }
  }

  @Override
  public Object remove() {
    Object item;

    while (count == 0);

    --count;

    item = buffer[out];
    out = (out + 1) % BUFFER_SIZE;
    if (count == 0) {
      System.out.printf("lab03.Consumer consumed %s buffer EMPTY\n", item);
    } else {
      System.out.printf("lab03.Consumer consumed %s buffer size %d\n", item, count);
    }

    return item;
  }
}
