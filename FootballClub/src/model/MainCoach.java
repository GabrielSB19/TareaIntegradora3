/*
Gabriel Suarez
A00368589
*/

package model;
import java.util.*;

public class MainCoach extends Coach implements CalculateOperation{

  /*
  Class Builder Attributes
  */

  private int amountTeam;
  private int amountWinner;

  /**
  *MainCoach class builder. <br>
  *<b>pre: </b><br>
  *<b>post: </b> A MainCoach type object has been created. <br>
  @param nameEm name of the employee. nameEm ! = null
  @param idEm employee id. idEm ! = null
  @param salary employee's salary. salary must be greater than or equal to zero and salary ! = null
  @param status employee status. status = inactive or status = active
  @param yearExperience must be greater than or equal to zero and yearExperience ! = null
  @param amountTeam number of clubs managed. amountTeam must be greater than or equal to zero and amountTeam ! = null
  @param amountWinner amount of championships won. amountWinner must be greater than or equal to zero and amountWinner ! = null

Translated with www.DeepL.com/Translator (free version)
  */

  public MainCoach(String nameEm, int idEm, int salary, boolean status, int yearExperience, int amountTeam, int amountWinner){
    super(nameEm, idEm, salary, status, yearExperience);
    this.amountTeam = amountTeam;
    this.amountWinner = amountWinner;
  }

  /**
  *Getter of the amount of directed equipment. <br>
  *<b>pre: </b><br>
  *<b>post: </b> Amount of directed equipment. <br>
  @return amountTeam
  */

  public int getAmountTeam(){
    return amountTeam;
  }

  /**
  *Setter of the amount of directed equipment. <br>
  *<b>pre: </b><br>
  *<b>post: </b> Updates the amount of directed equipment. <br>
  @param amountTeam number of clubs managed. amountTeam must be greater than or equal to zero and amountTeam ! = null
  */

  public void setAmountTeam(int amountTeam){
    this.amountTeam = amountTeam;
  }

  /**
  *Getter of the amount of trophies won. <br>
  *<b>pre: </b><br>
  *<b>post: </b> Number of trophies won. <br>
  @return amountWinner
  */

  public int getAmountWinner(){
    return amountWinner;
  }

  /**
  *Setter of the amount of trophies won <br>
  *<b>pre: </b><br>
  *<b>post: </b> Update the amount of trophies won. <br>
  @param amountWinner amount of championships won. amountWinner must be greater than or equal to zero and amountWinner ! = null
  */

  public void setAmountWinner(int amountWinner){
    this.amountWinner = amountWinner;
  }

  /**
  *It allows to calculate the market price of the main trainer. <br>
  *<b>pre: </b> At least one head coach must exist <br>
  *<b>post: </b> The market price of the trainer <br>
  */

  @Override
  public double priceMarket(){
    double priceMarketCoach = 0;
    priceMarketCoach = (getSalary()*10)+(getYearExperience()*100)+(getAmountWinner()*50);
    return priceMarketCoach;
  }

  /**
  *It allows to calculate the market level of the main trainer. <br>
  *<b>pre: </b> At least one head coach must exist <br>
  *<b>post: </b> The market level of the trainer <br>
  */

  @Override
  public double lvlMarket(){
    double lvlMarketCoach = 0;
    lvlMarketCoach = 5+(getAmountWinner()*1.0/10);
    return lvlMarketCoach;
  }

  /**
  *Allows to show the specific information of the employees. <br>
  *<b>pre: </b> At least one employee must be hired. <br>
  *<b>post: </b> Employee's information dated <br>
  */

  @Override
  public String showData(){
    String msg = super.showData();
    msg += "Cantidad de equipos dirigidos: "+getAmountTeam()+"\n";
    msg += "Cantidad de trofeos ganados: "+getAmountWinner()+"\n";
    msg += "************************************\n";
    return msg;
  }
}
