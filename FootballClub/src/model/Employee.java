/*
Gabriel Suarez
A00368589
*/

package model;
import java.util.*;

public abstract class Employee{

  private String nameEm;
  private int idEm;
  private int salary;
  private boolean status;

  public Employee(String nameEm, int idEm, int salary, boolean status){
    this.nameEm = nameEm;
    this.idEm = idEm;
    this.salary = salary;
    this.status = status;
  }

  public String getNameEm(){
    return nameEm;
  }

  public void setNameEm(String nameEm){
    this.nameEm = nameEm;
  }

  public int getIdEm(){
    return idEm;
  }

  public void setIdEm(int idEm){
    this.idEm = idEm;
  }

  public int getSalary(){
    return salary;
  }

  public void setSalary(int salary){
    this.salary = salary;
  }

  public boolean getStatus(){
    return status;
  }

  public void setStatus(boolean status){
    this.status = status;
  }
}
