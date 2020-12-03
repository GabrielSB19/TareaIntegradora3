/*
Gabriel Suarez
A00368589
*/

package model;
import java.util.*;

public class AsistentCoach extends Coach{

  /*
  Class Builder Attributes
  */

  private boolean playerProfesional;
  private Expertise expertise;

  /**
  AssistantCoach class builder. <br>
  *<b>pre: </b><br>
  *<b>post: </b> An AsistentCoach type object has been created. <br>
  @param nameEm name of the employee. nameEm ! = null
  @param idEm employee id. idEm ! = null
  @param salary employee's salary. salary must be greater than or equal to zero and salary ! = null
  @param status employee status. status = inactive or status = active
  @param yearExperience must be greater than or equal to zero and yearExperience ! = null
  @param playerProfesional asks if the player was a professional player. playerProfessional = true or false
  @param expertise expertisia del entrenador. expertise = OFFENSIVE, DEFENSIVE, POSSESSION, LABORATORYPLAYS or DEFAULT
  */

  public AsistentCoach(String nameEm, int idEm, int salary, boolean status, int yearExperience, boolean playerProfesional, Expertise expertise){
    super(nameEm, idEm, salary, status, yearExperience);
    this.playerProfesional = playerProfesional;
    this.expertise = expertise;
  }

  /**
  *Getter to know if he was a professional player. <br>
  *<b>pre: </b><br>
  *<b>post: </b> He was a professional player <br>
  @return playerProfessional
  */

  public boolean getPlayerProfesional(){
    return playerProfesional;
  }

  /**
  *Setter to know if he was a professional player. <br>
  *<b>pre: </b><br>
  *<b>post: </b> Update if you were a professional player <br>
  @param playerProfesional asks if the player was a professional player. playerProfessional = true or false
  */

  public void setPlayerProfesional(boolean playerProfesional){
    this.playerProfesional = playerProfesional;
  }

  /**
  *Getter to determine the coach's expertise. <br>
  *<b>pre: </b><br>
  *<b>post: </b> Trainer's experience. <br>
  @return expertise
  */

  public Expertise getExpertise(){
    return expertise;
  }

  /**
  *Setter to determine the coach's expertise. <br>
  *<b>pre: </b><br>
  *<b>post: </b> Update the coach's expertise. <br>
  @param expertise expertisia del entrenador. expertise = OFFENSIVE, DEFENSIVE, POSSESSION, LABORATORYPLAYS or DEFAULT
  */

  public void setExpertise(Expertise expertise){
    this.expertise = expertise;
  }

  /**
  *Allows to show the specific information of the employees. <br>
  *<b>pre: </b> At least one employee must be hired. <br>
  *<b>post: </b> Employee's information dated <br>
  */

  @Override
  public String showData(){
    String msg = super.showData();
    if(getPlayerProfesional()){
      msg += "Fue jugador profesional\n";
    }
    else{
      msg += "No fue jugador profesional\n";
    }
    msg += "Expertisia: "+getExpertise()+"\n";
    msg += "************************************\n";
    return msg;
  }
}
