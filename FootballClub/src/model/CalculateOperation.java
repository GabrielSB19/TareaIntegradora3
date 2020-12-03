/*
Gabriel Suarez
A00368589
*/

package model;
import java.util.*;

public interface CalculateOperation{

  /**
  *Allows to calculate the market price. <br>
  *<b>pre: </b><br>
  *<b>post: </b> The market price<br>
  @return double
  */

  public double priceMarket();

  /**
  *Allows to calculate the market level. <br>
  *<b>pre: </b><br>
  *<b>post: </b> The market level<br>
  @return double
  */

  public double lvlMarket();

}
