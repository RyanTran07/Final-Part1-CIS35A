/*
 * Name: Ryan Tran, Krish Kowkuntla, Erin Law
 *
 * Description: This program is a menu-driven interaction system where a user
 *              continuosly enters their burger choice and how many burgers
 *              they want until they indicate that they want to end their order.
 *              It then asks them for what type of customer they are and prints
 *              out their order quantity, the subtotal for each burger option,
 *              their subtotal for all burgers, the tax charged, and the total
 *              bill. It implements an Order class, which holds all of the
 *              logic of the program, through multiple instance variables
 *              and methods. The Driver class contains a main method which
 *              creates an Order object and calls all required methods
 *              of the Order class in order for the program to work.
 *
 * Note: To compile and run, this program was placed in a folder/directory. The
 *       Driver.java and Order.java programs are within this same directory.
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

