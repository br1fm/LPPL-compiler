package ast;

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
          case MAYOR:  opstr = "POR"; break;
          default:
          break;
       }
        return opnd1 + " " + opstr + " " + opnd2;
    }
  
  
}
