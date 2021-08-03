
/**
 * ArrayList class has methods similar to some of the actual ArrayList package
 * as is described in our homework assignment.
 *
 * Any ArrayIndexOutOfBoundsException does not exit the program for testing purposes,
 * just prints the message on the screen so that the remaining tests could be executed.
 * 
 * @author Agne Januskeviciute
 * @date 2020-04-18
 * 
 * UPDATE:
 * 
 * ArrayList has been made generic as per homework requirement.
 * 
 * PRE: All objects must be of the same type.
 * POST: Objects will be added to the list.
 * 
 * @author Agne Januskeviciute
 * @date 2020-05-31
 */
public class ArrayList <T>
{
    //Instance variables
    private Object[]array;
    private int size;
    private int arrayLength;

    /**
     * Constructor for objects of class ArrayList that takes no arguments
     */
    public ArrayList()
    {
        //initialising instance variables
        this.size = 0;
        this.arrayLength = this.size; //I figured that's better than declaring a 100 element array.
        this.array = new Object[arrayLength];
    }
    
    /**
     * Constructor for objects of class ArrayList that takes arrayLength as an argument.
     * Same as built-in ArrayList class.
     * 
     * @param int arrayLength
     */
    public ArrayList(int arrayLength)
    {
        this.size = 0;
        this.arrayLength = arrayLength;
        this.array = new Object[arrayLength];
    }

    /**
     * insert (T someObject, int index)
     * ________________________________________________________
     * This method inserts an object at a specified index and shifts
     * remaining elements as per homework requirement. I used an example from here:
     * https://stackoverflow.com/questions/11638123/how-to-add-an-
     * element-to-array-and-shift-indexes
     *
     * PRE: a valid, not null object must be inserted. If index is not valid,
     * a message is printed to the screen.
     * POST: an element is inserted in the array list and elements are shifted
     * to the right.
     * 
     * @param  Object someObject, int index
     * 
     */
    public void insert(T someObject, int index) throws ArrayIndexOutOfBoundsException
    {
      try
      {
        //If the index is valid, a new array is created:
        Object[] arrayNew = new Object [array.length+1];
        
        //Old array is copied to the new one up until the index:
        for (int i = 0; i < index; i++)
        {
            arrayNew[i] = array[i];
        }
        //A new object is assigned to the index:
        arrayNew[index] = someObject;
        //The rest of objects are copied after the insert:
        for (int i = index; i < array.length; i++)
        {
            arrayNew[i+1] = array[i];
        }
        //Old array is replaced by the new one:
        this.array = arrayNew;
        size++; //Size is also increased as it's inserting, not replacing objects
      }
      catch (ArrayIndexOutOfBoundsException e)
      {
        System.out.println("Invalid index. Array is out of bounds.");
      }
    }
    
    /**
     * remove (int index)
     * _________________________________________________
     * This method removes an object from a specified index
     * and returns the removed object. If index is not valid,
     * an error message is thrown and nothing is returned.
     * The remaining elements are then shifted to fill the empty space.
     * 
     * @param int index
     * @return Object removedObject/null
     */
    public T remove (int index) throws ArrayIndexOutOfBoundsException
    {       
      try //If index is valid, code is executed:
      {
        //Object to be returned:
        T removedObject = (T) array[index]; //Classmate helped with figuring out how to
        //make the object of a type T
        
        //Elements must be shifted back. Creating new array that now will be shorter:
        Object[]arrayNew = new Object[array.length-1];
        //Copying elements up until the index:
        for (int i = 0; i < index; i++)
        {
            arrayNew[i] = array[i];
        }
        //Moving back the elements:
        for (int i = index; i < arrayNew.length; i++)
        {
            arrayNew[i] = array[i+1];
        }
        //Replacing the old array with new:
        this.array = arrayNew;
        size--;//reducing the size of the array:
        return removedObject; //returning the element  
      }
      catch (ArrayIndexOutOfBoundsException e)
      {
        System.out.println("Invalid index. Array is out of bounds.");
        return null;
      }
      
    }
    
    /**
     * size()
     * _____________________________________________
     * This method returns the size of the array.
     * 
     * @return int size;
     */
    public int size()
    {
      return this.size;
    }
    
    @Override
    /**
     * toString()
     * _____________________________________________
     * Overriding the method String and printing the 
     * elements in ArrayList-like fashion with square
     * brackets.
     * 
     * @return String list
     */
    public String toString()
    {
      String list = null;
      if(size > 0) //If array is larger than 0, prints the list of elements:
      {
        list = "";
        //Adding array elements to the string:
        for (int i = 0; i<array.length; i++)
        {
            if(array[i]!=null)
            list +=array[i]+"";
        }
        //Since the last array element does not need a comma, it's replaced with the 
        //bracket:
       // list = list.substring(0, list.length()-2); //removing the two last elements (space and comma)
       // list +=""; //Adding the bracket
        return list;
      }
      else
      {
        //In ArrayList-like fashion, if the array is empty, only the brackets are returned:
        list = "[]";
        return list;
      }
    }
    
