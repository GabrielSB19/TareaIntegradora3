/*
Gabriel Suarez
A00368589
*/

package model;
import java.util.*;

public class MainCoach extends Coach implements CalculateOperation{

  private int amountTeam;
  private int amountWinner;

  public MainCoach(String nameEm, int idEm, int salary, boolean status, int yearExperience, int amountTeam, int amountWinner){
    super(nameEm, idEm, salary, status, yearExperience);
    this.amountTeam = amountTeam;
    this.amountWinner = amountWinner;
  }

  public int getAmountTeam(){
    return amountTeam;
  }

  public void setAmountTeam(int amountTeam){
    this.amountTeam = amountTeam;
  }

  public int getAmountWinner(){
    return amountWinner;
  }

  public void setAmountWinner(int amountWinner){
    this.amountWinner = amountWinner;
  }

  @Override
  public double priceMarket(){
    double priceMarketCoach = 0;
    priceMarketCoach = (getSalary()*10)+(getYearExperience()*100)+(getAmountWinner()*50);
    return priceMarketCoach;
  }

  @Override
  public double lvlMarket(){
    double lvlMarketCoach = 0;
    lvlMarketCoach = 5+(getAmountWinner()/10);
    return 0.0;
  }

  @Override
  public String showData(){
    String msg = super.showData();
    msg += "Cantidad de equipos dirigidos: "+getAmountTeam()+"\n";
    msg += "Cantidad de trofeos ganados: "+getAmountWinner()+"\n";
    msg += "************************************\n";
    return msg;
  }
}
