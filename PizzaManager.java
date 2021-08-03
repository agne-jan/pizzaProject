
import java.util.Scanner;

/** PizzaManager Skeleton File
 *  CSS 162, Final Project
 * 
 *  This class is a starting point for your final project and is incomplete.
 *  Note that if there are any inconsistencies between this skeleton and
 *  the assignment description, the assignment description controls.
 * 
 *  Author: Rob Nash with edits by Johnny Lin
 */

/**
 * This class has been updated by Agne Januskeviciute
 */
public class PizzaManager {
    /*
     *  TODO: Data definitions here.  
     */
    //List of pizzas and an index to help locate pizzas:
    ArrayList <Pizza> listOfPizzas = new ArrayList<>();
    int index = 0;

    /** 
     * The console interface is defined in the start method 
     * You can exit or extend the code below to accomplish all of 
     * the outcomes defined in the homework document
     */
    public void start() {
        char selection='q';
        
        Scanner foo = new Scanner(System.in);
        
        
        while(true) {
            displayAllPizzas();
            displayInstructions();
            
            
             //foo.nextChar() doesn't exist, so now what?
            selection = foo.next().charAt(0); //First character typed in
            switch(selection) {
                case 'A':    
                case 'a':    System.out.println("Adding a random pizza to the ArrayList<Pizza>.");
                                //todo:
                             try
                             {
                               addRandomPizza();
                             }
                             catch (CloneNotSupportedException e)
                             {
                                System.out.println(e);
                             }
                             catch (PizzaException e)
                             {
                                System.out.println(e);
                             }
                                break;
                case 'H':    
                case 'h':    System.out.println("Adding one hundred random pizzas to the ArrayList<Pizza>.");
                                //todo:
                              try
                             {
                               addAHundredRandomPizzas(); //Calls hundred pizza method
                             }
                             catch (CloneNotSupportedException e)
                             {
                                System.out.println(e);
                             }
                             catch (PizzaException e)
                             {
                                System.out.println(e);
                             }
                                break;                    
                case 'E':    
                case 'e':    System.out.println("Eating a fraction of a pizza. How much? (a/b)");
                                //todo:pizza eating code here                             
                             eatSomePizza(foo); ////Calls pizzaEating method
                                break;            
                case 'P':    
                case 'p':    System.out.println("Sorting pizzas by (P)rice");
                                //todo:
                                sortByPrice(); //Calls sorting method
                                  break;    
                case 'S':    
                case 's':    System.out.println("Sorting pizzas by (S)ize");
                                 //todo:
                                 sortBySize(); //Calls sorting method
                                 break;          
                case 'C':    
                case 'c':    System.out.println("Sorting pizzas by (C)alories");
                                  //todo
                                  sortByCalories(); //Calls sorting method
                                  break;
                case 'B':
                case 'b':    System.out.println("(B)inary search over pizzas by calories(int).  Sorting first.  What calorie count are you looking for?");
                                //todo:
                                int calories = foo.nextInt();
                                //Finds calories
                                binarySearchByCalories(calories);
                                //Also prints the pizza that has those calories:
                                System.out.println("Here's the pizza with the calories chosen:");
                                System.out.println(listOfPizzas.get(binarySearchByCalories(calories))+"\n");                                
                                break;
                                
                case 'Q':
                case 'q':    System.out.println("(Q)uitting!" );
                                //todo:
                             System.exit(0);
                                break;
                default:     System.out.println("Unrecognized input - try again");
            }
        }

    }

