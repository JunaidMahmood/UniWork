/**
 * This is the Shop class, contains information about the shop such as what products it holds and how many coins it holds
 */

import java.util.ArrayList;
import java.util.TreeMap;

public class Shop {

    private String name;
    private ArrayList<Product> products; // arraylist for products of type Product
    private ArrayList<GoldCoin> coinBox; // arraylist for the coinBox of type GoldCoin
    private TreeMap<String, Integer> customerTotalSpend; // treemap for customer spend, associates customer name with gold coins spent

    /**
     * getter method to retrieve the coin box arraylist
     */
    public ArrayList<GoldCoin> getCoinBox() {
        return coinBox;
    }

    public Shop(String name){

        this.name = name;
        this.products = new ArrayList<Product>(); // initialising arraylist
        this.coinBox = new ArrayList<GoldCoin>(); // initialising arraylist
        this.customerTotalSpend = new TreeMap<String, Integer>(); // initialising tree map
    }

    /**
     * adds a product to the products arraylist
     */
    public void addProduct(Product product){

        products.add(product);
    }

    /**
     * removes a product from the product arraylist
     */
    public boolean removeProduct(Product product){

        products.remove(product);
        return true;
    }

    /**
     * searches a supplied product to see if the shop holds it or not
     */
    public Product searchProduct(String name) {

        for (int i = 0; i < products.size(); i++) {

            if (products.get(i).getName().equals(name)) {

                return products.get(i);
            }
        }
        return null;
    }

    /**
     * adds gold coins to the coin box in the store
     */
    public void addGoldCoin(GoldCoin coins){

        coinBox.add(coins);
    }

    /**
     * updates the total spend by the customer after purchasing some items
     */
    public void updateTotalSpend(String customer, int coins){

        customerTotalSpend.put(customer, coins); // associates customer with coins

    }

    /**
     * toString method to form a standard string representation of the Shop class
     */
    public String toString(){

        String product = "";
        for(Product item : products) {
            product += ", " + item.toString();
        }

        return "Shop " + "[" + "name" + " = " + name + "]" + product;
    }

}
