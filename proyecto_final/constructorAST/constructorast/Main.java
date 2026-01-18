package constructorast;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import alex.AnalizadorLexicoTiny;
import ast.Instruccion;
import ast.TableStack;
import java.util.LinkedList;
import errors.ErrorSemantico;

public class Main {
	public static void main(String[] args) throws Exception {
		Reader input = new InputStreamReader(new FileInputStream(args[0]));
		AnalizadorLexicoTiny alex = new AnalizadorLexicoTiny(input);
		ConstructorAST constructorast = new ConstructorAST(alex);
		//System.out.println(constructorast.parse().value);

		LinkedList<Instruccion> program = (LinkedList<Instruccion>) constructorast.parse().value;
		TableStack infoBinding = new TableStack();

		// Analisis de identificadores
		LinkedList<ErrorSemantico> errores = new LinkedList();
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
	}
}
