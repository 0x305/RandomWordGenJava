/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pronounceable_words;

/**
 *
 * 
 */
public class UnitPairRules {
    String combo;
    Boolean mustBegin;
    Boolean mustNotBegin;
    Boolean needsBreak;
    Boolean needsVowelPrefix;
    Boolean mustEnd;
    Boolean mustNotEnd;
    
    UnitPairRules(String combo, Boolean mustBegin, Boolean mustNotBegin, Boolean needsBreak,
                  Boolean needsVowelPrefix, Boolean mustEnd, Boolean mustNotEnd){
        this.combo = combo;
        this.mustBegin= mustBegin;
        this.mustNotBegin = mustNotBegin;
        this.needsBreak = needsBreak;
        this.needsVowelPrefix = needsVowelPrefix;
        this.mustEnd = mustEnd;
        this.mustNotEnd = mustNotEnd;
    }
    
    
}
