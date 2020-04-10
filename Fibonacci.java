/**
 * The Fibonacci class takes a user inputted number and find the
 * Fibonacci number at that place in the series both iteratively and recursively,
 * then also display the time it took each method to run.
 */
import java.math.BigInteger;
import java.util.Scanner;
public class Fibonacci{
    public static void main(String[] args){
        /*Takes in user input with a scanner and prompts*/
        System.out.println("Helo! Please enter the term of the Fibonacci Sequence you want: ");
        Scanner sc = new Scanner(System.in);
        String number = sc.nextLine();
        int num = Integer.parseInt(number);
        System.out.println("Please enter a for the number Iteratively or b for the number Recursively: ");
        String choice = sc.nextLine();
        
        if(choice.equals("a")){
            /*Iteratively go through the Fibonacci Sequence
            and time it, printing the results*/
            long start = System.currentTimeMillis();
            System.out.println(fibIterative(num));
            long end = System.currentTimeMillis();
            long durationMillis = end - start;
            System.out.println(durationMillis);
        }

        else if(choice.equals("b")){
            /*Recursively go through the Fibonacci Sequence
            and time it, printing the results*/
            long start2 = System.currentTimeMillis();
            System.out.println(fibRecursive(num));
            long end2 = System.currentTimeMillis();
            long durationMillis2 = end2 - start2;
            System.out.println(durationMillis2);
        }
        
        /*In case of an invalid input*/
        else{
            System.out.println("Sorry, that was not a valid choice. Bye!");
        }
        sc.close();
    }
    
    /**
     * method returns the Fibonacci number specified by the index of num
     * recursively
     * @param num
     * @return the Fibonacci number at the num index
     */
    public static long fibRecursive(int num){
        if(num<=1){
            return num;
        }

        else{
            return fibRecursive(num-1) + fibRecursive(num-2);
        }
    }
    
    /**
     * method returns the Fibonacci number specified by the index of num
     * iteratively
     * @param num
     * @return the Fibonacci number at the num index
     */
    public static BigInteger fibIterative(int num){
        
        int iteration = 1;
        BigInteger firFib = new BigInteger("0");
        BigInteger secFib = new BigInteger("1");
        BigInteger adder = new BigInteger("0");

        while(iteration < num){
            adder = firFib.add(secFib);
            firFib = secFib;
            secFib = adder;
            iteration++;
        }

        return adder;
    }
}