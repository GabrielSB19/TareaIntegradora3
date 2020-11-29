/*
Gabriel Suarez
A00368589
*/

package model;
import java.util.*;

public abstract class Coach extends Employee{

  private int yearExperience;

  public Coach(String nameEm, int idEm, int salary, boolean status, int yearExperience){
    super(nameEm, idEm, salary, status);
    this.yearExperience = yearExperience;
  }

  public int getYearExperience(){
    return yearExperience;
  }

  public void setYearExperience(int yearExperience){
    this.yearExperience = yearExperience;
  }

  @Override
  public String showData(){
    String msg = super.showData();
    msg += "Años de Experiencia: "+getYearExperience()+"\n";
    return msg;
  }
}
