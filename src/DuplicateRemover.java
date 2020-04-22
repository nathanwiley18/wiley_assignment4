import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.util.Set;
import java.util.LinkedHashSet;

public class DuplicateRemover {
    Set<String> uniqueWords;
    void remove(String dataFile){
        Scanner input = null;
        try {
            uniqueWords = new LinkedHashSet<>();
            input = new Scanner(new File(dataFile));
            
            while(input.hasNextLine()){
                String line = input.nextLine();
                String[] word = line.split(" ");
                
                for(int i = 0;i < word.length;i++){
                    String str = word[i].toLowerCase();
                    uniqueWords.add(str);
                }
            }
        }
        
        catch(Exception e){
            System.out.println("Couldn't open file: " +dataFile);
        }
        
        if(input != null)
            input.close();
    }
    
    void write(String outputFile){
        FileWriter output = null;
        try {
            output = new FileWriter(outputFile);
            for(String unique:uniqueWords)
                output.write(unique + "\n");
            output.close();
        }
        
        catch(Exception e){
            System.out.println("Error writing to: " +outputFile);
        }
        
    }
}