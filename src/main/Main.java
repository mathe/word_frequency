package main;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class Main{
  
  /*
    args[0] = Name of the unique file, or, 
              main folder which contains all of the other files.
  */
  public static void main(String args[]){      
    try{      
      WordReader wr = new WordReader(new File(args[0]));      
      for(List<String> w = wr.nextWords(); w != null; w = wr.nextWords()){
        for(String wi : w){
          System.out.println(wi);
        }
      }
    }
    catch(FileNotFoundException notFound){
      System.out.println("File was not found!");
    }
  }
}