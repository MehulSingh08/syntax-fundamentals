import java.util.*;
public class ReverseArr{
    static int temp;
    static void reverse(int i, int arr[], int n)
    {
        if(i>n/2)
        return;
        temp = arr[i];
        arr[i] = arr[n-i-1];
        arr[n-i-1] = temp;

        reverse(i+1, arr, n);
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
        {
            arr[i] = sc.nextInt();
        }

        reverse(0,arr,n);
        System.out.println(Arrays.toString(arr));

        sc.close();
    }
}