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
      WordFrequency wordFreq = new WordFrequency(); 
      Files.walkFileTree(Paths.get(args[0]),wordFreq);
    }
    catch(FileNotFoundException notFound){
      System.out.println("File was not found!");
    }
    catch(IOException io){
      System.out.println("IO exception: " + io.getMessage());
    }
  }
}