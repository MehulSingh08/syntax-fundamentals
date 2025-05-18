import java.util.*;
public class number{
    static int count = 1;
    static int n;
    static void printnumber(){
        if(n<count)
        return;
        System.out.println(n);
        n--;
        printnumber(); // the most important part it has to call again and again till reached

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number from whcih you have to print: ");
        n = sc.nextInt();
        printnumber();
        sc.close();
    }
}