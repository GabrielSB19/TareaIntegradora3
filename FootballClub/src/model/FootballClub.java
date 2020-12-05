/*
Gabriel Suarez
A00368589
*/

package model;
import java.util.*;

public class FootballClub{

  /*
  Constants to determine the size of the arrays and matrices
  */

  private final static int NUM_MAX_TEAM = 2;
  private final static int HORIZONTALSECTOROFFICE = 6;
  private final static int VERTICALSECTOROFFICE = 6;
  private final static int HORIZONTALDRESSINGROOMA = 7;
  private final static int VERTICALDRESSINGROOMA = 6;
  private final static int HORIZONTALDRESSINGROOMB = 7;
  private final static int VERTICALDRESSINGROOMB = 7;

  /*
  Arrays, arrayList, relationship matrices
  with the other classes
  */

  private ArrayList<Employee> employeeClub;
  private ArrayList<MainCoach> arrayMainCoach;
  private ArrayList<AsistentCoach> arrayAsistentCoach;
  private ArrayList<Player> arrayPlayer;
  private Team [] team;
  private Coach [][] sectorOffice;
  private Player [][] dressingRoom1;
  private Player [][] dressingRoom2;

  /*
  Class Builder Attributes
  */

  private String nameFC;
  private int nitFC;
  private String fundationDateFC;

  /**
  *FootballClub class builder. <br>
  *<b>pre: </b><br>
  *<b>post: </b> A FootballClub type object has been created <br>
  @param nameFC name of the club. nameFc != null
  @param nitFC club's nitFC NIT parameter. nitFC ! = null
  @param fundationDateFC date of foundation of the club. fundationDateFC ! = null
  */

  public FootballClub(String nameFC, int nitFC, String fundationDateFC){
    this.nameFC = nameFC;
    this.nitFC = nitFC;
    this.fundationDateFC = fundationDateFC;
    employeeClub = new ArrayList<Employee>();
    arrayMainCoach = new ArrayList<MainCoach>();
    arrayAsistentCoach = new ArrayList<AsistentCoach>();
    arrayPlayer = new ArrayList<Player>();
    team = new Team [NUM_MAX_TEAM];
    team[0] = new Team ("Team A");
    team[1] = new Team ("Team B");
    sectorOffice = new Coach[HORIZONTALSECTOROFFICE][VERTICALSECTOROFFICE];
    dressingRoom1 = new Player [HORIZONTALDRESSINGROOMA][VERTICALDRESSINGROOMA];
    dressingRoom2 = new Player [HORIZONTALDRESSINGROOMB][VERTICALDRESSINGROOMB];
  }

  /**
  *Getter of the name of the club. <br>
  *<b>pre: </b><br>
  *<b>post: </b> Name of the club <br>
  @return nameFc
  */

  public String getNameFC(){
    return nameFC;
  }

  /**
  *Club name setter. <br>
  *<b>pre: </b><br>
  *<b>post: </b> Update the club name. <br>
  @param nameFC name of the club. nameFc != null
  */

  public void setNameFC(String nameFC){
    this.nameFC = nameFC;
  }

  /**
  *Getter of the club's NIT. <br>
  *<b>pre: </b><br><br>
  *<b>post: </b> NIT of the club. <br>
  @return nitFC
  */

  public int getNitFC(){
    return nitFC;
  }

  /**
  *Club NIT setter <br>
  *<b>pre: </b><br>
  *<b>post: </b> Update the club's TIN. <br>
  @param nitFC club's nitFC NIT parameter. nitFC ! = null
  */

  public void setNitFC(int nitFC){
    this.nitFC = nitFC;
  }

  /**
  *Getter of the date of foundation of the club. <br>
  *<b>pre: </b><br>
  *<b>post: </b> Date of foundation of the club <br>
  @return fundationDateFC
  */

  public String getFundationDateFC(){
    return fundationDateFC;
  }

