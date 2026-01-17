#!/bin/bash
echo "#####################################"
echo "### Generando el Analizador Léxico..."
java -cp jflex.jar jflex.Main mini_lexico.l
mv AnalizadorLexicoTiny.java constructorAST/alex/AnalizadorLexicoTiny.java
echo 
echo
echo "#####################################"
echo "### Compilando el analizador..."
cd constructorAST
javac -cp "../cup.jar" */*.java
