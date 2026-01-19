package alex;

import constructorast.ClaseLexica;

public class ALexOperations {
  private AnalizadorLexicoTiny alex;
  public ALexOperations(AnalizadorLexicoTiny alex) {
   this.alex = alex;   
  }
  
  public UnidadLexica unidadId() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.IDEN,alex.lexema()); 
  } 
  public UnidadLexica unidadIf() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.IF); 
  } 
  public UnidadLexica unidadElse() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.ELSE); 
  }
  public UnidadLexica unidadEnt() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.ENT,alex.lexema()); 
  }
   public UnidadLexica unidadNumReal() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.REAL,alex.lexema()); 
  }
  public UnidadLexica unidadNumHuge() {
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.HUGE, alex.lexema());
  }
  public UnidadLexica unidadTipoEnt() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.TIPO_ENT); 
  }
  public UnidadLexica unidadTipoBool() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.TIPO_BOOL); 
  }
  public UnidadLexica unidadTrue() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.TRUE); 
  }
  public UnidadLexica unidadFalse() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.FALSE); 
  }
  public UnidadLexica unidadSuma() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.MAS); 
  } 
   public UnidadLexica unidadResta() {
      return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.MENOS);
 }
 public UnidadLexica unidadDivide() {
      return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.DIVIDE);
 }
  public UnidadLexica unidadPAp() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.PAP); 
  } 
  public UnidadLexica unidadPCierre() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.PCIERRE); 
  }
  public UnidadLexica unidadCAp() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.CAP); 
  } 
  public UnidadLexica unidadCCierre() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.CCIERRE); 
  }  
  public UnidadLexica unidadIgual() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.IGUAL); 
  } 
  public UnidadLexica unidadIgualIgual() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.IGUALIGUAL); 
  }
  public UnidadLexica unidadDistinto() {
      return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.DISTINTO);
  }
  public UnidadLexica unidadMayor() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.MAYOR); 
  }
  public UnidadLexica unidadMenor() {
      return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.MENOR);
  }
  public UnidadLexica unidadMayorIgual() {
      return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.MAYOR_IGUAL);
  }
  public UnidadLexica unidadMenorIgual() {
      return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.MENOR_IGUAL);
  }
  public UnidadLexica unidadPuntoComa() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.PUNTOCOMA); 
  } 
  public UnidadLexica unidadEof() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.EOF); 
  }
  public UnidadLexica unidadTipoHuge() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.TIPO_HUGE);
  }
  public UnidadLexica unidadMultiplica() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.MULTIPLICA);
  }
  /*public UnidadLexica unidadPorfavor() {
     return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.PORFAVOR);
  }*/
 public UnidadLexica unidadTipoReal() {
      return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.TIPO_REAL);
 }
 public UnidadLexica unidadBucleWhile() {
      return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.BUCLE_WHILE);
 }
 public UnidadLexica unidadWhileIf() {
      return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.WHILEIF);
 }




}
