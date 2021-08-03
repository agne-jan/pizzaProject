
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.lang.*;
import java.awt.geom.*;

/**
 * Class Square has a few methods such as area calculation and side length
 * that has been created for Pizza project.
 * 
 * @author Agne Januskeviciute
 * @date 2020-05-28
 */
public class Square extends Shape
{
    private int side;
    /**
     * Square (int side)
     * ___________________________________________
     * Constructor for class Square that takes an 
     * int as a parameters as required by Shape class.
     * 
     * PRE: side must be a valid positive integer
     * POST: sqare side will be set.
     * 
     * @param int side
     */
    public Square (int side)
    {
        super (0, 0); //As this class is only used for pizza, the initial Shape 
        //coordinates are set to 0.
        this.side = side;
    }
    
    /**
     * Square (Square o)
     * _____________________________________________
     * Copy constructor for class Square.
     * 
     * PRE: Square object to be copied must be valid and not null
     * POST: Square object will be copied
     * 
     * @param Square o
     */
    public Square (Square o)
    {
      super (0,0);
      if (o != null)
      {
        this.side = o.getSide();
      }
      else System.out.println("Invalid Square object.");
    }
    
    /**
     * getSide ()
     * _________________________________________
     * Returns the side of the square.
     * 
     * @return int X
     */
    public int getSide ()
    {
        return this.side;        
    }
    
    @Override 
    
    /**
     * getArea ()
     * _____________________________________
     * This method overrides Shape's getArea
     * method and returns the area of the square.
     * 
     * @return int area
     */
    public double getArea ()
    {
        return this.side*this.side;
    }
    
    @Override
    
    /**
     * draw (Graphics g)
     * _____________________________________
     * This method draws the square using Graphics2D method.
     * Example taken from Spray class that was provided.
     * 
     * PRE: Graphics object must be valid.
     * POST: paints a square on the screen.
     * 
     * @param Graphics g
     */
    public void draw (Graphics g)
    {
      Graphics2D g2d = (Graphics2D) g; //creating Graphics2D object
      
      //setting the values:
      final int x = getX();
      final int y = getY();
      final int side = getSide();
      g2d.setColor(Color.BLUE); //setting colors
      
      //drawing:
      g2d.draw(new Ellipse2D.Double(x, y, side, side));
      g2d.fill(new Ellipse2D.Double(x, y, side, side));
    }   
    
    @Override
    /**
     * toString()
     * __________________________________
     * Overrides toString method and returns
     * representation of this class.
     * 
     * @return String
     */
    public String toString() 
    {
        return "Square " + getSide();
    }
    
    @Override
    /**
     * equals(Object o)
     * ___________________________________
     * Overrides equals method and returns true
     * if objects are the same and false if 
     * they are not.
     * 
     * @return true/false
     */
    public boolean equals(Object o)
    {
        if (o != null && o.toString().equals(this.toString()))
        return true;
        else return false;
    }
    
    @Override
    /**
     * clone()
     * ______________________________________
     * Clones the Square object
     * 
     * @return Square object
     */
    public Object clone() 
    {
      return new Square(this); //Since abstract parent class cannot 
      //have an instance, I'm copying the current class and returning it
    }
    /*
    public static void main (String[] args)
    {
        Square test = new Square (10);
        System.out.println(test);
    }*/
}
