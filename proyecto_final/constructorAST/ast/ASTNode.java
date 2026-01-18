package ast;

interface ASTNode {
    //public void type(); // for the future
    // public ?? bind() // for the future
    // public ?? generateCode() // for the future
    public NodeKind nodeKind();
    public String toString();
    //public Type getType();
}
