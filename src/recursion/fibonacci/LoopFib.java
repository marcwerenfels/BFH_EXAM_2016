package recursion.fibonacci;
import java.util.Scanner;

/**
   This program computes Fibonacci numbers using an iterative method.
*/ 
public class LoopFib
{  
   public static void main(String[] args)
   {  
      Scanner in = new Scanner(System.in);
      System.out.print("Enter n: ");
      int n = in.nextInt();

      for (int i = 1; i <= n; i++)
      {
         long f = fib(i);
         System.out.println("fib(" + i + ") = " + f);
      }
   }

   /**
      Computes a Fibonacci number.
      @param n an integer
      @return the nth Fibonacci number
   */
   public static long fib(int n)
   {  
      if (n <= 2) return 1;
      long fold = 1;
      long fold2 = 1;
      long fnew = 1;
      for (int i = 3; i <= n; i++)
      {  
         fnew = fold + fold2;
         fold2 = fold;
         fold = fnew;
      }
      return fnew;
   }
}
