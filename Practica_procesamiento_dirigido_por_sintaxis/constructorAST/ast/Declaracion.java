package ast;

public class Declaracion extends Instruccion {
  private String name;
  private Type type;
  
  public Declaracion(Type type, String name) {
   this.type = type;
   this.name = name;
  }

  @Override
  public KindI kind() { return KindI.DECLARACION;}   
  public String toString() {return "DEC: " + type + " " + name + "\n";}  

}
