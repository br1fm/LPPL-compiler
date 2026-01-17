package ast;
import java.util.LinkedList;
import errors.ErrorSemantico;
import errors.TipoError;

public abstract class E implements ASTNode {

    protected Type type;


    public abstract KindE kind();
    public E opnd1() {throw new UnsupportedOperationException("opnd1");} 
    public E opnd2() {throw new UnsupportedOperationException("opnd2");} 
    public String num() {throw new UnsupportedOperationException("num");}
    public NodeKind nodeKind() {return NodeKind.EXPRESION;}
    public String toString() {return "";}
    
    // Analisis de identificadores
    public void bind(TableStack bind_info, LinkedList<ErrorSemantico> errors){}; 
    
    // Analisis de tipos
    public abstract void checkTypes(LinkedList<ErrorSemantico> errors);
    public Type getType(){
        return type;
    };
}
