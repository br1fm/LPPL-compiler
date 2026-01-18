package ast;
import java.util.LinkedList;

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
}