import java.util.*;
public class fibonacci
{
    static int fib(int n, ArrayList<Integer> dp)
    {
        if(n<=1)
        return n;

        if(dp.get(n) !=-1)
        return dp.get(n);

        int result = fib(n-1, dp) + fib(n-2, dp);
        dp.set(n, result);
        return result;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the index: ");
        int n = sc.nextInt();
        ArrayList<Integer> dp = new ArrayList<>();
        for(int i=0; i<=n; i++)
        {
            dp.add(-1);
        }

        int ans = fib(n, dp);
        System.out.println("The fibonacci at the " +n+"th index is: "+ans);
        sc.close();
    }
}
