package input_output.caesar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
   This program encrypts a file, using the Caesar cipher.
   @author lua1
*/
public class NIOCaesarEncryptor
{  
   public static void main(String[] args)
   {  
      Scanner in = new Scanner(System.in);
      try
      {  
    	 System.out.println("Caesar encryption (NIO - read/write whole content)");
    	  
    	 System.out.print("Input file: ");
         String inFile = in.next();
         System.out.print("Output file: ");
         String outFile = in.next();
         System.out.print("Encryption key: ");
         int key = in.nextInt();
         in.close();
                 
         // ensures ensures that the file is closed when all bytes have been read
         byte[] bytes = Files.readAllBytes(Paths.get(inFile));
                 
         CaesarCipher cipher = new CaesarCipher(key);
         
         for (int i=0; i<bytes.length ; i++) {
        	 bytes[i] = cipher.encrypt(bytes[i]);
         }

         // ensures that the file is closed when all bytes have been written 
         Files.write(Paths.get(outFile), bytes);
                  
      } catch (IOException exception) {  
         System.out.println("Error processing file: " + exception);
      }
   }
}


