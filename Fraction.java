
/**
 * Fraction class holds two variables, numerator and denominator that represent fraction elements.
 * This class simplifies the fraction and returns simplified version only.
 *
 * @author Agne Januskeviciute
 * @date 2020-04-12
 */
public class Fraction
{
    //self explanatory
    private int numerator;
    private int denominator;
    
    public Fraction () //default constructor that is technically not used
    {
        this.numerator = 1;
        this.denominator = 1;        
    }

    /**
     * Constructor that takes in two integers (numerator and denominator),
     * simplifies and returns simplified version. Uses greatestCommonDenominator
     * method to do that.
     * 
     * PRE: greatestComonDenominator must work for it to return  proper values
     */
    public Fraction (int numerator, int denominator)
    {
        //finds greatest common denominator to simplify the fraction:
        int gcd = greatestCommonDenominator(numerator, denominator);
        
        //assigns the variables with simplified version:
        this.numerator = numerator/gcd;
        this.denominator = denominator/gcd;       
    }  
    
    public Fraction (Fraction o)
    {
        this.numerator = o.numerator;
        this.denominator = o.denominator;
    }
    
    /**
     * setNumerator (int numerator)
     * _______________________________________________________________________
     * Setter method to assign the new value to numerator.
     * 
     * @param int numerator
     */
    public void setNumerator (int numerator)
    {
        this.numerator = numerator;
    }
    
    /**
     * getNumerator()
     * ________________________________________________________________________
     * Getter method to access numerator
     * 
     * @return int numerator
     */
    public int getNumerator ()
    {
        return this.numerator; 
    }
    
    /**
     * 
     * getDenominator()
     * ________________________________________________________________________
     * Getter method to access denominator
     * 
     * @return int denominator
     */
    public int getDenominator()
    {
     return this.denominator;
    }
    
    /**
     * setDenominator (int denominator)
     * ________________________________________________________________________
     * This method sets the denominator to the new value. If the value is 0,
     * it sends the message that denominator cannot be 0.
     * 
     * @param int denominator
     */
    public void setDenominator(int denominator)
    {
        if (denominator == 0)
        {
            System.out.println("Denominator cannot be 0!");
        }
        else
        {
            this.denominator = denominator;
        }
    }
    
    /**
     * equalsTo (Fraction other)
     * ___________________________________________________________________________
     * This method compares the two Fraction objects to one another.
     * 
     * To compare separate objects I referenced this example:
     * https://www.chegg.com/homework-help/questions-and-answers/
     * summary-build-two-classes-fraction-fractioncounter-driver-use-counting-number-unique-fract-q24109960
     * 
     * @param Fraction other
     * @return true/false
     */
    public boolean equalsTo (Fraction other)
    {
        if (other == null)
        { //if input nonexistent, returns false
            return false;
        }
        else if (other instanceof Fraction == false)
        { //if input is not a Fraction object then returns false
            return false;
        }
        //if input is a Fraction object then the method compares its numerator and 
        //denominator to the numerator and denominator Fraction class vars
        Fraction newObject = (Fraction) other;
        return this.numerator == newObject.numerator && this.denominator == newObject.denominator; //returns true if equal
    }
    
    /**
     * greatestCommonDenominator (int numerator, int denominator)
     * _______________________________________________________________________
     * Private method (as it is not needed elsewhere)to find the greatest 
     * common denominator. This method was also used in Fractions V1 homework, 
     * where I referenced this source:
     * 
     * https://www.geeksforgeeks.org/reduce-the-fraction-to-its-lowest-form/
     * 
     * @param int numerator, int denominator
     * @return int greatestCommonDenominator
     * 
     */
    private int greatestCommonDenominator(int numerator, int denominator)
    {
        if (denominator == 0)  
        {
            return numerator;  
        }
    
        //0f denominator is not 0, it calculates and returns gcd:  
        return greatestCommonDenominator (denominator, numerator % denominator); 
    }
    
    /**
     * toString()
     * _____________________________________________________________________
     * This method overrides the built-in toString and replaces it with the 
     * normal fraction form that is read from the file. If denominator is 0,
     * the method returns the error message.
     * 
     * @return String
     */
    public String toString()
    {
       if(denominator == 0)
       {
           //the second part of the error message is used to smooth out the whole message in the final output.
           String denomError = "Denominator cannot be 0. This type of invalid fraction";   
           return denomError;
       }
       else
       {
           return this.numerator+"/"+this.denominator;
       }
    }
}