    /**
     * eatSomePizza(Scanner keys)
     * ____________________________
     * Allows the user to "eat" some pizza
     * using user input.
     * 
     * @param Scanner keys
     */
    private void eatSomePizza(Scanner keys) 
    {
      //todo:
      //Declaring the new input:
      keys = new Scanner (System.in);
      
      //Creating a new fraction that will be used to "eat" pizza:
      Fraction iWantToEat = new Fraction();
      
      //Reading the fraction (based off of our Fraction homework):
      String fraction = keys.nextLine();
      String[]splitFraction = fraction.split("/");
      
      //Assigning the numerator and denominator:
      int numerator = Integer.parseInt(splitFraction[0]);      
      iWantToEat.setNumerator(numerator);
      int denominator = Integer.parseInt(splitFraction[1]);
      iWantToEat.setDenominator(denominator);
      
      //Asking user which pizza:
      System.out.println("Which pizza would you like to eat? Type in an integer denoting its place in the list:");
      displayAllPizzas();
      
      //Assigning the pizza:
      int keyIndex = keys.nextInt();
      try //Big try-catch for proper pizza choice
      {
        Pizza pizzaToEat = listOfPizzas.get(keyIndex-1);
      
        try
        {
          pizzaToEat.eatSomePizza(iWantToEat); //Invoking the eatSomePizza from
          //Pizza class
        }
        catch (PizzaException e)
        {
          System.out.println(e);        
        } 
      
      
        if (pizzaToEat.getRemainingArea() == 0) //If no more pizza left
        {
          listOfPizzas.remove(keyIndex-1); //the pizza is removed
          this.index = 0; //and the next pizza is assigned to the beginning
          //when invoked
        }
        else if (pizzaToEat.getRemaining().getNumerator() < 0)
        {
          System.out.println("Too little pizza was left. The rest of"+
            " the pizza has been eaten. If still hungry - choose another one!");
          listOfPizzas.remove(keyIndex-1);
          this.index = 0;
        }
      }
      catch (Exception e)
      {
        System.out.println("Invalid pizza choice.");
      }
    }
    
    /**
     * addRandomPizza()
     * ____________________________
     * Adds a random pizza to the list.
     */
    private void addRandomPizza() throws CloneNotSupportedException, PizzaException
    {
      //todo: 
      Pizza randomPizza = new Pizza (); //Creating random pizza with no-arg constructor
      randomPizza.getRandomPizza(); //Modifying with random ingredients
      this.listOfPizzas.insert(randomPizza, index); //Inserting it in the pizza list
      this.index++;//Updating the index
      
    }
    
    /**
     * addAHundredRandomPizzas()
     * _______________________________
     * Adds a hundred random pizzas to the list
     */
    private void addAHundredRandomPizzas() throws CloneNotSupportedException, PizzaException
    {
        //todo: 
      for (int i = 0; i < 100; i++) //It literally adds random pizzas 100 times
      { 
        Pizza randomPizza = new Pizza();
        randomPizza.getRandomPizza();
        listOfPizzas.insert(randomPizza, this.index);
        this.index++;
      }
    }

    /**
     * displayAllPizzas()
     * _____________________________
     * Prints out all the pizzas.
     */
    private void displayAllPizzas() {
        //todo:
        System.out.println(listOfPizzas);
    }

    /**
     * sortByPrice()
     * ____________________________
     * Sorts pizzas by price.
     */
    private void sortByPrice() {  
        //todo:
        //Selection sort. Based on our Lab practice:
        for (int i = 0; i < listOfPizzas.size()-1; i++) //Loops up until
        //the second last item
        {
          int nextMin = i; //assigns the new minimum each time
          for (int j = i+1; j < listOfPizzas.size(); j++)
          //continues to loop from the next unasorted spot
          {
            if (listOfPizzas.get(j).getCost().compareTo(listOfPizzas.get(nextMin).getCost()) < 0)
            //if the object compared is less, the new minimum is j
            {
              nextMin = j;
            }
          }
          //Then objects are swapped:
          listOfPizzas.swap(i, nextMin);
        }
        /*
        for (int i = 1; i < listOfPizzas.size(); ++i)
        {
          Pizza current = listOfPizzas.get(i);
          int secondIndex = i - 1;
          while (secondIndex >= 0 && listOfPizzas.get(secondIndex).getCost().compareTo((current).getCost()) >0)
          {
            listOfPizzas.get(secondIndex + 1);
            listOfPizzas.get(secondIndex+1) = listOfPizzas.get(secondIndex);
            secondIndex = secondIndex - 1;
          }
          listOfPizzas.get(secondIndex + 1) = current;
        }*/
        
    }
    
