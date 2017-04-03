/**
 * This is the player class, stores data about the player such as the user input name, starting lives and which room they are currently in
 */
public class Player {

    private String name;
    private int lives;
    private Room currentRoom;

    public Player (String name, int lives, Room currentRoom){

        this.name = name;
        this.lives = lives;
        this.currentRoom = currentRoom;
    }

    /**
     * getter method to retrieve the players name
     */
    public String getName(){

        return name;
    }

    /**
     * getter method to get the remaining lives of the player
     */
    public int getLives() {

        return lives;
    }

    /**
     * setter method to assign the number of lives the player gets
     */
    public void setLives(int lives) {

        this.lives = lives;
    }

    /**
     * getter method to get the current room the player is in
     */
    public Room getCurrentRoom() {

        return currentRoom;
    }

    /**
     * setter method to assign the next room if the player chooses the right door
     */
    public void setCurrentRoom(Room currentRoom) {

        this.currentRoom = currentRoom;
    }

    /**
     * Move method which determines whether the monster is in the room or not. Returns a boolean value, which is used in the main loop.
     */
    public boolean move(Room room){

    	boolean roomStatus;

            if (room.getContainsMonster() == true){
                // if monster is in room, return true
            	roomStatus = true;
                return roomStatus;

            } else {
                // otherwise if theres no monster return false
            	roomStatus = false;
                return roomStatus;
            }

    }
}
