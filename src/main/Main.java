package main;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.ArrayList;

public class Main{ 
  
  /*
    args[0] = Name of the unique file, or, 
              main folder which contains all of the other files.
  */
  public static void main(String args[]){    
    try{                      
      WordFrequency wordFreq = new WordFrequency(new WordReader(),
                                                  new FrequencyIncrementer()); 
                                                  
      Files.walkFileTree(Paths.get(args[0]),wordFreq);
      
      List<Frequency> freqs = wordFreq.getCurrWordsFrequencies();
      for(Frequency f : freqs){
        System.out.println(f.getWord() + " : " + f.getFrequency());
      }
    }
    catch(FileNotFoundException notFound){
      System.out.println("File was not found!");
    }
    catch(IOException io){
      System.out.println("IO exception: " + io.getMessage());
    }
  }
}