package assessment; // part of the assessment package

public class Person {

    private String name; // name of person
    private int friendliness; // friendliness level of person

    /**
     * constructor for person class allows values to be set and accessed in the driver class
     */
    public Person(String name, int friendliness) {

        this.name = name;
        this.friendliness = friendliness;
    }

    /**
     * toString method for the person, just displays name and level of friendliness
     */
    public String toString() {

        return "[ " + "Name: " + getName() + ", " + " Friendliness: " + getFriendliness() + " ]";
    }

    /**
     * getter method for level of friendliness 
     */
    public int getFriendliness() {

        return friendliness;
    }

    /**
     * getter method for the name of the person
     */
    public String getName() {

        return name;
    }
}
