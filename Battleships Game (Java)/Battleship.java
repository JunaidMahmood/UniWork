/**
 * this is the Battleship class, acts as a parent class for the other ships
 */

import java.util.ArrayList;
import java.util.Objects;

public class Battleship {

    private ArrayList<Part> parts; // list for the parts of the ship
    private int row;
    private int column;

    // pass the number of the parts the ship has and which row it appears
    public Battleship(int row, int numberOfParts){
        this.parts = new ArrayList<Part>();
        this.row = row;
        int column = 0;

        // loops through i as long as its lower than the supplied no of parts so that all parts are add
        for (int i = 0; i < numberOfParts; i++) {
            Part newPart = new Part(row, column);
            parts.add(newPart);
            column++;
        }
    }

    // gets the parts of a ship
    public ArrayList<Part> getParts(){

        return parts;
    }

    /**
     * hit method with takes a supplied row and column and checks whether the parts are already destroyed
     * and compares supplied values with parts coordinates and destroys it if true
     */
    public boolean hit(int row, int column){

        Part newPart2 = new Part(row, column);

        for (int i = 0; i < parts.size(); i++){

            // already destroyed
            if (parts.get(i).isDestroyed() && newPart2.equals(parts.get(i))){
                parts.get(i).isDestroyed();
            }

            // destroys parts
            if (newPart2.equals(parts.get(i))){

                parts.get(i).setDestroyed(true);
                parts.get(i).isDestroyed();
                return  true;
            }
        }

        return false;
    }

    // equals method which checks when the ship is completely destroyed by comparing sizes
    public boolean equals(Object battleShip){

        if (!(battleShip instanceof Battleship)) return false;

        if (parts.size() == ((Battleship)battleShip).parts.size()){

            for (Part part : parts) {

                if (part.isDestroyed()){

                    return false;
                }
            }

            return true;
        }

        return false;
    }

    // toString method which outputs the number of parts in each ship using [ ]
    public String toString(){
        String part = " ";

        for (Part partName : parts){
            part += " " + partName;
        }
        return "\n" + part;
    }
}
