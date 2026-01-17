#!/bin/bash
echo "#####################################"
echo "### Generando el Analizador Léxico..."
java -cp jflex.jar jflex.Main mini_lexico.l
mv AnalizadorLexicoTiny.java AnalizadorSintacticoCUP/alex/AnalizadorLexicoTiny.java
echo 
echo
echo "#####################################"
echo "### Compilando el analizador..."
cd AnalizadorSintacticoCUP
javac -cp "../cup.jar" */*.java
