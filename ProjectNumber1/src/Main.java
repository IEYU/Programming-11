import java.util.Arrays;

public class Main {
    //Code your solution to problem number one here
    static int problemOne(String s){
        int answer = 0;
        //your code here
        //iterates through the string and check on every letter
        for (int i = 0; i < s.length(); i++){
            //check whether the current letter is a vowel, and if it is, increase the counter by 1
            if(s.substring(i, i+1).equals("a")||s.substring(i, i+1).equals("e")||s.substring(i, i+1).equals("i")||s.substring(i, i+1).equals("o")||s.substring(i, i+1).equals("u")) {
                answer += 1;
            }
        }
        return answer;
    }
    //Code you problem number two here
    static int problemTwo(String s){
        int answer = 0;
        //your code here
        //iterates through the string and check on the letters in a group of 3
        for (int i = 0; i+2 < s.length(); i++){
            //check if the current letter, the next letter, and the next next letter equals to "bob"
            //if yes, increase the counter by 1
            //if not, does nothing but moving on to the next letter
            if (s.substring(i, i+3).equals("bob")){
                answer += 1;
            }
        }
        return answer;
    }
    //Code your solution to problem number 3 here
    static String problemThree(String s){
        //your code here
        String max_word = "";
        String current_word = "";

        //iterates by initial letters
        //a - bcd..., b - cde..., c - def..., d - efg...
        for (int i = 0; i < s.length(); i ++) {
            //iterates through the string
            //abcdefg...
            for (int j = i; j + 1 < s.length(); j++) {
                //check whether the characters are in alphabetical orders
                if (s.charAt(j) <= s.charAt(j + 1)) {
                    //current word is composed of the letter at current index and the following letters until the next letter that doesn't follow the alphabetical order.
                    //i stays the same and j increases, so current word keeps updating itself
                    current_word = s.substring(i, j + 2);
                }
                else{
                    //if the next letter doesn't follow the alphabetical order, current_word doesn't include that letter
                    current_word = s.substring(i, j + 1);
                    break;
                }
                //current_word now represents the longest sequence that follows alphabetical order starts with the first initial letter (e.g. a)
                //it is now about to move on to the next initial letter (e.g. b) and repeats everything
            }
            //before the next iteration starts, it needs to check whether the current_word is the longest sequence so far.
            //If yes, the assign max_word to the sequence so that this longest sequence so far doesn't get replaced by another string in the iterations
            //if not, it means the current_word is not the longest sequence and max_word remains to be the last longest sequence
            if (current_word.length() > max_word.length()) {
                max_word = current_word;
            }
        }
        //modify s to be the longest sequence and return it
        s = max_word;
        return s;
    }
    public static void main(String[] args) {
        /*
        Set s to a string and run your method using s as the parameter
        Run your method in a println statement to determine what the output was
        Once you think you have it working try running the tests.
        The tests will put your method through several different Strings to test
        all possible cases.  If you have 100% success then there is no bugs in your methods.
         */
        String s;
    }
}
