package ast;

public class Identificador extends E {
    private String v;
    public Identificador(String v) {
        this.v = v;
    }

    public KindE kind() {return KindE.ID;}   
    public String toString() {return v;} 
}
