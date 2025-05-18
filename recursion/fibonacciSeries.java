import java.util.*;
public class fibonacciSeries{
    static int n;
    static int fib(int n){
        if(n==0)
        return 0; //first base case
        if(n==1)
        return 1; //second base case
        return fib(n-1) + fib(n-2); // built on previous 2 base cases
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number upto: ");
        n = sc.nextInt();

        int [] series = new int[n+1];

        System.out.println("The " +n+ "th element is " + fib(n));

        for (int i=0; i<=n; i++){
            series[i] = fib(i);
        }

        System.out.println("The series is: ");
        //for (datatype token array)
        for(int num: series){
            System.out.println(num);
        }

        sc.close();
    }
}