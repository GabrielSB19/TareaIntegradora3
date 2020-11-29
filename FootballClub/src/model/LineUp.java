/*
Gabriel Suarez
A00368589
*/

package model;
import java.util.*;

public class LineUp{

  private String dateLineUp;
  private Tactic tactic;
  private String formation;

  public LineUp(String dateLineUp, Tactic tactic, String formation){
   this.dateLineUp = dateLineUp;
   this.tactic = tactic;
   this.formation  = formation;
  }

  public String getDateLineUp(){
    return dateLineUp;
  }

  public void setDateLineUp(String dateLineUp){
    this.dateLineUp = dateLineUp;
  }

  public Tactic getTactic(){
    return tactic;
  }

  public void setTactic(Tactic tactic){
    this.tactic = tactic;
  }

  public String getFormation(){
    return formation;
  }

  public void setFormation(String formation){
    this.formation  = formation;
  }
}
