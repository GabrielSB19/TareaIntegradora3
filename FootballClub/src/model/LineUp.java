/*
Gabriel Suarez
A00368589
*/

package model;
import java.util.*;

public class LineUp{

  private int [] newFormationInInt;
  private String[] newFormationInString;
  private boolean [] fieldHorizontal;

  /*
  Class Builder Attributes
  */

  private String dateLineUp;
  private Tactic tactic;
  private String formation;
  private boolean [][] showFormation;

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
   showFormation = new boolean [10][7];
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

  public int[] formationSeparate(){
    newFormationInString = getFormation().split("-");
    newFormationInInt = new int [newFormationInString.length];
    for(int i = 0; i<newFormationInInt.length; i++){
      newFormationInInt[i] = Integer.parseInt(newFormationInString[i]);
    }
    return newFormationInInt;
  }

  public boolean [] switchFormationInField(int i){
    fieldHorizontal = new boolean [7];
    if(formationSeparate()[i] == 1){
      boolean [] option1 = {false, false, false, true, false, false, false};
      fieldHorizontal = option1;
    } else if (formationSeparate()[i] == 2){
      boolean [] option2 = {false, true, false, false, false, true, false};
      fieldHorizontal = option2;
    } else if (formationSeparate()[i] == 3){
      boolean [] option3 = {false, true, false, true, false, true, false};
      fieldHorizontal = option3;
    } else if (formationSeparate()[i] == 4){
      boolean [] option4 = {false, true, true, false, true, true, false};
      fieldHorizontal = option4;
    } else if (formationSeparate()[i] == 5){
      boolean [] option5 = {true, true, false, true, false, true, true};
      fieldHorizontal = option5;
    } else if (formationSeparate()[i] == 6){
      boolean [] option6 = {true, true, true, false, true, true, true};
      fieldHorizontal = option6;
    } else if (formationSeparate()[i] == 7){
      boolean [] option7 = {true, false, true, true, true, true, true};
      fieldHorizontal = option7;
    }
    return fieldHorizontal;
  }

  public boolean [][] showField(){
    for(int j = 0; j<7; j++){
      if(formationSeparate().length == 2){
        showFormation[7][j] = switchFormationInField(0)[j];
        showFormation[2][j] = switchFormationInField(1)[j];
      } else if(formationSeparate().length == 3){
        showFormation[8][j] = switchFormationInField(0)[j];
        showFormation[5][j] = switchFormationInField(1)[j];
        showFormation[2][j] = switchFormationInField(2)[j];
      } else if(formationSeparate().length == 4){
        showFormation[8][j] = switchFormationInField(0)[j];
        showFormation[5][j] = switchFormationInField(1)[j];
        showFormation[4][j] = switchFormationInField(2)[j];
        showFormation[2][j] = switchFormationInField(3)[j];
      } else if(formationSeparate().length == 5){
        showFormation[8][j] = switchFormationInField(0)[j];
        showFormation[5][j] = switchFormationInField(1)[j];
        showFormation[4][j] = switchFormationInField(2)[j];
        showFormation[2][j] = switchFormationInField(3)[j];
        showFormation[1][j] = switchFormationInField(4)[j];
      }
    }
    return showFormation;
  }

  public String showFielBinary(){
    int [][] prueba = new int [10][7];
    String msg = "";
    for(int i = 0; i<10; i++){
      for(int j = 0; j<7; j++){
        if(showField()[i][j] == true){
          prueba[i][j] = 1;
        }
        else if (showField()[i][j] == false){
          prueba[i][j] = 0;
        }
        msg += prueba[i][j]+" ";
      }
      msg += "\n";
    }
    return msg;
  }
}
