package ast;

public abstract class Instruccion implements ASTNode {
    public abstract KindI kind();
    public NodeKind nodeKind() {return NodeKind.INSTRUCCION;}
    public String toString() {return "";}

}
