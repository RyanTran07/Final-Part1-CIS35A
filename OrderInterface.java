public interface OrderInterface {
    final double TAX = 0.09;

    void displayMenu();
    void getInputs();
    void calculate();
    void printBill();

    void saveBillToFile();
    
}
