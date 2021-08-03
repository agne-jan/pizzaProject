 
import java.awt.Color;
/**
 * Class Olive is a subclass of Vegetable that has a constructor,
 * get/set methods for calories and cost if needed by the user.
 *
 * @author Agne Januskeviciute
 * @date 2020-05-29
 */
public class Olive extends Vegetable
{
    /**
     * Olive (String description, Money cost, int calorieCount, Color newColor)
     * __________________________________________________
     * Constructor for objects of class Olive that takes in
     * description, cost, calorie count and Color as parameters.
     * 
     * PRE: Money and Color objects must be valid, calorie count must
     * not be negative.
     * POST: The object will be initiated.
     * 
     * @param String description, Money cost, int calorieCount
     * 
     */
    public Olive (String description, Money cost, int calorieCount, Color newColor) throws CloneNotSupportedException
    {
        super(description, cost, calorieCount, newColor);
    }
    
    /**
     * setOliveCalories (int newCalories)
     * ______________________________________
     * Allows the user to set calories.
     * 
     * PRE: Calories must be higher than 0.
     * POST: Calorie amount will be set.
     * 
     * @param int newCalories
     */
    public void setOliveCalories (int newCalories)
    {
      if (newCalories > 0) //only water has 0 calories. Pepper is not water.
      {
        super.setCalories(newCalories);
      }
      else 
      {
        System.out.println("Calories cannot be 0 or negative. Calories will be set to 1.");
        super.setCalories(1);
      }
    }
    
    /**
     * getOliveCalories()
     * ______________________________________
     * Returns calorie count for Olive.
     * 
     * @return int calories
     */
    public int getOliveCalories()
    {
      return super.getCalories();
    }
    
    /**
     * setOliveCost(Money cost)
     * ______________________________________
     * Allows the user to set cost.
     * 
     * PRE: Money must be a valid object.
     * POST: Cost will be set.
     * 
     * @param Money cost
     */
    public void setOliveCost(Money cost) throws CloneNotSupportedException
    {
      super.setCost(cost);
    }
    
    /**
     * getOliveCost()
     * ______________________________________
     * Returns the cost of olive.
     * 
     * @return Money cost
     */
    public Money getOliveCost() throws CloneNotSupportedException
    {
      return super.getCost();
    }
    
    @Override
    /**
     * toString()
     * ______________________________________
     * Returns String representation of the Olive class.
     * 
     * @return String s
     */
    public String toString()
    {
      String s = super.toString();
      s += " olives ";
      return s;
    }
    
    @Override
    /**
     * equals (Object o)
     * ______________________________________
     * Compares the parameter object with Olive
     * class.
     * 
     * @param Object o
     * @return true/false
     */
    public boolean equals (Object o)
    {
      if (this.getClass().equals(o.getClass()))  //If they're of the same class
      {
        Olive other = (Olive) o; //The object is typecasted
        if (super.getCalories() == other.getCalories() &&
            super.equals(other) && super.getColor().equals(other.getColor()))
            //The objects are then compared
        {
              return true; //and if they're the same returns true
        } else return false; //else returns false
      } else return false;
    }
}
