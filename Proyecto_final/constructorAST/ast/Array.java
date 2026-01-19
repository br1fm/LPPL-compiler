/*package ast;

import java.util.LinkedList;

import errors.ErrorSemantico;

public class Array extends E {
    private String v;
    private LinkedList<Number> array;


    public Array(String v) {
        this.v = v;
    }

    public String lexema() {
        return v;
    }

    public String toString() {
        return v;
    }

    public KindE kind() {
        return KindE.REAL;
    }

    public void checkTypes(LinkedList<ErrorSemantico> errors) {
        type = Type.REAL;
    }

    public Number execute() {
        return Double.parseDouble(v);
    }
}*/