/**
 * This is the gold coin coin class, it represents the coins unique number
 */
public class GoldCoin {

    private int coinNumber;
    private static int numberOfCoins;

    public GoldCoin(){

        numberOfCoins++;// whenever an object is created numberOfCoins is incremented to give a unique number
    }
    /**
     * getter method for numberOfCoins
     */
    public int getCoin(){

        return numberOfCoins;
    }
}
