/*
Gabriel Suarez
A00368589
*/

package model;
import java.util.*;

public class LineUp{

  /*
  Class Builder Attributes
  */

  private String dateLineUp;
  private Tactic tactic;
  private String formation;

  /**
  *LineUp class builder. <br>
  *<b>pre: </b><br>
  *<b>post: </b> A LineUp type object has been created. <br>
  @param dateLineUp alignment date. dateLineUp ! = null and in DD/MM/YY format
  @param tactic = POSSESSION, COUNTERATTACK, HIGHPRESSUR or DEFAULT
  @param formation formation ! = null and in the format N-N-N
  */

  public LineUp(String dateLineUp, Tactic tactic, String formation){
   this.dateLineUp = dateLineUp;
   this.tactic = tactic;
   this.formation  = formation;
  }

  /**
  *Getter for the date of the alignment. <br>
  *<b>pre: </b><br>
  *<b>post: </b> Date of the alignment <br>
  @return dateLineUp
  */

  public String getDateLineUp(){
    return dateLineUp;
  }

  /**
  *Setter for the date of the alignment. <br>
  *<b>pre: </b><br>
  *<b>post: </b> Update the date of the alignment. <br>
  @param dateLineUp alignment date. dateLineUp ! = null and in DD/MM/YY format
  */

  public void setDateLineUp(String dateLineUp){
    this.dateLineUp = dateLineUp;
  }

  /**
  *Getter for the tactical alignment. <br>
  *<b>pre: </b><br>
  *<b>post: </b> Alignment tactics. <br>
  @return tactic
  */

  public Tactic getTactic(){
    return tactic;
  }

  /**
  *Setter for the tactical alignment. <br>
  *<b>pre: </b><br>
  *<b>post: </b> Update the alignment tactics. <br>
  @param tactic = POSSESSION, COUNTERATTACK, HIGHPRESSUR or DEFAULT
  */

  public void setTactic(Tactic tactic){
    this.tactic = tactic;
  }

  /**
  *Getter for the formation of the alignment. <br>
  *<b>pre: </b><br>
  *<b>post: </b> Alignment formation. <br>
  @return formation
  */

  public String getFormation(){
    return formation;
  }

  /**
  *Setter for the formation of the alignment. <br>
  *<b>pre: </b><br>
  *<b>post: </b> Update the alignment formation. <br>
  @param formation formation ! = null and in the format N-N-N
  */

  public void setFormation(String formation){
    this.formation  = formation;
  }

  /**
  *Allows you to display the alignment information. <br>
  *<b>pre: </b> At least one lineup and one team must be created. <br>
  *<b>post: </b> The information of the alignement datallada. <br>
  @return msg
  */

  public String showNormalLineUp(){
    String msg = "";
    msg += "***** Alineaciones del equipo ******\n";
    msg += "Fecha de la alineacion: "+getDateLineUp()+"\n";
    msg += "Tactica : "+getTactic()+"\n";
    msg += "Formacion: "+getFormation()+"\n";
    return msg;
  }
}
