
/**
 * Class Base has a constructor for Base that is derived from Ingredient
 * class.
 *
 * @author Agne Januskeviciute
 * @date 2020-05-29
 */
public class Base extends Ingredient
{
  /**
   * Base (String description, Money cost, int calorieCount)
   * _______________________________________________
   * Constructor that takes in description, cost and calorie 
   * count for Base ingredients.
   * 
   * PRE: Money has to be a valid object, calories cannot be negative
   * POST: The object will be initiated.
   * 
   * @param String description, Money cost, int calorieCount
   */
   public Base (String description, Money cost, int calorieCount) throws CloneNotSupportedException
   {
     super (description, cost, calorieCount);
   }    
}
