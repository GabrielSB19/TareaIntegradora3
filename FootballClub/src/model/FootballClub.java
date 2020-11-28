/*
Gabriel Suarez
A00368589
*/

package model;
import java.util.*;

public class FootballClub{

  private final static int NUM_MAX_TEAM = 2;

  private ArrayList<Employee> employeeClub;
  private ArrayList<MainCoach> arrayMainCoach;
  private ArrayList<AsistentCoach> arrayAsistentCoach;
  private ArrayList<Player> arrayPlayer;
  private Team [] team;

  private String nameFC;
  private int nitFC;
  private String fundationDateFC;

  public FootballClub(String nameFC, int nitFC, String fundationDateFC){
    this.nameFC = nameFC;
    this.nitFC = nitFC;
    this.fundationDateFC = fundationDateFC;
    employeeClub = new ArrayList<Employee>();
    arrayMainCoach = new ArrayList<MainCoach>();
    arrayAsistentCoach = new ArrayList<AsistentCoach>();
    arrayPlayer = new ArrayList<Player>();
    team = new Team [NUM_MAX_TEAM];
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
    Player teamPlayer = new Player(nameEm, idEm, salary, status, dorsal, amountGoal, average, position);
    arrayPlayer.add(teamPlayer);
    String msg = "El empleado se ha contratado";
    return msg;
  }

  public String addEmployee(String nameEm, int idEm, int salary, boolean status, int yearExperience, int amountTeam, int amountWinner){
    Employee newMainCoach = new MainCoach(nameEm, idEm, salary, status, yearExperience, amountTeam, amountWinner);
    employeeClub.add(newMainCoach);
    MainCoach teamMainCoach = new MainCoach(nameEm, idEm, salary, status, yearExperience, amountTeam, amountWinner);
    arrayMainCoach.add(teamMainCoach);
    String msg = "El empleado se ha contratado";
    return msg;
  }

  public String addEmployee(String nameEm, int idEm, int salary, boolean status, int yearExperience, boolean playerProfesional, Expertise expertise){
    Employee newAsistentCoach = new AsistentCoach(nameEm, idEm, salary, status, yearExperience, playerProfesional, expertise);
    employeeClub.add(newAsistentCoach);
    AsistentCoach teamAsistentCoach = new AsistentCoach(nameEm, idEm, salary, status, yearExperience, playerProfesional, expertise);
    arrayAsistentCoach.add(teamAsistentCoach);
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

  public String addTeam(String nameTeam){
    boolean out = false;
    String msg = "";
    for(int i = 0; i<NUM_MAX_TEAM && !out; i++){
      if(team[i] == null){
        team[i] = new Team(nameTeam);
        msg = "El equipo ha sido creado";
        out = true;
      }
    }
    if(!out){
      msg = "El equipo no ha sido creado debido a que excede el numero de equipos diponibles";
    }
    return msg;
  }

  public String showNameNewTeam(){
    String msg = "";
    for(int i = 0; i<NUM_MAX_TEAM; i++){
      if(team[i] != null){
        msg += "["+(i+1)+"]"+team[i].getNameTeam()+"\n";
      }
    }
    return msg;
  }

  public String showNameOptionMainCoachTeam(){
    String msg = "";
    int x = 0;
    for(int i = 0; i<arrayMainCoach.size(); i++){
      msg += "["+(i+1)+"]"+arrayMainCoach.get(i).getNameEm()+"\n";
      x++;
    }
    if(x == 0){
      msg = "No hay entrenadores disponibles, presiona la tecla Enter";
    }
    return msg;
  }

  public String showNameOptionAsistenCoachTeam(){
    String msg = "";
    int x = 0;
    for(int i = 0; i<arrayAsistentCoach.size(); i++){
      msg += "["+(i+1)+"]"+arrayAsistentCoach.get(i).getNameEm()+"\n";
      x++;
    }
    if(x == 0){
      msg = "No hay entrenadores disponibles, presiona la tecla Enter";
    }
    return msg;
  }

  public String showNameOptionPlayer(){
    String msg = "";
    int x = 0;
    for(int i = 0; i<arrayPlayer.size(); i++){
      msg += "["+(i+1)+"]"+arrayPlayer.get(i).getNameEm()+"\n";
      x++;
    }
    if(x == 0){
      msg = "No hay entrenadores disponibles, presiona la tecla Enter";
    }
    return msg;
  }

  public String addMainCoachToTheTeam(int index1, int index2){
    return team[index1].addMainCoachInTeam(arrayMainCoach.get(index2));
  }

  public String addAsistentCoachToTheTeam(int index1, int index3){
    return team[index1].addAsistentCoachInTeam(arrayAsistentCoach.get(index3));
  }

  public String addPlayerToTheTeam(int index1, int index4){
    return team[index1].addPlayerInTeam(arrayPlayer.get(index4));
  }

  public String uptadeDataMainCoachProcess(int index1, int salary, boolean status, int yearExperience, int amountTeam, int amountWinner){
    arrayMainCoach.get(index1).setSalary(salary);
    arrayMainCoach.get(index1).setYearExperience(yearExperience);
    arrayMainCoach.get(index1).setAmountTeam(amountTeam);
    arrayMainCoach.get(index1).setAmountWinner(amountWinner);
    String msg = "La informacion del entrenador principal se ha actualizado";
    return msg;
  }

  public String uptadeDataAsistenCoachProcess(int index1, int salary, boolean status, int yearExperience, boolean playerProfesional, Expertise expertise){
    arrayAsistentCoach.get(index1).setSalary(salary);
    arrayAsistentCoach.get(index1).setStatus(status);
    arrayAsistentCoach.get(index1).setYearExperience(yearExperience);
    arrayAsistentCoach.get(index1).setPlayerProfesional(playerProfesional);
    arrayAsistentCoach.get(index1).setExpertise(expertise);
    String msg = "La informacion del entrenador asistente se ha actualizado";
    return msg;
  }

  public String uptadeDataPlayerProcess(int index1, int salary, boolean status, int dorsal, int amountGoal, double average, Position position){
    arrayPlayer.get(index1).setSalary(salary);
    arrayPlayer.get(index1).setStatus(status);
    arrayPlayer.get(index1).setDorsal(dorsal);
    arrayPlayer.get(index1).setAmountGoal(amountGoal);
    arrayPlayer.get(index1).setAverage(average);
    arrayPlayer.get(index1).setPosition(position);
    String msg = "La informacion del jugador se ha actualizado";
    return msg;
  }
}
