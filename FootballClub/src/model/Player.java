/*
Gabriel Suarez
A00368589
*/

package model;
import java.util.*;

public class Player extends Employee implements CalculateOperation{

  /*
  Class Builder Attributes
  */

  private int dorsal;
  private int amountGoal;
  private double average;
  private Position position;

  /**
  *Builder of the Player class. <br>
  *<b>pre: </b><br>
  *<b>post: </b> A Player type object has been created. <br>
  @param nameEm name of the employee. nameEm ! = null
  @param idEm employee id. idEm ! = null
  @param salary employee's salary. salary must be greater than or equal to zero and salary ! = null
  @param status employee status. status = inactive or status = active
  @param dorsal employee's shirt number. dorsal must be greater than or equal to zero and dorsal ! = null
  @param amountGoal number of goals. amountGoal must be greater than or equal to zero and amountGoal ! = null
  @param average average of the player. average must be greater than or equal to zero and average ! = null
  @param position player position. position = GOALKEEPER, DEFENCE, MIDFIELDER OR FORWARD
  */

  public Player(String nameEm, int idEm, int salary, boolean status, int dorsal, int amountGoal, double average, Position position){
    super(nameEm, idEm, salary, status);
    this.dorsal = dorsal;
    this.amountGoal = amountGoal;
    this.average = average;
    this.position = position;
  }

  /**
  *Getter for the player's bib. <br>
  *<b>pre: </b><br>
  *<b>post: </b> Player's bib <br>
  @return dorsal
  */

  public int getDorsal(){
    return dorsal;
  }

  /**
  *Setter for the player's bib. <br>
  *<b>pre: </b><br>
  *<b>post: </b> Update the player's bib <br>
  @param dorsal employee's shirt number. dorsal must be greater than or equal to zero and dorsal ! = null
  */

  public void setDorsal(int dorsal){
    this.dorsal = dorsal;
  }

  /**
  *Getter for the number of goals made by the player. <br>
  *<b>pre: </b><br>
  *<b>post: </b> The number of goals. <br>
  @return amountGoal
  */

  public int getAmountGoal(){
    return amountGoal;
  }

  /**
  *Setter for the number of goals made by the player. <br>
  *<b>pre: </b><br>
  *<b>post: </b> Update the number of goals. <br>
  @param amountGoal number of goals. amountGoal must be greater than or equal to zero and amountGoal ! = null
  */

  public void setAmountGoal(int amountGoal){
    this.amountGoal = amountGoal;
  }

  /**
  *Getter for the qualification of the player. <br>
  *<b>pre: </b><br>
  *<b>post: </b> Player rating. <br>
  @return average
  */

  public double getAverage(){
    return average;
  }

  /**
  *Setter for player qualification. <br>
  *<b>pre: </b><br>
  *<b>post: </b> Updates the player's rating <br>
  @param average average of the player. average must be greater than or equal to zero and average ! = null
  */

  public void setAverage(double average){
    this.average = average;
  }

  /**
  *Getter for the position of the player. <br>
  *<b>pre: </b><br>
  *<b>post: </b> Player position. <br>
  @return position
  */

  public Position getPosition(){
    return position;
  }

  /**
  *Setter for the position of the player. <br>
  *<b>pre: </b><br>
  *<b>post: </b> Updates the player's position. <br>
  @param position player position. position = GOALKEEPER, DEFENCE, MIDFIELDER OR FORWARD
  */

  public void setPosition(Position position){
    this.position = position;
  }

  /**
  *Allows to calculate the market price of a player. <br>
  *<b>pre: </b> At least one player must exist. <br>
  *<b>post: </b> The player's market price. <br>
  @return priceMarketPlayer
  */

  @Override
  public double priceMarket(){
    double priceMarketPlayer = 0;
    if(getPosition() == Position.GOALKEEPER){
      priceMarketPlayer = (getSalary()*12)+(getAverage()*150);
    }
    else if(getPosition() == Position.DEFENCE){
      priceMarketPlayer = (getSalary()*13)+(getAverage()*125)+(getAmountGoal()*100);
    }
    else if(getPosition() == Position.MIDFIELDER){
      priceMarketPlayer = (getSalary()*14)+(getAverage()*135)+(getAmountGoal()*125);
    }
    else if(getPosition() == Position.FORWARD){
      priceMarketPlayer = (getSalary()*15)+(getAverage()*145)+(getAmountGoal()*150);
    }
    else{
      priceMarketPlayer = 0;
    }
    return priceMarketPlayer;
  }

  /**
  *Allows to calculate the market level of a player. <br>
  *<b>pre: </b> At least one player must exist. <br>
  *<b>post: </b> The player's market level. <br>
  @return levelPlayer
  */

  @Override
  public double lvlMarket(){
    double levelPlayer = 0;
    if(getPosition() == Position.GOALKEEPER){
      levelPlayer = (getAverage()*0.9);
    }
    else if(getPosition() == Position.DEFENCE){
      levelPlayer = (getAverage()*0.9)+(getAmountGoal()/100);
    }
    else if(getPosition() == Position.MIDFIELDER){
      levelPlayer = (getAverage()*0.9)+(getAmountGoal()/90);
    }
    else if(getPosition() == Position.FORWARD){
      levelPlayer = (getAverage()*0.9)+(getAmountGoal()/80);
    }
    else{
      levelPlayer = 0;
    }
    return levelPlayer;
  }

  /**
  *Allows to show the specific information of the employees. <br>
  *<b>pre: </b> At least one employee must be hired. <br>
  *<b>post: </b> Employee's information dated <br>
  @return msg
  */

  @Override
  public String showData(){
    String msg = super.showData();
    msg += "Numero de camiseta: "+getDorsal()+"\n";
    msg += "Numero de goles anotados: "+getAmountGoal()+"\n";
    msg += "Calificacion: "+getAverage()+"\n";
    msg += "Posicion: "+getPosition()+"\n";
    msg += "************************************\n";
    return msg;
  }

}
