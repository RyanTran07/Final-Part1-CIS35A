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

public class Driver {
    // Main method
    public static void main(String[] args) {
        // Creating the Order object
        Order order1 = new OrderBurger();

        // Calling the methods of the order object
        order1.displayMenu();
        order1.getInputs();
        order1.calculate();
        order1.printBill();

        order1.saveBillToFile();
    }
}
