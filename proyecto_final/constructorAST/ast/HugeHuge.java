package ast;

public class HugeHuge extends E {
  private String v;
  public HugeHuge(String v) {
   this.v = v;   
  }
  public String num() {return v;}
  public KindE kind() {return KindE.HUGEHUGE;}   
  public String toString() {return v;}  
}
