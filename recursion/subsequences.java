import java.util.*;
public class subsequences
{
    static int count = 0;
    static int subs(int ind, List<Integer> ds, int s, int sum, int[] arr, int n)
    {
        if(ind == n)
        {
            if(s == sum)
            {
                for (int it: ds)
                {
                    System.out.print(it+" "); //all reached print the data structure
                }
                System.out.println();
                return 1;
            }
            return 0;
        }

        ds.add(arr[ind]);
        int left = subs(ind+1, ds, s+arr[ind], sum, arr, n);
        
        ds.remove(ds.size() - 1);

        
        int right = subs(ind+1, ds, s, sum, arr, n);

        return left + right;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array: ");
        int n = sc.nextInt();

        System.out.println("Enter the elements of the array: ");
        int[] arr = new int[n];

        for(int i=0; i<n; i++)
        {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter the target sum: ");
        int sum = sc.nextInt();
        
        //dynamic list for managing backtracking and recursion
        List<Integer> list = new ArrayList<>();

        int count = subs(0, list, 0,sum, arr, n);
        System.out.println("The number of subsequnces are: "+count);
        sc.close();        
    }
}