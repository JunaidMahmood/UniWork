/**
 * This is the plane class where we hold getters and setter for the planes elevation, time in flight, speed and x coordinate.
 */
package CW12;

import CW5.Coordinates;

public class Plane {

    // private variables for the methods
    private int seconds;
    private int speed;
    private int elevation;
    private int timePassed;
    private int sprint;

    // Coordinates instance to access the Coordinates class
    Coordinates coordinates = new Coordinates(5, 0);

    /**
     * getter method for the planes elevation
     */
    public int getElevation() {

        return elevation;
    }

    /**
     * setter method for the planes elevation, when the speed is changed correctly
     */
    public void setElevation(int elevation) {

        this.elevation = elevation;
    }

    /**
     * getter method to retrieve the time the plane is in travel
     */
    public int getTimePassed() {

        return timePassed;
    }

    /**
     * setter method to set the time the plane is in flight
     */
    public void setTimePassed(int timePassed) {

        this.timePassed = timePassed + 1;
    }

    /**
     * setter method to set the x coordinate of the plane when the horizontal slider is changed
     */
    public void setX(int x) {

        coordinates.setX(x);
    }

    /**
     * getter method for the distance the plane has covered on the runway
     */
    public int getSprint() {

        return  sprint;
    }

    /**
     * getter method for the retrieving the speed of the plane at any given time
     */
    public int getSpeed() {

        return speed;
    }

    /**
     * setter method to set the speed of the plane when the throttle slider is changed
     */
    public void setSpeed(int speed) {

        this.speed = speed;
    }

    /**
     *  toString method to represent the plane attributes, which is printed in the text area of the simulator
     */
    public String toString() {

        sprint += speed;

        return "X: " + coordinates.getX() + " Y: " + (sprint) + " Speed: " + speed + " Elevation: " + getElevation() + "\n" + "Seconds: " + seconds++ + "\n";
    }
}
