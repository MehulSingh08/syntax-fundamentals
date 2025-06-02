import java.util.*;
public class quicksort
{
    static int partition(int [] arr, int low, int high)
    {
        int pivot = arr[high];  //Last element is the pivot
        int i = low-1;

        for(int j=low; j<high; j++)
        {
            if(arr[j]  <=pivot)
            {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i+1, high);
        return i+1;
    }

    public static void qSort(int [] arr, int low, int high)
    {
        if(low<high)
        {
            int partInd = partition(arr, low, high);
            qSort(arr, low, partInd-1);
            qSort(arr, partInd+1, high);
        }
    }
    
    public static void Quicksort(int[] arr)
    {
        if((arr == null) || (arr.length < 2)) // base case for the array size for checking if element exists or not
        return;
        qSort(arr, 0, arr.length-1);
    }

    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array: ");
        for(int i=0; i<n; i++)
        {
            arr[i] = sc.nextInt();
        }
        Quicksort(arr);
        System.out.println(Arrays.toString(arr));
        sc.close();
    }
}