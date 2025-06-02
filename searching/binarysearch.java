import java.util.*;
public class binarysearch
{
    static int binsearch(int arr[], int target)
    {
        int low = 0;
        int high = arr.length-1;
        while(low<=high)
        {
            int mid = low + (high-low)/2;

            if(arr[mid]==target)
            {
                return mid;
            }

            else if(arr[mid] < target)
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.err.println("Enter the number of elements: ");
        int n = sc.nextInt();

        System.err.println("Enter the elements of the array: ");
        int[] arr = new int[n];
        for (int i=0; i<n; i++)
        {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        System.out.println("Enter the target element to find");
        int target = sc.nextInt();
        int result = binsearch(arr, target);
        if(result != -1)
        {
            System.out.println("Yes found at " +result+" index");
        }
        else
        {
            System.out.println("Not found: ");
        }
        
        sc.close();
    }
}