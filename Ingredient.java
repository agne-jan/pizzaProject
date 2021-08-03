
/**
 * Class Ingredient is a parent class to pizza ingredients. It tracks
 * cost, description and calories for future ingredients.
 *
 * @author Agne Januskeviciute
 * @date 2020-05-31
 */
public class Ingredient implements Comparable
{
    //instance variables
    private Money cost;
    private String description;
    private int calorieCount;

    /**
     * No-arg constructor for objects of class Ingredient.
     */
    public Ingredient()
    {
      //because why not
      this.cost = new Money (5, 0);
      this.description = "delicious";
      this.calorieCount = 200;  
    }
    
    /**
     * Ingredient(String description, Money cost, int calorieCount)
     * ___________________________________________
     * Constructor for objects of class Ingredient that
     * takes in description, cost and calories.
     * 
     * PRE: cost must be a valid Money object and calorieCount must be
     * a valid positive integer.
     * POST: constructor will be set accordingly.
     * 
     * @param String description, Money cost, int calorieCount
     * 
     */
    public Ingredient(String description, Money cost, int calorieCount) throws CloneNotSupportedException
    {
      this.description = description;
      this.cost = new Money (cost);
        
      if (calorieCount > 0) //Only water has 0 calories, so the rest of the ingredients
        //must be more than that
      {
        this.calorieCount = calorieCount;
      }
      else 
      {
        System.out.println("Calories cannot be 0 or negative. Setting calories to 10.");
        this.calorieCount = 20;
      }
    }
    
    /**
     * Ingredient(Ingredient a)
     * _________________________________________________ 
     * Copy constructor for objects of class Ingredient.
     * 
     * PRE: Ingredient object must be valid and not null.
     * POST: constructor will be set accordingly.
     * 
     * @param Ingredient a
     */
    public Ingredient(Ingredient a) throws CloneNotSupportedException
    {
      if (a != null) //if the object is not null variables are assigned
      {
        this.description = a.description;
        this.cost = new Money (a.cost);
        this.calorieCount = a.calorieCount;
      }
      else //else the program exits
      {
        System.out.println("Invalid object.");
        System.exit(0);
      }
    }
    
    /**
     * setDescription (String pizza)
     * _______________________________
     * Sets the description of a pizza ingredient.
     * 
     * @param String pizza
     */
    public void setDescription (String pizza)
    {
      this.description = pizza;
    }
    
    /**
     * setCost (Money price)
     * ______________________________
     * Sets the cost of the ingredient.
     * 
     * PRE: Money object must be valid and non negative.
     * POST: The cost will be set accordingly.
     * 
     * @param Money price
     */
    public void setCost (Money price) throws CloneNotSupportedException
    {
      this.cost = new Money (price);
    }
    
    /**
     * setCalories (int calories)
     * _____________________________
     * Sets the calories for the ingredient.
     * 
     * PRE: Calories must be a positive valid integer.
     * POST: Calories will be set.
     * 
     * @param int calories
     */
    public void setCalories (int calories)
    {
      if (calories > 0)
      {
        this.calorieCount = calories;
      }
      else
      {
        System.out.println("Calories cannot be 0 or negative.");
      }
    }
    
    /**
     * etDescription()
     * ___________________________
     * Returns the description of the
     * ingredient.
     * 
     * @return String description;
     */
    public String getDescription()
    {
        return this.description;
    }
    
    /**
     * getCost()
     * _________________________
     * Returns the Money object that 
     * represents the cost.
     * 
     * @return Money cost
     */
    public Money getCost() throws CloneNotSupportedException
    {
      Money returnCost = new Money (this.cost); //returning a copy of the object
      return returnCost;
    }
    
    /**
     * getCalories()
     * _________________________
     * Returns the calorie amount.
     * 
     * @return int calories
     */
    public int getCalories()
    {
      return this.calorieCount;
    }
    
    @Override
    /**
     * compareTo(Object o)
     * ____________________________ 
     * The method compares two objects and if they are of the 
     * same class, compares their values. If the first one is less than
     * the comparable object, the method returns -1, if they are the
     * same - returns 0 and 1 if it is higher. If the object is not of
     * the same class, the method returns -10.
     * 
     * PRE: Object must be valid and not null.
     * POST: Compares the two objects and returns integer value.
     * 
     * @param Object m
     * @return int -10, -1, 0, 1
     * 
     */
    public int compareTo(Object o)
    {
        if (this.getClass().equals(o.getClass())) //if they are of the same class
        {
            Ingredient other = (Ingredient) o; //the object is typecasted
            int compared = -2;
            try
            {
               compared = cost.compareTo(other.getCost()); //using Money class compare method
            }
            catch (CloneNotSupportedException e)
            {
               System.out.println("Cannot clone the object.");
            }
            return compared;
        }
        else return -10;        
    }
    
    @Override
    /**
     * toString()
     * ________________________
     * Returns the description of the
     * ingredient.
     * 
     * @return String description
     */
    public String toString()
    {
      String s = this.description; //because other ingredients can add to this 
      //description
      return s;
    }
    
    @Override
    /**
     * equals (Object o)
     * ________________________________________________________________________
     * This method compares the two objects. If they have the same values, it
     * will return true, if not - false.
     * 
     * PRE: The comparing object must not be null/invalid.
     * POST: The method will compare the two objects.
     * 
     * @param Object other;
     * @return true/false
     */
    public boolean equals (Object o)
    {
      if (this.getClass().equals(o.getClass())) //if they are of the same class
      {
        Ingredient other = (Ingredient) o;
        if (this.cost.equals(other.cost) && this.description.equals(other.description)
        && this.calorieCount == other.calorieCount) //and their values match
        {
          return true; //returns true
        }
        else return false; //if values do not match returns false
      } return false; //if they are not of the same class it returns false
    }
}
