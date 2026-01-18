package ast;

import java.util.LinkedList;

import errors.ErrorSemantico;

public class Huge extends E {
  private String v;

  public Huge(String v) {
    this.v = v;
  }

  public String num() {
    return v;
  }

  public KindE kind() {
    return KindE.HUGE;
  }

  public String toString() {
    return v;
  }

  public void checkTypes(LinkedList<ErrorSemantico> errors) {
    type = Type.HUGE;
  }
}