    /**
     * sortBySize()
     * ____________________________
     * Sorts pizzas by size.
     */
    private void sortBySize() {
        //todo:
        //Selection sort. Based on our Lab practice:
        for (int i = 0; i < listOfPizzas.size()-1; i++) //Loops up until
        //the second last item
        {
          int nextMin = i; //assigns the new minimum each time
          for (int j = i+1; j < listOfPizzas.size(); j++)
          //continues to loop from the next unasorted spot
          {
            if (listOfPizzas.get(j).compareToBySize(listOfPizzas.get(nextMin)) < 0)
            { //if the object compared is less, the new minimum is j
              nextMin = j;
            }
          }
          listOfPizzas.swap(i, nextMin); //Then objects are swapped:
        }
    }
    
    /**
     * sortByCalories()
     * ____________________________
     * Sorts pizzas by calories.
     */
    private void sortByCalories() {
        //todo:
        //Insertion sort. Based on our Lab example and:
        //https://howtodoinjava.com/algorithm/insertion-sort-java-example/
        for (int i = 1; i < listOfPizzas.size(); ++i) //Loops until the
        //end but starting with 1
        {
          Pizza current = listOfPizzas.get(i); //need a comparing object retrieved
          int secondIndex = i - 1; //Second index is always higher as the
          //first one is assumed to be sorted
          while (secondIndex >= 0 && listOfPizzas.get(secondIndex).getCalories() >current.getCalories())
          {
            //Sorts and swaps until all elements are moved to the sorted side:
            listOfPizzas.swap(secondIndex+1, secondIndex);
            secondIndex = secondIndex - 1; //Updating index each time while loops
          }       
        }
        /*for (int i = 0; i < listOfPizzas.size()-1; i++)
        {
          int nextMin = i;
          for (int j = i+1; j < listOfPizzas.size(); j++)
          {
            if (listOfPizzas.get(j).getCalories() < listOfPizzas.get(nextMin).getCalories())
            {
              nextMin = j;
            }
          }
          listOfPizzas.swap(i, nextMin);
        }*/
    }
    
    /**
     * binarySearchByCalories(int cals)
     * _________________________________________
     * Finds calories from the pizza list and
     * returns the index of where it's found.
     * 
     * @param int cals
     * @return int 
     */
    private int binarySearchByCalories(int cals) {
        //todo:
        //Binary search is based on this example:
        //https://www.geeksforgeeks.org/binary-search/
        
        //First it needs to be sorted:
        sortByCalories();
        
        //Declaring left and right side of the list:
        int left = 0; 
        int right = listOfPizzas.size() - 1; //last index is size -1 
        
        while(left <= right) //While left is less or equal to the right
        {
          int middle = left + (right - left) / 2; //middle point is calculated
          if (listOfPizzas.get(middle).getCalories() == cals)
          {
            return middle; //If calories are found in the middle,
            //the index is returned
          }
          
          if (listOfPizzas.get(middle).getCalories() < cals) // if they're
          //less than the calories to be found
          {
            left = middle + 1; //search continues to the left
          }
          else right = middle - 1; //else search continues to the right 
        }
        
        return -1; //if not found returns -1
    }
    
    /**
     * No need to edit functions below this line, unless extending the menu or
     * changing the instructions
     */
    private static final String instructions = "-----------------------\nWelcome to PizzaManager\n-----------------------\n(A)dd a random pizza\nAdd a (H)undred random pizzas\n(E)at a fraction of a pizza\nSort pizzas by (P)rice\nSort pizzas by (S)ize\nSort pizzas by (C)alories\n(B)inary Search pizzas by calories\n(Q)uit\n";

    private void displayInstructions() {
        System.out.println(instructions);    
    }

    /*
     * Notice the one-line main function.
     */
    public static void main(String[] args) {
        new PizzaManager().start();
    }
}
