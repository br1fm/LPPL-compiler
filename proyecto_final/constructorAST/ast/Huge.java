package ast;

public class Huge extends E {
  private String v;
  public Huge(String v) {
   this.v = v;   
  }
  public String num() {return v;}
  public KindE kind() {return KindE.HUGE;}   
  public String toString() {return v;}  
}
