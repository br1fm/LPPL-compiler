package ast;

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
}
