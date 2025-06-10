import java.util.*;

class Node //defining class Node to represent each node
{
    int data; //storing the value of node
    Node next; //reference to the next node

    Node() {}

    Node(int data)
    {
        this.data = data; //the instance variable of this object
    }

    Node(int data, Node next) //doing constructor overloading for creating new instances
    {
        this.data = data; //assign the value
        this.next = next; //assign the next node reference
    }
}

public class LinkedListInsertion
{
    private Node head; //reference to the first node in the list

    //constructor for initializing empty list
    public LinkedListInsertion()
    {
        this.head = null; //start with empty list
    }

    //method to insert at the beginning of the list
    public void insertAtBeginning(int data)
    {
        Node newNode = new Node(data); //create new node with given data
        newNode.next = head; //make new node point to current head
        head = newNode; //update head to point to new node
    }

    //method to insert at the end of the list
    public void insertAtEnd(int data)
    {
        Node newNode = new Node(data); //create new node with given data

        if (head == null) //if list is empty
        {
            head = newNode; //make new node the head
            return;
        }

        Node current = head; //start traversal from head
        while (current.next != null) //traverse until last node
        {
            current = current.next; //move to next node
        }
        current.next = newNode; //link last node to new node
    }

    //method to insert at specific position (0-indexed)
    public void insertAtPosition(int data, int position)
    {
        if (position < 0) //invalid position check
        {
            System.out.println("Position cannot be negative");
            return;
        }

        if (position == 0) //insert at beginning
        {
            insertAtBeginning(data);
            return;
        }

        Node newNode = new Node(data); //create new node
        Node current = head; //start from head

        //traverse to position-1
        for (int i = 0; i < position - 1 && current != null; i++)
        {
            current = current.next; //move to next node
        }

        if (current == null) //position out of bounds
        {
            System.out.println("Position out of bounds");
            return;
        }

        newNode.next = current.next; //link new node to next node
        current.next = newNode; //link current node to new node
    }

    //method to display the linked list
    public void display()
    {
        if (head == null) //check if list is empty
        {
            System.out.println("List is empty");
            return;
        }

        Node current = head; //start from head
        while (current != null) //traverse until end
        {
            System.out.print(current.data); //print current node data
            if (current.next != null)
            {
                System.out.print(" -> "); //print arrow if not last node
            }
            current = current.next; //move to next node
        }
        System.out.println(); //new line after printing list
    }

    //method to get size of the list
    public int size()
    {
        int count = 0; //initialize counter
        Node current = head; //start from head
        while (current != null) //traverse entire list
        {
            count++; //increment counter
            current = current.next; //move to next node
        }
        return count; //return total count
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        LinkedListInsertion list = new LinkedListInsertion();

        System.out.println("Linked List Insertion Operations");
        System.out.println("1. Insert at beginning");
        System.out.println("2. Insert at end");
        System.out.println("3. Insert at position");
        System.out.println("4. Display list");
        System.out.println("5. Exit");

        while (true)
        {
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice)
            {
                case 1: //insert at beginning
                    System.out.print("Enter data to insert at beginning: ");
                    int data1 = sc.nextInt();
                    list.insertAtBeginning(data1);
                    System.out.println("Inserted " + data1 + " at beginning");
                    break;

                case 2: //insert at end
                    System.out.print("Enter data to insert at end: ");
                    int data2 = sc.nextInt();
                    list.insertAtEnd(data2);
                    System.out.println("Inserted " + data2 + " at end");
                    break;

                case 3: //insert at position
                    System.out.print("Enter data to insert: ");
                    int data3 = sc.nextInt();
                    System.out.print("Enter position (0-indexed): ");
                    int position = sc.nextInt();
                    list.insertAtPosition(data3, position);
                    break;

                case 4: //display list
                    System.out.print("Current list: ");
                    list.display();
                    System.out.println("List size: " + list.size());
                    break;

                case 5: //exit
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default: //invalid choice
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}