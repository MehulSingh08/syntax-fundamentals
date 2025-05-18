import java.util.*;
public class factorial{
    static double fact(double n){
        if (n==0)
        return 1;
        
        return n*fact(n-1);
    }
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number to find out the factorial: ");
        double n = sc.nextInt();
        double result = fact(n);
        System.out.println(result);
        sc.close();
    }
}