/**
 * this is the farm class which is made of fields and harvesters
 */

import java.util.ArrayList;

public class Farm {

    // arraylist for the number of fields the farm owns
    private ArrayList<Field> numberOfFields;
    // arraylist for the number of harvesters the farm owns
    private ArrayList<Harvester> numberOfHarvesters;
    // field for the profit the farm makes from harvesting the fields
    private int profit;

    public Farm(){

        this.numberOfFields = new ArrayList<>();
        this.numberOfHarvesters =  new ArrayList<>();
    }

    // add a harvester to the harvester arraylist
    public void addHarvester(Harvester harvester){

        numberOfHarvesters.add(harvester);
    }

    // add a field to the field arraylist
    public void addField(Field field){

        numberOfFields.add(field);
    }

    // allows to get the profit the farm makes
    public int getProfit(){

        return profit;
    }

    // allows us to set the profit the farm makes from calculations
    public void setProfit(int profit) {

        this.profit = profit;
    }

    /**
     * the harvest method harvests the fields that the harvesters can reach
     */
    public void harvest(){

        // total capacity all the harvesters
        int totalCapacity = 0;

        // updates the totalCapacity by going through all the harvesters the farm owns and adds their individual capacities together
        for (int h = 0; h < numberOfHarvesters.size(); h++){

            totalCapacity = totalCapacity + numberOfHarvesters.get(h).harvestingCapacity();
        }

        // if the total capacity of the harvesters is less than the number of field the farm owns then the max number of fields the that are harvested is equal to the harvesters capacities
        if (totalCapacity < numberOfFields.size()){

            for (int i = 0; i < totalCapacity; i++){

                // the total profit would therefore updated and would be the harvesters capacities multiplied by total value of the crops from the harvested fields
                setProfit(totalCapacity * numberOfFields.get(i).harvest());
            }
        }

        // if the total capacity is greater or equal to the number of fields then the all the fields are harvested
        else if (totalCapacity >= numberOfFields.size()){

            for (int i = 0; i < numberOfFields.size(); i++){

                // the total profit would therefore be the total number of fields multiplied by the total value of all the crops from all fields
                setProfit(numberOfFields.get(i).harvest() * numberOfFields.size());
            }
        }
    }
}