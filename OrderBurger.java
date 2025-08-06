import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class OrderBurger extends Order {

    public OrderBurger() {
        super();
    }

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
        for(int i = 0; i < getArrSize(); i++) {
            if(getOrderArr()[i] != 0) {
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
            System.out.print("Please enter the quantity of " + this.getBurgerNames()[userBurgerSelection - 1] + "s that you would like to order: " );


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
            int[] quantities = getOrderArr();
            switch(userBurgerSelection) {
                case 1:
                    quantities[0] += userQuantity;
                    break;
                case 2:
                    quantities[1] += userQuantity;
                    break;
                case 3:
                    quantities[2] += userQuantity;
                    break;
                case 4:
                    quantities[3] += userQuantity;
                    break;
                case 5:
                    quantities[4] += userQuantity;
                    break;

            }

            setOrderArr(quantities);

            }

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
                        this.setCustomerType(input.nextInt());
                        if (getCustomerType() <= 2 && getCustomerType() >= 1) {
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
        for(int i = 0; i < getArrSize(); i++) {
            System.out.println(getBurgerNames()[i] + " Quantity Ordered: " + getOrderArr()[i]);
        }

        System.out.println();

        // Printing out the cost per item, or sub total per item.
        System.out.println("Cost Per Item:");
        for (int i = 0; i < getArrSize(); i++) {
            if (getOrderArr()[i] > 0) {
                System.out.println(getBurgerNames()[i] + ": $" + getPriceArr()[i] + " x " + getOrderArr()[i] + " = $" + String.format("%.2f", getOrderArr()[i] * getPriceArr()[i]));
            }
            else {
                continue;
            }
        }

        System.out.println();

        // Printing out the subtotal, tax amount and total bill
        System.out.printf("The total before tax is: $%.2f%n", getSubTotal());
        System.out.printf("The tax amount is: $%.2f%n", getTax());
        System.out.printf("The total bill is: $%.2f%n", getTotal());

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
        for (int i = 0; i < getArrSize(); i++) {
            setSubTotal(getSubTotal() + getPriceArr()[i] * getOrderArr()[i]);
        }

        // Calculations using tax
        if (getCustomerType() == 2) {
            setTaxAmount(getSubTotal() * TAX);
            setTotal(getSubTotal() + getTax());
        }

        else if (getCustomerType() == 1) {
            setTotal(getSubTotal());
        }

    }

    public void saveBillToFile() {
        if(orderArrEmpty()) {
            return;
        }

        try (PrintWriter output = new PrintWriter("bill.txt")){
            output.println("Here is your receipt:");
            output.println("--------------------------------------");
            for (int i = 0; i < getOrderArr().length; i++) {
                if (getOrderArr()[i] > 0) {
                    output.println(getBurgerNames()[i] + ": $" + getPriceArr()[i] + " x " + getOrderArr()[i] + " = $"  + String.format("%.2f", (getPriceArr()[i] * getOrderArr()[i])));
                }
            }
            output.printf("\nSubtotal: $%.2f\n", getSubTotal());

            // if user is student, tax is always $0, but is they are staff print out the calculated tax
            if (getCustomerType() == 2) {
                output.printf("Tax Amount: $%.2f\n", getTax());
            }
            else {
                output.println("Tax Amount: $0.00");
            }
            output.printf("Total: $%.2f\n", getTotal());
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("Oops, there was an error while saving bill to file: " + ex.getMessage());
        }
    }

}
