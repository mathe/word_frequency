package main;

import java.util.*;

class FrequencyIncrementerWMap extends FrequencyIncrementer{
  TreeMap<String,Integer> freqMap;

  public FrequencyIncrementerWMap(){
    this.freqMap = new TreeMap<>();        
  }

  @Override
  public void incrementFrequency(String word){        
    System.out.println("asduh");
    if(freqMap.containsKey(word)){
      Integer f = freqMap.get(word);
      freqMap.replace(word,f,f+1);      
    }
    else freqMap.put(word,1);    
  }

  @Override
  public List<Frequency> getCurrFrequencies(){
    List<Frequency> wordFreq = new ArrayList<>();
    
    Set set = freqMap.entrySet();         
    Iterator i = set.iterator();     
    
    while(i.hasNext()) {      
      Map.Entry me = (Map.Entry)i.next();
      wordFreq.add(new Frequency((String)me.getKey(),(Integer)me.getValue()));      
    }    
    return wordFreq;
  }
}