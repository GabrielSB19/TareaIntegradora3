/*
Gabriel Suarez
A00368589
*/

package model;
import java.util.*;

public class Player extends Employee implements CalculateOperation{

  private int dorsal;
  private int amountGoal;
  private avergae double;
  private Position position;

  public Player(String nameEm, int idEm, int salary, boolean status, int dorsal, int amountGoal, double avergae, Position position){
    super(nameEm, idEm, salary, status);
    this.dorsal = dorsal;
    this.amountGoal = amountGoal;
    this.avergae = avergae;
    this.position = position;
  }

  public int getDorsal(){
    return dorsal;
  }

  public void setDorsal(int dorsal){
    this.dorsal = dorsal;
  }

  public int getAmountGoal(){
    return amountGoal;
  }

  public void setAmountGoal(int amountGoal){
    this.amountGoal = amountGoal;
  }

  public double getAverage(){
    return avergae;
  }

  public void setAverage(double avergae){
    this.avergae = avergae;
  }

  public Position getPosition(){
    return position;
  }

  public void setPosition(Position position){
    this.position = position;
  }

  @Override
  public double priceMarket(){
    return 0.0;
  }

  @Override
  public double lvlMarket(){
    return 0.0;
  }

}
