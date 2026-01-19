package ast;

import java.util.LinkedList;

import errors.ErrorSemantico;

public abstract class Instruccion implements ASTNode {
    public abstract KindI kind();

    public NodeKind nodeKind() {
        return NodeKind.INSTRUCCION;
    }

    public String toString() {
        return "";
    }

    // Analisis de identificadores
    public abstract void bind(TableStack bind_info, LinkedList<ErrorSemantico> errors);

    // Analisis de tipos
    public abstract void checkTypes(LinkedList<ErrorSemantico> errors);

    public Type getType() {
        return null;
    }

    // Ejecución
    public abstract void execute();
}
