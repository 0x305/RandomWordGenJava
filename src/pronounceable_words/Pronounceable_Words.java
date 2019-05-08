/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pronounceable_words;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.util.ArrayList;



public class Pronounceable_Words  {

       
    public static void main(String[] args)throws FileNotFoundException{
      //Testing stuff
         
         StringBuilder myName = new StringBuilder();
            
            myName.append("aanblonda");
            String test = "lon";
     int start = myName.indexOf("aanb");
        System.out.println(start);
        //System.exit(0);
     int end = start + test.length();
     myName.delete(start, end);
       // System.out.println(myName);
        
        
     Generator generator = new Generator();
    // generator.testJOption();
    // System.exit(0);
    generator.setConditions();
     StringBuilder originalWord = generator.randomWord(8);
        System.out.println("Original Word: "+ originalWord);
        
        generator.checkWord(originalWord);
        
     System.exit(0);
        
        
       
   
        
        
        
       
       System.exit(0);
        
         
      generator.testJOption();
       
        
        
        
    }
}
