
/**
 * Class Cheese has a constructor for Cheeses that is derived from Ingredient
 * class.
 *
 * @author Agne Januskeviciute
 * @date 2020-05-29
 */
public class Cheese extends Ingredient
{
  /**
   * Cheese (String description, Money cost, int calorieCount)
   * _______________________________________________
   * Constructor that takes in description, cost and calorie 
   * count for Cheese ingredients.
   * 
   * PRE: Money has to be a valid object, calories cannot be negative
   * POST: The object will be initiated.
   * 
   * @param String description, Money cost, int calorieCount
   */
  public Cheese (String description, Money cost, int calorieCount) throws CloneNotSupportedException
  {
    super (description, cost, calorieCount);
  }
}
