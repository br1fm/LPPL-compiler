package ast;

import java.util.LinkedList;

import errors.ErrorSemantico;
import errors.TipoError;

public class WhileIf extends Instruccion {
    private E condBucle;
    private E condIf;
    private LinkedList<Instruccion> body;
    private LinkedList<Instruccion> bodyElse;

    public WhileIf(E condBucle, E condIf, LinkedList<Instruccion> body, LinkedList<Instruccion> bodyElse) {
        this.condBucle = condBucle;
        this.condIf = condIf;
        this.body = body;
        this.bodyElse = bodyElse;
    }

    public KindI kind() {
        return KindI.WHILEIF;
    }

    public String toString() {
        String s = "whif (" + condBucle.toString() + ";" + condIf.toString() + ") [\n";

        for(Instruccion instr: body){
            s += instr.toString();
        }
        s += "] sino [\n";
        for(Instruccion instr: bodyElse){
            s += instr.toString();
        }

        s += "]";
        return s;
    }

    
  public void bind(TableStack bind_info, LinkedList<ErrorSemantico> errors){
    // Bind the conditional expression
    condBucle.bind(bind_info, errors);
    condIf.bind(bind_info, errors);

    // Open new block and bind the IF branch
    bind_info.push();
    for(Instruccion instr : body) {
      instr.bind(bind_info, errors);
    }  
    bind_info.pop();

    bind_info.push();
    for(Instruccion instr : bodyElse) {
      instr.bind(bind_info, errors);
    }  
    bind_info.pop();

  }

  public void checkTypes(LinkedList<ErrorSemantico> errors){
    // Check that the conditional is of type bool
    condBucle.checkTypes(errors);
    Type left_type = condBucle.getType();
    if (left_type != Type.BOOL){
      errors.add(new ErrorSemantico(condBucle, TipoError.TYPECOND));
    }

    condIf.checkTypes(errors);
    Type right_type = condIf.getType();
    if (right_type != Type.BOOL){
      errors.add(new ErrorSemantico(condIf, TipoError.TYPECOND));
    }
    
    // Check that the branches are well typed
    for(Instruccion instr : body) {
      instr.checkTypes(errors);
    }

    for(Instruccion instr : bodyElse) {
      instr.checkTypes(errors);
    }

  }

  public void execute() {
  while(condBucle.execute().intValue() == 1){

    if(condIf.execute().intValue() == 1){
      for(Instruccion instr : body) {
          instr.execute();
      }  
    } else {
      for(Instruccion instr : bodyElse) {
        instr.execute();
      }  
    }
  }
}

}