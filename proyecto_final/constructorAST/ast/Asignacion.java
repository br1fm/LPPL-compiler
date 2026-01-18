package ast;
import java.util.LinkedList;
import errors.ErrorSemantico;
import errors.TipoError;

public class Asignacion extends Instruccion {
  private String variable;
  private E valor;

  private Declaracion variable_binding;

  public Asignacion(String variable, E valor) {
	  this.variable = variable;
	  this.valor = valor;   
  }

  @Override
  public KindI kind() {return KindI.ASIGNACION;}   
  public String toString() {return "ASIG: " + variable +" -> "+ valor + "\n";}  

    
  public void bind(TableStack bind_info, LinkedList<ErrorSemantico> errors){
    // Check that the assigned variable is defined
    Declaracion lookup_variable = bind_info.lookup(variable);
    if (lookup_variable == null){
      errors.add(new ErrorSemantico(this, TipoError.NOIDEN));
    } else{
      this.variable_binding = lookup_variable;
    }

    // Bind the value assigned
    valor.bind(bind_info, errors);
  }

  public void checkTypes(LinkedList<ErrorSemantico> errors){
    // Check that the types are valid
    Type left_type = variable_binding.getType();
    if (left_type == null){
      errors.add(new ErrorSemantico(this, TipoError.TYPEASIG));
    }

    // Check that the value assigned is well typed 
    valor.checkTypes(errors);
    Type right_type = valor.getType();
    if (right_type == null){
      errors.add(new ErrorSemantico(this, TipoError.TYPEASIG));
    }

    if (left_type != right_type){
      errors.add(new ErrorSemantico(this, TipoError.TYPEASIG));
    }
  }

}   
