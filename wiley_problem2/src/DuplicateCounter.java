import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;

public class DuplicateCounter{
   private HashMap<String, Integer> wordCounter;
   
   public DuplicateCounter(){
       wordCounter = new HashMap<String, Integer>();
   }

   public void count(String dataFile){
       wordCounter.clear();
       
       try{
           Scanner in = new Scanner(new File(dataFile));
           String word;
           
           while(in.hasNext()){
               word = in.next();
               
               if(!word.equals("")) {
                   if(wordCounter.get(word) == null)
                       wordCounter.put(word, 1);
                   else
                       wordCounter.put(word, wordCounter.get(word) + 1);
               }
               
           }
           in.close();
       }
       catch(Exception e){
           System.out.println(e.getMessage());
       }
   }


   public void write(String outputFile){
       try{
           PrintWriter out = new PrintWriter(new File(outputFile));
           
           for(String word : wordCounter.keySet()){
               out.println(word + " " + wordCounter.get(word));
           }
           out.close();
       }
       catch(Exception e){
           System.out.println(e.getMessage());
       }
   }
}