
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.lang.*;
import java.awt.geom.*;

/**
 * Class Circle is a class that inherits Shape data members and methods
 * and draws a circle. 
 *
 * @author Agne Januskeviciute
 * @version 2020-05-04
 * 
 * UPDATE
 * The class has been slightly modified to meet Pizza project requirements.
 * 
 * @author Agne Januskeviciute
 * @version 2020-05-28
 */
public class Circle extends Shape
{
    //instance variables:
    private final double PI = Math.PI; //PI cannot be changed ever.
    private double radius = 10;
    
    /**
     * Circle ()
     * ___________________________________________
     * No-arg constructor for class Circle
     * 
     */
    public Circle ()
    {
        super (0, 0); //Since Circle is used for pizza now, it does not need coordinates
        //anymore
        this.radius = 10;
    }
    
    /**
     * Circle (double radius)
     * ___________________________________________
     * Constructor for class Circle that a double for radius.
     * 
     * PRE: radius must be a valid positive double.
     * POST: radius will be set.
     * 
     * @param double radius
     */
    public Circle (double radius)
    {
        super (0, 0); //
        
        if (radius > 0)
          this.radius = radius;
        else 
        {
           System.out.println("Invalid radius. Setting radius to 10.");
           this.radius = 10;
        }
    }
    
    /**
     * Circle (Circle o)
     * ______________________________
     * Copy constructor for class Circle.
     * 
     * PRE: Circle object must be non null and valid
     * POST: The object will be copied
     * 
     * @param Circle o
     */
    public Circle (Circle o)
    {
      super (0, 0);
      if (o != null)
      {
        this.radius = o.getRadius();
      } else System.out.println("Invalid Circle object.");
    }
    
    /**
     * getRadius ()
     * _________________________________________
     * Returns the radius.
     * 
     * @return double radius
     */
    public double getRadius ()
    {
        return this.radius;        
    }
    
    /**
     * setRadius (double radius)
     * ___________________________________________
     * Sets radius. 
     * 
     * PRE: radius must be a valid positive double.
     * POST: sets the new radius.
     * 
     * @param double radius
     */
    public void setRadius (double radius)
    {
        if (radius > 0)
          this.radius = radius;
        else System.out.println("Invalid radius!");
    }
    
    @Override 
    
    /**
     * getArea ()
     * _____________________________________
     * This method overrides Shape's getArea
     * method and returns the area of the circle.
     * 
     * @return double area
     */
    public double getArea ()
    {
        return this.PI * this.radius * this.radius;
    }
    
    @Override
    
    /**
     * draw (Graphics g)
     * _____________________________________
     * This method draws the Circle using Graphics2D method.
     * Example taken from Spray class that was provided.
     * 
     * PRE: Graphics object must be valid.
     * POST: paints a circle on the screen.
     * 
     * @param Graphics g
     */
    public void draw (Graphics g)
    {
      Graphics2D g2d = (Graphics2D) g; //creating Graphics2D object
      
      //setting the values:
      final int x = getX();
      final int y = getY();
      final double radius = getRadius();
    
      g2d.setColor(Color.BLUE); //setting colors
      
      //drawing:
      g2d.draw(new Ellipse2D.Double(x, y, radius, radius));
      g2d.fill(new Ellipse2D.Double(x, y, radius, radius));
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
        String radius = String.format("%.2f", getRadius());
        return "Circular " + radius;
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
     * Clones the Circle object
     * 
     * @return Circle object
     */
    public Object clone() 
    {
      return new Circle(this); //Since abstract parent class cannot 
      //have an instance, I'm copying the current class and returning it
    }
}
