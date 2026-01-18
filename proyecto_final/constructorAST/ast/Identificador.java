package ast;

import java.util.LinkedList;
import errors.ErrorSemantico;
import errors.TipoError;

public class Identificador extends E {
    private String v;
    private Declaracion binding;

    public Identificador(String v) {
        this.v = v;
    }

    public KindE kind() {
        return KindE.ID;
    }

    public String toString() {
        return v;
    }

    public void bind(TableStack bind_info, LinkedList<ErrorSemantico> errors) {
        // Check that the identifier is defined
        Declaracion lookup_variable = bind_info.lookup(v);
        if (lookup_variable == null) {
            errors.add(new ErrorSemantico(this, TipoError.NOIDEN));
        } else {
            this.binding = lookup_variable;
            lookup_variable.setLeido();
        }
    }

    public void checkTypes(LinkedList<ErrorSemantico> errors) {
        Type bind_type = binding.getType();
        type = bind_type;
    }
}
