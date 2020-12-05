/*
Gabriel Suarez
A00368589
*/

package model;
import java.util.*;

public class Team{

  /*
  Constants to initialize the arrangements
  */

  private final static int NUM_MAX_ASISTENTCOACH = 3;
  private final static int NUM_MAX_PLAYER = 25;

  /*
  Arrangements related to the other classes
  */

  private MainCoach mainCoachTeam;
  private AsistentCoach [] asistentCoachTeam;
  private Player [] playerTeam;
  private ArrayList<LineUp> lineUpTeam;

  /*
  Class Builder Attribute
  */

  private String nameTeam;

  /**
  *Team class builder. <br>
  *<b>pre: </b><br>
  *<b>post: </b> A Team type object has been created. <br>
  @param nameTeam name. nameTeam != null
  */

  public Team(String nameTeam){
    this.nameTeam = nameTeam;
    this.mainCoachTeam = mainCoachTeam;
    asistentCoachTeam = new AsistentCoach [NUM_MAX_ASISTENTCOACH];
    playerTeam = new Player [NUM_MAX_PLAYER];
    lineUpTeam = new ArrayList<LineUp>();
  }

  /**
  *Getter for the name of the team. <br>
  *<b>pre: </b><br>
  *<b>post: </b> team name. <br>
  @return nameTeam
  */

  public String getNameTeam(){
    return nameTeam;
  }

  /**
  *Setter for the name of the team. <br>
  *<b>pre: </b><br>
  *<b>post: </b> Update the name of the equipment. <br>
  @param nameTeam name. nameTeam != null
  */

  public void setNameTeam(String nameTeam){
    this.nameTeam = nameTeam;
  }

  /**
  *Allows you to add a head coach to the team <br>
  *<b>pre: </b> At least one team and head coach exist. <br>
  *<b>post: </b> The coach has been added to the team. <br>
  @param mainCoach coach to be added mainCoach ! = null
  @return msg
  */

  public String addMainCoachInTeam(MainCoach mainCoach){
    String msg = "";
    if(mainCoachTeam == null){
      mainCoachTeam = mainCoach;
      msg = "El entrenador se ha anadido";
    }
    else{
      msg = "El entrenador no se ha anadido debido a que solo puede haber un entrenador";
    }
    return msg;
  }

  /**
  *Allows you to add up to three assistant coaches to the team. <br>
  *<b>pre: </b> At least one team and assistant coach exist. <br>
  *<b>post: </b> The assistant coach has been added to the team <br>
  @param asistenCoach assistant coach to be added. asistenCoach ! = null
  @return msg
  */

  public String addAsistentCoachInTeam(AsistentCoach asistenCoach){
    String msg = "";
    boolean out = false;
    for(int i = 0; i<NUM_MAX_ASISTENTCOACH && !out; i++){
      if(asistentCoachTeam[i] == null){
        asistentCoachTeam[i] = asistenCoach;
        msg = "El entrenador asistente se ha anadido";
        out = true;
      }
      else {
        msg = "El entrenador asistente no se ha anadido debido a que solo se pueden tener hasta 3 entrenadores";
      }
    }
    return msg;
  }

  /**
  *Allows you to add up to 25 players to the team. <br>
  *<b>pre: </b> At least one team and player exist. <br>
  *<b>post: </b> The player has been added to the team <br>
  @param player player to be added. player ! = null
  @return msg
  */

  public String addPlayerInTeam(Player player){
    String msg = "";
    boolean out = false;
    for(int i = 0; i<NUM_MAX_PLAYER && !out; i++){
      if(playerTeam[i] == null){
        playerTeam[i] = player;
        msg = "El jugador se ha anadido";
        out = true;
      }
      else{
        msg = "El jugador no se ha anadido debido a que excede el numero de jugadores permitidos";
      }
    }
    return msg;
  }

  /**
  *Allows you to add an alignment to the equipment. <br>
  *<b>pre: </b> At least one device exists. <br>
  *<b>post: </b> The alignment has been added. <br>
  @param dateLineUp alignment date. dateLineUp ! = null and in DD/MM/YY format
  @param tactic = POSSESSION, COUNTERATTACK, HIGHPRESSUR or DEFAULT
  @param formation formation ! = null and in the format N-N-N
  @return msg
  */

