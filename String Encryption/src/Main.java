import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        //"Hello" becomes -> "oHellay" which translates back to "Hello"
        //take the last letter move it to the front and then add on 'ay' to the end.
        String encrypted_word = "";
        String decrypted_word = "";

        Scanner input_object = new Scanner(System.in);
        System.out.println("Please enter the word: ");

        //encrypting the word
        String word = input_object.next();
        encrypted_word = word.substring(word.length()-1) + word.substring(0, word.length() - 1) + "ay";


        //decrypting the word
        String word_without_ay = encrypted_word.substring(0, encrypted_word.length() - 2);
        decrypted_word = word_without_ay.substring(1, word_without_ay.length()) + word_without_ay.substring(0, 1);


        //prints the encrypted version and the decrypted version
        System.out.println("encrypted version: " + encrypted_word + "\n" + "decrypted version: " + decrypted_word);
    }
}
