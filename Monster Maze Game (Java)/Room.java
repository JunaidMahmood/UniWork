/**
 * This is the room class, stores information about the where the monster is, the room names and where the final room is.
 */
public class Room {

    private String name;
    private Room blueDoorRoom;
    private Room redDoorRoom;
    private boolean containsMonster;
    private boolean isFinalRoom;

    // first constructor for the monster room and final room
    public Room (String name, boolean containsMonster, boolean isFinalRoom) {

        this.name = name;
        this.containsMonster = containsMonster;
        this.isFinalRoom = isFinalRoom;
    }

    // second constructor for the two doors
    public Room (String name, Room blueDoorRoom, Room redDoorRoom){
    	
    	this.name = name;
    	this.blueDoorRoom = blueDoorRoom;
        this.redDoorRoom = redDoorRoom;
    }

    /**
     * getter method to get the name of the room
     */
    public String getName() {

        return name;
    }

    /**
     * getter method to access the blue door room
     */
    public Room getBlueDoorRoom() {

        return blueDoorRoom;
    }

    /**
     * getter method to access the red door room
     */
    public Room getRedDoorRoom() {

        return redDoorRoom;
    }

    /**
     * getter method to figure if the room contains the monster
     */
    public boolean getContainsMonster() {

        return containsMonster;
    }

    /**
     * getter method to figure if the room is the last one
     */
    public boolean getFinalRoom() {

        return isFinalRoom;
    }
}
