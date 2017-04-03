/**
 * This is the driver class, containing objects of the room class and player class.
 */

// import Scanner, allows us to take user input
import java.util.Scanner;

public class DoorMazeGame {

    public static void main(String[] args) {
        // Scanner object, variable scan
        Scanner scan = new Scanner(System.in);
        String userInput;

        // room variables, six different room, 5 connected to the monster room
        Room monsterRoom = new Room("The Monster Room", true, false);
        Room room6 = new Room("The Final Chamber", false, true);
        Room room5 = new Room("The Fifth Chamber", monsterRoom, room6);
        Room room4 = new Room("The Fourth Chamber", monsterRoom, room5);
        Room room3 = new Room("The Third Chamber", room4, monsterRoom);
        Room room2 = new Room("The Second Chamber", room3, monsterRoom);
        Room room1 = new Room("The First Chamber", monsterRoom, room2);

        // introduction message for the user, displaying the game rules
        System.out.println("Welcome to MonsterMaze! Play through the maze by selecting either the" +
                " blue or red door, opening the right" + "\n" + "door will allow you to progress to the next room" +
                " but watch out opening the wrong door will unleash the monster" + "\n" + "and a life will be lost!" +
                " You will start in The First Chamber with 2 lives, play through all six Chambers to beat the Monster...");

        System.out.println("");

        // prompting user to input their name
        System.out.println("Ready? Please enter your name...");
        Player newPlayer = new Player(scan.nextLine(), 2, room1);

        System.out.println("");

        // while loop, while player is not in final room and while lives are above 0 then continue looping
        while (!newPlayer.getCurrentRoom().getFinalRoom() && newPlayer.getLives() > 0){

            // game status, player name, lives and current room
            System.out.println("GAME STATUS");
            System.out.println("Name: " + newPlayer.getName());
            System.out.println("Current Lives: " + newPlayer.getLives());
            System.out.println("Current Room: " + newPlayer.getCurrentRoom().getName());
            System.out.println("");
            System.out.println("So... which door will you choose? blue or red?");

            // waits for acceptable user input
        	userInput = scan.nextLine();

            // if the player inputs blue, system checks if monster in blue door room, if so then player loses a life. Otherwise the player will move to the next room
        	if (userInput.equals("blue")){

        		if (newPlayer.move(newPlayer.getCurrentRoom().getBlueDoorRoom()) == true){

        			newPlayer.setLives(newPlayer.getLives() - 1);

                    System.out.println("");
                    System.out.println("OUCH! The monster got you...");
                    System.out.println("You lost a life...");
                    System.out.println("");

                } else if (newPlayer.move(newPlayer.getCurrentRoom().getBlueDoorRoom()) == false){

        			newPlayer.setCurrentRoom(newPlayer.getCurrentRoom().getBlueDoorRoom());

                    System.out.println("");
                    System.out.println("Phew... That was close!");
                    System.out.println("");
                }

                // if the player inputs red, system checks if monster in blue door room, if so then player loses a life. Otherwise the player will move to the next room
        	} else if (userInput.equals("red")){

        		if (newPlayer.move(newPlayer.getCurrentRoom().getRedDoorRoom()) == true){

        			newPlayer.setLives(newPlayer.getLives() - 1);

                    System.out.println("");
                    System.out.println("OUCH! The monster got you...");
                    System.out.println("You lost a life...");
                    System.out.println("");

                } else if (newPlayer.move(newPlayer.getCurrentRoom().getRedDoorRoom()) == false){

        			newPlayer.setCurrentRoom(newPlayer.getCurrentRoom().getRedDoorRoom());

                    System.out.println("");
                    System.out.println("Phew... That was close!");
                    System.out.println("");
                }
        	// if the user inputs anything apart from blue or red then the user will be notified acceptable inputs
        	} else {

                System.out.println("");
                System.out.println("You can only choose a blue or red door (Enter 'blue' or 'red')");
                System.out.println("");
            }

            // if the player loses all lives, then the game is lost
        	if (newPlayer.getLives() == 0){
        		
        		System.out.print("Ooops... I'm afraid the monster got you this time! YOU LOSE");
                System.out.println("");
                System.out.println("GAME STATUS");
                System.out.println("Name: " + newPlayer.getName());
                System.out.println("Ending Lives: " + newPlayer.getLives());
                System.out.println("Final Room: " + newPlayer.getCurrentRoom().getName());
        		
        	}

        	// if the player reaches the final room then the game is won
        	if (newPlayer.getCurrentRoom().getFinalRoom()){
        		
        		System.out.print("Woop Woop! You beat the monster! YOU WIN");
                System.out.println("");
                System.out.println("GAME STATUS");
                System.out.println("Name: " + newPlayer.getName());
                System.out.println("Ending Lives: " + newPlayer.getLives());
                System.out.println("Final Room: " + newPlayer.getCurrentRoom().getName());
        	}
        }
    }
}
