package main;

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