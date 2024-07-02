public class Alumn{
  //parameters
  private String name, lastName, noControl,gEsc;
  
  //contructor
  public Alumn(String name, String lastName, String noControl, String gEsc){
    this.name=name;
    this.lastName=lastName;
    this.noControl=noControl;
    this.gEsc=gEsc;
  }
  
  //methods
  public void inscribirse(){
    System.out.println(name+" "+ lastName+" has been enrolled.");
  }

  public void pagarColegiatura(){
    System.out.println(name+" "+ lastName+" has paid the tuition");
  }

  public void darseDeBaja(){
    System.out.println(name+" "+lastName+" has withdraw");
  }
  
  @Override
  public String toString(){
    return "Alumn{name= '" + name + "', lastName= '" + lastName+"', noControl= '"+noControl+"', gEsc= '" + gEsc+"'}";
  }

  public String getNoControl(){
    return noControl;
  }



}
