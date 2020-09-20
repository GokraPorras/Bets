package exceptions;
public class SuperBetMinimumRes extends Exception {
 private static final long serialVersionUID = 1L;
 
 public SuperBetMinimumRes()
  {
    super();
  }
  /**This exception is triggered if the event has already finished
  *@param s String of the exception
  */
  public SuperBetMinimumRes(String s)
  {
    super(s);
  }
}