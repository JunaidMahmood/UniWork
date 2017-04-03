/**
 * This is the Customer class, hold information about the customer such as name and how much is in his purse
 */

import java.util.ArrayList;

public class Customer {

    private String name;
    private ArrayList<Product> shoppingBasket; // arraylist for shopping basket of type Product
    private ArrayList<Product> ownedProducts; // arraylist for owned products of type product
    private ArrayList<GoldCoin> purse; // arraylist for purse of type goldcoin

    public Customer(String name) {

        this.name = name;
        this.shoppingBasket = new ArrayList<Product>(); // initialising arraylist
        this.ownedProducts = new ArrayList<Product>(); // initialising arraylist
        this.purse = new ArrayList<GoldCoin>(); // initialising TreeMap
    }

    /**
     * getter method for getting customers name
     */
    public String getName() {

        return name;
    }

    /**
     * getter method for purse
     */
    public ArrayList<GoldCoin> getPurse() {

        return purse;
    }

    /**
     * getter method for shopping basket
     */
    public ArrayList<Product> getShoppingBasket() {

        return shoppingBasket;
    }

    /**
     * adds products to the shopping basket
     */
    public void addToShoppingBasket(Product product) {
        shoppingBasket.add(product);

    }

    /**
     * removes the product from the customers shopping basket and returns positive if found
     */
    public boolean removeFromShoppingBasket(Product product) {

        if (shoppingBasket.contains(product)) {

            shoppingBasket.remove(product);
            return true;

        } else {

            return false;
        }
    }

    /**
     * searches shopping basket for a particular item
     */
    public Product searchShoppingBasket(String name) {

        for (int i = 0; i < shoppingBasket.size(); i++) {

            if (shoppingBasket.get(i).getName().equals(name)) {

                return shoppingBasket.get(i);
            }
        }
        return null;
    }

    /**
     * adds purchased products to the pirates owned items
     */
    public void addOwnedProduct(Product product) {

        ownedProducts.add(product);
    }

    /**
     * adds coins to the pirates purse
     */
    public void addCoin(GoldCoin coins) {

        purse.add(coins);
    }

    /**
     * this method purchases the products in the pirates basket, by checking if there are sufficient funds available
     */
    public boolean purchaseProducts(Shop shop) {

        int totalCost = 0;

        for (int i = 0; i < shoppingBasket.size(); i++) {
            totalCost = totalCost + shoppingBasket.get(i).getPrice();
        }

        if (totalCost < purse.size()) {

            for (int i = 0; i < totalCost; i++) {

                shop.addGoldCoin(purse.get(i));
                purse.remove(i);
            }

            for (int i = 0; i < shoppingBasket.size(); i++) {

                addOwnedProduct(shoppingBasket.get(i));
                shoppingBasket.remove(i);
            }

            return true;
        }else
            System.out.println("not enough funds");

        return false;
    }
}
