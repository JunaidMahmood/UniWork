/**
 * This is the product class, stores information about each product
 */
public class Product {

    private String name;
    private int price;

    public Product(String name, int price){

        this.name = name;
        this.price = price;
    }

    /**
     * getter method to retrieve product name
     */
    public String getName(){

        return name;
    }

    /**
     * getter method to retrieve product price
     */
    public int getPrice(){

        return price;
    }

    /**
     * toString method to form a standard string representation of the product class
     */
    public String toString(){

        return "Product " + "[" + "name" + " = " + name + ", " + "price" + " = " + price + "]";
    }
}

