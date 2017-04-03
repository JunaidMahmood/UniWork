/**
 * this is the driver class which contains the main loop
 */

import java.util.Collections;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {

        // new board is created
        Board board = new Board();

        // int holding frequency of battleships
        int battleshipFrequency = Collections.frequency(board.getShips(), board.getBattleship());

        // int holding frequency of cruisers
        int cruiserFrequency = Collections.frequency(board.getShips(), board.getCruiser());

        // int holding frequency of frigate
        int frigateFrequency = Collections.frequency(board.getShips(), board.getFrigate());

        // int holding frequency of minesweeper
        int minesweeperFrequency = Collections.frequency(board.getShips(), board.getMinesweeper());

        Scanner in = new Scanner(System.in); // user input
        String userInput = " ";
        int row;
        int column;

        System.out.println("Welcome to Battleships!");

        // loop while user input does not equal quit
        while (!(userInput.equals("quit"))){

            // prints all the occurrences of the ships
            System.out.println("Battleships: " + battleshipFrequency);
            System.out.println("Cruisers: " + (cruiserFrequency));
            System.out.println("Frigates: " + frigateFrequency);
            System.out.println("Minesweepers: " + minesweeperFrequency);
            System.out.println("");
            System.out.println("Please enter your row and column on a single line with a space in between:");
            // displays the board
            System.out.println(board);

            //userInput = in.next();

            // takes the first integer as row
            row = in.nextInt();
            // takes the second integer as column
            column = in.nextInt();

            if (board.hit(row, column)){
                //System.out.println(board.hit(row, column));
                board.hit(row, column);
                System.out.println("Hit!");

            } else {
                //System.out.println(board.hit(row, column));
                //board.hit(row, column);
                System.out.println("Miss!");
            }
        }

        in.close();
    }
}
