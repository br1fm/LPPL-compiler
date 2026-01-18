package ast;
import java.util.LinkedList;

public class Condicional extends Instruccion {
  private E condicion;
  private LinkedList<Instruccion> inst_IF;
  private LinkedList<Instruccion> inst_ELSE;

  public Condicional(E Condicion, LinkedList<Instruccion> inst_IF, LinkedList<Instruccion> inst_ELSE) {
   this.condicion = Condicion;
   this.inst_IF = inst_IF;
   this.inst_ELSE = inst_ELSE;
  }
  public KindI kind() {
   return KindI.CONDICIONAL;
  }   
  public String toString() {
    String value = "";
    value += "IF " + condicion + ":\n";
    for(Instruccion instr : inst_IF) {
       value += instr;
    }
    value += "ELSE:\n";
    for(Instruccion instr : inst_ELSE) {
       value += instr;
    }
    value += "ENDIF\n";
    return value;
  }  
}

