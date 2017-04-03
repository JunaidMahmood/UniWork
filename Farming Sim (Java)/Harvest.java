/**
 * this is the driver class
 */

public class Harvest {

    public static void main(String[] args) {

        // new farm is created
        Farm farm = new Farm();
        // a normal harvester and combine harvester are created
        Harvester harvester = new Harvester(1, 1);
        Harvester harvester2 = new CombineHarvester(2, 2, 3);

        // 4 different crops fields are made with their values
        Field cornField = new Field("corn", 20);
        Field wheatField = new Field("wheat", 20);
        Field oatsField = new Field("oats", 20);
        Field barleyField = new Field("barley", 20);

        // the harvesters are add to the farm
        farm.addHarvester(harvester);
        farm.addHarvester(harvester2);

        // 5 corn fields are add to the farm
        for (int i = 0; i < 5; i++){

            farm.addField(cornField);
        }

        // 5 wheat fields are add to the farm
        for (int i = 0; i < 5; i++){

            farm.addField(wheatField);
        }

        // 5 oats fields are add to the farm
        for (int i = 0; i < 5; i++){

            farm.addField(oatsField);
        }

        // 5 barley farms are add to the farm
        for (int i = 0; i < 5; i++){

            farm.addField(barleyField);
        }

        // the harvest method is called
        farm.harvest();

        // the farms profit is printed
        System.out.println("Farm's profit: " + "\u00A3" + farm.getProfit());
    }
}