  /**
  *Setter of the date of foundation of the club. <br>
  *<b>pre: </b><br>
  *<b>post: </b> Update the date of foundation of the club. <br>
  @param fundationDateFC date of foundation of the club. fundationDateFC ! = null
  */

  public void setFundationDateFC(String fundationDateFC){
    this.fundationDateFC = fundationDateFC;
  }

  /**
  *Allows you to add a player to the club. <br>
  *<b>pre: </b> Player information has already been entered. <br>
  *<b>post: </b> An employee has been added <br>
  @param nameEm name of the employee. nameEm ! = null
  @param idEm employee id. idEm ! = null
  @param salary employee's salary. salary must be greater than or equal to zero and salary ! = null
  @param status employee status. status = inactive or status = active
  @param dorsal employee's shirt number. dorsal must be greater than or equal to zero and dorsal ! = null
  @param amountGoal number of goals. amountGoal must be greater than or equal to zero and amountGoal ! = null
  @param average average of the player. average must be greater than or equal to zero and average ! = null
  @param position player position. position = GOALKEEPER, DEFENCE, MIDFIELDER OR FORWARD
  @return msg
  */

  public String addEmployee(String nameEm, int idEm, int salary, boolean status, int dorsal, int amountGoal, double average, Position position){
    Employee newPlayer = new Player(nameEm, idEm, salary, status, dorsal, amountGoal, average, position);
    employeeClub.add(newPlayer);
    Player teamPlayer = new Player(nameEm, idEm, salary, status, dorsal, amountGoal, average, position);
    arrayPlayer.add(teamPlayer);
    String msg = "El empleado se ha contratado";
    return msg;
  }

  /**
  *Allows to add a head coach to the club<br>
  *<b>pre: </b> Head coach information has already been entered. <br>
  *<b>post: </b> A head coach has been hired <br>
  @param nameEm name of the employee. nameEm ! = null
  @param idEm employee id. idEm ! = null
  @param salary employee's salary. salary must be greater than or equal to zero and salary ! = null
  @param status employee status. status = inactive or status = active
  @param yearExperience must be greater than or equal to zero and yearExperience ! = null
  @param amountTeam number of clubs managed. amountTeam must be greater than or equal to zero and amountTeam ! = null
  @param amountWinner amount of championships won. amountWinner must be greater than or equal to zero and amountWinner ! = null
  @return msg
  */

  public String addEmployee(String nameEm, int idEm, int salary, boolean status, int yearExperience, int amountTeam, int amountWinner){
    Employee newMainCoach = new MainCoach(nameEm, idEm, salary, status, yearExperience, amountTeam, amountWinner);
    employeeClub.add(newMainCoach);
    MainCoach teamMainCoach = new MainCoach(nameEm, idEm, salary, status, yearExperience, amountTeam, amountWinner);
    arrayMainCoach.add(teamMainCoach);
    String msg = "El empleado se ha contratado";
    return msg;
  }

  /**
  *Allows you to add an assistant coach to the club <br>
  *<b>pre: </b> Assistant coach information has been entered. <br>
  *<b>post: </b> An assistant entreandor has been hired. <br>
  @param nameEm name of the employee. nameEm ! = null
  @param idEm employee id. idEm ! = null
  @param salary employee's salary. salary must be greater than or equal to zero and salary ! = null
  @param status employee status. status = inactive or status = active
  @param yearExperience must be greater than or equal to zero and yearExperience ! = null
  @param playerProfesional asks if the player was a professional player. playerProfessional = true or false
  @param expertise expertisia del entrenador. expertise = OFFENSIVE, DEFENSIVE, POSSESSION, LABORATORYPLAYS or DEFAULT
  @return msg
  */

  public String addEmployee(String nameEm, int idEm, int salary, boolean status, int yearExperience, boolean playerProfesional, Expertise expertise){
    Employee newAsistentCoach = new AsistentCoach(nameEm, idEm, salary, status, yearExperience, playerProfesional, expertise);
    employeeClub.add(newAsistentCoach);
    AsistentCoach teamAsistentCoach = new AsistentCoach(nameEm, idEm, salary, status, yearExperience, playerProfesional, expertise);
    arrayAsistentCoach.add(teamAsistentCoach);
    String msg = "El empleado se ha contratado";
    return msg;
  }

