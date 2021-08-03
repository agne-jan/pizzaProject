
/**
 * PizzaException class is an exception class used by PizzaManager
 * to catch errors.
 *
 * @author Agne Januskeviciute
 * @version 2020-05-28
 */
public class PizzaException extends Exception
{
    /**
     * No-arg constructor for class PizzaException.
     */
    public PizzaException()
    {
        super(); //calls the parent class Exception
    }

    /**
     * PizzaException(String m)
     * __________________________________________
     * Constructor for class PizzaException that takes
     * a String and uses it to print the error message.
     * 
     * PRE: Message must be a valid String.
     * POST: The message will be used in an error.
     * 
     * @param String m
     */
    public PizzaException(String m)
    {
        super(m); //calls the parent class Exception
    }
}
