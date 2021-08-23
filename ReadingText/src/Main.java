import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

public class Main {
    //TODO Copy each line into its own element of an ArrayList
    //TODO Create a method that can search for a word in the entire text, return every index position of the arraylist that the word is in.
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("ProgrammingHistory.txt");
        ArrayList<String> lines = new ArrayList<>();
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null){
            //Copy each line into its own element of an ArrayList
            lines.add(line);
        }
        br.close();

        //searching method
        search(lines, "however");
    }

    public static void search(ArrayList<String> list, String text) throws IOException {
        System.out.println("Searching for word: " + text + "\n");
        int total = 0;
        for (int i=0; i < list.size(); i++){
            String line = list.get(i).toLowerCase();
            if (line.contains(text)){
                String[] words = line.replaceAll("[.,;()]","").split(" ");
                ArrayList<Integer> index = new ArrayList<>();
                for (int j=0; j < words.length; j++){
                    //System.out.println(words[j]);
                    if (words[j].equals(text)){
                        total ++;
                        index.add(j);
                    }
                }
                if (!index.isEmpty()){
                    System.out.println("line " + (i+1) + " | index " + index);
                }
            }
        }
        System.out.println("\ntotal occurance: " + total);
    }
}
