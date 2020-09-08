import java.util.Arrays;

public class Main {
    //Code your solution to problem number one here
    static int problemOne(String s){
        int answer = 0;
        //your code here
        //iterates through the string and check on every letter
        for (int i = 0; i < s.length(); i++){
            //check whether the current letter is a vowel("a", "e", "i", "o", "u"), and if it is, increase the counter answer by 1
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
            if (s.substring(i, i+3).equals("bob")){
                answer += 1;
            }
        }
        return answer;
    }
    //Code your solution to problem number 3 here
    static String problemThree(String s){
        //your code here
        String max_seq = "";//max_seq represents the longest sequence of letters that follows the alphabetical order (so-far)
        String curr_seq = "";//curr_seq represents the current sequence of letters that follows the alphabetical order

        for (int i = 0; i < s.length(); i ++) {//iterates by initial letters. e.g. (a - bcd..., b - cde...)
            for (int j = i; j + 1 < s.length(); j++) {//iterates through the string. e.g. (abcdefg...)
                if (s.charAt(j) <= s.charAt(j + 1)) {//check whether the characters are in alphabetical orders
                    curr_seq = s.substring(i, j + 2);
                }
                else{
                    curr_seq = s.substring(i, j + 1);
                    break;
                }
            }
            if (curr_seq.length() > max_seq.length()) {//before the next iteration starts, it needs to check whether curr_seq is the longest sequence so far.
                max_seq = curr_seq;
            }
        }
        s = max_seq;
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
        String s = "azcbobobegghakl";
        System.out.println(problemOne(s));
        System.out.println(problemTwo(s));
        System.out.println(problemThree(s));
    }
}
