import java.util.*;
public class palindrome
{
    static boolean palin(String s, int i)
    {
        int n = s.length();
        if (i>n/2)
        return true;

        if (s.charAt(i)!= s.charAt(n-i-1))
        return false;

        return palin(s, i+1); // all the fucntions with the int argument must and should use return 
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(palin(s,0));
        sc.close();
    }

}