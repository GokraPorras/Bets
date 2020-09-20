package exceptions;
public class betMinimum extends Exception {
 private static final long serialVersionUID = 1L;
 
 public betMinimum()
  {
    super();
  }
  /**This exception is triggered if the event has already finished
  *@param s String of the exception
  */
  public betMinimum(String s)
  {
    super(s);
  }
}