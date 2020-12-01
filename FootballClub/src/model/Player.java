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
    return average;
  }

  public void setAverage(double average){
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
