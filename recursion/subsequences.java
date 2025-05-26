import java.util.*;
public class subsequences
{
    static void subs(int ind, List<Integer> ds, int s, int sum, int[] arr, int n)
    {
        if(ind == n)
        {
            if(s == sum)
            {
                for (int it: ds)
                {
                    System.out.println(it+" "); //all reached print the data structure
                }
                System.out.println();
            }
            return;
        }

        ds.add(arr[ind]);
        s = s+arr[ind];
        subs(ind+1, ds, s, sum, arr, n);

        s = s-arr[ind];
        ds.remove(ds.size() - 1);

        subs(ind+1, ds, s, sum, arr, n);
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the elements in the array");
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
        for(int i=0; i<n; i++)
        {
            list.add(sc.nextInt());
        }

        subs(0, list, 0,sum, arr, n);
        sc.close();        
    }
}