package ast;
import java.util.LinkedList;
import errors.ErrorSemantico;
import errors.TipoError;

public interface ASTNode {
    //public void type(); // for the future
    // public ?? generateCode() // for the future

    public NodeKind nodeKind();
    public String toString();
    //public Type getType();

    public void bind(TableStack bind_info, LinkedList<ErrorSemantico> errors); 
    public void checkTypes(LinkedList<ErrorSemantico> errors);
}
