package preliminaries;

import java.awt.Dimension;
import java.util.Observable;

import preliminaries.Coordinates;

import javax.swing.event.ChangeListener;

public class Model extends Observable{

    /* Here we added a required take off speed, required Elevation to take off
	and take off time to start elevating because not all planes are the same model and may differ.*/
    private int takeOffSpeed;
    private int speed;
    private int maxSpeed;
    private int requiredElevation;
    private Coordinates coordinates;
    private double elevation;
    private int takeOffTime;
    private boolean simulation;

    public Model(int maxSpeed, int takeOffSpeed, Coordinates coordinates, int takeOffTime, int requiredElevation) {
        this.maxSpeed = maxSpeed;
        this.coordinates = coordinates;
        this.takeOffSpeed = takeOffSpeed;
        this.takeOffTime = takeOffTime;
        this.requiredElevation = requiredElevation;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getX() {
        return coordinates.getX();
    }

    public int getY() {
        return coordinates.getY();
    }

    public void setX(int x) {
        x = coordinates.getX();
        //coordinates.setX(x);
        setChanged();
        notifyObservers();
    }

    public void setY(int y) {
        coordinates.setY(y);
        setChanged();
        notifyObservers();
    }

    public String toString() {
        return coordinates + "Speed:" + speed + " Elevation:" + (int)(elevation +0.5);
    }


    // The method that does it all
    public void takeOff(View f, Dimension r) {
        simulation = true;
        int counter = 0;
        int seconds = 0;

        //While loop to make sure the simulation keeps running until we want it to stop
        while (simulation == true) {

            // these lines add the planes information to the gui.
            f.getTextArea().append("Seconds:" + seconds + "\n");
            f.getTextArea().append(this + "\n");
            setY(getY() + speed);
            seconds++;

            // the method that pauses the program for 1 second (1000 milliseconds in a second)
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}

            // This if statement increments the counter if the speed is the required speed but the time since the speed was equal
            // to the take off speed. Basically it waits 5 seconds before increasing the elevation.
            if (speed == takeOffSpeed && counter < takeOffTime) {
                counter++;
                // increases the elevation if the counter is >= takeOffTime
            } else if (speed == takeOffSpeed) {
                elevation ++;
                // Edge case where the pilot reduces the speed as the plane is elevating
            } else if (speed < takeOffSpeed) {
                // Changes the elevation slightly depending on the speed thats changed.
                if ( elevation > 0) {
                    elevation = elevation - (1-0.1*speed);
                }
            }


			/* This if statement makes sure that the elevation of the plane is equal to the required elevation to take off
			and that the plane is in the middle of the runway. If yes then take off is successfull, if not then take off will
			be shown as unsuccessful */
            if (elevation > requiredElevation && getX() == r.getWidth()/2) {
                f.getTextArea().append("Takeoff was successful!");
                simulation = false;
            } else if (getY() > r.getHeight()) {
                f.getTextArea().append("Takeoff was unsuccessful!");
                simulation = false;
            }
        }
    }
}