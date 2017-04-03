package model;

import java.util.Observable;

public class Model extends Observable{

    private Coordinates leftPlayer = new Coordinates(1, 275);
    private Coordinates rightPlayer = new Coordinates(875, 275);
    private int x;
    private int velX;
    private int y;
    private int velY;
    private String [] numbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    private int scoreNumberLeft ;
    private int scoreNumberRight ;
    private boolean winP1 = false;
    private boolean winP2 = false;
    private String scoreLeft = "src/numberImages/" + numbers[scoreNumberLeft] + ".png";
    private String scoreRight = "src/numberImages/" + numbers[scoreNumberRight] + ".png";

    public Model(){

        x = 460;
        velX = 1;
        y = 300;
        velY = 1;
        System.out.println("1");
    }

    public void move(){

        if (winP1 == false && winP2 == false){

            if(y > leftPlayer.getY() &&  y <=leftPlayer.getY() + 110){
                if (x < 50) {

                    velX = -velX;
                    System.out.println("2");
                }
                System.out.println("3");
            }

            x = x + velX;

            if(y > rightPlayer.getY() &&  y <=rightPlayer.getY() + 110){
                if (x > 870) {

                    velX = -velX;
                    System.out.println("4");
                }
                System.out.println("12");
            }

            x = x + velX;
        }


        if (y < 0 || y > 590) {


            velY = -velY;
            System.out.println("5");
        }

        y = y + velY;

        if (x > 920){

            x = 460;
            y = 300;
            if(scoreNumberLeft != 10) {
                scoreNumberLeft++;
                System.out.println("6");
            }
            scoreRight = "src/numberImages/" + numbers[scoreNumberLeft] + ".png";
            System.out.println("7");
        }

        if (x < 0){

            x = 460;
            y = 300;

            if(scoreNumberRight != 10){
                scoreNumberRight ++ ;
                System.out.println("8");
            }

            scoreLeft = "src/numberImages/" + numbers[scoreNumberRight] + ".png";
            System.out.println("9");
        }

        if(scoreNumberRight == 10 && winP2 == false){
            winP2 = true;
            velY = 0;
            velX = 0;
            System.out.println("10");
        }

        if(scoreNumberLeft == 10 && winP1 == false){
            winP1 = true;
            velY = 0;
            velX = 0;
            System.out.println("11");
        }

        setChanged();
        notifyObservers();
    }

    public boolean getWinP1(){

        return winP1;
    }

    public boolean getWinP2(){

        return winP2;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;

        setChanged();
        notifyObservers();
    }


    public void setRightPlayerMove (String direction) {
        if (direction.equals("up")){
            if (getYposRightPlayer() > 30){
                setYposRightPlayer( getYposRightPlayer() - 75);
            }
            System.out.println("a");
        }
        if (direction.equals("down")){
            if (getYposRightPlayer() < 490) {
                setYposRightPlayer(getYposRightPlayer() + 75);
            }
            System.out.println("b");
        }

        setChanged();
        notifyObservers();
    }

    public void setLeftPlayerMove (String direction) {
        if (direction.equals("up")){
            if (getYposLeftPlayer() > 30) {
                setYposLeftPlayer(getYposLeftPlayer() - 75 );
            }
            System.out.println("c");
        }

        if (direction.equals("down")){
            if (getYposLeftPlayer() < 490) {
                setYposLeftPlayer(getYposLeftPlayer() + 75);
            }
            System.out.println("d");

        }

        setChanged();
        notifyObservers();
    }

    public void setYposLeftPlayer (int y) {
        leftPlayer.setY(y);
    }

    public void setYposRightPlayer (int y) {
        rightPlayer.setY(y);
    }

    public int getYposLeftPlayer () {
        return leftPlayer.getY();
    }

    public int getXposLeftPlayer () {
        return leftPlayer.getX();
    }

    public int getYposRightPlayer () {
        return rightPlayer.getY();
    }

    public int getXposRightPlayer () {
        return rightPlayer.getX();
    }

    public String getScoreLeft(){
        return scoreLeft;
    }

    public String getScoreRight(){
        return scoreRight;
    }
}