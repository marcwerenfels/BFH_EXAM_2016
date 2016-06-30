package recursion.permute;
import java.util.ArrayList;

/**
   This program demonstrates the permutation generator.
*/
public class PermutationGeneratorDemo
{
   public static void main(String[] args)
   {
      PermutationGenerator generator 
            = new PermutationGenerator("beat");
      ArrayList<String> permutations = generator.getPermutations();
      int i = 1;
      for (String s : permutations)
      {         
         System.out.println(i+" : "+ s);
         i++;
      }
   }
}

