package main;

import java.io.*;
import java.nio.file.*;
import java.util.List;
import java.util.Scanner;

class Frequency{
  private String word;
  private int frequency;
  public Frequency(String _word,int _frequency){
    word = _word;
    frequency = _frequency;
  } 
  
  public String getWord(){
    return this.word;
  }
  
  public int getFrequency(){
    return this.frequency;
  }
}

class FrequencyIncrementer{
  /*
    Auxiliary directory for file criation.
  */
  private static final String TEMP_DIR = "/home/matheus/Documents/repositories/word_frequency/temp_dir/";
      
  /* Increments the frequency of the given word. */
  public void incrementFrequency(String word) throws IOException{
    File file;
    Path path = FileSystems.getDefault().getPath(TEMP_DIR + word);
    
    int freq = 0;    
    if(Files.exists(path)){
      file = path.toFile();
      Scanner scanner = new Scanner(file);
      freq = scanner.nextInt();        
      scanner.close();
    }    
    else {
      path = Files.createFile(path);
      file = path.toFile();
    }    
    freq++;
    Files.write(file.toPath(),String.valueOf(freq).getBytes());
  }
  
  /*
    Return a list of frequency objects with a word and it's current frequency.
  */
  public List<Frequency> getAllWordsFrequency(){    
    return null;
  }
}