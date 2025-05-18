//import java.util.*;
public class name{
    static int count = 0;
    static void printname(){
        if(count>10){
            return;
        }
        System.out.println("Mehul Singh");
        count++;
        printname();
    }
    public static void main(String[] args){
        printname();
    }
}