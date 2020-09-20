package exceptions;
public class MaximumMoneyInserted extends Exception {
 private static final long serialVersionUID = 1L;
 
 public MaximumMoneyInserted()
  {
    super();
  }
  /**This exception is triggered if the event has already finished
  *@param s String of the exception
  */
  public MaximumMoneyInserted(String s)
  {
    super(s);
  }
}