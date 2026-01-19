package ast;

import java.util.LinkedList;

import errors.ErrorSemantico;
import errors.TipoError;

public class While extends Instruccion {
    private E cond;
    private LinkedList<Instruccion> body;

    public While(E cond, LinkedList<Instruccion> body) {
        this.cond = cond;
        this.body = body;
    }

    public KindI kind() {
        return KindI.BUCLE_WHILE;
    }

    public String toString() {
        return "while (" + cond.toString() + ") [\n" + body.toString() + "\n]";
    }

    
  public void bind(TableStack bind_info, LinkedList<ErrorSemantico> errors){
    // Hacemos bind de la condición
    cond.bind(bind_info, errors);

    // Añadimos un nuevo bloque a la pila y hacemos bind para todas sus instrucciones
    bind_info.push();
    for(Instruccion instr : body) {
      instr.bind(bind_info, errors);
    }  
    bind_info.pop();
  }

  public void checkTypes(LinkedList<ErrorSemantico> errors){
    // Comprobar que la condición es un booleano
    cond.checkTypes(errors);
    Type left_type = cond.getType();
    if (left_type != Type.BOOL){
      errors.add(new ErrorSemantico(cond, TipoError.TYPECOND));
    }
    
    // Comprobar que las instrucciones dentro del bloque no tengan errores de tipado
    for(Instruccion instr : body) {
      instr.checkTypes(errors);
    }
  }

  // Ejecución
  public void execute(){
    // Ejecutar las instrucciones de bloque mientras se cumpla la condición
    while(cond.execute().intValue() == 1){
      for(Instruccion instr : body) {
        instr.execute();
      }  
    }
  }
}