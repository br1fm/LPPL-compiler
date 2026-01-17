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
numeroEntero = {digitoPositivo}{digito}*|0
separador = [ \t\r\b\n]
comentario = \#[^\#]*\# 
identificador = {letra}({letra}|{digito})*
operadorSuma = \+
operadorIgual = \=
operadorMultiplica = \*
operadorMayor = \>
operadorIgualIgual = \=\=
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
longInt = huge
longLongInt = hugeHuge
puntocoma = \;

%%
{separador}               {}
{comentario}              {}
{if}                      {return ops.unidadIf();}
{else}                    {return ops.unidadElse();}
{int}                     {return ops.unidadTipoEnt();}
{longLongInt}             {return ops.unidadTipoHugeHuge();}
{longInt}                 {return ops.unidadTipoHuge();}
{bool}                    {return ops.unidadTipoBool();}
{false}                   {return ops.unidadFalse();}
{true}                    {return ops.unidadTrue();}
{identificador}           {return ops.unidadId();}
{numeroEntero}            {return ops.unidadEnt();}
{operadorSuma}            {return ops.unidadSuma();}
{operadorIgual}           {return ops.unidadIgual();}
{operadorIgualIgual}      {return ops.unidadIgualIgual();}
{operadorMayor}           {return ops.unidadMayor();}
{parentesisApertura}      {return ops.unidadPAp();}
{parentesisCierre}        {return ops.unidadPCierre();} 
{corcheteApertura}        {return ops.unidadCAp();}
{corcheteCierre}          {return ops.unidadCCierre();} 
{puntocoma}               {return ops.unidadPuntoComa();} 
{operadorMultiplica}			{return ops.unidadMultiplica();}
[^]                       {errores.errorLexico(fila(),columna(),lexema());}  
