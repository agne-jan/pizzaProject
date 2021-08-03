 
import java.awt.Color;
/**
 * Class Pizza has various constructors for the class as well as methods 
 * to eat pizza, generate random pizza, eat some pizza, track cost and
 * eaten pizza.
 *
 * @author Agne Januskeviciute
 * @date 2020-06-01
 */
public class Pizza implements PizzaComparable
{
    // instance variables for class Pizza
    private Ingredient pizzaIngredient;
    private ArrayList<Ingredient> listOfIngredients;
    private int calorieCount;
    private Money costOfIngredients;
    private Shape pizzaShape;
    private Fraction pizzaEaten;
    private int index = 0;
    
    /**
     * No-arg constructor for objects of class Pizza
     */
    public Pizza() throws CloneNotSupportedException
    {
      //Creating random pizza:
      this.pizzaIngredient = getRandBase(); //need random base
      this.listOfIngredients = new ArrayList<>();
      this.index = 0;
      listOfIngredients.insert(pizzaIngredient, this.index);
      this.index++;
      this.listOfIngredients.insert(getRandCheese(), this.index); //then need random cheese
      //as per assignment
      this.index++;
      //Counting calories of that random pizza:
      this.calorieCount += pizzaIngredient.getCalories();
      this.costOfIngredients = pizzaIngredient.getCost();
      //Getting random shape:
      this.pizzaShape = getRandShape();
      this.pizzaEaten = new Fraction(1, 1); //All pizzas are whole when created
    }
        
    /**
     * Pizza(Ingredient pizzaIngredient, Money cost, Shape shape, Fraction atePizza)
     * _____________________________________________
     * Constructor for objects of class Pizza that takes ingredient,
     * cost, shape and eaten pizza fraction as parameters.
     * 
     * PRE: Ingredient, Money, Shape and Fraction objects must be valid.
     * POST: Pizza will be constructed.
     * 
     * @param Ingredient pizzaIngredient, Money cost, Shape shape, Fraction atePizza
     */
    public Pizza(Ingredient pizzaIngredient, Money cost, Shape shape, Fraction atePizza) throws CloneNotSupportedException
    {
      this.pizzaIngredient = new Ingredient (pizzaIngredient);
      //To add ingredient in the beginning of the list:
      this.listOfIngredients = new ArrayList<>();
      listOfIngredients.insert(pizzaIngredient, this.index);
      this.index++;
      //Continues with calorie count
      this.calorieCount = pizzaIngredient.getCalories();
      this.costOfIngredients = new Money(cost);
      this.pizzaShape = shape; //can't do new because Shape is abstract as required
      //by the assignment (for some reason clone() had to be abstract)
      this.pizzaEaten = new Fraction(atePizza);
    }
    
    /**
     * Pizza(Pizza other)
     * ______________________________
     * Copy constructor for Pizza class.
     */
    public Pizza(Pizza other) throws CloneNotSupportedException
    {
      this.pizzaIngredient = other.pizzaIngredient;
      this.listOfIngredients = other.listOfIngredients;
      this.index = other.index;
      this.calorieCount = other.calorieCount;
      this.costOfIngredients = other.costOfIngredients;
      this.pizzaShape = other.pizzaShape;
      this.pizzaEaten = other.pizzaEaten;      
    }
    
    /**
     * getRandShape()
     * _____________________
     * Helper method to get random shape for
     * pizza. 
     * 
     * @return Shape pizzaShape
     */
    private Shape getRandShape()
    {
      //I modeled this after the Shape homework
      Shape pizzaShape = null; //Initializing shape
      switch((int)(Math.random() * 2)) //randomly choosing from 2 options
      {
        case 0: pizzaShape = new Circle (1+(double)(Math.random() * 15));
                break; //Creating a random size circular pizza. No smaller than 
                //1 inch and no larger than 15.
                
        case 1: pizzaShape = new Square (1+(int)(Math.random() * 15));
                break; //Creating a random size square pizza. No smaller than 
                //1 inch and no larger than 15.
      }
      
      return pizzaShape; //returning randomly chosen shape
    }
    
    /**
     * getRandBase()
     * _____________________
     * Helper method to get random base for
     * pizza. 
     * 
     * @return Base pizzaBase
     */
    private Base getRandBase() throws CloneNotSupportedException
    {
      //I modeled this after the Shape homework
      Base pizzaBase = null; //Initializing base
      switch((int)(Math.random() * 2)) //Choosing from 2 options
      {
        case 0: pizzaBase = new Marinara ("hearty", new Money (3, 50), 150);
                break; //Decided to put description, cost and calories myself
                
        case 1: pizzaBase = new Alfredo ("delicious", new Money (2, 50), 200);
                break;
      }
      
      return pizzaBase; //returning the random base
    }
    
