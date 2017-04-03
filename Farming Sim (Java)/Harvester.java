/**
 * this is the harvester class, a machine to harvest crops
 */

public class Harvester {

    private int fuelTankSize;
    private int topSpeed;

    public Harvester(int fuelTankSize, int topSpeed){

        this.fuelTankSize = fuelTankSize;
        this.topSpeed = topSpeed;
    }

    /**
     * this method determines how many fields a harvester can harvest
     */
    public int harvestingCapacity(){

        int capacity = 0;

        // the number of fields the harvester can harvest is calculated by adding the fuel tank size with the top speed which the updates the capacity
        capacity = capacity + fuelTankSize + topSpeed;
        return capacity;
    }
}
