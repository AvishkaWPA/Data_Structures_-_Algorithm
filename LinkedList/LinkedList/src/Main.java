
public class Main {
    public static void main(String[] args) {
        LinkedList waitlist = new LinkedList();
        // Adding regular customers
        waitlist.addCustomer("Alice", "Party of 2");
        waitlist.addCustomer("Bob", "Party of 3");

        // Adding VIP customers
        waitlist.addVIPCustomer("VIP Charlie", "Party of 1");
        waitlist.addVIPCustomer("VIP Dave", "Party of 4");

        // Adding another regular customer
        waitlist.addCustomer("Eve", "Party of 2");

        // Displaying the final waitlist
        waitlist.printList();

    }
}