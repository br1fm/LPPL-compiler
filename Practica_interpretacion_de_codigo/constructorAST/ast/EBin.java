package ast;
import java.util.LinkedList;
import errors.ErrorSemantico;
import errors.TipoError;

public class EBin extends E {
   private E opnd1;
   private E opnd2;
   private BinOps op;	

   public EBin(BinOps op, E opnd1, E opnd2) {
     this.op = op;
     this.opnd1 = opnd1;
     this.opnd2 = opnd2;
   }

   public E opnd1() {return opnd1;}
   public E opnd2() {return opnd2;} 
   public KindE kind() { return KindE.EBIN; }
       public String toString() {
        String opstr = "";
        switch(op) {
          case MAS:  opstr = "MAS"; break;
          case IGUAL: opstr = "IGUAL"; break;
          case MAYOR:  opstr = "MAYOR"; break;
          default:
          break;
       }
        return opnd1 + " " + opstr + " " + opnd2;
    }

    public void bind(TableStack bind_info, LinkedList<ErrorSemantico> errors){
      opnd1.bind(bind_info, errors);
      opnd2.bind(bind_info, errors);
    }

    public void checkTypes(LinkedList<ErrorSemantico> errors){
      // Check the left and right ops
      opnd1.checkTypes(errors);
      opnd2.checkTypes(errors);

      Type left_type = opnd1.getType();
      Type right_type = opnd2.getType();
      
      switch(op) {
          case MAS:  
            if (left_type != Type.NUM || right_type != Type.NUM){
              errors.add(new ErrorSemantico(this, TipoError.TYPEOP));
            }
            type = Type.NUM;
            break;
          case IGUAL: 
            if (left_type != right_type){
              errors.add(new ErrorSemantico(this, TipoError.TYPEOP));
            }
            type = Type.BOOL;
            break;
          case MAYOR:  
            if (left_type != Type.NUM || right_type != Type.NUM){
              errors.add(new ErrorSemantico(this, TipoError.TYPEOP));
            }
            type = Type.BOOL;
            break;
          default:
            break;
      }
    }

    public Integer execute(){

      // Execute the child nodes
      Integer left_value = opnd1.execute();
      Integer right_value = opnd2.execute();
      
      Integer value;

      switch(op) {
          case MAS:  
            value = left_value + right_value;
            break;
          case IGUAL: 
            if (left_value == right_value){
             value = 1; 
            } else{
              value = 0;
            }
            break;
          case MAYOR:  
            if (left_value > right_value){
             value = 1; 
            } else{
              value = 0;
            }
            break;
          default:
            value = 0;
            break;
      }
      return value;
    }
}
