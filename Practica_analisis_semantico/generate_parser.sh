#!/bin/bash
echo "#####################################"
echo "### Generando el Analizador Sintáctico..."
java -cp cup.jar java_cup.Main -parser ConstructorAST -symbols ClaseLexica -nopositions Tiny.cup
mv ConstructorAST.java constructorAST/constructorast/ConstructorAST.java
mv ClaseLexica.java constructorAST/constructorast/ClaseLexica.java
echo 
echo
echo "#####################################"
echo "### Compilando el analizador..."
cd constructorAST
javac -cp "../cup.jar" */*.java
