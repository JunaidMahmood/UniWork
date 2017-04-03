/**
 * this is the crop class, it holds the type of crop and its value for each field
 */
public class Crop {

    private String type;
    private int value;

    public Crop(String type, int value) {

        this.type = type;
        this.value = value;
    }

    /**
     * returns the value of each crop
     */
    public int getValue() {

        return value;
    }
}
