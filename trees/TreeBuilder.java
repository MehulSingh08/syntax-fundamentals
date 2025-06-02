import java.util.*;

class TreeNode //defining class TreeNode to represent each node
{
    int val;  //storing the value of node
    TreeNode left; // reference of the left chile
    TreeNode right;//reference to the right child

    TreeNode() {}

    TreeNode(int val)
    {
        this.val = val; // the instanca varibale of this object
    }

    TreeNode(int val, TreeNode left, TreeNode right) //doing constructor overloading for creating new instances
    {
        this.val = val; // assign the value
        this.left = left;// assign the left value
        this.right = right;//assign the right value
    }
}

public class TreeBuilder
{
        // method treenode created just like void and it will return treenode object
        // buildtree being the method name taking arr input
        public static TreeNode buildTree(int [] arr)
        {
            if (arr == null || arr.length == 0 || arr[0] == -1)
            {
                return null; // conditions not met
            }
        

        TreeNode root = new TreeNode(arr[0]); // creation of root element from arrays first element

        Queue<TreeNode> queue = new LinkedList<>(); //initializaton of queue DS for processign one by one

        queue.offer(root); // adding first element from the queue to the already created node

        int i = 1; // first index gone hence at 1
        while(!queue.isEmpty() && i<arr.length) // parallely check if array and queue have elements or not.
        {
            TreeNode current = queue.poll(); // it is the current instance uses the poll function, Retrieves and removes the head of the queue, or returns null if the queue is empty

            if(i<arr.length && arr[i]!=-1) //element is there and not null
            {
                current.left = new TreeNode(arr[i]); // new node created for left child
                queue.offer(current.left); // add the second element to the left node made above
            }
            i++; // move next into array

            if(i<arr.length && arr[i] != -1)
            {
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
            }
            i++;
            //repeat the same for new right node also
        }
        return root;
    }

    public static void LevelOrder(TreeNode root)
    {
        if(root == null)
        {
            System.out.println("Empty Tree");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); //start with the root node

        while(!queue.isEmpty())
        {
            int levelsize = queue.size(); //processing the current queue at the particular level

            for(int i=0; i<levelsize; i++)
            {
                TreeNode node = queue.poll();  //puts the node at the curre t level and push it
                System.out.print(node.val +" "); 

                if (node.left!=null) queue.offer(node.left); // now recursivley goes for the left and right
                if (node.right!= null) queue.offer(node.right);
            }
            System.out.println();
        }
    }

    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        int n = sc.nextInt();
        System.out.println("Enter the array elements (use -1 for null nodes):");
        int [] inparr = new int[n];
        for (int i=0; i<n; i++)
        {
            inparr[i] = sc.nextInt();
        }

        TreeNode root = buildTree(inparr);
        LevelOrder(root);
        sc.close();
    }
}