    /**
     * getRandCheese()
     * _____________________
     * Helper method to get random cheese for
     * pizza. 
     * 
     * @return Cheese pizzaCheese
     */
    private Cheese getRandCheese() throws CloneNotSupportedException
    {
      Cheese pizzaCheese = null;
      switch((int)(Math.random() * 2))
      {
        case 0: pizzaCheese = new Mozzarella ("fresh", new Money (3, 50), 150);
                break; //again, made up the objects
                
        case 1: pizzaCheese = new Goat ("flavourful", new Money (2, 50), 200);
                break;
      }
      
      return pizzaCheese; //returning random cheese
    }
    
    /**
     * getRandMeat()
     * _____________________
     * Helper method to get random meat for
     * pizza. 
     * 
     * @return Meat pizzaMeat
     */
    private Meat getRandMeat() throws CloneNotSupportedException
    {
      Meat pizzaMeat = null;
      //All same as above
      switch((int)(Math.random() * 2))
      {
        case 0: pizzaMeat = new Pepperoni ("Italian", new Money (4, 50), 250);
                break;
                
        case 1: pizzaMeat = new Sausage ("smoky", new Money (5, 50), 200);
                break;
      }
      
      return pizzaMeat;
    }
    
    /**
     * getRandVegetable()
     * _____________________
     * Helper method to get random vegetable for
     * pizza. 
     * 
     * @return Vegetable pizzaVegetable
     */
    private Vegetable getRandVegetable() throws CloneNotSupportedException
    {
      Vegetable pizzaVegetable = null;
      //Same as above
      switch((int)(Math.random() * 2))
      {
        case 0: pizzaVegetable = new Olive ("marinated", new Money (4, 50), 250, new Color (0, 0, 0));
                break; //The color part was weird and prof didn't quite 
                //clarify what it's meant for so I came up randomly
                
        case 1: pizzaVegetable = new Pepper ("fresh", new Money (5, 50), 200, new Color (0, 255, 0));
                break;
                
      }
      
      return pizzaVegetable;
    }
    
    /**
     * getRandomPizza()
     * ______________________________
     * Void method to build a random pizza.
     * The method can add one random vegetable,
     * one random meat or one of each randomly.
     */
    public void getRandomPizza() throws CloneNotSupportedException, PizzaException
    {
      
      switch((int)(Math.random() * 3))
      {
        case 0: addIngredient(getRandVegetable()); //adding one random vegetable
                break;
                
        case 1: addIngredient(getRandMeat()); //adding one random meat
                break;
                
        case 2: addIngredient(getRandVegetable()); //adding one of each randomly
                addIngredient(getRandMeat());
                break;
      }    
    }
    
    /**
     * getRemaining ()
     * _____________________________
     * Returns a Fraction object of remaining pizza.
     * 
     * @return Fraction pizzaEaten
     */
    public Fraction getRemaining ()
    {
      return pizzaEaten = new Fraction (pizzaEaten); //returning new object 
      //to prevent privacy leaks
    }

    /**
     * setRemaining (Fraction f)
     * ________________________________
     * Sets remaining fraction of eaten
     * pizza.
     * 
     * PRE: Fraction object must be valid
     * POST: Pizza fraction will be set.
     * 
     * @param Fraction f
     */
    public void setRemaining (Fraction f) throws PizzaException
    {
      if (f != null) //If the object is not null
      
         this.pizzaEaten = new Fraction (f); //pizza eaten is set
         
      else throw new PizzaException ("Invalid fraction object.");
      //else throws exception
    }
    
    /**
     * getCalories ()
     * ____________________________
     * Returns calorie count.
     * 
     * @return int calorieCount
     */
    public int getCalories ()
    {
      return this.calorieCount;
    }
    
    /**
     * getCost()
     * __________________________________
     * Returns cost of the ingredients.
     * 
     * @return Money cost
     */
    public Money getCost()
    {
      return this.costOfIngredients;
    }
    
    /**
     * getRemainingArea()
     * ___________________________________
     * Returns remaining area of the pizza.
     * 
     * @return double remaining area
     */
    public double getRemainingArea()
    {
      //For calculating remaining area getting an approximate double from
      //a fraction object is accurate enough
      double fraction = (double) pizzaEaten.getNumerator() / pizzaEaten.getDenominator();
      
      //Using that fraction value to multiply the whole area
      double remainingArea = (double) fraction * pizzaShape.getArea();
      
      //Returning the value
      return remainingArea;
    }
    
