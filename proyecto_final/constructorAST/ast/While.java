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
    // Bind the conditional expression
    cond.bind(bind_info, errors);

    // Open new block and bind the IF branch
    bind_info.push();
    for(Instruccion instr : body) {
      instr.bind(bind_info, errors);
    }  
    bind_info.pop();
  }

  public void checkTypes(LinkedList<ErrorSemantico> errors){
    // Check that the conditional is of type bool
    cond.checkTypes(errors);
    Type left_type = cond.getType();
    if (left_type != Type.BOOL){
      errors.add(new ErrorSemantico(cond, TipoError.TYPECOND));
    }
    
    // Check that the branches are well typed
    for(Instruccion instr : body) {
      instr.checkTypes(errors);
    }
  }
}