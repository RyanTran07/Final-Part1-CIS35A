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
        Order order1 = new Order();

        // Calling the methods of the order object
        order1.displayMenu();
        order1.getInputs();
        order1.calculate();
        order1.printBill();
    }
}

/*
 * Sample Output 1 (checking if logic works correctly):
   De Anza Food Menu:
    1. De Anza Burger - $5.25

    2. Bacon Cheese Burger - $5.75

    3. Mushroom Swiss Burger - $5.95

    4. Western Burger - $5.95

    5. Don Cali Burger - $5.95

    6. Exit

    Please enter a burger option (1-5), or select 6 to exit: -1
    Invalid Selection. Please choose a burger by entering a number from 1-5: 7
    Invalid Selection. Please choose a burger by entering a number from 1-5: a
    Invalid Selection. Please choose a burger by entering a number from 1-5: abc
    Invalid Selection. Please choose a burger by entering a number from 1-5: 1

    Please enter the quantity of De Anza Burgers that you would like to order: -1
    Please enter a valid amount of burgers to order: 10

    Please enter a burger option (1-5), or select 6 to exit: 2

    Please enter the quantity of Bacon Cheese Burgers that you would like to order: abc
    Please enter a valid amount of burgers to order: 20

    Please enter a burger option (1-5), or select 6 to exit: 3

    Please enter the quantity of Mushroom Swiss Burgers that you would like to order: 30

    Please enter a burger option (1-5), or select 6 to exit: 4

    Please enter the quantity of Western Burgers that you would like to order: 40

    Please enter a burger option (1-5), or select 6 to exit: 5

    Please enter the quantity of Don Cali Burgers that you would like to order: 50

    Please enter a burger option (1-5), or select 6 to exit: 1

    Please enter the quantity of De Anza Burgers that you would like to order: 5

    Please enter a burger option (1-5), or select 6 to exit: 2

    Please enter the quantity of Bacon Cheese Burgers that you would like to order: 4

    Please enter a burger option (1-5), or select 6 to exit: 3

    Please enter the quantity of Mushroom Swiss Burgers that you would like to order: 3

    Please enter a burger option (1-5), or select 6 to exit: 4

    Please enter the quantity of Western Burgers that you would like to order: 2

    Please enter a burger option (1-5), or select 6 to exit: 5

    Please enter the quantity of Don Cali Burgers that you would like to order: 1

    Please enter a burger option (1-5), or select 6 to exit: 6


    Your order has now ended.

    Customer Types:
    1. Student
    2. Staff
    Please enter the type of customer you are: abc
    Please enter a valid customer type. 1 for student or 2 for staff: -1
    Please enter a valid customer type. 1 for student or 2 for staff: 0
    Please enter a valid customer type. 1 for student or 2 for staff: 3
    Please enter a valid customer type. 1 for student or 2 for staff: 2

    Ordered Items and Quantities:
    De Anza Burger Quantity Ordered: 15
    Bacon Cheese Burger Quantity Ordered: 24
    Mushroom Swiss Burger Quantity Ordered: 33
    Western Burger Quantity Ordered: 42
    Don Cali Burger Quantity Ordered: 51

    Cost Per Item:
    De Anza Burger: $5.25 x 15 = $78.75
    Bacon Cheese Burger: $5.75 x 24 = $138.00
    Mushroom Swiss Burger: $5.95 x 33 = $196.35
    Western Burger: $5.95 x 42 = $249.90
    Don Cali Burger: $5.95 x 51 = $303.45

    The total before tax is: $966.45
    The tax amount is: $86.98
    The total bill is: $1053.43



    Sample Output 2 (input validation checking):
    De Anza Food Menu:
    1. De Anza Burger - $5.25

    2. Bacon Cheese Burger - $5.75

    3. Mushroom Swiss Burger - $5.95

    4. Western Burger - $5.95

    5. Don Cali Burger - $5.95

    6. Exit

    Please enter a burger option (1-5), or select 6 to exit: abc
    Invalid Selection. Please choose a burger by entering a number from 1-5: -1
    Invalid Selection. Please choose a burger by entering a number from 1-5: 7
    Invalid Selection. Please choose a burger by entering a number from 1-5: 1

    Please enter the quantity of De Anza Burgers that you would like to order: string
    Please enter a valid amount of burgers to order: 4

    Please enter a burger option (1-5), or select 6 to exit: 2

    Please enter the quantity of Bacon Cheese Burgers that you would like to order: abc
    Please enter a valid amount of burgers to order: -1
    Please enter a valid amount of burgers to order: 0

    Please enter a burger option (1-5), or select 6 to exit: -3
    Invalid Selection. Please choose a burger by entering a number from 1-5: bc
    Invalid Selection. Please choose a burger by entering a number from 1-5: 3

    Please enter the quantity of Mushroom Swiss Burgers that you would like to order: abc
    Please enter a valid amount of burgers to order: 20

    Please enter a burger option (1-5), or select 6 to exit: 4

    Please enter the quantity of Western Burgers that you would like to order: 0

    Please enter a burger option (1-5), or select 6 to exit: 5

    Please enter the quantity of Don Cali Burgers that you would like to order: 23

    Please enter a burger option (1-5), or select 6 to exit: abc
    Invalid Selection. Please choose a burger by entering a number from 1-5: 6


    Your order has now ended.

    Customer Types:
    1. Student
    2. Staff
    Please enter the type of customer you are: abc
    Please enter a valid customer type. 1 for student or 2 for staff: -1
    Please enter a valid customer type. 1 for student or 2 for staff: 0
    Please enter a valid customer type. 1 for student or 2 for staff: 3
    Please enter a valid customer type. 1 for student or 2 for staff: 1

    Ordered Items and Quantities:
    De Anza Burger Quantity Ordered: 4
    Bacon Cheese Burger Quantity Ordered: 0
    Mushroom Swiss Burger Quantity Ordered: 20
    Western Burger Quantity Ordered: 0
    Don Cali Burger Quantity Ordered: 23

    Cost Per Item:
    De Anza Burger: $5.25 x 4 = $21.00
    Mushroom Swiss Burger: $5.95 x 20 = $119.00
    Don Cali Burger: $5.95 x 23 = $136.85

    The total before tax is: $276.85
    The tax amount is: $0.00
    The total bill is: $276.85





    Sample Output 3 (immediate exit):
    De Anza Food Menu:
    1. De Anza Burger - $5.25

    2. Bacon Cheese Burger - $5.75

    3. Mushroom Swiss Burger - $5.95

    4. Western Burger - $5.95

    5. Don Cali Burger - $5.95

    6. Exit

    Please enter a burger option (1-5), or select 6 to exit: 6


    Your order has now ended.
 */
