#!/bin/bash
echo "#####################################"
echo "### Generando el Analizador Léxico..."
java -cp jflex.jar jflex.Main mini_lexico.l
mv AnalizadorLexicoTiny.java AnalizadorSintacticoCUP/alex/AnalizadorLexicoTiny.java
echo 
echo
echo "#####################################"
echo "### Generando el Analizador Sintáctico..."
java -cp cup.jar java_cup.Main -parser AnalizadorSintacticoTiny -symbols ClaseLexica -nopositions Tiny.cup
mv AnalizadorSintacticoTiny.java AnalizadorSintacticoCUP/asint/AnalizadorSintacticoTiny.java
mv ClaseLexica.java AnalizadorSintacticoCUP/asint/ClaseLexica.java
echo 
echo
echo "#####################################"
echo "### Compilando el analizador..."
cd AnalizadorSintacticoCUP
javac -cp "../cup.jar" */*.java
