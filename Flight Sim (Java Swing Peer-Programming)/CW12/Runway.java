/**
 *  this is the runway class, we have imported the Java Rectangle class as a template for the runway, were we can set the width and length of the runway
 */
package CW12;

import java.awt.Rectangle;

public class Runway extends Rectangle {

    // dimensions of the rectange set in the constructor
    public Runway() {

        super.setSize(10 , 100);
    }

    /**
     * getter method for the length/height of the runway
     */
    public double getHeight() {

        return height;
    }
}
