package ast;

import java.util.LinkedList;

import errors.ErrorSemantico;
import errors.TipoError;

public class AsignacionArray extends Instruccion {
    private String variable;
    private E valor;
    private int index;

    private DeclaracionArray variable_binding;

    public AsignacionArray(String variable, String index, E valor) {
        this.variable = variable;
        this.valor = valor;
        this.index = Integer.parseInt(index);
    }

    @Override
    public KindI kind() {
        return KindI.ASIGNACION_ARRAY;
    }

    public String toString() {
        return "ASIG: " + variable + "[" + index + "] -> " + valor + "\n";
    }

    public void bind(TableStack bind_info, LinkedList<ErrorSemantico> errors) {
        // Check that the assigned variable is defined
        Declaracion lookup_variable = bind_info.lookup(variable);
        if (lookup_variable == null) {
            errors.add(new ErrorSemantico(this, TipoError.NOIDEN));
        } else if (!(lookup_variable instanceof DeclaracionArray)) {
            errors.add(new ErrorSemantico(this, TipoError.NOTARRAY));
        } else {
            this.variable_binding = (DeclaracionArray) lookup_variable;
        }

        // Bind the value assigned
        valor.bind(bind_info, errors);
    }

    public void checkTypes(LinkedList<ErrorSemantico> errors) {
        // Check that the types are valid
        Type left_type = variable_binding.getType();
        if (left_type == null) {
            errors.add(new ErrorSemantico(this, TipoError.TYPEASIG));
        }

        // Check that the value assigned is well typed
        valor.checkTypes(errors);
        Type right_type = valor.getType();
        if (right_type == null) {
            errors.add(new ErrorSemantico(this, TipoError.TYPEASIG));
        }

        if (left_type != right_type) {
            errors.add(new ErrorSemantico(this, TipoError.TYPEASIG));
        }
    }

    public void execute() {
        Number value = valor.execute();

        variable_binding.setValue(value, index);
    }
}
