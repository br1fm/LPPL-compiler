package ast;

import java.util.LinkedList;

import errors.ErrorSemantico;

public class Num extends E {
  private String v;
  public Num(String v) {
   this.v = v;   
  }
  public String num() {return v;}
  public KindE kind() {return KindE.NUM;}   
  public String toString() {return v;}
  
  public void checkTypes(LinkedList<ErrorSemantico> errors){
    type = Type.NUM;
  }

  public Number execute(){
    return Integer.parseInt(v);
  }
}
