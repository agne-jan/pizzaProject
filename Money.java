
import java.io.Serializable;
/**
 * Class Money stores two values - dollars and cents as per homework assignment.
 * 
 * Error messages are printed to screen rather thrown as an error to keep the 
 * program running.
 *
 * @author Agne Januskeviciute
 * @date 2020-04-25
 * 
 * UPDATE: 
 * Class Money now implements Comparable, Cloneable and Serializable interfaces.
 * 
 * @author Agne Januskeviciute
 * @date 2020-05-24
 */
public class Money implements Comparable <Object>, Cloneable, Serializable
{
    private int dollars;
    private int cents;

    /**
     * Money (int dol)
     * __________________________________________________________________________
     * Constructor for variables of class Money that takes dollars as an argument.
     * 
     * @param int dol
     */
    public Money (int dol)
    {
      if (dol > 0) //dollars cannot be negative
      {
        this.dollars = dol;
        this.cents = 0;
      }
      else
      {
        System.out.println("Invalid input");
      }
      
    }
    
    /**
     * Money(int dol, int cent)
     * _________________________________________________________________________________
     * Constructor for variables of class Money that takes dollars and cents as an argument.
     * 
     * @param int dol, int cent
     */
    public Money(int dol, int cent)
    {
      if(dol >= 0 && cent < 100 && cent >= 0) //dollars cannot be negative and cents
      //have to be between 0 and 99 
      {
        this.dollars = dol;
        this.cents = cent;
      }
      else 
      {
        System.out.println("Invalid currency input");
      }
    }

    /**
     * Money (Money other)
     * _____________________________________________________________________________ 
     * Constructor for variables of class Money that takes Money object as an argument.
     * 
     * @param Money other
     */
    public Money (Money other) throws CloneNotSupportedException
    {
        //this.clone();
        this (other.getDollars(), other.getCents());        
    }
    
    /**
     * getDollars()
     * __________________________________________________________________________
     * Returns dollar value.
     * 
     * @return int dollars
     * 
     */   
    public int getDollars()
    {
        return this.dollars;
    }
    
    /**
     * getCents()
     * __________________________________________________________________________
     * Returns cent value.
     * 
     * @return int cents
     * 
     */
    public int getCents()
    {
        return this.cents;
    }
    
    /**
     * setDollars(int dollars)
     * __________________________________________________________________________
     * Sets dollar value.
     * 
     * @param int dollars
     * 
     */
    public void setDollars(int dollars)
    {
        this.dollars = dollars;
    }
    
    /**
     * setCents(int cents)
     * __________________________________________________________________________
     * Sets cent value.
     * 
     * @param int cents
     * 
     */
    public void setCents(int cents)
    {
        this.cents = cents;
    }
    
    /**
     * getMoney()
     * __________________________________________________________________________
     * Returns total money value as a double.
     * 
     * @return double dollars
     * 
     */
    public double getMoney()
    {         
        return this.dollars + (double)this.cents/100;
    }
    
    /**
     * setMoney()
     * __________________________________________________________________________
     * Sets money value.
     * 
     * @param int dol, int cent
     * 
     */
    public void setMoney(int dol, int cent)
    {
      if (dol >= 0 && cent >= 0 && cent <100)
      {
        setDollars(dol); 
        setCents(cent);
      }
      else System.out.println("Invalid dollar/cent input");
    }
    
    /**
     * add ()
     * __________________________________________________________________________
     * Adds dollars.
     * 
     * @param int dol
     * 
     */
    public void add (int dol)
    {
      if (dollars >= 0)
        this.dollars += dol;
      else System.out.println("Dollars cannot be negative");
    }
    
    /**
     * add (int dol, int cent)
     * ___________________________________________________________________________
     * Adds dollars to dollars and cents to cents. If total cent amount is higher than
     * 99, the cents are then converted into dollars and cents respectively. For example,
     * 90 cents + 90 cents = 1 dollar and 80 cents.
     * 
     * PRE: Dollars cannot be negative, cents have to be between [0, 99].
     * POST: Cents and dollars are added together.
     * 
     * @param int dol, int cent
     * 
     */
    public void add (int dol, int cent)
    {
      if (dol >= 0 && cent >= 0 && cent < 100) 
      {
        this.cents += cent; //addition of the dollars and cents
        this.dollars += dol;
        
        int remainingCents = 0; //remainder of dollars and cents if cent value is high
        
        //TEST: System.out.println(this.dollars+"."+this.cents);
        if (this.cents > 99) //if cent value is higher than 99
        {
          remainingCents = (this.cents - 100); //the difference is added to remaining cents
        
          //TEST: System.out.println("Change: " + remainingCents);
        }
       //TEST: System.out.println(this.dollars+"."+this.cents);    
       
        this.cents =remainingCents; // remaining cents are then turned to cents
        this.dollars +=1; //and dollar amount is increased by 1
       //TEST: System.out.println(this.dollars+"."+this.cents);
    } else System.out.println("Invalid dollar/cent amount");
    }
    
