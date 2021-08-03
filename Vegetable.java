
import java.awt.Color;
/**
 * Class Vegetable here.
 *
 * @author Agne Januskeviciute
 * @date 2020-05-29
 */
public class Vegetable extends Ingredient
{
    private Color veggieColor; //as required

    /**
     * Vegetable (String description, Money cost, int calorieCount)
     * __________________________________________________________
     * Class constructor that takes in description, cost and calorie count
     * as parameters that are required by the parent Ingredient class.
     * 
     * PRE: Money cost object must be valid, calorie count must be non-negative.
     * POST: The class object will be initiated.
     * 
     * @param String description, Money cost, int calorieCount
     */
    public Vegetable (String description, Money cost, int calorieCount) throws CloneNotSupportedException
    {
        super(description, cost, calorieCount);
    }
    
    /**
     * Vegetable (String description, Money cost, int calorieCount, Color newColor)
     * _________________________________________________________
     * Class constructor that takes in description, cost, calorie count
     * as parameters that are required by the parent Ingredient class
     * and Color object.
     * 
     * PRE: Money cost object must be valid, calorie count must be non-negative, Color object must be valid.
     * POST: The class object will be initiated.
     * 
     * @param String description, Money cost, int calorieCount, Color newColor
     */
    public Vegetable (String description, Money cost, int calorieCount, Color newColor) throws CloneNotSupportedException
    {
        super(description, cost, calorieCount);
        this.veggieColor = newColor; //honestly I'm not sure how color should work with this assignment
    }
    
    /**
     * setColor (Color newColor)
     * _____________________________________
     * Sets the color of the veggie.
     * 
     * PRE: Color object must be valid.
     * POST: Color will be set.
     * 
     * @param Color newColor
     */
    public void setColor (Color newColor)
    {
        this.veggieColor = newColor;
    }
    
    /**
     * getColor()
     * ______________________________________
     * Returns the color.
     * 
     * @return Color veggieColor
     */
    public Color getColor()
    {
        return this.veggieColor;
    }
    
    @Override
    /**
     * toString()
     * ______________________________
     * Returns the description as well as the color
     * of the vegetable.
     * 
     * @return String
     */    
    public String toString()
    {
        return super.toString() +" "+ this.veggieColor;
    }
    
    @Override
    /**
     * equals (Object o)
     * __________________________________
     * Compares this object with another object
     * and returns true if they're identical and false 
     * if they are not.
     * 
     * @param Object o
     * @return true/false
     */
    public boolean equals (Object o)
    {
        if (this.getClass().equals(o.getClass())) //If they are of the same class
        {
            Vegetable other = (Vegetable) o; //o is typecasted
            if (this.veggieColor.equals(other.veggieColor) && //if colors are the same
            super.equals(other)==true) //then calling Ingredient equals method and if it's true
            {
              return true; //returns true
            } else return false;
        }
        return false;
    }
    
    
}
