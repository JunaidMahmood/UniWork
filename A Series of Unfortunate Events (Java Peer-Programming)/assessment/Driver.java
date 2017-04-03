package assessment; // part of the assessment package

public class Driver {

    public static void main(String[] args) { // main method of the program

        Banker poe = new Banker("Mr Poe"); // created a new object of the Banker

        Guardian josephine = new Guardian("Josephine", 5, 100); // new object of Guardian with name, friendliness and distance passed through 
        Guardian olaf = new Guardian("Olaf", -10, 10); // new object of Guardian with name, friendliness and distance passed through 
        Guardian sir = new Guardian("Sir", 0, 20); // new object of Guardian with name, friendliness and distance passed through 
        Guardian uncleMonty = new Guardian("Uncle Monty", 10, 20); // new object of Guardian with name, friendliness and distance passed through 

        poe.addToList(uncleMonty); // Uncle Monty added to the ArrayList in Banker
        poe.addToList(olaf); // Olaf added to the ArrayList in Banker
        poe.addToList(sir); // Sir added to the ArrayList in Banker
        poe.addToList(josephine); // Josephine added to the ArrayList in Banker

        boolean friendlyRelative = false; // variable to check whether or not the relative is friendly, by default it is set to default can be updated when the condition is met in the while loop

        while(friendlyRelative == false){ // while loop will continue until friendlyRelative equals true
            poe.chooseRelative(); // chooseRelative method is called

            if(poe.compareFriendliness(poe.getCurrentRelative()) == true){ // if true the the while loop will exit and the print statements will be displayed of the suitable relative the children can stay with
                friendlyRelative = true;
                System.out.println(poe.findCurrentName(poe.getCurrentRelative()) + " is the next closest relative... the children move in");
                System.out.println("and " + poe.findCurrentName(poe.getCurrentRelative()) + " is friendly according to " + poe.getName());

            } else { // otherwise the while loop will continue and the print statements will be displayed about the unfriendly relatives not being suitable even though they may be closer

                System.out.println(poe.findCurrentName(poe.getCurrentRelative()) + " is the next closest relative... the children move in");
                System.out.println("but " + poe.findCurrentName(poe.getCurrentRelative()) + " is unfriendly!");
                System.out.println("");
                System.out.println("The children are moving...");
                System.out.println("");
            }
        }
    }
}
