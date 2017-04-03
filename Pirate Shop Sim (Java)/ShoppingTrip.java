/**
 * This is the Driver class, contains objects of customer, shop and product classes and main loop.
 */

import java.util.Scanner;

public class ShoppingTrip {

    public static void main(String[] args) {

        // creates new product
        Product product1 = new Product("Diamond", 40);
        System.out.println(product1);

        // creates new product
        Product product2 = new Product("Crown Jewels", 100);
        System.out.println(product2);

        // creates new product
        Product product3 = new Product("Silver Locket", 60);
        System.out.println(product3);

        // creates new shop
        Shop shop = new Shop("Hidden Hideaway");

        // adds 125 coins to the coin box in the shop
        for (int i = 0; i < 125; i++){
            shop.addGoldCoin(new GoldCoin());
        }

        // adds all three products to the shops stock
        shop.addProduct(product1);
        shop.addProduct(product2);
        shop.addProduct(product3);

        System.out.println("");
        System.out.println(shop.toString() + ", Gold Coins" + " [" + shop.getCoinBox().size() + "]"); // standard string representation of the product class

        // creates new customer
        Customer blackBeard = new Customer("BlackBeard");

        // adds 100 coins to the pirates purse
        for (int i = 0; i < 100; i++){
            blackBeard.addCoin(new GoldCoin());
        }

        System.out.println("Customer's name" + " [" + blackBeard.getName() + "]" + ", " + "Gold Coins in Purse" + " [" + blackBeard.getPurse().size() + "]" ); // standard string representation of the customer class

        Scanner in = new Scanner(System.in); // user input
        String userInput = "";

        System.out.println("");
        System.out.println("Welcome to the Hidden Hideaway! Browse away with our marvellous selection of jewellery..."); // intro message
        System.out.println("");

        // main loop
        while (!userInput.equals("exit")){

            // information displayed every time it loops
            System.out.println("");
            System.out.println("Products in the shop are: "  );
            System.out.println(product1);
            System.out.println(product2);
            System.out.println(product3);
            System.out.println("");
            System.out.println("Items in your shopping basket: ");
            System.out.println(blackBeard.getShoppingBasket().toString());
            System.out.println("");
            System.out.println("Coins in your wallet: ");
            System.out.println(blackBeard.getPurse().size());
            System.out.println("");
            System.out.println("Please enter: 'add product' to add a product your basket or, ");
            System.out.println("Please enter: 'remove product' to remove a product from your basket or, ");
            System.out.println("Please enter: 'purchase' to purchase all the products in the shopping basket or, ");
            System.out.println("Please enter: 'exit' if you want to leave");

            //waits for user input
            userInput = in.nextLine();

            // if user enters add product, it asks for product name and if found adds it to the shopping basket otherwise an error message is displayed
            if (userInput.equals("add product")) {

                System.out.println("Enter name of product (case sensitive) : ");
                userInput = in.nextLine();

                if (shop.searchProduct(userInput) != null) {

                    blackBeard.addToShoppingBasket(shop.searchProduct(userInput));
                    shop.removeProduct(shop.searchProduct(userInput));
                    System.out.println("We've found your product! It's in your basket...");
                    System.out.println("");

                } else {

                    System.out.println("Sorry this product: " + userInput + " is not available right now...");
                    System.out.println("");
                }

            // if user enters remove product, it asks for the product name and if found it removes it from basket otherwise an error message is displayed
            } else if (userInput.equals("remove product")){

                System.out.println("Enter name of product (case sensitive) :");
                userInput = in.nextLine();

                if (blackBeard.searchShoppingBasket(userInput) != null) {

                    shop.addProduct(blackBeard.searchShoppingBasket(userInput));
                    blackBeard.removeFromShoppingBasket(blackBeard.searchShoppingBasket(userInput));
                    System.out.println("We've removed the product from your basket...");
                    System.out.println("");

                } else {

                    System.out.println("Sorry this product: " + userInput + " is not in your basket...");
                    System.out.println("");
                }

            // if user enters purchase all items in the basket will be bought unless there are insufficient funds
            }else if (userInput.equals("purchase")){

                blackBeard.purchaseProducts(shop);
                System.out.println("You've purchased all your items, thank you very much!");

            }
        }
        in.close();
        System.out.println("Thank you for visiting...");
    }
}