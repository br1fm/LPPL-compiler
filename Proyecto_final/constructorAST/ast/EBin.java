package ast;

import java.nio.channels.MulticastChannel;
import java.util.LinkedList;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;

import javax.swing.plaf.basic.BasicBorders.MenuBarBorder;

import errors.ErrorSemantico;
import errors.TipoError;
import util.Util;

public class EBin extends E {
  private E opnd1;
  private E opnd2;
  private BinOps op;

  public EBin(BinOps op, E opnd1, E opnd2) {
    this.op = op;
    this.opnd1 = opnd1;
    this.opnd2 = opnd2;
  }

  public E opnd1() {
    return opnd1;
  }

  public E opnd2() {
    return opnd2;
  }

  public KindE kind() {
    return KindE.EBIN;
  }

  public String toString() {
    String opstr = "";
    switch (op) {
      case MAS:
        opstr = "MAS";
        break;
      case IGUAL:
        opstr = "IGUAL";
        break;
      case IGUALIGUAL:
        opstr = "IGUALIGUAL";
        break;
      case DISTINTO:
        opstr = "DISTINTO";
        break;
      case MAYOR:
        opstr = "MAYOR";
        break;
      case MENOR:
        opstr = "MENOR";
        break;
      case MAYOR_IGUAL:
        opstr = "MAYOR_IGUAL";
        break;
      case MENOR_IGUAL:
        opstr = "MENOR_IGUAL";
        break;
      case MULTIPLICA:
        opstr = "MULTIPLICA";
        break;
      case DIVIDE:
        opstr = "DIVIDE";
        break;
      case MENOS:
        opstr = "MENOS";
        break;
      default:
        break;
    }
    return opnd1 + " " + opstr + " " + opnd2;
  }

  public void bind(TableStack bind_info, LinkedList<ErrorSemantico> errors) {
    opnd1.bind(bind_info, errors);
    opnd2.bind(bind_info, errors);
  }

  public void checkTypes(LinkedList<ErrorSemantico> errors) {
    // Check the left and right ops
    opnd1.checkTypes(errors);
    opnd2.checkTypes(errors);

    Type left_type = opnd1.getType();
    Type right_type = opnd2.getType();

    switch (op) {
      case MAS:
        if (!esTipoNumerico(right_type) || !esTipoNumerico(left_type)) {
          errors.add(new ErrorSemantico(this, TipoError.TYPEOP));
        }

        type = Type.NUM;

        if (left_type == Type.REAL || right_type == Type.REAL)
          type = Type.REAL;

        break;
      case MENOS:
        if (!esTipoNumerico(right_type) || !esTipoNumerico(left_type)) {
          errors.add(new ErrorSemantico(this, TipoError.TYPEOP));
        }
        type = Type.NUM;
        if (left_type == Type.REAL || right_type == Type.REAL)
          type = Type.REAL;
        break;
      case IGUAL:
        if (left_type != right_type) {
          errors.add(new ErrorSemantico(this, TipoError.TYPEOP));
        }
        type = Type.BOOL;
        break;
      case IGUALIGUAL:
        if (left_type != right_type) {
          errors.add(new ErrorSemantico(this, TipoError.TYPEOP));
        }
        type = Type.BOOL;
        break;
      case DISTINTO:
        if (left_type != right_type) {
          errors.add(new ErrorSemantico(this, TipoError.TYPEOP));
        }
        type = Type.BOOL;
        break;
      case MAYOR:
        if (!esTipoNumerico(right_type) || !esTipoNumerico(left_type)) {
          errors.add(new ErrorSemantico(this, TipoError.TYPEOP));
        }
        type = Type.BOOL;
        break;
      case MENOR:
        if (!esTipoNumerico(right_type) || !esTipoNumerico(left_type)) {
          errors.add(new ErrorSemantico(this, TipoError.TYPEOP));
        }
        type = Type.BOOL;
        break;
      case MAYOR_IGUAL:
        if (!esTipoNumerico(right_type) || !esTipoNumerico(left_type)) {
          errors.add(new ErrorSemantico(this, TipoError.TYPEOP));
        }
        type = Type.BOOL;
        break;
      case MENOR_IGUAL:
        if (!esTipoNumerico(right_type) || !esTipoNumerico(left_type)) {
          errors.add(new ErrorSemantico(this, TipoError.TYPEOP));
        }
        type = Type.BOOL;
        break;
      case MULTIPLICA:
        if (!esTipoNumerico(right_type) || !esTipoNumerico(left_type)) {
          errors.add(new ErrorSemantico(this, TipoError.TYPEOP));
        }

        type = Type.NUM;

        if (left_type == Type.REAL || right_type == Type.REAL)
          type = Type.REAL;
        break;
      case DIVIDE:
        if (!esTipoNumerico(right_type) || !esTipoNumerico(left_type)) {
          errors.add(new ErrorSemantico(this, TipoError.TYPEOP));
        }

        type = Type.NUM;

        if (left_type == Type.REAL || right_type == Type.REAL)
          type = Type.REAL;
        break;
      default:
        break;
    }
  }

  boolean esTipoNumerico(Type tipo) {
    return tipo == Type.NUM || tipo == Type.REAL || tipo == Type.HUGE || tipo == Type.HUGEHUGE;
  }

  public Number execute() {

    // Execute the child nodes
    Number left_value = opnd1.execute();
    Number right_value = opnd2.execute();

    Number value;

    switch (op) {
      case MAS:
        value = Util.addNumbers(left_value, right_value);
        break;
      case MENOS:
        value = Util.substractNumbers(left_value, right_value);
        break;
      case MULTIPLICA:
        value = Util.multiplyNumbers(left_value, right_value);
        break;
      case DIVIDE:
        value = Util.divideNumbers(left_value, right_value);
        break;

      // case IGUAL: NO ESTÁ PORQUE NO TIENE QUE ESTAR, las asignaciones van en la
      // clase Asignacion
      case IGUALIGUAL:
        if (Util.compareNumbers(left_value, right_value) == 0) {
          value = 1;
        } else {
          value = 0;
        }
        break;
      case DISTINTO:
        if (Util.compareNumbers(left_value, right_value) != 0) {
          value = 1;
        } else {
          value = 0;
        }
        break;
      case MAYOR:
        if (Util.compareNumbers(left_value, right_value) == 1) {
          value = 1;
        } else {
          value = 0;
        }
        break;
      case MAYOR_IGUAL:
        int resMayor = Util.compareNumbers(left_value, right_value);
        if (resMayor == 1 || resMayor == 0) {
          value = 1;
        } else {
          value = 0;
        }
        break;
      case MENOR:
        if (Util.compareNumbers(left_value, right_value) == -1) {
          value = 1;
        } else {
          value = 0;
        }
        break;
      case MENOR_IGUAL:
        int resMenor = Util.compareNumbers(left_value, right_value);
        if (resMenor == -1 || resMenor == 0) {
          value = 1;
        } else {
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
