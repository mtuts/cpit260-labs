package lab03;

public interface Buffer {

  /**
   * insert an item into the buffer.
   * Note: This may be either a blocking or non-blocking operation.
   * @param item
   */
  public abstract void insert(Object item);

  /**
   * remove an item from the buffer.
   * Note: This may be either a blocking or non-blocking operation.
   * @return
   */
  public abstract Object remove();
}
