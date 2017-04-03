/**
 * this is the field class, each field contains one type of crop with the same value
 */

import java.util.ArrayList;

public class Field {

    // arraylist for the set of crops the field contains
    private ArrayList<Crop> cropCollection;
    private int totalValue = 0;

    public Field(String type, int value){

        this.cropCollection = new ArrayList<>();

        // the max number of crops the each field can have, when the field is first made, it is possible to add 10 crops of a specified type and value
        for (int i = 0; i < 10; i++){

            plant(type, value);
        }
    }

    /**
     * method allows the specified crops to be add to the field
     */
    public void plant(String type, int value){

        cropCollection.add(new Crop(type, value));
    }

    /**
     * method allows the total value of the crops to be calculated and then removed from the field
     */
    public int harvest(){

        for (int i = 0; i < cropCollection.size(); i++){

            //cycles through all the crops and adds their value to the totalValue
            totalValue = totalValue + cropCollection.get(i).getValue();
        }
        // removes all crops from arraylist once total value is calculated
        cropCollection.removeAll(cropCollection);
        return totalValue;
    }
}
