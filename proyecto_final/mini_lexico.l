package alex;

import errors.GestionErroresTiny;

%%
%cup
%line
%column
%class AnalizadorLexicoTiny
%unicode
%public

%{
  private ALexOperations ops;
  private GestionErroresTiny errores;
  public String lexema() {return yytext();}
  public int fila() {return yyline+1;}
  public int columna() {return yycolumn+1;}
  public void fijaGestionErrores(GestionErroresTiny errores) {
   this.errores = errores;
  }
%}

%eofval{
  return ops.unidadEof();
%eofval}

%init{
  ops = new ALexOperations(this);
%init}

letra  = ([A-Z]|[a-z])
digitoPositivo = [1-9]
digito = ({digitoPositivo}|0)
exponente = [eE][\+\-]?{digito}+
numeroEntero = {digitoPositivo}{digito}*|0
numeroReal = {digitoPositivo}{digito}*\.{digito}+|0\.{digito}+
numeroHuge = ({digito}+|{digito}+\.{digito}+){exponente}
separador = [ \t\r\b\n]
comentario = \#[^\#]*\# 
identificador = {letra}({letra}|{digito})*
operadorSuma = \+
operadorResta = \-
operadorIgual = \=
operadorMultiplica = \*
operadorDivide = \/
operadorMayor = \>
operadorIgualIgual = \=\=
operadorDistinto = \!\=
operadorMenor = \<
operadorMayorIgual = \>\=
operadorMenorIgual = \<\=
parentesisApertura = \(
parentesisCierre = \)
corcheteApertura = \[
corcheteCierre = \]
true = verdadero
false = falso
if = si
else = sino
int = ent
bool = bool
real = real
longInt = huge
puntocoma = \;
while = while
whileif = whif

%%
{separador}               {}
{comentario}              {}
{if}                      {return ops.unidadIf();}
{else}                    {return ops.unidadElse();}
{while}                   {return ops.unidadBucleWhile();}
{whileif}                 {return ops.unidadWhileIf();}
{int}                     {return ops.unidadTipoEnt();}
{longInt}                 {return ops.unidadTipoHuge();}
{bool}                    {return ops.unidadTipoBool();}
{real}                    {return ops.unidadTipoReal();}
{false}                   {return ops.unidadFalse();}
{true}                    {return ops.unidadTrue();}
{identificador}           {return ops.unidadId();}
{numeroEntero}            {return ops.unidadEnt();}
{numeroReal}              {return ops.unidadNumReal();}
{numeroHuge}              {return ops.unidadNumHuge();}
{operadorSuma}            {return ops.unidadSuma();}
{operadorResta}           {return ops.unidadResta();}
{operadorDivide}          {return ops.unidadDivide();}
{operadorIgual}           {return ops.unidadIgual();}
{operadorIgualIgual}      {return ops.unidadIgualIgual();}
{operadorDistinto}        {return ops.unidadDistinto();}
{operadorMayor}           {return ops.unidadMayor();}
{operadorMenor}           {return ops.unidadMenor();}
{operadorMayorIgual}      {return ops.unidadMayorIgual();}
{operadorMenorIgual}      {return ops.unidadMenorIgual();}
{parentesisApertura}      {return ops.unidadPAp();}
{parentesisCierre}        {return ops.unidadPCierre();}
{corcheteApertura}        {return ops.unidadCAp();}
{corcheteCierre}          {return ops.unidadCCierre();} 
{puntocoma}               {return ops.unidadPuntoComa();} 
{operadorMultiplica}			{return ops.unidadMultiplica();}
[^]                       {errores.errorLexico(fila(),columna(),lexema());}  
