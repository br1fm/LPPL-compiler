package ast;

import java.util.LinkedList;

import errors.ErrorEjecucion;
import errors.ErrorSemantico;
import errors.TipoError;

public class IdentificadorArray extends E {
    private String v;
    private DeclaracionArray binding;
    private int index;

    public IdentificadorArray(String v, String index) {
        this.v = v;
        this.index = Integer.parseInt(index);
    }

    public KindE kind() {
        return KindE.ID_ARRAY;
    }

    public String toString() {
        return v;
    }

    public void bind(TableStack bind_info, LinkedList<ErrorSemantico> errors) {
        // Check that the identifier is defined
        Declaracion lookup_variable = bind_info.lookup(v);
        if (lookup_variable == null) {
            errors.add(new ErrorSemantico(this, TipoError.NOIDEN));
        } else if (!(lookup_variable instanceof DeclaracionArray)) {
            errors.add(new ErrorSemantico(this, TipoError.NOTARRAY));
        } else {
            this.binding = (DeclaracionArray) lookup_variable;
            lookup_variable.setLeido();
        }
    }

    public void checkTypes(LinkedList<ErrorSemantico> errors) {
        Type bind_type = binding.getType();
        type = bind_type;
    }

    public Number execute() {
        Number value = binding.getValue(index);
        if (value == null) {
            ErrorEjecucion error = new ErrorEjecucion(this, TipoError.NOVALUE);
            error.gestionaError();
        }
        return value;
    }
}