  /**
  *Allows to show the name of all the main trainers without the index. <br>
  *<b>pre: </b> At least one head coach exists. <br>
  *<b>post: </b> Shows the names of the main coaches <br>
  @return msg
  */

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
      nameEmployee = "No existen empleados de este tipo\n";
    }
    return nameEmployee;
  }

  /**
  *Allows to show the name of all the trainer assistants without the index. <br>
  *<b>pre: </b> At least one assistant coach exists. <br>
  *<b>post: </b> Shows the names of the assistant coaches <br>
  @return msg
  */

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

  /**
  *Allows to show the name of all the players without the index. <br>
  *<b>pre: </b> At least one player exists <br>
  *<b>post: </b> Shows the names of the players <br>
  @return msg
  */

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
      nameEmployee = "No existe empleados de este tipo\n";
    }
    return nameEmployee;
  }

  /**
  *Allows you to select the employee to be fired. <br>
  *<b>pre: </b> At least one employee exists. <br>
  *<b>post: </b> The employee has been fired. <br>
  @param name name of employee to be fired. name = name of a contract employee
  @return msg
  */

  public String removeEmployee(String name){
    String msg = "";
    if(employeeClub.size() != 0){
      for(int i = 0; i<employeeClub.size(); i++){
        if(employeeClub.get(i) instanceof MainCoach){
          for(int j = 0; j<arrayMainCoach.size(); j++){
            if(employeeClub.get(i).getNameEm().equalsIgnoreCase(name)){
              if(employeeClub.get(i).getNameEm().equalsIgnoreCase(arrayMainCoach.get(j).getNameEm())){
                if(employeeClub.get(i).getIdEm() == arrayMainCoach.get(j).getIdEm()){
                  arrayMainCoach.remove(j);
                }
              }
            }
          }
        } else if(employeeClub.get(i) instanceof AsistentCoach){
          for(int j = 0; j<arrayAsistentCoach.size(); j++){
            if(employeeClub.get(i).getNameEm().equalsIgnoreCase(name)){
              if(employeeClub.get(i).getNameEm().equalsIgnoreCase(arrayAsistentCoach.get(j).getNameEm())){
                if(employeeClub.get(i).getIdEm() == arrayAsistentCoach.get(j).getIdEm()){
                  arrayAsistentCoach.remove(j);
                }
              }
            }
          }
        } else if(employeeClub.get(i) instanceof Player){
          for(int j = 0; j<arrayPlayer.size(); j++){
            if(employeeClub.get(i).getNameEm().equalsIgnoreCase(name)){
              if(employeeClub.get(i).getNameEm().equalsIgnoreCase(arrayPlayer.get(j).getNameEm())){
                if(employeeClub.get(i).getIdEm() == arrayPlayer.get(j).getIdEm()){
                  arrayPlayer.remove(j);
                }
              }
            }
          }
        }
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

  /**
  *Allows to show the name of the created teams<br>
  *<b>pre: </b> At least one team exists. <br>
  *<b>post: </b> Shows the names of the existing team. <br>
  @return msg
  */

  public String showNameTeam(){
    String msg = "";
    for(int i = 0; i<NUM_MAX_TEAM; i++){
      if(team[i] != null){
        msg += "["+(i+1)+"]"+team[i].getNameTeam()+"\n";
      }
    }
    return msg;
  }

  /**
  *Allows you to see the name of the head coaches with the index. <br>
  *<b>pre: </b> At least one head coach exists. <br>
  *<b>post: </b> Shows the index with the name of each head coach. <br>
  @return msg
  */

  public String showIndexNameMainCoach(){
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

  /**
  *Allows you to see the name of the assistant coaches with the index. <br>
   *<b>pre: </b> At least one assistant coach exists. <br>
   *<b>post: </b> Shows the index with the name of each coach attending. <br>
   @return msg
  */

  public String showIndexNameAsistenCoach(){
    String msg = "";
    int x = 0;
    for(int i = 0; i<arrayAsistentCoach.size(); i++){
      msg += "["+(i+1)+"]"+arrayAsistentCoach.get(i).getNameEm()+"\n";
      x++;
    }
    if(x == 0){
      msg = "No hay entrenadores disponibles\n";
    }
    return msg;
  }

  /**
  *Allows to see the name of the players with the index. <br>
  *<b>pre: </b> At least one player exists <br>
  *<b>post: </b> Shows the index with the name of each player <br>
  @return msg
  */

  public String showIndexNamePlayer(){
    String msg = "";
    int x = 0;
    for(int i = 0; i<arrayPlayer.size(); i++){
      msg += "["+(i+1)+"]"+arrayPlayer.get(i).getNameEm()+"\n";
      x++;
    }
    if(x == 0){
      msg = "No hay jugadores disponibles, presiona la tecla Enter";
    }
    return msg;
  }

  /**
  *Allows you to add a head coach to a team <br>
  *<b>pre: </b> At least one head coach and one team exist <br>
  *<b>post: </b> The head coach has been added to the team. <br>
  @param index1 equipment index. index1 = 1 or 2
  @param index2 index of available trainers. index2 = greater than zero and index2 ! = null
  @return msg
  */

  public String addMainCoachToTheTeam(int index1, int index2){
    return team[index1].addMainCoachInTeam(arrayMainCoach.get(index2));
  }

  /**
  *Allows you to add an assistant coach to a team <br>
  *<b>pre: </b> At least one assistant coach and one team exist. <br>
  *<b>post: </b> The assistant coach has been added to the team <br>
  @param index1 equipment index. index1 = 1 or 2
  @param index3 index of available assistant trainers. index3 = greater than zero and index2 ! = null
  @return msg
  */

  public String addAsistentCoachToTheTeam(int index1, int index3){
    return team[index1].addAsistentCoachInTeam(arrayAsistentCoach.get(index3));
  }

  /**
  *Allows you to add a player to a team <br>
  *<b>pre: </b> At least one player and one team exist. <br>
  *<b>post: </b> The player has been added to the team <br>
  @param index1 equipment index. index1 = 1 or 2
  @param index4 index of the players. index4 = greater than zero and index2 != null
  @return msg
  */

  public String addPlayerToTheTeam(int index1, int index4){
    return team[index1].addPlayerInTeam(arrayPlayer.get(index4));
  }

  /**
  *Allows you to update the data of the main trainers. <br>
  *<b>pre: </b> At least one head coach exists. <br>
  *<b>post: </b> The data of the main coach has been updated. <br>
  @param index1 employee index. index1 = greater than zero and index1 != null
  @param salary employee's salary. salary must be greater than or equal to zero and salary ! = null
  @param status employee status. status = inactive or status = active
  @param yearExperience must be greater than or equal to zero and yearExperience ! = null
  @param amountTeam number of clubs managed. amountTeam must be greater than or equal to zero and amountTeam ! = null
  @param amountWinner amount of championships won. amountWinner must be greater than or equal to zero and amountWinner ! = null
  @return msg
  */

  public String uptadeDataMainCoachProcess(int index1, int salary, boolean status, int yearExperience, int amountTeam, int amountWinner){
    arrayMainCoach.get(index1).setSalary(salary);
    arrayMainCoach.get(index1).setYearExperience(yearExperience);
    arrayMainCoach.get(index1).setAmountTeam(amountTeam);
    arrayMainCoach.get(index1).setAmountWinner(amountWinner);
    String msg = "La informacion del entrenador principal se ha actualizado";
    return msg;
  }

  /**
  *Allows you to update the data of the assistant trainers. <br>
  *<b>pre: </b> At least one assistant coach exists. <br>
  *<b>post: </b> The data of the assistant coach has been updated. <br>
  @param index1 employee index. index1 = greater than zero and index1 != null
  @param salary employee's salary. salary must be greater than or equal to zero and salary ! = null
  @param status employee status. status = inactive or status = active
  @param yearExperience must be greater than or equal to zero and yearExperience ! = null
  @param playerProfesional asks if the player was a professional player. playerProfessional = true or false
  @param expertise expertisia del entrenador. expertise = OFFENSIVE, DEFENSIVE, POSSESSION, LABORATORYPLAYS or DEFAULT
  @return msg
  */

  public String uptadeDataAsistenCoachProcess(int index1, int salary, boolean status, int yearExperience, boolean playerProfesional, Expertise expertise){
    arrayAsistentCoach.get(index1).setSalary(salary);
    arrayAsistentCoach.get(index1).setStatus(status);
    arrayAsistentCoach.get(index1).setYearExperience(yearExperience);
    arrayAsistentCoach.get(index1).setPlayerProfesional(playerProfesional);
    arrayAsistentCoach.get(index1).setExpertise(expertise);
    String msg = "La informacion del entrenador asistente se ha actualizado";
    return msg;
  }

  /**
  *Allows to update the players' data. <br>
  *<b>pre: </b> At least one player exists <br>
  *<b>post: </b> The player's data has been updated. <br>
  @param index1 employee index. index1 = greater than zero and index1 != null
  @param salary employee's salary. salary must be greater than or equal to zero and salary ! = null
  @param status employee status. status = inactive or status = active
  @param dorsal employee's shirt number. dorsal must be greater than or equal to zero and dorsal ! = null
  @param amountGoal number of goals. amountGoal must be greater than or equal to zero and amountGoal ! = null
  @param average average of the player. average must be greater than or equal to zero and average ! = null
  @param position player position. position = GOALKEEPER, DEFENCE, MIDFIELDER OR FORWARD
  @return msg
  */

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

  /**
  *Display all the information of the head coaches. <br>
  *<b>pre: </b> At least one head coach exists. <br>
  *<b>post: </b> All the information of the main coach has been shown. <br>
  @return msg
  */

  public String showDataMainCoach(){
    String msg = "";
    for(int i = 0; i<arrayMainCoach.size(); i++){
      msg += arrayMainCoach.get(i).showData();
    }
    return msg;
  }

  /**
  *Display all the information of the assistant coaches. <br>
  *<b>pre: </b> At least one assistant coach exists. <br>
  *<b>post: </b> All the information of the assistant coach has been shown. <br>
  @return msg
  */

  public String showDataAsistentCoach(){
    String msg = "";
    for(int i = 0; i<arrayAsistentCoach.size(); i++){
      msg += arrayAsistentCoach.get(i).showData();
    }
    return msg;
  }

  /**
  *Displays all player information <br>
  *<b>pre: </b> At least one player exists <br>
  *<b>post: </b> All the information of the player has been shown. <br>
  @return msg
  */

  public String showDataPlayer(){
    String msg = "";
    for(int i = 0; i<arrayPlayer.size(); i++){
      msg += arrayPlayer.get(i).showData();
    }
    return msg;
  }

  /**
  *Allows to show all the information of the equipments. <br>
  *<b>pre: </b> At least one device exists. <br>
  *<b>post: </b> All the information of the equipment has been shown. <br>
  @return msg
  */

  public String showDataTeam(){
    String msg = "";
    for(int i = 0; i<NUM_MAX_TEAM; i++){
      if(team[i] != null){
        msg += team[i].showDataTeam();
      }
    }
    return msg;
  }

  /**
  *Allows you to add an alignment to a team. <br>
  *<b>pre: </b> At least one device exists. <br>
  *<b>post: </b> An alignment has been added to the selected equipment. <br>
  @param index1 index of the selected equipment. index1 = 1 or 2
  @param dateLineUp alignment date. dateLineUp in DD-MM-YY format
  @param tactic = POSSESSION, COUNTERATTACK, HIGHPRESSURE OR DEFAULT
  @param formation alienation. formation ! = null and formation in N-N-N format
  @return msg
  */

  public String addLineUpToTheTeam(int index1, String dateLineUp, Tactic tactic, String formation){
    return team[index1].addLineUpInTeam(dateLineUp, tactic, formation);
  }

  /**
  *Allows you to add a head coach or assistant to the office secotor. <br>
  *<b>pre: </b> At least one coach of any type and team exists. <br>
  *<b>post: </b> The coach has been added to the office sector. <br>
  @param index1 Select the type of trainer. index1 = 1 or 2
  @param index2 Select the player's index. index2 = greater than zero and index2 ! = null
  @return msg
  */

  public String addCoachToTheSectorOffice(int index1, int index2){
    String msg = "";
    boolean out = false;
    for(int i = 0; i<HORIZONTALSECTOROFFICE && !out; i++){
      for(int j = 0; j<VERTICALSECTOROFFICE && !out; j++){
        if(i == 0 && j ==0){
          if(sectorOffice[i][j] == null){
            if(index1 == 0){
              sectorOffice[i][j] = arrayMainCoach.get(index2);
              msg  = "Se agrego correctamente el entrenador a la oficina";
              out = true;
            }
            else if (index1 == 1){
              sectorOffice[i][j] = arrayAsistentCoach.get(index2);
              msg  = "Se agrego correctamente el entrenador a la oficina";
              out = true;
            }
          }
        }
        else if((i %2 == 0 && j%2 == 0) || (i == 0 && j%2 == 0) || (j == 0 && i%2 == 0)){
          if(sectorOffice[i][j] == null){
            if(index1 == 0){
              sectorOffice[i][j] = arrayMainCoach.get(index2);
              msg  = "Se agrego correctamente el entrenador a la oficina";
              out = true;
            }
            else if(index1 == 1){
              sectorOffice[i][j] = arrayAsistentCoach.get(index2);
              msg  = "Se agrego correctamente el entrenador a la oficina";
              out = true;
            }
          }
        }
        else{
          msg = "No se puedo agregar el jugador debida a que no hay mas espacios disponibles";
        }
      }
    }
    return msg;
  }

  /**
  *Displays the players belonging to a selected team. <br>
  *<b>pre: </b> At least one player and one team exists. <br>
  *<b>post: </b> The players of the selected team <br>
  @param index1 index of the equipment. index1 = 1 or 2
  @return msg
  */

  public String showNameOfPlayerToTheTeam(int index1){
    return team[index1].showNameOfPlayerInTeam();
  }

  /**
  *Allows you to add a player to a dressing room <br>
  *<b>pre: </b> At least one player is associated with a team. <br>
  *<b>post: </b> The player has been added to his corresponding dressing room. <br>
  @param index1 index of the equipment. index1 = 1 or 2
  @param index2 index of the players of the selected team. index2 = greater than zero and index2 ! = null
  @return msg
  */

  public String addPlayerDressingRoom(int index1, int index2){
    String msg = "";
    boolean out = false;
    if(index1 == 0){
      for(int i = 0; i<HORIZONTALDRESSINGROOMA && !out; i++){
        for(int j = 0; j<VERTICALDRESSINGROOMA && !out; j++){
          if(i == 0 && j ==0){
            if(dressingRoom1[i][j] == null){
              dressingRoom1[i][j] = team[index1].addNewPlayerToTheDressingRoom(index2);
              msg  = "Se agrego correctamente el jugador al camerino 6x7";
              out = true;
            }
          }
          else if((i %2 == 0 && j%2 == 0) || (i == 0 && j%2 == 0) || (j == 0 && i%2 == 0)){
            if(dressingRoom1[i][j] == null){
              dressingRoom1[i][j] = team[index1].addNewPlayerToTheDressingRoom(index2);
              msg  = "Se agrego correctamente el jugador al camerino 6x7";
              out = true;
            }
          }
          else{
            msg = "No se puedo agregar el jugador debida a que no hay mas espacios disponibles";
          }
        }
      }
    }
    if(index1 == 1){
      for(int i = 0; i<HORIZONTALDRESSINGROOMB && !out; i++){
        for(int j = 0; j<VERTICALDRESSINGROOMB && !out; j++){
          if(i == 0 && j ==0){
            if(dressingRoom2[i][j] == null){
              dressingRoom2[i][j] = team[index1].addNewPlayerToTheDressingRoom(index2);
              msg  = "Se agrego correctamente el jugador al camerino 6x7";
              out = true;
            }
          }
          else if((i %2 == 0 && j%2 == 0) || (i == 0 && j%2 == 0) || (j == 0 && i%2 == 0)){
            if(dressingRoom2[i][j] == null){
              dressingRoom2[i][j] = team[index1].addNewPlayerToTheDressingRoom(index2);
              msg  = "Se agrego correctamente el jugador al camerino 6x7";
              out = true;
            }
          }
          else{
            msg = "No se puedo agregar el jugador debida a que no hay mas espacios disponibles";
          }
        }
      }
    }
    return msg;
  }

  /**
  *Allows you to calculate the market price of a head coach. <br>
  *<b>pre: </b> At least one main enrenator exists. <br>
  *<b>post: </b> the market price of the head coach is <br>
  @param index1 index of the main trainers. index1 = greater than zero and index1 ! = null
  @return msg
  */

  public String newPriceMarketCoach(int index1){
    String msg = "";
    double result = arrayMainCoach.get(index1).priceMarket();
    msg = "El precio de mercado de este entrenador principal es de "+result+"\n";
    return msg;
  }

  /**
  *Allows to calculate the market price of a player. <br>
  *<b>pre: </b> At least one player exists <br>
  *<b>post: </b> the market price of the player is ###. <br>
  @param index1 index of the players. index1 = greater than zero and index1 != null
  @return msg
  */

  public String newPriceMarketPlayer(int index1){
    String msg = "";
    double result = arrayPlayer.get(index1).priceMarket();
    msg = "El precio de mercado de este jugador es de "+result+"\n";
    return msg;
  }

  /**
  *Allows you to calculate the market level of a master trainer <br>
  *<b>pre: </b> At least one main enrenator exists. <br>
  *<b>post: </b> the market level of the head coach is ###. <br>
  @param index1 index of the main trainers. index1 = greater than zero and index1 ! = null
  @return msg
  */

  public String newLevelCoach(int index1){
    String msg = "";
    double result = arrayMainCoach.get(index1).lvlMarket();
    msg = "El nivel de este entrenador principal es de "+result+"\n";
    return msg;
  }

  /**
  *Allows to calculate the market level of a player. <br>
  *<b>pre: </b> At least one player exists <br>
  *<b>post: </b> the market level of the player is ###. <br>
  @param index1 index of the players. index1 = greater than zero and index1 != null
  @return msg
  */

  public String newLevelPlayer(int index1){
    String msg = "";
    double result = arrayPlayer.get(index1).lvlMarket();
    msg = "El nivel de este jugador es de "+result+"\n";
    return msg;
  }

  /**
  *It allows to know how many computers have been created. <br>
  *<b>pre: </b><br>
  *<b>post: </b> The number of equipment created. <br>
  @return msg
  */

  public int numTeam(){
    int x = 0;
    for(int i = 0; i<NUM_MAX_TEAM; i++){
      if(team[i] != null){
        x++;
      }
    }
    return x;
  }

  /**
  *Allows to show all the information of the club. <br>
  *<b>pre: </b><br>
  *<b>post:</b> Shows all the general information of the equipment. <br>
  @return msg
  */

  public String showInformationClub(){
    String msg = "************** Informacion del Club **************\n";
    msg += "Nombre del club: "+getNameFC()+"\n";
    msg += "NIT del club: "+getNitFC()+"\n";
    msg += "Fecha de fundacion: "+getFundationDateFC()+"\n";
    msg += "Numero de empleados totales: "+employeeClub.size()+"\n";
    msg += "Numero de entrenadore principales"+arrayMainCoach.size()+"\n";
    msg += "Numero de entrenadores asistentes: "+arrayAsistentCoach.size()+"\n";
    msg += "Numero de jugadores: "+arrayPlayer.size()+"\n";
    msg += "Numero de equipos: "+numTeam()+"\n";
    msg += "Numero de oficinas: 1\n";
    msg += "Numero de camerinos: 2\n";
    msg += "Si deseas ver la informacion de los jugadores detallada selecciona la opcion [6]\n";
    msg += "Si deseas ver la informacion de los equipo detallada selecciona la Opcion [7]\n";
    return msg;
  }

  /**
  *Allows to show the position of the coaches in the office sector. <br>
  *<b>pre: </b><br>
  *<b>post:</b> Shows the position of the trainers in the offices. <br>
  @return msg
  */

  public String showSectorOffice(){
    int [][] showEmployeeOffice = new int [HORIZONTALSECTOROFFICE][VERTICALSECTOROFFICE];
    String msg = "";
    for(int i = 0; i<HORIZONTALSECTOROFFICE; i++){
      for(int j = 0; j<VERTICALSECTOROFFICE; j++){
        if(sectorOffice[i][j] != null){
          showEmployeeOffice[i][j] = 1;
        }
        else{
          showEmployeeOffice[i][j] = 0;
        }
        msg += showEmployeeOffice[i][j]+" ";
      }
      msg += "\n";
    }
    return msg;
  }

  /**
  *Allows to show the position of the players in the dressing room. <br>
  *<b>pre: </b><br>
  *<b>post:</b> Show the position of the players in the dressing room <br>
  @param index1 shows the selected dressing room. index1 = 1 or 2
  @return msg
  */

  public String showDressingRoom(int index1){
    int [][] showPlayerDressing1 = new int [HORIZONTALDRESSINGROOMA][VERTICALDRESSINGROOMA];
    int [][] showPlayerDressing2 = new int [HORIZONTALDRESSINGROOMB][VERTICALDRESSINGROOMB];
    String msg = "";
    if(index1 == 0){
      for(int i = 0; i<HORIZONTALDRESSINGROOMA; i++){
        for(int j = 0; j<VERTICALDRESSINGROOMA; j++){
          if(dressingRoom1[i][j] != null){
            showPlayerDressing1[i][j] = 1;
          }
          else{
            showPlayerDressing1[i][j] = 0;
          }
          msg += showPlayerDressing1[i][j]+" ";
        }
        msg += "\n";
      }
    }
    else if(index1 == 1){
      for(int i = 0; i<HORIZONTALDRESSINGROOMB; i++){
        for(int j = 0; j<VERTICALDRESSINGROOMB; j++){
          if(dressingRoom2[i][j] != null){
            showPlayerDressing2[i][j] = 1;
          }
          else{
            showPlayerDressing2[i][j] = 0;
          }
          msg += showPlayerDressing2[i][j]+" ";
        }
        msg += "\n";
      }
    }
    return msg;
  }

  /**
  *Show the formation in the N-N-N form. <br>
  *<b>pre: </b> There must be an alignment in the selected equipment. <br>
  *<b>post:</b> Shows the team formations. <br>
  @param index1 shows the selected equipment. index1 = 1 or 2
  @return msg
  */

  public String showFormationWithOutFormat(int index1){
    return team[index1].showNameLineUpFormation();
  }

  /**
  *Allows you to select the equipment and alignment which will be displayed in the fields. <br>
  *<b>pre: </b> There must be at least one alignment in the selected equipment. <br>
  *<b>post:</b> Shows all the general information of the equipment. <br>
  @param index1 Selected equipment. index1 = 1 or 2
  @param index2 Selected formation. index2 = greater than zero and index2 != null
  @return msg
  */

  public String showFieldLineUpInTeam(int index1, int index2){
    return team[index1].showFieldLineUp(index2);
  }
}
