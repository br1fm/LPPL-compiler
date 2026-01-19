
package errors;
import ast.ASTNode;

public class ErrorEjecucion {

    private ASTNode nodo;
    private TipoError tipo;

    public ErrorEjecucion(ASTNode nodo, TipoError tipo){
        this.nodo = nodo;
        this.tipo = tipo;
    }

    public void gestionaError() {
        String mensaje = "ERROR: ";
        switch (tipo){
            case NOVALUE: 
                mensaje += "Acceso a variable no inicializada\n";
                break;
            case TOOBIG: 
                mensaje += "El número introducido es demasiado grande\n";
                break;
            default:
                break;
        }
        mensaje += "Localización: " + nodo.toString();
        System.out.println(mensaje);
        System.exit(1);    
    }  

}