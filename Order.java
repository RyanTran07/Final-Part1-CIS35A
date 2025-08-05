/*
 * Name: Ryan Tran, Krish Kowkuntla, Erin Law
 * Description: This program is a menu-driven interaction system where a user
 *              continuosly enters their burger choice and how many burgers
 *              they want until they indicate that they want to end their order.
 *              It then asks them for what type of customer they are and prints
 *              out their order quantity, the subtotal for each burger option,
 *              their subtotal for all burgers, the tax charged, and the total
 *              bill.
 *
 *
 */

import java.util.Scanner;

public abstract class Order implements OrderInterface {
    Scanner input = new Scanner(System.in);

    // Array instance variables
    private final int arrSize = 5;
    private final String[] burgerNames = {"De Anza Burger", "Bacon Cheese Burger", "Mushroom Swiss Burger", "Western Burger", "Don Cali Burger"};
    private int[] orderArr = {0, 0, 0, 0, 0};
    private final double[] priceArr = {5.25, 5.75, 5.95, 5.95, 5.95};

    // customerType = 1 (student) customerType = 2 (staff)
    private int customerType = -1;

    // Instance variables relating to money/calculations
    private double subTotal;
    private double total;
    private double tax;


    /*
     * Order()
     * Purpose: A default constructor, takes no arguments,
     *          and instantitates customerType
     *          subTotal, total, and tax instance variables to default values
     *
     */
    public Order() {}

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
        for(int i = 0; i < arrSize; i++) {
            System.out.println((i+1) + ". " + burgerNames[i] + " - $" + priceArr[i]);
            System.out.println();
        }

        System.out.println("6. Exit");
        System.out.println();

        System.out.println("==========================================");

    }

    public abstract void getInputs();
    public abstract void calculate();
    public abstract void printBill();

    /*
     * boolean orderArrEmpty()
     *  Purpose: Check if the order array is all zeros
     *
     *  Receives: N/A
     *  Returns: true - if the orderArr is all zeros
     *           false - if the orderArr is not all zeros
     *  Output: N/A
     *
     */
    public boolean orderArrEmpty() {
        for(int i = 0; i < arrSize; i++) {
            if(orderArr[i] != 0) {
                return false;
            }
        }

        return true;
    }

    /*
     * void getInputs()
     *  Purpose: Collect user input on what burgers should be ordered, how many
     *           of each burger should be collected, and the type of customer
     *           the user is.
     *
     *  Receives: N/A
     *  Returns: N/A
     *  Output: Prints statements prompting user for inputs
     *
     */
    public void getInputs() {
        boolean orderEnded = false;

        int userBurgerSelection = -1;
        int userQuantity = -1;

        // User ordering
        while(!orderEnded) {
            System.out.print("Please enter a burger option (1-5), or select 6 to exit: ");

            // Input validation for the burger selection
            while (true) {
            	if (input.hasNextInt()) {
            		userBurgerSelection = input.nextInt();
            		if (userBurgerSelection <= 6 && userBurgerSelection >= 1) {
            			break;
            		} else {
            			System.out.print("Invalid Selection. Please choose a burger by entering a number from 1-5: ");
            		}
            	} else {
            		input.next();
            		System.out.print("Invalid Selection. Please choose a burger by entering a number from 1-5: ");
            	}
            }

            System.out.println();

            // If the user ends the order, end the while loop
            if(userBurgerSelection == 6) {
                System.out.println("\nYour order has now ended.\n");
                orderEnded = true;
                continue;
            }

            // Collecting input
            System.out.print("Please enter the quantity of " + burgerNames[userBurgerSelection - 1] + "s that you would like to order: " );


            // Input validation for the amount of burgers to order

            while (true) {
            	if (input.hasNextInt())  {
            		userQuantity = input.nextInt();
            		if (userQuantity>=0) {
            			break;
            		} else {
            			System.out.print("Please enter a valid amount of burgers to order: ");
            		}
            	} else {
            		input.next();
            		System.out.print("Please enter a valid amount of burgers to order: ");
            	}
            }

            // Adds user inputted quantity to the order array
            switch(userBurgerSelection) {
                case 1:
                    orderArr[0] += userQuantity;
                    break;
                case 2:
                    orderArr[1] += userQuantity;
                    break;
                case 3:
                    orderArr[2] += userQuantity;
                    break;
                case 4:
                    orderArr[3] += userQuantity;
                    break;
                case 5:
                    orderArr[4] += userQuantity;
                    break;

            }

            System.out.println();
        }

        // If the user exits without ordering
        if(orderArrEmpty()) {
            return;
        }


        // Input collection for the customer type
        System.out.println("Customer Types:");
        System.out.println("1. Student\n2. Staff");
        System.out.print("Please enter the type of customer you are: ");

        // Input validation for customer type
        while (true) {
            	if (input.hasNextInt()) {
            		customerType = input.nextInt();
            		if (customerType <= 2 && customerType >= 1) {
            			break;
            		}

                    else {
            			System.out.print("Please enter a valid customer type. 1 for student or 2 for staff: ");
            		}
            	}

                else {
            		input.next();
            		System.out.print("Please enter a valid customer type. 1 for student or 2 for staff: ");
            	}
        }

        System.out.println();
    }


    /*
     * void printBill()
     * Purpose: Prints the quantities of each item ordered, cost per item
     *          total before tax, tax amount, and the total bill (after tax)
     *
     *
     * Receives: N/A
     * Returns: N/A
     * Outputs: Ordered items and quantities, cost per item, total before tax
     *          tax amount, and the total bill (after tax).
     *
     *
     */
    public void printBill() {

        // Don't print if nothing ordered
        if(orderArrEmpty()) {
            return;
        }

        // Printing out the ordered items and their quantities
        System.out.println("Ordered Items and Quantities: ");
        for(int i = 0; i < arrSize; i++) {
            System.out.println(burgerNames[i] + " Quantity Ordered: " + orderArr[i]);
        }

        System.out.println();

        // Printing out the cost per item, or sub total per item.
        System.out.println("Cost Per Item:");
        for (int i = 0; i < arrSize; i++) {
            if (orderArr [i] > 0) {
                System.out.println(burgerNames[i] + ": $" + priceArr[i] + " x " + orderArr[i] + " = $" + String.format("%.2f", orderArr[i]*priceArr[i]));
            }
            else {
                continue;
            }
        }

        System.out.println();

        // Printing out the subtotal, tax amount and total bill
        System.out.printf("The total before tax is: $%.2f%n", subTotal);
        System.out.printf("The tax amount is: $%.2f%n", tax);
        System.out.printf("The total bill is: $%.2f%n", total);

    }


    /*
     * void calculate()
     * Purpose: Calculate and modifies the subTotal, tax, and total instance variables
     *
     * Receives: N/A
     * Returns: N/A
     * Outputs: N/A
     *
     *
     */
    public void calculate() {

        // Do not calclate if the order is empty
        if(orderArrEmpty()) {
            return;
        }

        // Subtotal calculation
        for (int i = 0; i < arrSize; i++) {
            subTotal += priceArr[i] * orderArr[i];
        }

        // Calculations using tax
        if (customerType == 2) {
            tax = subTotal * .09;
            total = subTotal + tax;
        }

        else if (customerType == 1) {
            total = subTotal;
        }

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
