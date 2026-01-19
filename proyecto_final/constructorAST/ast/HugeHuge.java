package ast;

import java.util.LinkedList;

import errors.ErrorSemantico;

public class HugeHuge extends E {
  private String v;
  public HugeHuge(String v) {
   this.v = v;   
  }
  public String num() {return v;}
  public KindE kind() {return KindE.HUGEHUGE;}   
  public String toString() {return v;}  
  public void checkTypes(LinkedList<ErrorSemantico> errors){
      type = Type.HUGEHUGE;
  }
  public Number execute(){
    return Integer.parseInt(v);
  }
}
