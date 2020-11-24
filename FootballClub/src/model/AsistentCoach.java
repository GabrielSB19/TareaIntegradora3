/*
Gabriel Suarez
A00368589
*/

package model;
import java.util.*;

public class AsistentCoach extends Coach{

  private boolean playerProfesional;
  private Expertise expertise;

  public AsistentCoach(String nameEm, int idEm, int salary, boolean status, int yearExperience, boolean playerProfesional, Expertise expertise){
    super(nameEm, idEm, salary, status, yearExperience);
    this.playerProfesional = playerProfesional;
    this.expertise = expertise;
  }

  public boolean getPlayerProfesional(){
    return playerProfesional;
  }

  public void setPlayerProfesional(boolean playerProfesional){
    this.playerProfesional = playerProfesional;
  }

  public Expertise getExpertise(){
    return expertise;
  }

  public void setExpertise(Expertise expertise){
    this.expertise = expertise;
  }
}
