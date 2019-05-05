
package pronounceable_words;

import java.util.Random;
import javax.swing.JOptionPane;
/**
 *
 */
public class Generator extends Units {
      
 
   /**
    * This method will create a random char and pass it when called. 
    * @return 
    */
    public char randomChar(){
       
        Random r = new Random();
        
        char c = (char)(r.nextInt(26) + 'a');
        
        return c;
        
    }
     
    /**
     * This method will use StringBuilder to create a string. This allows you to iterate
     * each char and assign a random char
     * Must use append. But when switching one that is not null, use setCharAt.
     *You can do this when changing it to pronounceable
     */
     
    public StringBuilder randomWord(int wordLength){
        
        StringBuilder word = new StringBuilder();
        
        for(int i=0; i<wordLength; i++){
        word.append(randomChar());
        
        }
        
       
        return word;
    }    
    
    //The plan is to generate a random word, then iterate through the unit array list
    //and see if the string contains any of the combos. From there, you will use all the booleans
    //from the indexed combo. Methods will be made to modify for each boolean and they will
    //be called if needed. The string will then be checked again and process will repeat. 
   
    public void testJOption(){
       int wordLength = Integer.parseInt( JOptionPane.showInputDialog("Type word length"));
       
      StringBuilder testing = randomWord(wordLength);
  
      
      
      
       
       JOptionPane.showMessageDialog(null, testing );
       
       testJOption();
    }
}
