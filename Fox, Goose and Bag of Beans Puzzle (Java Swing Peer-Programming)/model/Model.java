/**
 * this is model class which contains the logic and data of the program, it notifies the observers in the view class of any changes
 */

package model;

import java.util.Observable;

// model can be observed by the view class
public class Model extends Observable{
    private String[] grassRight = new String[4];
    private String[] grassLeft = new String[4];
    private String[] boat = new String[2];
    private String boatDirection;
    private boolean isBoatWest;
    private boolean winCondition = false;
    private boolean lossCondition = false;
    private int counter;

    public Model() {
        grassRight[0] = "fox";
        grassRight[1] = "goose";
        grassRight[2] = "bean";
        grassRight[3] = "farmer";
    }

    // allows to the boat to move left depending on the conditions
    public void moveLeft(String item) {

        // this allows the boat to move left if the farmer is on it
        if (item == "boat") {
            if (boat[0] == "farmer") {
                boatDirection = "left";
            }
        }

        // case if farmer
        else if (item == "farmer") {
            if (boat[0] == "farmer" && isBoatWest == true && boat [1] == null) {
                grassLeft[3] = "farmer";
                boat[0] = null;
            }
            for (int i = 0; i < grassRight.length; i++) {
                if (item == grassRight[i]) {
                    boatDirection = "right";
                    boat[0] = "farmer";
                    grassRight[i] = null;
                }
            }

            // case if fox
        } else if (item == "fox") {
            if (boat[1] == "fox" && isBoatWest == true) {
                grassLeft[0] = "fox";
                boat[1] = null;
            }
            else if (boat[1] == null) {
                for (int i = 0; i < grassRight.length; i++) {
                    if (item == grassRight[i]) {
                        boatDirection = "right";
                        if (boat[0] == "farmer") {
                            boat[1] = "fox";
                            grassRight[i] = null;
                        }
                    }
                }
            }

            // case if goose
        } else if (item == "goose") {
            if (boat[1] == "goose" && isBoatWest == true) {
                grassLeft[1] = "goose";
                boat[1] = null;
            } else if (boat[1] == null) {
                for (int i = 0; i < grassRight.length; i++) {
                    if (item == grassRight[i]) {
                        boatDirection = "right";
                        if (boat[0] == "farmer") {
                            boat[1] = "goose";
                            grassRight[i] = null;
                        }
                    }
                }
            }

            // case if bean
        } else if (item == "bean") {
            if (boat[1] == "bean" && isBoatWest == true) {
                grassLeft[2] = "bean";
                boat[1] = null;
            } else if (boat[1] == null) {
                for (int i = 0; i < grassRight.length; i++) {
                    if (item == grassRight[i]) {
                        boatDirection = "right";
                        if (boat[0] == "farmer") {
                            boat[1] = "bean";
                            grassRight[i] = null;
                        }
                    }
                }
            }
        }

        setChanged();
        notifyObservers();
    }

    // allows to the boat to move right depending on the conditions
    public void moveRight(String item) {
        if (item == "boat") {
            if (boat[0] == "farmer") {
                boatDirection = "right";
            }

        } else if (item == "farmer") {
            if (boat[0] == "farmer" && isBoatWest == false && boat [1] == null) {
                grassRight[3] = "farmer";
                boat[0] = null;
            }
            for (int i = 0; i < grassLeft.length; i++) {
                if (item == grassLeft[i]) {
                    boatDirection = "left";
                    boat[0] = "farmer";
                    grassLeft[i] = null;
                }
            }

        } else if (item == "fox") {
            if (boat[1] == "fox" && isBoatWest == false) {
                grassRight[0] = "fox";
                boat[1] = null;
            }
            else if (boat[1] == null) {
                for (int i = 0; i < grassLeft.length; i++) {
                    if (item == grassLeft[i]) {
                        boatDirection = "left";
                        if (boat[0] == "farmer") {
                            boat[1] = "fox";
                            grassLeft[i] = null;
                        }
                    }
                }
            }

        } else if (item == "goose") {
            if (boat[1] == "goose" && isBoatWest == false) {
                grassRight[1] = "goose";
                boat[1] = null;
            }
            else if (boat[1] == null) {
                for (int i = 0; i < grassLeft.length; i++) {
                    if (item == grassLeft[i]) {
                        boatDirection = "left";
                        if (boat[0] == "farmer") {
                            boat[1] = "goose";
                            grassLeft[i] = null;
                        }
                    }
                }
            }

        } else if (item == "bean") {
            if (boat[1] == "bean" && isBoatWest == false) {
                grassRight[2] = "bean";
                boat[1] = null;
            }
            else if (boat[1] == null) {
                for (int i = 0; i < grassLeft.length; i++) {
                    if (item == grassLeft[i]) {
                        boatDirection = "left";
                        if (boat[0] == "farmer") {
                            boat[1] = "bean";
                            grassLeft[i] = null;
                        }
                    }
                }
            }
        }

        setChanged();
        notifyObservers();

    }

    // determines whether the player and won or lost the game
    public void winOrLoss() {
        lossCondition = false;
        winCondition = false;
        // does this via finding out if goose and fox or goose and bean are left on one side or the other
        for (int i = 0; i < grassLeft.length; i++) {
            if (grassRight[i] == "goose") {
                for (int c = 0; c < grassRight.length; c++) {
                    if (grassRight[c] == "bean" ||  grassRight[c] == "fox") {
                        if (boat[0] == "farmer" && isBoatWest == true) {
                            lossCondition = true;
                        }
                    }
                }

            } else if (grassLeft[i] == "goose") {
                for (int c = 0; c < grassLeft.length; c++) {
                    if (grassLeft[c] == "fox" || grassLeft[c] == "bean") {
                        if (boat[0] == "farmer" && isBoatWest != true) {
                            lossCondition = true;
                        }
                    }
                }
                // the legendary win condition
            } else if (grassLeft[0] == "fox" && grassLeft[1] == "goose" && grassLeft[2] == "bean" && grassLeft[3] == "farmer") {
                winCondition = true;
            }
        }

        setChanged();
        notifyObservers();
    }

    public String getDirection() {

        return boatDirection;
    }

    public void boatLeft(boolean isBoatWest) {

        this.isBoatWest = isBoatWest;
    }

    public String[] getGrassRight() {

        return grassRight;
    }

    public String[] getGrassLeft() {

        return grassLeft;
    }

    public String[] getBoat() {

        return boat;
    }

    // Cutting the work in half by returning just one condition
    public boolean getCondition() {
        if (winCondition == true || lossCondition == true) {
            return true;

        } else {
            return false;
        }
    }

    public void decrementCounter() {

        counter -= 1;
    }

    public int getCounter() {

        return counter;
    }
}
