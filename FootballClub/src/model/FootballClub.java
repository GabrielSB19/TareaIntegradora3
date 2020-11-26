/*
Gabriel Suarez
A00368589
*/

package model;
import java.util.*;

public class FootballClub{

  private ArrayList<Employee> employeeClub;

  private String nameFC;
  private int nitFC;
  private String fundationDateFC;
  private Team TeamA;
  private Team TeamB;

  public FootballClub(String nameFC, int nitFC, String fundationDateFC){
    this.nameFC = nameFC;
    this.nitFC = nitFC;
    this.fundationDateFC = fundationDateFC;
    employeeClub = new ArrayList<Employee>();
  }

  public String getNameFC(){
    return nameFC;
  }

  public void setNameFC(String nameFC){
    this.nameFC = nameFC;
  }

  public int getNitFC(){
    return nitFC;
  }

  public void setNitFC(int nitFC){
    this.nitFC = nitFC;
  }

  public String getFundationDateFC(){
    return fundationDateFC;
  }

  public void setFundationDateFC(String fundationDateFC){
    this.fundationDateFC = fundationDateFC;
  }

  public String addEmployee(String nameEm, int idEm, int salary, boolean status, int dorsal, int amountGoal, double average, Position position){
    Employee newPlayer = new Player(nameEm, idEm, salary, status, dorsal, amountGoal, average, position);
    employeeClub.add(newPlayer);
    String msg = "El empleado se ha contratado";
    return msg;
  }

  public String addEmployee(String nameEm, int idEm, int salary, boolean status, int yearExperience, int amountTeam, int amountWinner){
    Employee newMainCoach = new MainCoach(nameEm, idEm, salary, status, yearExperience, amountTeam, amountWinner);
    employeeClub.add(newMainCoach);
    String msg = "El empleado se ha contratado";
    return msg;
  }

  public String addEmployee(String nameEm, int idEm, int salary, boolean status, int yearExperience, boolean playerProfesional, Expertise expertise){
    Employee newAsistentCoach = new AsistentCoach(nameEm, idEm, salary, status, yearExperience, playerProfesional, expertise);
    employeeClub.add(newAsistentCoach);
    String msg = "El empleado se ha contratado";
    return msg;
  }

  public String showNameMainCoach(){
    String nameEmployee = "";
    int x = 0;
    for(int i = 0; i<employeeClub.size(); i++){
      if(employeeClub.get(i) instanceof MainCoach){
        x++;
        nameEmployee += employeeClub.get(i).getNameEm()+"\n";
      }
    }
    if(x == 0){
      nameEmployee = "No existen empleados de este tipo";
    }
    return nameEmployee;
  }

  public String showNameAsistenCoach(){
    String nameEmployee ="";
    int x = 0;
    for(int i = 0; i<employeeClub.size(); i++){
      if(employeeClub.get(i) instanceof AsistentCoach){
        x++;
        nameEmployee += employeeClub.get(i).getNameEm()+"\n";
      }
    }
    if(x == 0){
      nameEmployee = "No existen empleados de este tipo\n";
    }
    return nameEmployee;
  }

  public String showNamePlayer(){
    String nameEmployee = "";
    int x = 0;
    for(int i = 0; i<employeeClub.size(); i++){
      if(employeeClub.get(i) instanceof Player){
        x++;
        nameEmployee += employeeClub.get(i).getNameEm()+"\n";
      }
    }
    if(x == 0){
      nameEmployee = "No existe empleados de este tipo";
    }
    return nameEmployee;
  }

  public String removeEmployee(String name){
    String msg = "";
    if(employeeClub.size() != 0){
      for(int i = 0; i<employeeClub.size(); i++){
        if(employeeClub.get(i).getNameEm().equalsIgnoreCase(name)){
          employeeClub.remove(i);
          msg = "El empleado ha sido despedido";
        }
        else{
          msg = "El empleado no ha sido encontrado en nuestra base de datos";
        }
      }
    }
    else{
      msg = "No existen empleados de este tipo";
    }
    return msg;
  }
}
