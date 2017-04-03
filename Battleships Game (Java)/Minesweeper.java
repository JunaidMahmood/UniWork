/**
 * extends from the Battleship class and allows its own row and number of parts to be passed through
 * also contains its own method
 */

public class Minesweeper extends Battleship {

    public Minesweeper(int row, int numberOfParts) {

        super(row, numberOfParts);
    }

    /**
     * hit method which randomly creates a number giving a 50% chance of the hit successfully destroying the part
     * providing the correct values are supplied
     */
    public boolean hit(int row, int column) {

        double number = Math.random();

        for (int i = 0; i < getParts().size(); i++) {

            // if number is greater than 0.5 then destroy
            if (number > 0.5) {

                getParts().get(i).setDestroyed(true);
                getParts().get(i).isDestroyed();
                return true;

            } else {

                getParts().get(i).setDestroyed(false);
                getParts().get(i).isDestroyed();
            }
        }

        return false;
    }
}


