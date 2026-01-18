package alex;

%%
%char
%line
%column
%class AnalizadorLexicoTiny
%type  UnidadLexica
%unicode

%{
  private ALexOperations ops;
  public String lexema() {return yytext();}
  public int fila() {return yyline+1;}
  public int columna() {return yycolumn+1;}
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
puntocoma = \;


%%
{separador}               {}
{comentario}              {}
{if}                      {return ops.unidadIf();}
{else}                    {return ops.unidadElse();}
{int}                     {return ops.unidadTipoEnt();}
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
[^]                       {ops.error();}  
