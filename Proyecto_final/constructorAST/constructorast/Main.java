package constructorast;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import alex.AnalizadorLexicoTiny;
import ast.Declaracion;
import ast.DeclaracionArray;
import ast.Instruccion;
import ast.TableStack;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import errors.ErrorSemantico;

public class Main {
	public static void main(String[] args) throws Exception {
		Reader input = new InputStreamReader(new FileInputStream(args[0]));
		AnalizadorLexicoTiny alex = new AnalizadorLexicoTiny(input);
		ConstructorAST constructorast = new ConstructorAST(alex);
		// System.out.println(constructorast.parse().value);

		LinkedList<Instruccion> program = (LinkedList<Instruccion>) constructorast.parse().value;
		TableStack infoBinding = new TableStack();

		// Analisis de identificadores
		LinkedList<ErrorSemantico> errores = new LinkedList<ErrorSemantico>();
		for (Instruccion i : program) {
			i.bind(infoBinding, errores);
		}

		if (errores.size() != 0) {
			for (ErrorSemantico e : errores) {
				System.out.println(e + "\n");
			}
			System.exit(1);
		}

		// Analisis de tipos
		for (Instruccion i : program) {
			i.checkTypes(errores);
		}
		if (errores.size() != 0) {
			for (ErrorSemantico e : errores) {
				System.out.println(e + "\n");
			}
			System.exit(1);
		}

		LinkedList<Declaracion> noUsado = infoBinding.buscaNoUsado();
		if (noUsado.size() != 0) {
			for (Declaracion d : noUsado) {
				System.out.println("AVISO: Variable no leída: " + d.getName());
			}
		}

		// Ejecución / generación código
		for (Instruccion i : program) {
			i.execute();
		}

		// Para mostrar la asignación final de las variables
		Set<Map.Entry<String, Declaracion>> variables_vivas = infoBinding.peek().getTable();
		for (Map.Entry<String, Declaracion> entry : variables_vivas) {
			Declaracion nodo = entry.getValue();
			if(nodo instanceof DeclaracionArray)
				System.out.println("Variable  " + entry.getKey() + " -> " + ((DeclaracionArray) nodo).getValues());
			else
				System.out.println("Variable  " + entry.getKey() + " -> " + nodo.getValue());
		}
	}
}