    /**
     * setShape (Shape s)
     * _____________________________________
     * Sets the shape of the pizza.
     * 
     * PRE: Shape object must be valid.
     * POST: Shape will be updated.
     * 
     * @param Shape s 
     */
    public void setShape (Shape s) throws CloneNotSupportedException, PizzaException
    {
      if (s != null) //If the object is not null
      
        this.pizzaShape = (Shape)s.clone(); //sets the shape
      
      else throw new PizzaException("Invalid Shape object"); //else throws exception      
    }
    
    /**
     * getShape()
     * _____________________________
     * Returns the shape of the pizza.
     * 
     * @return Shape pizzaShape
     */
    public Shape getShape() throws CloneNotSupportedException
    {
      return (Shape) pizzaShape.clone();
    }
    
    /**
     * addIngredient (Ingredient a)
     * ______________________________
     * Adds ingredient to the pizza.
     * 
     * PRE: Ingredient must be a valid object.
     * POST: Ingredient will be added.
     * 
     * @param Ingredient a
     */
    public void addIngredient (Ingredient a) throws CloneNotSupportedException, PizzaException
    {
      if (a != null) //If object is not null
      {
        //Inserts ingredient to the list using the first available index:
        this.listOfIngredients.insert(a, this.index);
        //Then updates index:
        this.index++;
        //Updates calories using ingredient calories:
        this.calorieCount += a.getCalories();
        //Updates cost using ingredient cost:
        this.costOfIngredients.add(a.getCost());
      }
      else throw new PizzaException ("Invalid Ingredient object.");
    }
    
    /**
     * eatSomePizza(Fraction amt)
     * ________________________________________
     * Subtracts the fraction of the pizza eaten 
     * from the pizza pie.
     * 
     * PRE: Fraction must be a valid object.
     * POST: Some pizza will be eaten.
     * 
     * @param Fraction amt
     */
    public void eatSomePizza(Fraction amt) throws PizzaException
    {
      if (amt != null && amt.getNumerator() != 0 && amt.getDenominator() != 0)
      //If the object is not null and numerator and denominator are not 0
      {
        
        //Calculating new numerator:
        int num = (this.pizzaEaten.getNumerator() * amt.getDenominator()) - 
        (amt.getNumerator() * this.pizzaEaten.getDenominator());
        //Calculating new denominator:
        int den = this.pizzaEaten.getDenominator()*amt.getDenominator();
        //Setting them to pizzaEaten:
        if (this.pizzaEaten.getNumerator() < 0) //If remaining numerator is less than 0:
        {
            throw new PizzaException ("Too little pizza was left. The rest of"+
            " the pizza has been eaten. If still hungry - choose another one!");
            
        }
        else
        {
        this.pizzaEaten.setNumerator(num);
        this.pizzaEaten.setDenominator(den);
        //Previous attempts:
        /*
        int commonDenominator = (this.pizzaEaten.getDenominator()*amt.getDenominator());        
        //System.out.println("Common den " + commonDenominator);
        int currentNumerator = this.pizzaEaten.getNumerator() * commonDenominator;
        //System.out.println("Current numerator " + currentNumerator);
        int anotherNumerator = amt.getNumerator();
        //System.out.println("Another numerator " + anotherNumerator);
        int remainingNumerator = currentNumerator - anotherNumerator;
        //System.out.println("Remaining numerator " + remainingNumerator)*/;
        
        }
        if (num < 0) //If remaining numerator is less than 0:
        {
            throw new PizzaException ("Too little pizza left.");
        }
        else if (num == 0) //If it's 0:
        {
            this.pizzaEaten = new Fraction (0, 1); //Since denominator can't be 0
            throw new PizzaException ("Whole pizza has been eaten. No more left!");
        }
        else //If valid fraction is still left:
        {
          //Updating pizzaEaten object with the new numerator and denominator:
          this.pizzaEaten = new Fraction (num, den);
            //System.out.println("new fraction" + pizzaEaten.getNumerator() + "" + pizzaEaten.getDenominator());
          //Getting the fraction again (to make sure that it worked):
          double fraction = (double)(pizzaEaten.getNumerator())/(pizzaEaten.getDenominator());
            //System.out.println("fraction to multiply " + fraction);
          //Updating cost:
          double pizzaCost = this.costOfIngredients.getMoney() * fraction * 100; 
            //System.out.println("pizza cost double " + pizzaCost);
          //Converting it to cents and dollars:
          int cents = (int) pizzaCost % 100;
          int dollars = (int) pizzaCost / 100;
          //Updating it with Money object:
          this.costOfIngredients = new Money (dollars, cents);
        }
      }
      else throw new PizzaException("Invalid fraction.");
    }
    
    
    @Override
    /**
     * compareTo(Object o)
     * _______________________________
     * Compares Pizza object to another object
     * by cost as required per homework assignment.
     * Returns -1 if the object has less money than
     * comparable object, 0 of they're the same and 
     * 1 if current object has more money.
     * 
     * PRE: Object o must be valid.
     * POST: Will return compared value.
     * 
     * @param Object o
     * @return int -2, -1, 0, 1
     */
    public int compareTo(Object o)
    {
      if (this.getClass().equals(o.getClass())) //If they're of the same type
      {
        Pizza other = (Pizza) o; //Object is then typecasted to Pizza
        if (this.getCost().compareTo(other.getCost()) < 0) //Cost is compared
        {
          return -1; //appropriate value is returned
        }
        else if (this.getCost().compareTo(other.getCost()) == 0)
        {
          return 0;
        }
        else
          return 1;
      }
      return -2;
    }
    
