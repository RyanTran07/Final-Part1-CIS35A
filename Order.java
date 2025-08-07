/*
 * Name: Ryan Tran, Krish Kowkuntla, Erin Law, Carson Luu, Grace Truong
 *
 * Description: This program is a menu-driven interaction system where a user
 *              continuosly enters their burger choice and how many burgers
 *              they want until they indicate that they want to end their order.
 *              It then asks them for what type of customer they are and prints
 *              out their order quantity, the subtotal for each burger option,
 *              their subtotal for all burgers, the tax charged, and the total
 *              bill. It implements an abstract Order class, which contains
 *              all of the instance variables, appropriate getters and setters
 *              and abstract methods that  implemented in the
 *              Order.java file.
 *
 * Note: To compile and run, this program was placed in a folder/directory. The
 *       Driver.java, Order.java, OrderBurger.java and OrderInterface.java
 *       are all in the same folder/directory
 *
 */

import java.util.Scanner;

public abstract class Order implements OrderInterface {
    Scanner input = new Scanner(System.in);

    // Array instance variables
    private final int ARR_SIZE = 5;
    private final String[] BURGER_NAMES = {"De Anza Burger", "Bacon Cheese Burger", "Mushroom Swiss Burger", "Western Burger", "Don Cali Burger"};
    private int[] orderArr = {0, 0, 0, 0, 0};
    private final double[] PRICE_ARR = {5.25, 5.75, 5.95, 5.95, 5.95};

    // customerType = 1 (student) customerType = 2 (staff)
    private int customerType = -1;

    // Instance variables relating to money/calculations
    private double subTotal;
    private double total;
    private double taxAmount;


    /*
     * Order()
     * Purpose: A default constructor, takes no arguments.
     *
     */
    protected Order() {}

    /*
     * void displayMenu()
     * Purpose: Displays all of the menu items and their prices
     *
     * Receives: N/A
     * Returns: N/A
     * Output: All menu items and their prices
     *
     *
     */

    public void displayMenu() {
        System.out.println("==========================================");

        System.out.println("De Anza Food Menu: ");
        for(int i = 0; i < ARR_SIZE; i++) {
            System.out.println((i+1) + ". " + BURGER_NAMES[i] + " - $" + PRICE_ARR[i]);
            System.out.println();
        }

        System.out.println("6. Exit");
        System.out.println();

        System.out.println("==========================================");

    }

    public abstract void getInputs();
    public abstract void calculate();
    public abstract void printBill();
    public abstract boolean orderArrEmpty();
    public abstract void saveBillToFile();

    /*
     * Getters:
     * getArrSize - Returns array size for burger array, price array, quantity array
     * getBurgerNames - Returns the burgerNames array.
     * getOrderArr - Returns the order quantity array (orderArr)
     * getPriceArr - Returns the price array (priceArr)
     * getCustomerType - Returns the value of the instance variable customerType
     * getSubTotal - Returns the value of the instance variable subTotal
     * getTotal - Returns the value of the instance variable total
     * getTax - Returns the taxAmount instance variable
     *
     *
     *
     */
    public int getArrSize() {
        return ARR_SIZE;
    }

    public String[] getBurgerNames() {
        return BURGER_NAMES;
    }

    public int[] getOrderArr() {
        return orderArr;
    }

    public double[] getPriceArr() {
        return PRICE_ARR;
    }

    public int getCustomerType() {
        return customerType;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public double getTotal() {
        return total;
    }

    public double getTax() {
        return taxAmount;
    }

    /*
     * Setters:
     * setOrderArr - Set the orderArr to the integer array that is passed in
     * setCustomerType - Set the customerType to the integer passed in the function call
     * setSubTotal - Set subTotal to the subTotal (type double) that is passed in the function call
     * setTotal - Set the total to the total (type double) that is passed in the function call
     * setTaxAmount - Set the taxAmount to the taxAmount (type double) that is passed into the function call
     */

    public void setOrderArr(int[] orderArr) {
        this.orderArr = orderArr;
    }

    public void setCustomerType(int customerType) {
        this.customerType = customerType;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }

}
