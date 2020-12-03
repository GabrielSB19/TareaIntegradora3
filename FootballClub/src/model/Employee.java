/*
Gabriel Suarez
A00368589
*/

package model;
import java.util.*;

public abstract class Employee{

  /*
  Class Builder Attributes
  */

  private String nameEm;
  private int idEm;
  private int salary;
  private boolean status;

  /**
  *Employee class builder. <br>
  *<b>pre: </b><br>
  *<b>post: </b> An Employee type object has been created. <br>
  @param nameEm name of the employee. nameEm ! = null
  @param idEm employee id. idEm ! = null
  @param salary employee's salary. salary must be greater than or equal to zero and salary ! = null
  @param status employee status. status = inactive or status = active
  */

  public Employee(String nameEm, int idEm, int salary, boolean status){
    this.nameEm = nameEm;
    this.idEm = idEm;
    this.salary = salary;
    this.status = status;
  }

  /**
  *Getter of the employee's name. <br>
  *<b>pre: </b><br>
  *<b>post: </b> Employee's name <br>
  @return nameEm
  */

  public String getNameEm(){
    return nameEm;
  }

  /**
  *Employee name setter<br>
  *<b>pre: </b><br>
  *<b>post: </b> Update the name of the employee. <br>
  @param nameEm name of the employee. nameEm ! = null
  */

  public void setNameEm(String nameEm){
    this.nameEm = nameEm;
  }

  /**
  *Employee ID setter. <br>
  *<b>pre: </b><br>
  *<b>post: </b> Employee's idea. <br>
  @return idEm
  */

  public int getIdEm(){
    return idEm;
  }

  /**
  *Employee ID setter. <br>
  *<b>pre: </b><br>
  *<b>post: </b> Update the employee ID <br>
  @param idEm employee id. idEm ! = null
  */

  public void setIdEm(int idEm){
    this.idEm = idEm;
  }

  /**
  *Getter of the employee's salary. <br>
  *<b>pre: </b><br>
  *<b>post: </b> Employee's salary <br>
  @return salary
  */

  public int getSalary(){
    return salary;
  }

  /**
  Employee salary setter. <br>
  *<b>pre: </b><br>
  *<b>post: </b> Updates the employee's salary <br>
  @param salary employee's salary. salary must be greater than or equal to zero and salary ! = null
  */

  public void setSalary(int salary){
    this.salary = salary;
  }

  /**
  *Employee status getter. <br>
  *<b>pre: </b><br>
  *<b>post: </b> Employee status. <br>
  @return status
  */

  public boolean getStatus(){
    return status;
  }

  /**
  *Employee status setter. <br>
  *<b>pre: </b><br>
  *<b>post: </b> Update the status of the employee. <br>
  @param status employee status. status = inactive or status = active
  */

  public void setStatus(boolean status){
    this.status = status;
  }

  /**
  *Allows to show the specific information of the employees. <br>
  *<b>pre: </b> At least one employee must be hired. <br>
  *<b>post: </b> Employee's information dated <br>
  @return msg
  */

  public String showData(){
    String msg = "";
    msg += "************* Empleado *************\n";
    msg += "Nombre: "+getNameEm()+"\n";
    msg += "Id: "+getIdEm()+"\n";
    msg += "Salario: "+getSalary()+"\n";
    if(getStatus()){
      msg += "Estado: Activo\n";
    }
    else{
      msg += "Estado: Inactivo\n";
    }
    return msg;
  }
}
