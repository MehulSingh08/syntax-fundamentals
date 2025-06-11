import java.util.*;
class Node
{
    int data;
    Node next;

    Node(){}

    Node(int data)
    {
        this.data = data; //instance variable for the object
    }

    Node(int data, Node next)
    {
        this.data = data;
        this.next = next;
    }
}

public class insertion
{
    Node head;
    public insertion()
    {
        this.head=null;
    }

    public void insertBegin(int data)
    {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertEnd(int data)
    {
        Node newNode = new Node(data);
        if(head == null)
        {
            head = newNode;
            return;
        }

        Node curr = head;
        while(curr.next != null)
        {
            curr = curr.next; //traverse upto the end
        }
        curr.next = newNode; //Now just simply insert 
    }

    public void insertPos(int data, int pos)
    {
        if(pos<0)
        {
            System.out.println("Can't be -ve");
            return;
        }

        if(pos==0)
        {
            insertBegin(data);
            return;
        }

        Node newNode = new Node(data);
        Node curr = head;

        for(int i=0; i<pos-1 && curr !=null; i++)
        {
            curr = curr.next;
        }

        if(curr == null)
        {
            System.out.println("Out of bounds");
            return;
        }

        newNode.next = curr.next;
        curr.next = newNode;
    }

    public void display()
    {
        if(head==null)
        {
            System.out.println("Empty");
            return;
        }

        Node curr = head;
        while(curr != null)
        {
            System.out.print(curr.data);
            if(curr.next != null)
            {
                System.out.print(" -> ");
            }
            curr = curr.next;
        }
        System.out.println();
    }

    public int size()
    {
        int count =0;
        Node curr = head;
        while(curr != null )
        {
            count++;
            curr = curr.next;
        }
        return count;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        insertion list = new insertion();

        while(true)
        {
            System.out.println("Linked List Insertion Operations");
            System.out.println("1. Insert at beginning");
            System.out.println("2. Insert at end");
            System.out.println("3. Insert at position");
            System.out.println("4. Exit");
            System.out.println("5. Display the size: ");

            System.out.print("Enter the choice: ");
            int choice = sc.nextInt();

            switch(choice)
            {
                case 1:
                    System.out.print("Enter data for begin: ");
                    int data1 = sc.nextInt();
                    list.insertBegin(data1);
                    System.out.println("Data Inserted");
                    System.out.println("The new list is: ");
                    list.display();
                    System.out.println();
                    break;

                case 2:
                    System.out.print("Enter data for end: ");
                    int data2 = sc.nextInt();
                    list.insertEnd(data2);
                    System.out.println("Data Inserted");
                    System.out.print("The new list is: ");
                    list.display();
                    System.out.println();
                    break;

                case 3:
                    System.out.print("Enter the position (0 based): ");
                    int pos = sc.nextInt();
                    System.out.print("Enter the data: ");
                    int data3 = sc.nextInt();
                    list.insertPos(data3, pos);
                    System.out.println("Data Inserted");
                    System.out.println("The new list is: ");
                    list.display();
                    System.out.println();
                    break;

                case 4:
                    System.out.println("Finished Execution... ");
                    sc.close();
                    return;

                case 5:
                    System.out.print("The size of the list is: "+ list.size());
                    System.out.println();
                    break;

                default:
                    System.out.println("Invalid");
                    return;
            }
        }
    }
}