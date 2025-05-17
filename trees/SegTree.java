import java.util.*;
public class SegTree
{
    static int[] a;
    static int[] seg;

    static void build(int ind, int low, int high)
    {
        if(low==high)
        {
            seg[ind] = a[low];
            return;
        }

        int mid = (low+high)/2;
        build(2*ind+1, low, mid);
        build(2*ind+2, mid+1, high);
        seg[ind] = Math.max(seg[2*ind+1], seg[2*ind+2]);
    }

    static int query(int ind, int low, int high, int l, int r)
    {
        //complete overlap
        if(low>=l && high<=r)
        {
            return seg[ind];
        }

        //no overlap
        if(high<l || low>r)
        {
            return Integer.MIN_VALUE; 
        }


        int mid = (low+high)/2;
        int left = query(2*ind+1, low, mid, l, r);
        int right = query(2*ind+2, mid+1, high, l, r);

        return Math.max(left,right);

    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        a = new int[n]; //assigns to static a
        System.out.println("Enter the elements of the array: ");
        for (int i=0; i<n; i++)
        {
            a[i] = sc.nextInt();
        }

        seg = new int[4*n]; //asigns to static seg
        build(0,0,n-1);
        System.out.println("Enter the number of queries: ");
        int q = sc.nextInt();
        while(q>0)
        {
            q--;
            System.out.println("Enter the lower index: ");
            int l = sc.nextInt();
            System.out.println("Enter the hihger index: ");
            int r = sc.nextInt();

            int result = query(0,0,n-1,l,r);
            System.out.println("The the max value in range is: ");
            System.out.println(result);

        }
        sc.close();
    }
}