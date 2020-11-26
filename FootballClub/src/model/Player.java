/*
Gabriel Suarez
A00368589
*/

package model;
import java.util.*;

public class Player extends Employee implements CalculateOperation{

  private int dorsal;
  private int amountGoal;
  private double average;
  private Position position;

  public Player(String nameEm, int idEm, int salary, boolean status, int dorsal, int amountGoal, double average, Position position){
    super(nameEm, idEm, salary, status);
    this.dorsal = dorsal;
    this.amountGoal = amountGoal;
    this.average = average;
    this.position = Position.DEFAULT;
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
    return average;
  }

  public void setAverage(double avergae){
    this.average = average;
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
