package ast;

public class DeclaracionArray extends Declaracion {
  private String size; 
  
  public DeclaracionArray(Type type, String name, String size) {
     super(type, name); 
     this.size = size;
  }

  @Override
  public KindI kind() { 
      return KindI.DECLARACION_ARRAY; 
  }   

  @Override
  public String toString() {
      return "DEC ARRAY: " + getType() + " " + getName() + "[" + size + "]\n";
  }  

  public String getSize(){
      return size;
  }
  

}