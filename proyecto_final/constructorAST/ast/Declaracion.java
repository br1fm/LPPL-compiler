package ast;
import errors.ErrorSemantico;
import errors.TipoError;
import java.util.LinkedList;

public class Declaracion extends Instruccion {
  private String name;
  private Type type;
  private boolean usado;
  
  public Declaracion(Type type, String name) {
   this.type = type;
   this.name = name;
   this.usado = false;
  }

  @Override
  public KindI kind() { return KindI.DECLARACION;}   
  public String toString() {return "DEC: " + type + " " + name + "\n";}  

  public void bind(TableStack bind_info, LinkedList<ErrorSemantico> errors){
    if (bind_info.contains_id_peek(name)){
      errors.add(new ErrorSemantico(this, TipoError.DUPIDEN));
    }
    bind_info.add_id(name, this);
  }

  public void checkTypes(LinkedList<ErrorSemantico> errors){}
  public Type getType(){ 
    return type; 
  }

  public String getName(){ 
    return name; 
  }

  public void setLeido(){
    usado = true;
  }

  public boolean isLeido(){
    return usado;
  }
  
}
