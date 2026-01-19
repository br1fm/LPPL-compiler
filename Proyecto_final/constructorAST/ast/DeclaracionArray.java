package ast;

import java.util.Vector;
import errors.TipoError;
import errors.ErrorEjecucion;
import errors.ErrorSemantico;

public class DeclaracionArray extends Declaracion {
    private String size;
    private Vector<Number> array;


    public DeclaracionArray(Type type, String name, String size) {
        super(type, name);
        this.size = size;
        this.array = new Vector<Number>();
        for (int i = 0; i < Integer.parseInt(this.size); i++) {
            array.add(null);
        }
    }

    @Override
    public KindI kind() {
        return KindI.DECLARACION_ARRAY;
    }

    @Override
    public String toString() {
        return "DEC ARRAY: " + type + " " + name + "[" + size + "]\n";
    }

    public String getSize() {
        return size;
    }

    @Override
    public void setValue(Number value){
        super.setValue(value);
        this.array.set(0, value);
    }

    public void setValue(Number value, int index) {
        super.setValue(array.get(0));
        if (index < Integer.parseInt(this.size) && index >= 0)
            this.array.set(index, value);
        else {
            ErrorEjecucion error = new ErrorEjecucion(this, TipoError.OUTOFBOUNDS);
            error.gestionaError();
        }
    }

    public Number getValue(int index){
        Number ret = null;
        if (index < Integer.parseInt(this.size) && index >= 0)
            ret = this.array.get(index);
        else {
            ErrorEjecucion error = new ErrorEjecucion(this, TipoError.OUTOFBOUNDS);
            error.gestionaError();
        }
        return ret;
    }

    public void execute() {
    };

    public String getValues(){
        String ret = new String();
        ret = "[";
        for(int i = 0; i < this.array.size(); i++){
            if(i > 0)
                ret = ret.concat(",");
                if(this.array.get(i) != null){
                    ret = ret.concat(" " + this.array.get(i).toString());
                }
                else
                    ret = ret.concat(" null");
        }
        ret = ret.concat("]");
        return ret;
    }

}