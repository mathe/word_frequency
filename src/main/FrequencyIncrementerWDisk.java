package main;

import java.io.*;
import java.nio.file.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/*
  This is not a good solution, the scanner is too slow, so we can't increment the frequency inside the file, and then close the file.
*/

class FrequencyIncrementerWDisk extends FrequencyIncrementer{
  /*
    Auxiliary directory for file criation.
  */
  private static final String TEMP_DIR = "/home/matheus/Documents/materia/bd/word_frequency/temp_dir/";
  
  /*
    File for the TEMP_DIR, where the frequency of the words will be stored.
  */
  private File freqFolder;  
  
  public FrequencyIncrementerWDisk(){
    this.freqFolder = FileSystems.getDefault().getPath(TEMP_DIR).toFile();    
  }
      
  /* Increments the frequency of the given word. */
  @Override
  public void incrementFrequency(String word){        
    try{
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
    catch(IOException ioException){ //cover this case later.      
    }    
  }
  
  /*
    Return a list of frequency objects with a word and it's current frequency.
  */
  @Override
  public List<Frequency> getCurrFrequencies(){        
    try{
      List<Frequency> freqs = new ArrayList<>();
      File[] wordFiles = this.freqFolder.listFiles();
      for(File wf : wordFiles){      
        Path path = wf.toPath();
        List<String> lines = Files.readAllLines(path);
        Frequency f = new Frequency(wf.getName(), Integer.valueOf(lines.get(0)));
        freqs.add(f);
      }
      return freqs;
    }
    catch(IOException ioException){ //cover this case later.      
    }   
    return null; 
  }
}