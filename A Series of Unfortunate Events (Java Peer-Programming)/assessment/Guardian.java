package assessment; // part of the assessment package

public class Guardian extends Person { // this is an extension of the person class
	
    private int distance; // distance variable to determine the distance the relatives are from the banker

    public Guardian(String name, int friendliness, int distance){ // added distance to the constructor as relatives also have distances
        super(name,friendliness);
        this.distance = distance;
    }

    public int getDistance(){ // getter method for distance to access it
        return distance;
    }

    public String toString() { // toString method to represent the fields in a string

        return "[ " + "Name: " + getName() + ", " + " Friendliness: " + getFriendliness() + ", " + " Distance: " + getDistance() + " miles " + "]";
    }
}