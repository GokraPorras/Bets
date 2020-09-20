package exceptions;
public class EventInCurrent extends Exception {
 private static final long serialVersionUID = 1L;
 
 public EventInCurrent()
  {
    super();
  }
  /**This exception is triggered if the event has already finished
  *@param s String of the exception
  */
  public EventInCurrent(String s)
  {
    super(s);
  }
}