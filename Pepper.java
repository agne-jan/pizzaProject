
import java.awt.Color;
/**
 * Class Pepper is a subclass of Vegetable that has a constructor,
 * get/set methods for calories and cost if needed by the user.
 *
 * @author Agne Januskeviciute
 * @date 2020-05-29
 */
public class Pepper extends Vegetable
{  
    /**
     * Pepper (String description, Money cost, int calorieCount, Color newColor)
     * __________________________________________________
     * Constructor for objects of class Pepper that takes in
     * description, cost, calorie count and Color as parameters.
     * 
     * PRE: Money and Color objects must be valid, calorie count 
     * must not be negative.
     * POST: The object will be initiated.
     * 
     * @param String description, Money cost, int calorieCount
     * 
     */
    public Pepper (String description, Money cost, int calorieCount, Color newColor) throws CloneNotSupportedException
    {
        super(description, cost, calorieCount, newColor);
    }
    
    /**
     * setPepperCalories (int newCalories)
     * ______________________________________
     * Allows the user to set calories.
     * 
     * PRE: Calories must be higher than 0.
     * POST: Calorie amount will be set.
     * 
     * @param int newCalories
     */
    public void setPepperCalories (int newCalories)
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
     * getPepperCalories()
     * ______________________________________
     * Returns calorie count for Pepper.
     * 
     * @return int calories
     */
    public int getPepperCalories()
    {
      return super.getCalories();
    }
    
    /**
     * setPepperCost(Money cost)
     * ______________________________________
     * Allows the user to set cost.
     * 
     * PRE: Money must be a valid object.
     * POST: Cost will be set.
     * 
     * @param Money cost
     */
    public void setPepperCost(Money cost) throws CloneNotSupportedException
    {
      super.setCost(cost);
    }
    
    /**
     * getPepperCost()
     * ______________________________________
     * Returns the cost of pepper.
     * 
     * @return Money cost
     */
    public Money getPepperCost() throws CloneNotSupportedException
    {
      return super.getCost();
    }
    
    @Override
    /**
     * toString()
     * ______________________________________
     * Returns String representation of the Pepper class.
     * 
     * @return String s
     */
    public String toString()
    {
      String s = super.toString() +  " pepper ";
      return s;
    }
    
    @Override
    /**
     * equals (Object o)
     * ______________________________________
     * Compares the parameter object with Pepper
     * class.
     * 
     * @param Object o
     * @return true/false
     */
    public boolean equals (Object o)
    {
      if (this.getClass().equals(o.getClass())) //If they're of the same class
      { 
        Pepper other = (Pepper) o; //The object is typecasted
        if (super.getCalories() == other.getCalories() && //and calories with
            super.equals(other) && super.equals(other))//parent equals method
            //are compared
        {
          return true; // if they're the same returns true
        } else return false; //if not returns false
      } else return false;
    }
}
