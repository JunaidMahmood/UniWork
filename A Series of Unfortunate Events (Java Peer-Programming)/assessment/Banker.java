package assessment; // part of the assessment package

import java.util.ArrayList; // allows ArrrayLists to be used in this class

public class Banker extends Person{ // the Banker class is an extension of the Person class

    private Guardian currentRelative; // the relative currently assigned as the guardian

    ArrayList<Guardian> list; // creates a new list of the names and friendliness levels f the relatives

    public Banker(String name){ // the constructor for banker

        super(name, 5); // all bankers have a friendliness of 5. the name is set in the same way it is in the person class
        list = new ArrayList<Guardian>(); // each banker has their own list
    }

    public Guardian getCurrentRelative(){

        return currentRelative; // when the method is called the value of current relative is returned
    }
    public int findDistance(int i){ // finds the distance of a relative in a given position on the list
        Guardian x = list.get(i); // gets the guardian from the given position of the ArrayList
        return x.getDistance(); // returns the distance of that relative
    }

    public Person chooseRelative(){ // the method for choosing the closest relative from the list

        int i = 0;
        int x = 0;
        boolean lessThan =false;
        Guardian nextRelative;
        while (i< list.size() && x <list.size()){ // while i and x are both smaller than the number of relatives in the list 
            if (findDistance(i) <= findDistance(x)){ // if the distance of the first relative is less than the distance of the next relative
                lessThan = true; // the value of lessThan becomes true
                x = x + 1; // x is incremented
            } else { // otherwise
                lessThan = false; // the value of lessThan is set as false
                i = i + 1; // i is incremented
                x=0; // x becomes 0
            }
        }

        if (lessThan == true){ // if the value of lessThan is true

            nextRelative = list.get(i); // the Guardian from the list that has the lowest distance becomes the new nextRelative
            currentRelative = nextRelative; // currentRelative becomes the same as nextRelative

            return nextRelative; // nextRelative is returned

        } else {

            return null; // null is returned if no relative is found in the list
        }
    }

    public boolean compareNames(String a, String b){ // this method is used to compare a name to the other names in the ArrayList so it can be put in the right order

        if (a.compareTo(b) <0){ // if string a comes before string b alphabetically

            return true; // then true is returned

        } else {

            return false; // otherwise false is returned
        }

    }
    
    public String findName(int i){ // this method finds the name of a guardian in a given position in the list
        Guardian x = list.get(i); // gets the guardian from the given position
        return x.getName(); // returns the name of that guardian
    }

    public void addToList(Guardian guardian){ // this method adds a new guardian to the list

        if (list.size() == 0){ // if the list is currently empty
            list.add(guardian); // the guardian is added to it

        } else { // otherwise

            int i = 0;
            while (i < list.size()){ // while i is less than the number of items in the ArrayList

                if(compareNames(guardian.getName(), findName(i)) == true){ // this compares the name of the guardian being added to the list with a guardian in position i in the list
                    list.add(i, guardian); //if the new guardians name comes before the compared one alphabetically, it places the new guardian on the list before the compared one
                    i =list.size(); // i becomes equal to the number of items in the array list so that the loop ends

                } else {

                    if( i+1 >= list.size()){ // if the new name comes after the compared name alphabetically
                        list.add(i+1, guardian); // the guardian is added after the compared name
                        i=list.size(); // the loop ends

                    } else {
                        i = i+1; // i is then iterated by 1
                    }
                }
            }
        }
    }

    public boolean compareFriendliness(Guardian newGuardian){ // this method allows us to compare the friendliness of each relative with the bankers, if they meet the banker requirements then we return true

        if (this.getFriendliness() > newGuardian.getFriendliness()){
            list.remove(newGuardian); // if the friendliness is less that the bankers then we remove the relative from the list of relatives

            return false;

        } else {

            return true;
        }
    }
    
    public String findCurrentName(Guardian currentName){ // this method allows us to find the relatives name
    	
    	return currentName.getName();
    	
    }

    public String toString() {

        return "[ " + "Name: " + getName() + ", " + " Friendliness: " + getFriendliness() + " ]"; // to string method to display a string representation of the bankers fields
    }

}