  public String addLineUpInTeam(String dateLineUp, Tactic tactic, String formation){
    String msg = "";
    LineUp newLineUp = new LineUp(dateLineUp, tactic, formation);
    lineUpTeam.add(newLineUp);
    msg = "Alineacion agregada correctamente";
    return msg;
  }

  /**
  *Allows to know the number of assistant coaches in the team. <br>
  *<b>pre: </b><br>
  *<b>post: </b> The number of assistant coaches in the team. <br>
  @return x
  */

  public int amountAsistentCoachInTeam(){
    int x = 0;
    for(int i = 0; i<NUM_MAX_ASISTENTCOACH; i++){
      if(asistentCoachTeam[i] != null){
        x++;
      }
    }
    return x;
  }

  /**
  *It allows to know the amount of players in the team. <br>
  *<b>pre: </b><br>
  *<b>post: </b> The number of players in the team. <br>
  @return x
  */

  public int amountPlayerInTeam(){
    int x = 0;
    for(int i = 0; i<NUM_MAX_PLAYER; i++){
      if(playerTeam[i] != null){
        x++;
      }
    }
    return x;
  }

  /**
  *Allows to show the specific information of the equipment. <br>
  *<b>pre: </b> At least one team must be created. <br>
  *<b>post: </b> The information of the equipment dated. <br>
  @return msg
  */

  public String showDataTeam(){
    String msg = "";
    msg = "*************** Team ***************\n";
    msg += "Nombre: "+getNameTeam()+"\n";
    if(mainCoachTeam != null){
      msg += "Numero de entrenadores principales: 1\n";
    }
    else{
      msg += "Numero de entrenadores principales : 0\n";
    }
    msg += "Numero de entrenadores asistentes: "+amountAsistentCoachInTeam()+"\n";
    msg += "Numero de jugadores: "+amountPlayerInTeam()+"\n";
    for(int i = 0; i<lineUpTeam.size(); i++){
      msg += lineUpTeam.get(i).showNormalLineUp();
    }
    msg += dataPlayerInTeam()+"\n";
    msg += "************************************\n";
    return msg;
  }

  /**
  *Allows to show the index of the players that belong to the team. <br>
  *<b>pre: </b> At least one player must be on the team. <br>
  *<b>post: </b> Index of the players <br>
  @return msg
  */

  public String showNameOfPlayerInTeam(){
    String msg = "";
    for(int i = 0; i<NUM_MAX_PLAYER; i++){
      if(playerTeam[i] != null){
        msg += "["+(i+1)+"]"+playerTeam[i].getNameEm()+"\n";
      }
    }
    return msg;
  }

  public String dataPlayerInTeam(){
    String msg = "";
    for(int i = 0; i<NUM_MAX_PLAYER; i++){
      if(playerTeam[i] != null){
        msg += "********* Jugadores *********\n";
        msg += "Nombre: "+playerTeam[i].getNameEm()+"\n";
        msg += "Dorsal: "+playerTeam[i].getDorsal()+"\n";
        msg += "Posicion: "+playerTeam[i].getPosition()+"\n";
        msg += "*****************************\n";
      }
    }
    return msg;
  }

  /**
  *Returns the player that will be added to the dressing room <br>
  *<b>pre: </b> At least one player must be on the team. <br>
  *<b>post: </b> The player has been added <br>
  @param index2 player index has added. index2 != null and greater than zero
  @return playerTeam
  */

  public Player addNewPlayerToTheDressingRoom(int index2){
    return playerTeam[index2];
  }

  public String showNameLineUpFormation(){
    String msg = "";
    for(int i = 0; i<lineUpTeam.size(); i++){
      msg += "["+(i+1)+"]"+lineUpTeam.get(i).getFormation()+"\n";
    }
    return msg;
  }

  public String showFieldLineUp(int index2){
    String msg = "";
    msg += "********** Alineacion ***********\n";
    msg += lineUpTeam.get(index2).showNormalLineUp()+"\n";
    msg += "***** Formacion en el campo *****\n";
    msg += lineUpTeam.get(index2).showFielBinary()+"\n";
    msg += "*********************************\n";
    return msg;
  }
}