    @Override
    /**
     * compareTo(Object o)
     * _______________________________
     * Compares Pizza object to another object
     * by size as required per homework assignment.
     * Returns -1 if the object has less money than
     * comparable object, 0 of they're the same and 
     * 1 if current object has more money.
     * 
     * PRE: Object o must be valid.
     * POST: Will return compared value.
     * 
     * @param Object o
     * @return int -2, -1, 0, 1
     */
    public int compareToBySize(Object o)
    {
      if (this.getClass().equals(o.getClass())) //If they're of the same class
      {
        Pizza other = (Pizza) o; //Object is typecasted to Pizza
        if (this.getRemainingArea() < other.getRemainingArea()) //then 
        //compared by area and appropriate values are assigned:
        {
          return -1;
        }
        else if (this.getRemainingArea() == other.getRemainingArea())
        {
          return 0;
        }
        else return 1;
      } else
        return -2;
    }    //a.k.a. compareToByAreaLeft
    
    @Override
    /**
     * compareTo(Object o)
     * _______________________________
     * Compares Pizza object to another object
     * by calories as required per homework assignment.
     * Returns -1 if the object has less money than
     * comparable object, 0 of they're the same and 
     * 1 if current object has more money.
     * 
     * PRE: Object o must be valid.
     * POST: Will return compared value.
     * 
     * @param Object o
     * @return int -2, -1, 0, 1
     */
    public int compareToByCalories(Object o) 
    {
      if (this.getClass().equals(o.getClass())) //If they're of the same class
      {
        Pizza other = (Pizza) o; //Object is typecasted to Pizza
        if (this.getCalories() < other.getCalories()) //then 
        //compared by calories and appropriate values are assigned:
        {
          return -1;
        }
        else if (this.getCalories() == other.getCalories())
        {
          return 0;
        }
        else return 1;
     } else
        return -2;
    }
    
    @Override
    /**
     * toString()
     * _________________________
     * Returns a String representation of a pizza.
     * 
     * @return String s
     */
    public String toString()
    {
       String s = "";
       //Only need two digits ofr area:
       String areaDouble = String.format("%.2f",this.getRemainingArea());
       
       s = this.pizzaShape.toString() + " in pizza with an area of " + areaDouble +
       ", these toppings: "+ this.listOfIngredients.toString()
       + " that costs " + this.costOfIngredients.toString() + " with " + this.calorieCount + 
       " calories that has " + this.pizzaEaten.toString() + " of a pizza left." +"\n";
       return s;
    }
    
    /*public static void main (String[] args) throws CloneNotSupportedException, PizzaException
    {        
        Pizza test = new Pizza();
        test.getRandomPizza();
        System.out.println(test);
        Color black = new Color (255, 255, 255);
        Goat addon = new Goat ("ew", new Money (0, 50), 100);
        test.addIngredient(addon);
       Fraction testf = new Fraction (1, 2);
        System.out.println(test);
        try
        {
          test.eatSomePizza(testf);
        }
        catch (PizzaException e)
        {
          System.out.println(e);
        }
        System.out.println(test);
       // Color black = new Color (255, 255, 255);
       // Goat addon = new Goat ("ew", new Money (0, 50), 100);
        test.addIngredient(addon);
        System.out.println(test);
        Olive testOlive = new Olive ("canned", new Money (0, 50), 100, black);
        test.addIngredient(testOlive);
        System.out.println(test);
        //System.out.println(test.getRemainingArea());
    }*/
}
