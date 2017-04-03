/**
 * this is the part class, it can store information about each part of a ship and can carry out actions on the ships
 */
public class Part {

    private int row; //row of the ship part
    private int column; //column of the ship part
    private boolean destroyed; //true or false if the part is destroyed

    // pass through row and column
    public Part(int row, int column) {

        this.row = row;
        this.column = column;
    }

    /**
     * sets the part of the ship to destroyed i.e. true
     *
     */
    public void setDestroyed(boolean destroyed) {

        this.destroyed = destroyed;
    }

    /**
     * confirms whether the ships part is destroyed or not
     *
     */
    public boolean isDestroyed() {

        return destroyed;
    }

    // compares the parts of the ship with the input to see if they match
    public boolean equals(Object part) {

        if (!(part instanceof Part)) return false;

        return row == ((Part) part).row && column == ((Part) part).column;
    }

    // returns hit symbol if isDestroyed returns true and vice versa
    public String toString() {

        String string;

        if (isDestroyed()) {

            string = "[X]";

        } else {

            string = "[ ]";
        }

        return string;
    }
}

