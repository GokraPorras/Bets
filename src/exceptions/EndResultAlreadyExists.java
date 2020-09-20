package exceptions;
public class EndResultAlreadyExists extends Exception {
 private static final long serialVersionUID = 1L;
 
 public EndResultAlreadyExists()
  {
    super();
  }
  /**This exception is triggered if the result already exists 
  *@param s String of the exception
  */
  public EndResultAlreadyExists(String s)
  {
    super(s);
  }
}