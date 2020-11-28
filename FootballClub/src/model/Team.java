/*
Gabriel Suarez
A00368589
*/

package model;
import java.util.*;

public class Team{

  private final static int NUM_MAX_ASISTENTCOACH = 3;
  private final static int NUM_MAX_PLAYER = 25;

  private MainCoach mainCoachTeam;
  private AsistentCoach [] asistentCoachTeam;
  private Player [] playerTeam;

  private String nameTeam;

  public Team(String nameTeam){
    this.nameTeam = nameTeam;
    this.mainCoachTeam = mainCoachTeam;
    asistentCoachTeam = new AsistentCoach [NUM_MAX_ASISTENTCOACH];
    playerTeam = new Player [NUM_MAX_PLAYER];
  }

  public String getNameTeam(){
    return nameTeam;
  }

  public void setNameTeam(String nameTeam){
    this.nameTeam = nameTeam;
  }

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
}
