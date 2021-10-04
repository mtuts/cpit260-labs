package lab04;

public interface Channel {
  public void send(Object message);

  public Object receive();
}
