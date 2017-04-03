/**
 * this is the combineharvester which extends of the harvester, allows to harvest more fields
 */

public class CombineHarvester extends Harvester {

    // length field for the cutter bar
    private int length;

    public CombineHarvester(int fuelTankSize, int topSpeed, int length){

        // length is add to the constructor so that it can be specified
        super(fuelTankSize, topSpeed);
        this.length = length;
    }

    public int harvestingCapacity(){

        int combineCapacity;

        // adds the length to the method so the capacity can be multiplied by the length
        combineCapacity = super.harvestingCapacity() * length;
        return combineCapacity;
    }
}
