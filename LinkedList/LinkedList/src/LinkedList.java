public class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
    }

    // Method to add a regular customer to the end of the list
    void addCustomer(String name, String details) {
        Node newNode = new Node(name, details);
        if (head == null) {
            head = newNode;
        } else {
            Node currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
    }

    // Method to add a VIP customer at the beginning of the list
    void addVIPCustomer(String name, String details) {
        Node newNode = new Node(name, details);
        newNode.next = head;
        head = newNode;
    }

    // Method to remove a specific customer from the wait list
    void removeCustomer(String name) {
        if (head == null) return;  // If the wait list is empty, there's nothing to remove

        // If the customer to remove is at the head of the list
        if (head.name.equals(name)) {
            head = head.next;
            return;
        }
        Node currentNode = head;
        while (currentNode.next != null && !currentNode.next.name.equals(name)) {
            currentNode = currentNode.next;
        }
        if (currentNode.next != null) {
            currentNode.next = currentNode.next.next; //bypass node to remove the customer
        }
    }

    // Method to update a customer's details
    void updateCustomer(String name, String details) {
        Node currentNode = head;

        while (currentNode.next != null) {
            if (currentNode.name.equals(name)) {
                currentNode.details = details; //update customer details
                return;
            }
            currentNode = currentNode.next;
        }
    }

    // Method to print the linked list
    void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.name + " (" + current.details + ")");
            current = current.next;
            if (current != null) {
                System.out.print(" -> ");

            }
        }
    }
}

