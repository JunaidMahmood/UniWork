/**
 * this is the board class, creates the board and adds the ships to it
 */

import java.util.ArrayList;

public class Board {

    // list for the ships
    private ArrayList<Battleship> ships;

    public Board(){

        this.ships = new ArrayList<Battleship>();
        ships.add(new Battleship(0,5)); // add ship to ships list with supplied row and number of parts
        ships.add(new Cruiser(1, 4)); // add ship to ships list with supplied row and number of parts
        ships.add(new Cruiser(2, 4)); // add ship to ships list with supplied row and number of parts
        ships.add(new Frigate(3,3)); // add ship to ships list with supplied row and number of parts
        ships.add(new Minesweeper(4,2)); // add ship to ships list with supplied row and number of parts
    }

    //getter method for getting ships in ships list
    public ArrayList<Battleship> getShips(){

        return ships;
    }

    // getter method for getting battleship at index 0
    public Battleship getBattleship(){

        return ships.get(0);
    }

    // getter method for getting first cruiser at index 1
    public Battleship getCruiser(){

        return ships.get(1);
    }

    // getter method for getting second cruiser at index 2
    public Battleship getCruiser2(){

        return ships.get(2);
    }

    // getter method for getting frigate at index 3
    public Battleship getFrigate(){

        return ships.get(3);
    }

    // getter method for getting minesweeper at index 4
    public Battleship getMinesweeper(){

        return ships.get(4);
    }

    // hit method which checks whether supplied row and column match up with actual coordinates of the ships part
    public boolean hit(int row, int column){

        // checks all ships in the list
        for (Battleship shipCheck : ships){

            if (shipCheck.hit(row, column)){

                //returns true so hit can take place
                return true;
            }
        }

        return false;
    }

    // prints out the board with the all the ships using getter methods, manually added blanks
    public String toString(){

        return "\n " + getBattleship() + getCruiser() + " [ ] " + getCruiser2() + " [ ] " + getFrigate() + " [ ] " + "[ ] " + getMinesweeper() + " [ ] " + "[ ] " + "[ ]" ;
    }
}
