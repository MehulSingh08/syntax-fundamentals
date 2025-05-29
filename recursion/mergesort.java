import java.util.*;
public class mergesort
{
    public static void Mergesort(List<Integer> arr)
    {
        if((arr == null) || (arr.size() < 2))
        return;
        int n = arr.size();
        mS(arr, 0, n-1);
    }
    static void merge(List<Integer> arr, int low, int mid, int high)
    {
        List<Integer> temp = new ArrayList<>();

        int left = low;
        int right = mid+1;

        while(left <=mid && right <=high)
        {
            if(arr.get(left) <= arr.get(right))
            {
                temp.add(arr.get(left)); //or temp.add(arr.get(left++))
                left++;
            }
            else
            {
                temp.add(arr.get(right)); //or temp.add(arr.get(right++))
                right++;
            }
        }

        while(left<=mid)
        {
            temp.add(arr.get(left));
            left++;
        }

        while(right<=high)
        {
            temp.add(arr.get(right));
            right++;
        }

        for(int i =low; i<=high; i++)
        {
            arr.set(i, temp.get(i-low));
        }

    }
    static void mS(List<Integer> arr, int low, int high)
    {
        if (low==high) return;
        int mid = (low+high)/2;
        
        mS(arr, low, mid);
        mS(arr, mid+1, high);
        merge(arr, low, mid, high);
    }

    public static void main(String[]args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the numebr of elements: ");
        int n = sc.nextInt();
        System.out.println("Enter the elements of the array: ");
        List<Integer> data = new ArrayList<>(); 
        for(int i=0; i<n; i++)
        {
            data.add(sc.nextInt());
        }
        Mergesort(data);
        System.out.println(data);

        sc.close();

    }
}