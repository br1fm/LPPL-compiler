package ast;
import java.util.LinkedList;
import errors.ErrorSemantico;

public class BoolValue extends E {
  private String valor;
  
  public BoolValue(String value) {
   this.valor = valor;   
  }

  public KindE kind() {
   return KindE.BOOL;
  }   
  
  public String toString() {
   return valor;
  }

  public void checkTypes(LinkedList<ErrorSemantico> errors){
    type = Type.BOOL;
  }

}