    /**
     * isEmpty()
     * ________________________________________
     * This method checks if the list is empty.
     * 
     * @return boolean true/false
     */
    public boolean isEmpty()
    {
        if(size == 0) //since size is counted only as elements are added, if it's 0, then it's empty
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * indexOf (T someObject)
     * _________________________________________________
     * This method returns an index of an object. If such object
     * is not found, it returns -1 as specified in homework requirement.
     * 
     * @param Object someObject
     * @return int indexOfSomeObject
     */
    public int indexOf(T someObject)
    {
        int indexOfSomeObject = -1; //If object is not found, it returns -1
        
        for(int i = 0; i < array.length; i++)
        {
            if(array[i] != null && array[i].equals(someObject))
            //If array index is not empty (otherwise it returned nonsense to me) and at i it 
            //equals another object, the index is set to i:
            {
                indexOfSomeObject = i;
            }        
        }
        return indexOfSomeObject;    
    }
    
    /**
     * equals (ArrayList otherList)
     * _____________________________________________________
     * This method compares two objects and returns true if they
     * match.
     * 
     * @param ArrayList otherList
     * @return boolean true/false
     */
    public boolean equals (ArrayList otherList)
    {
      if(this.size == otherList.size && this.toString().equals(otherList.toString()))
        /* Each element in each class will have its own toString method that represents
         * that class so if I were to compare the strings it should return true if they're
         * the same
         */
      {
        return true;
      }
      else //If neither size nor information matches, method returns false:
      {
        return false;
      }
    }
    
    /**
     * get (int index)
     * ______________________________________________
     * This method returns an object at a specified index.
     * If index is invalid, the method returns null and prints
     * the message.
     * 
     * @param int index
     * @return Object from array/null
     */
    public T get(int index) throws ArrayIndexOutOfBoundsException
    {
      try
      {
        return (T)array[index];  
      }
      catch (ArrayIndexOutOfBoundsException e)
      {
        System.out.println("Invalid index. Array is out of bounds.");
        return null;
      }
    }
    
    /**
     * swap (int idx1, int idx2)
     * ____________________________________
     * This method swaps objects within an 
     * array between the indicated indices.
     * 
     * @param int idx1, int idx2
     */
    public void swap (int idx1, int idx2)
    {
      if (idx1 >= 0 && idx2 >= 0) //If indices are 0 or higher
      {
        T temporary = (T) array[idx1]; //Creating temporary T object to hold first object from the list
        array [idx1] = array [idx2]; //Assigning the second object to the first object's index
        array [idx2] = temporary; //Assigning the temporary object to the second object's index
      } else System.out.println("Invalid index."); //else it's invalid index
    }
    
   /* generics test:
    * 
     public static void main (String[]args) throws Exception
    {
        ArrayList <String> test = new ArrayList<>();
        //Populating the array:
        for(int i=0; i<10; i++)
        {
           test.insert("hi", i);
        }
        for(int i=10; i<20; i++)
        {
           test.insert(1, i);
        }
        System.out.println(test);
     
    }*/
    
    /*Left all the tests I used to check how my methods are working:
     * 
     * public static void main (String[]args) throws Exception
    {
        ////All the tests I could think of:
        //Normal tests that should work:
        ArrayList test = new ArrayList();
        //Populating the array:
        for(int i=0; i<10; i++)
        {
           test.insert(i, i);
        }
        System.out.println(test);
        //Adding a random element
        test.insert(12, 4);
        System.out.println(test);
        //Removing element at index 0:
        System.out.println("Removing object at index 1: "+test.remove(1));
        System.out.println(test);
        System.out.println("ArrayList test size should be 10: "+test.size());
        //Testing size after adding another element:
        test.insert(13, 5);
        System.out.println(test.size());
        System.out.println("ArrayList test size should be 11: "+test.size());
        //Retrieving element:
        System.out.println("Getting element at index 5: " + test.get(5));
        //Test if it's empty:
        System.out.println("Is ArrayList test empty. should be false: "+test.isEmpty());        
        //Index of:
        System.out.println("Index of 12:"+test.indexOf(12));
        System.out.println("Index of 123456: "+test.indexOf(123456));
        //test to check if an empty array is empty:
        ArrayList test1=new ArrayList();      
        System.out.println("Is test1 empty, should be true: " + test1.isEmpty());        
        //Testing equals method:
        ArrayList twin1=new ArrayList();
        for(int i=0; i<10; i++)
           twin1.insert(i, i);
        System.out.println(twin1);
        ArrayList twin2=new ArrayList();
        for(int i=0; i<10; i++)
           twin2.insert(i, i);
        System.out.println(twin2);
        System.out.println("Equals test, should be true:"+twin1.equals(twin2));
        System.out.println(test);
        System.out.println("Not equals test, should be false:" +test.equals(twin2));        
        System.out.println("Empty list: "+test1);
        
        //Methods with errors:
        System.out.println("Testing insert 13 at a negative index:");
        twin1.insert(13, -1);
        System.out.println("Testing twin1 remove random large index:");
        twin1.remove(994);
        System.out.println("Testing twin1 remove element from random large index: "
        + twin1.remove(990));
        System.out.println("Testing retrieving object from invalid index of -1: "+twin1.get(-1));
        twin1.get(-1);
        //Testing a very large ArrayList
        ArrayList veryBigArray=new ArrayList();
        for(int i=0; i<1000; i++)
           veryBigArray.insert(i, i);
        System.out.println(veryBigArray);
    }*/
}
