package exceptions;
public class NotEnoughMoney extends Exception {
 private static final long serialVersionUID = 1L;
 
 public NotEnoughMoney()
  {
    super();
  }
  
 
 
  public NotEnoughMoney(String s)
  {
    super(s);
  }
}
