package ast;

public class Asignacion extends Instruccion {
  private String variable;
  private E valor;
  public Asignacion(String variable, E valor) {
	  this.variable = variable;
	  this.valor = valor;   
  }

  @Override
  public KindI kind() {return KindI.ASIGNACION;}   
  public String toString() {return "ASIG: " + variable +" -> "+ valor + "\n";}  
}   
