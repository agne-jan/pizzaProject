
/**
 * Class Pepperoni is a subclass of Meat that has a constructor,
 * get/set methods for calories and cost if needed by the user.
 *
 * @author Agne Januskeviciute
 * @date 2020-05-30
 */
//Pepperoni is a sausage so that's weird :D
public class Pepperoni extends Meat
{
    /**
     * Pepperoni (String description, Money cost, int calorieCount)
     * __________________________________________________
     * Constructor for objects of class Pepperoni that takes in
     * description, cost and calorie count as parameters.
     * 
     * PRE: Money object must be valid, calorie count must not be negative.
     * POST: The object will be initiated.
     * 
     * @param String description, Money cost, int calorieCount 
     */
    public Pepperoni (String description, Money cost, int calorieCount) throws CloneNotSupportedException
    {
        super(description, cost, calorieCount);
    }
    
    /**
     * setPepperoniCalories (int newCalories)
     * ______________________________________
     * Allows the user to set calories.
     * 
     * PRE: Calories must be higher than 0.
     * POST: Calorie amount will be set.
     * 
     * @param int newCalories
     */
    public void setPepperoniCalories (int newCalories)
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
     * getPepperoniCalories()
     * ______________________________________
     * Returns calorie count for Pepperoni.
     * 
     * @return int calories
     */
    public int getPepperoniCalories()
    {
        return super.getCalories();
    }
    
    /**
     * setPepperoniCost(Money cost)
     * ______________________________________
     * Allows the user to set cost.
     * 
     * PRE: Money must be a valid object.
     * POST: Cost will be set.
     * 
     * @param Money cost
     */
    public void setPepperoniCost(Money cost) throws CloneNotSupportedException
    {
        super.setCost(cost);
    }
    
    /**
     * getPepperoniCost()
     * ______________________________________
     * Returns the cost of pepperoni.
     * 
     * @return Money cost
     */
    public Money getPepperoniCost() throws CloneNotSupportedException
    {
        return super.getCost();
    }
    
    @Override
    /**
     * toString()
     * ______________________________________
     * Returns String representation of the Pepperoni class.
     * 
     * @return String s
     */
    public String toString()
    {
      String s = super.toString() +  " Pepperoni ";
      return s;
    }
    
    @Override
    /**
     * equals (Object o)
     * ______________________________________
     * Compares the parameter object with Pepperoni
     * class.
     * 
     * @param Object o
     * @return true/false
     */
    public boolean equals (Object o)
    {
      if (this.getClass().equals(o.getClass())) //If they're of the same class
      {
        Pepperoni other = (Pepperoni) o; //The object is typecasted
        if (super.getCalories() == other.getPepperoniCalories() &&
            super.equals(other)) //The objects are then compared
        {
          return true; //and if they're the same returns true
        } else return false; //else returns false
      } else return false;
    }
}
