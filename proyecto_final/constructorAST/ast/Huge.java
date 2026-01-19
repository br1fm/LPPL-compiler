package ast;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.LinkedList;

import errors.ErrorEjecucion;
import errors.ErrorSemantico;
import errors.TipoError;

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

  public Number execute(){
    
    int i = 0;
    
    Integer base = 0;
    Integer exponente = 0;
    while(i < v.length() && v.charAt(i) != 'e' && v.charAt(i) != 'E')i++;
  
    if(i < 10)  
      base = Integer.parseInt(v, 0, i, 10);
    else{
      ErrorEjecucion error = new ErrorEjecucion(this, TipoError.TOOBIG);
      error.gestionaError();
    }

    if(v.length() - (i + 1) < 10)  
      exponente = Integer.parseInt(v, i + 1, v.length(), 10);
    else{
      ErrorEjecucion error = new ErrorEjecucion(this, TipoError.TOOBIG);
      error.gestionaError();
    }

    Long ret = Long.valueOf((int) Math.pow(base, exponente));
    return ret;
  }
}
