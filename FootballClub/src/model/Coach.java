/*
Gabriel Suarez
A00368589
*/

package model;
import java.util.*;

public abstract class Coach extends Employee{

  /*
  Class Builder Attributess
  */

  private int yearExperience;

  /**
  *Coach class builder <br>
  *<b>pre: </b><br>
  *<b>post: </b> A Coach type object has been created <br>
  @param nameEm name of the employee. nameEm ! = null
  @param idEm employee id. idEm ! = null
  @param salary employee's salary. salary must be greater than or equal to zero and salary ! = null
  @param status employee status. status = inactive or status = active
  @param yearExperience must be greater than or equal to zero and yearExperience ! = null
  */

  public Coach(String nameEm, int idEm, int salary, boolean status, int yearExperience){
    super(nameEm, idEm, salary, status);
    this.yearExperience = yearExperience;
  }

  /**
  *Getter of the years of experience of the coaches <br>
  *<b>pre: </b><br>
  *<b>post: </b> Years of experience <br>
  @return yearExperience
  */

  public int getYearExperience(){
    return yearExperience;
  }

  /**
  *Setter of the years of experience of the coaches <br>
  *<b>pre: </b><br>
  *<b>post: </b> Update the years of experience <br>
  @param yearExperience must be greater than or equal to zero and yearExperience ! = null
  */

  public void setYearExperience(int yearExperience){
    this.yearExperience = yearExperience;
  }

  /**
  *Allows to show the specific information of the employees. <br>
  *<b>pre: </b> At least one employee must be hired. <br>
  *<b>post: </b> Employee's information dated <br>
  */

  @Override
  public String showData(){
    String msg = super.showData();
    msg += "Años de Experiencia: "+getYearExperience()+"\n";
    return msg;
  }
}
