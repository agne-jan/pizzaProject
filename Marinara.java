
/**
 * Class Marinara is a subclass of Base that has a constructor,
 * get/set methods for calories and cost if needed by the user.
 *
 * @author Agne Januskeviciute
 * @date 2020-05-30
 */
public class Marinara extends Base
{
    /**
     * Marinara (String description, Money cost, int calorieCount)
     * __________________________________________________
     * Constructor for objects of class Marinara that takes in
     * description, cost and calorie count as parameters.
     * 
     * PRE: Money object must be valid, calorie count must not be negative.
     * POST: The object will be initiated.
     * 
     * @param String description, Money cost, int calorieCount 
     */
    public Marinara (String description, Money cost, int calorieCount) throws CloneNotSupportedException
    {
        super (description, cost, calorieCount);
    }
    
    /**
     * setMarinaraCalories (int newCalories)
     * ______________________________________
     * Allows the user to set calories.
     * 
     * PRE: Calories must be higher than 0.
     * POST: Calorie amount will be set.
     * 
     * @param int newCalories
     */
     public void setMarinaraCalories (int newCalories)
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
     * getMarinaraCalories()
     * ______________________________________
     * Returns calorie count for Marinara.
     * 
     * @return int calories
     */
    public int getMarinaraCalories()
    {
        return super.getCalories();
    }
    
    /**
     * setMarinaraCost(Money cost)
     * ______________________________________
     * Allows the user to set cost.
     * 
     * PRE: Money must be a valid object.
     * POST: Cost will be set.
     * 
     * @param Money cost
     */
    public void setMarinaraCost(Money cost) throws CloneNotSupportedException
    {
        super.setCost(cost);
    }
    
    /**
     * getMarinaraCost()
     * ______________________________________
     * Returns the cost of Marinara.
     * 
     * @return Money cost
     */
    public Money getMarinaraCost() throws CloneNotSupportedException
    {
        return super.getCost();
    }
    
    @Override
    /**
     * toString()
     * ______________________________________
     * Returns String representation of the Marinara class.
     * 
     * @return String s
     */
    public String toString()
    {
        String s = super.toString();
        s += " Marinara sauce ";
        return s;
    }
    
    @Override
    /**
     * equals (Object o)
     * ______________________________________
     * Compares the parameter object with Marinara
     * class.
     * 
     * @param Object o
     * @return true/false
     */
    public boolean equals (Object o)
    {
      if (this.getClass().equals(o.getClass()))//If they're of the same class
      {
        Marinara other = (Marinara) o; //The object is typecasted
        if (super.getCalories() == other.getMarinaraCalories() &&
            super.equals(other)) //The objects are then compared
        {
          return true; //and if they're the same returns true
        } else return false; //else returns false
      } else return false;
    }
}
