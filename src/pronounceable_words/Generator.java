
package pronounceable_words;

import java.util.Random;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.io.FileNotFoundException;


public class Generator    {
      
 Units units = new Units();
 

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

    public void setConditions()throws FileNotFoundException{
         units.scanUnitPair();
    }
    
    //The plan is to generate a random word, then iterate through the unit array list
    //and see if the string contains any of the combos. From there, you will use all the booleans
    //from the indexed combo. Methods will be made to modify for each boolean and they will
    //be called if needed. The string will then be checked again and process will repeat. 
   
    public void testJOption()throws FileNotFoundException{
       //int wordLength = Integer.parseInt( JOptionPane.showInputDialog("Type word length"));
        
        
      StringBuilder testing = randomWord(7);
       units.scanUnitPair();
       
        System.out.println(units.unitPairs.size());
        System.exit(0);
       
       JOptionPane.showMessageDialog(null, testing );
       System.exit(0);
       //testJOption();
    }
    
    /**
     * 
     * @param word 
     * This method will be used every time we want to check the word. We use StringBuilder in parameter
     * so we can pass the random word from the other methods that required StringBuilder.
     * Then each boolean is checked and its corresponding methods are called.
     */
    public void checkWord(StringBuilder word){
        
       
        for(int i=0; i<units.unitPairs.size();i++){
            String wordCombo = units.unitPairs.get(i).combo;
            
            if(word.toString().contains(wordCombo)){//StringBuilder doesnt have .contains() but we can use toString() to interpret it as a String first
                if(units.unitPairs.get(i).mustBegin == true){
                    
                    modifyBegin(word,wordCombo);
                    
            }
                if(units.unitPairs.get(i).mustNotBegin==true){
                    
                    modifyNotBegin(word,wordCombo);
                }
                
            }
            
        }
        System.out.println(word);
}
    
    
    /**
     * 
     * @param word
     * @param combo
     * 
     * This method takes a word and a combo. Finds which index the combo is found, and removes
     * it from the word. Then, the combo is placed into the beginning of the word.
     * We must use StringBuilder because the .delete and .insert only works with stringBuilder
     * 
     */
    public void modifyBegin(StringBuilder word, String combo){
       //check if there is already a combo that is in first index
       
        StringBuilder newRandomReplace = randomWord(combo.length());
        int start = word.indexOf(combo);
        int end = start + combo.length();
        Boolean keepCombo =true;
        
        for(int i=0;i<units.unitPairs.size();i++){
            String currentCombo = units.unitPairs.get(i).combo;
            //if there is already a mustBegin combo that begins the word, the other combo will just be replaced
            //with another random string. This prevents recursion of fighting for who begins word
            if((units.unitPairs.get(i).mustBegin==true)&&(word.indexOf(currentCombo)==0)&&(currentCombo!=combo)){
                word.replace(start, end, newRandomReplace.toString());
                keepCombo=false;
            }
            
            
            if(keepCombo== true){
                word.delete(start, end);//remove where the combo was
                word.insert(0, combo);//add combo to beginning
            }
        }
        
        
       checkWord(word); //checking the word again
        
    }
    /**
     * 
     *
     * @param word
     * @param combo
     * 
     * This method will replace the beginning of the word with a new random combination.
     * Notice how we need to use toString to interpret the given stringBuilder as a string
     */
    public void modifyNotBegin(StringBuilder word, String combo){
        
        if(word.indexOf(combo)==0){
            StringBuilder newRandomReplace = randomWord(combo.length());
            word.replace(0, combo.length(), newRandomReplace.toString());
            }
        checkWord(word);
        }
    /**
     * 
     * @param word
     * @param combo
     * 
     * This method will do the same thing as modify beginning. We have to check if there
     * is already a combo that ends the word that is required. That way it wont keep fighting each other
     */
    public void modifyEnd(StringBuilder word, String combo){
        
        StringBuilder newRandomReplace = randomWord(combo.length());
        int start = word.indexOf(combo);
        int end = start + combo.length();
        Boolean keepCombo =true;
        
        for(int i=0;i<units.unitPairs.size();i++){
            String currentCombo = units.unitPairs.get(i).combo;
            String givenWord = word.toString();//Changing the stringbuilder to string so we can use function endsWith
            
            if((units.unitPairs.get(i).mustEnd==true)&&(givenWord.endsWith(currentCombo))&&(currentCombo!=combo)){
                 word.replace(start, end, newRandomReplace.toString());
                keepCombo = false;
            }
            
    }
        if(keepCombo == true){
            word.delete(start,end);
            word.append(combo);
        }
        checkWord(word);
    }
}


