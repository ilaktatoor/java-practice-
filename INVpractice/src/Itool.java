public class Itool{

  //atributos
  private String nombre;
  private double porcentaje;

  //constructor
  public Itool(String nombre, double porcentaje){
    this.nombre=nombre;
    this.porcentaje=porcentaje;
  }

  //metodos
  public String getNombre(){
    return nombre;
  }

  public double getPorcentaje(){
    return porcentaje;
  }

  @Override
  public String toString(){
    return ""+nombre+" "+porcentaje+"%";
  }

}
