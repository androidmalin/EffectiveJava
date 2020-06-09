package org.javase.genericsexamples.coffeehouse;

import java.util.ArrayList;
import java.util.List;

/**
 * Java Coffee House Utility Class
 *
 * @author Juneau
 */
public class JavaHouse {

    private List<CoffeeSaleType> purchase = new ArrayList<>();
    private List<Cup> cupsPurchased = new ArrayList<>();
    private List<Bag> bagsPurchased = new ArrayList<>();
    private List<Dark> darkTypes = new ArrayList<>();
    private List<CoffeeType> mediumTypes = new ArrayList<>();
    private List<Light> lightTypes = new ArrayList<>();

    public JavaHouse() {

    }

    /**
     * Return the total purchase list
     *
     * @return List<CoffeeSaleType>
     */
    public List<CoffeeSaleType> getCurrentPurchase() {
        return purchase;
    }

    /**
     * Add a cup of coffee to the purchase
     *
     * @param coffeeType coffeeType
     * @param size       size
     */
    public void addCup(CoffeeType coffeeType, double size) {
        Cup cup = new CoffeeCup(coffeeType, size);
        cupsPurchased.add(cup);
    }

    /**
     * Add a list of CoffeeCup purchases to the total purchase
     *
     * @param cups cups
     */
    public void addCups(List<CoffeeCup> cups) {
        cupsPurchased.addAll(cups);
    }

    /**
     * Add a bag of coffee to the purchase
     *
     * @param coffeeType coffeeType
     * @param weight     weight
     */
    public void addBag(CoffeeType coffeeType, double weight) {
        Bag bag = new CoffeeBag(coffeeType, weight);
        bagsPurchased.add(bag);
    }

    /**
     * Add a list of CoffeeBag to purchase
     *
     * @param bags bags
     */
    public void addBags(List<CoffeeBag> bags) {
        bagsPurchased.addAll(bags);
    }

    /**
     * Add a list of CoffeeSaleType objects to the purchase This List can
     * consist of either bags or cups
     *
     * @param <T>      <T>
     * @param saleList saleList
     */
    public <T extends CoffeeSaleType> void addToPurchase(List<T> saleList) {
        purchase.addAll(saleList);
    }

    /**
     * A utility function to add all cups and bags purchased to the purchase
     * list, and print out some useful labels.
     */
    public void checkout() {
        System.out.println("Cups Purchased");
        printPurchase(cupsPurchased);
        addToPurchase(cupsPurchased);
        System.out.println("Bags Purchased");
        printPurchase(bagsPurchased);
        addToPurchase(bagsPurchased);
        // Print out coffee strength summary
        sortByCoffeeStrength(purchase);
    }

    /**
     * Prints the purchase out. Accepts Lists of CoffeeSaleType objects (bags or
     * cups).
     *
     * @param input input
     */
    private void printPurchase(List<? extends CoffeeSaleType> input) {
        for (CoffeeSaleType element : input) {
            System.out.println(element.getType());
        }
    }

    /**
     * Returns the number of purchase of type T. This method uses a stream on
     * the purchase list, then filters upon the specified CoffeeType, and finally
     * returns a count
     *
     * @param <T>        <T>
     * @param coffeeType coffeeType
     * @return
     */
    public <T> long countTypes(T coffeeType) {
        return purchase.stream().filter(
                (sale) -> (sale.getType().getType().equals(coffeeType)))
                .count();
    }

    /**
     * This method accepts a purchase list (List of CoffeeSaleTypes), and extracts
     * the individual CoffeeType from each element within the purchase list.  It
     * then determines if the CoffeeType is an instance of Dark, Medium, or Light,
     * and places it into the appropriate container.
     *
     * @param coffeeSale coffeeSale
     */
    public void sortByCoffeeStrength(List<? extends CoffeeSaleType> coffeeSale) {
        for (CoffeeSaleType saleType : coffeeSale) {
            CoffeeType coffeeType = saleType.getType();
            if (coffeeType instanceof Dark) {
                // Note that a cast is required, since darkTypes only accepts
                // Dark type objects
                darkTypes.add((Dark) coffeeType);
            } else if (coffeeType instanceof Medium) {
                // Note that no cast is required, since mediumTypes accepts
                // any CoffeeType object
                mediumTypes.add(coffeeType);
            } else if (coffeeType instanceof Light) {
                lightTypes.add((Light) coffeeType);
            }
        }

        System.out.println("Number of Dark Types: " + darkTypes.size());
        System.out.println("Number of Medium Types: " + mediumTypes.size());
        System.out.println("Number of Light Types: " + lightTypes.size());

    }
}
