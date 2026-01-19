
package errors;

import ast.ASTNode;

public class ErrorSemantico {

    private ASTNode nodo;
    private TipoError tipo;

    public ErrorSemantico(ASTNode nodo, TipoError tipo){
        this.nodo = nodo;
        this.tipo = tipo;
    }

    public String toString() {
        String mensaje = "ERROR: ";
        switch (tipo){
            case DUPIDEN: 
                mensaje += "Definición de identificador duplicada\n";
                break;
            case NOIDEN:
                mensaje += "Uso de identificador no definido\n";
                break;
            case TYPEOP:
                mensaje += "Los tipos utilizados no son los esperados por el operador\n";
                break;
            case TYPECOND:
                mensaje += "La cláusula de un condicional esperado una expresión booleana\n";
                break;
            case TYPEASIG:
                mensaje += "El tipo de la expresión asignada no es el esperado\n";
                break;
            default:
                break;
        }
        mensaje += "Localización: " + nodo.toString();
        return mensaje;
    }  

}