    /**
     * add (Money other)
     * _________________________________________________________________
     * This method adds dollars and cents from another object. If cents 
     * exceed 99, they are converted to dollars and cents, for example, 
     * 90 cents + 90 cents will be 1 dollar and 80 cents.
     * 
     * PRE: Other object is not null and has valid dollars and cents.
     * POST: Dollar and cent values will be added together.
     * 
     * @param Money other
     */
    public void add (Money other)
    {
      if (other !=null) //if the object is valid, the code will execute
      {
        this.cents += other.getCents(); //dollars and cents will be added together
        this.dollars += other.getDollars();
        
        int remainingCents = 0;

        //TEST: System.out.println(this.dollars+"."+this.cents);
        if(this.cents > 100) //if there are more than 99 cents, they are turned to
        //dollars and cents:
        {
          remainingCents = (this.cents - 100);
          //TEST: System.out.println("Change: " + remainingCents);

          this.cents = remainingCents; //cents are represented as change
          this.dollars +=1; //and dollar value increases
         }
        //TEST: System.out.println(this.dollars+"."+this.cents); 
      }
      else System.out.println("Invalid input");        
    }
    
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
     * 
     */
    public boolean equals (Object o)
    {
      if (o != null && o.toString().equals(this.toString()))
      //All of our homework methods have toString so if they match exactly, 
      //the objects are the same.
      
      {
        return true; 
      }
      else return false;  
    }
    
    @Override
    /**
     * toString()
     * ____________________________________________________________
     * This method returns a String representation of the class object.
     * 
     * @return String
     */
    public String toString()
    {
        return "$" + getMoney();
    }
    
    @Override
    /**
     * compareTo(Object m)
     * _____________________________________________________
     * The method compares two objects and if they are of the 
     * same class, compares their values. If the first one is less than
     * the comparable object, the method returns -1, if they are the
     * same - returns 0 and 1 if it is higher. If the object is not of
     * the same class, the method returns -2.
     * 
     * PRE: Object must be valid and not null.
     * POST: Compares the two objects and returns integer value.
     * 
     * @param Object m
     * @return int -2, -1, 0, 1
     * 
     */
    public int compareTo(Object m)
    {
      if (this.getClass().equals(m.getClass())) //If they are of the same class
      {
        Money other = (Money) m; //the m object is typecasted
        if (this.getMoney() < other.getMoney()) //then their values are compared
        //as per homework assignment
        {
          return -1; 
        }
        else if (this.getMoney() == other.getMoney())
        {
          return 0;
        }
        else
        {
           return 1;
        }
      }
      else return -2; //if not of the same class, -2 is returned
    }
    
    @Override
    /**
     * clone ()
     * _________________________________
     * Clones the class object.
     * 
     * @return Object cloned
     */
    public Object clone () throws CloneNotSupportedException
    {
      //Based on this example:
      //https://howtodoinjava.com/java/cloning/a-guide-to-object-cloning-in-java/
      Money cloned = (Money) super.clone();
      return cloned;
    }
    
    /*Test methods:
     * public static void main (String[]args)
    {
        Money original = new Money (10, 20);
        try
        {
            Money clone = (Money) original.clone();
            System.out.println("Original: " + original);
            System.out.println("Clone: " + clone);
            clone.setMoney(5, 99);
            System.out.println("Clone set to $5.99");
            System.out.println("Original: " + original);
            System.out.println("Clone: " + clone);
        }
        catch (CloneNotSupportedException e)
        {
            System.out.println("Clone did not work");
        }
        Money original1 = new Money (10, 20);
        System.out.println(original.compareTo(original1));
    
    
        Money someMoney = new Money (30, 80); 
        System.out.println("I should have 30.80. I have: " + someMoney.getMoney());
        someMoney.add(10, 95);
        System.out.println("I added 10.95. Now I should have 41.75: " + someMoney.getMoney());
        someMoney.setMoney(13, 58);
        System.out.println("Now I should have 13.58: " +someMoney.getMoney());
        
        Money moneyMoney = new Money (10);
        System.out.println("I should have 10.00. I have: " + moneyMoney.getMoney());
        someMoney.add(moneyMoney);
        System.out.println("I added 10 to 13.58. I should have 23.58. I have: " + someMoney.getMoney());
        System.out.println("Does someMoney with 23.58 equal moneyMoney with 10.00?:"+
        someMoney.equals(moneyMoney));
        
        Money gimmeMoney = new Money (10, 0);
        
        System.out.println("Does gimmeMoney with 10.00 equal moneyMoney with 10.00?:"+
        gimmeMoney.equals(moneyMoney));
        
        System.out.println("Testing toString: " + someMoney);
        
        //BAD TESTS:
        System.out.println("Testing creation of a bad money object with -1 dollar:");
        Money badMoney = new Money (-1, 9);
        
        System.out.println("Testing comparing invalid money object to normal one:");
        System.out.println(badMoney.equals(gimmeMoney));
        
    }*/
}
