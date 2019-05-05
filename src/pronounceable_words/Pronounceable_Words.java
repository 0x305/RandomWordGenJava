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
/**
 *
 
 */
public class Pronounceable_Words  {

   
  
       
    public static void main(String[] args)throws FileNotFoundException{
       Generator testing = new Generator();
        
       //Just a bunch of shit i was testing
Random r = new Random();
char a = (char)(r.nextInt(26) + 'a');
char b = (char)(r.nextInt(26) + 'a');
char c = (char)(r.nextInt(26) + 'a');
char d = (char)(r.nextInt(26) + 'a');

        System.out.println(c);
        String test = "test";
        
        System.out.println(test.charAt(3));
       
        StringBuilder word = new StringBuilder();
         for(int i =0; i<4;i++){
             word.append(c);
            
       
        }
         //more testing shit
         StringBuilder word2 = new StringBuilder();
         word2.append(a);
         word2.append(b);
         word2.append(c);
         word2.append(d);
         String word2String = word2.toString();
         
         String randString = word.toString();
         System.out.println(randString);
         System.out.println(word2String);
         
         StringBuilder myName = new StringBuilder();
            myName.append( "x");
            
     //actual program
        Units testscan = new Units();
        testscan.scanUnitPair();
        
    }
}
