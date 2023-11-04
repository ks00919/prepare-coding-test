import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int[] alphabet = new int[26];
        char[] characters = word.toCharArray();
        for (char character : characters) {
            alphabet[character - 'a']++;
        }
        for (int count : alphabet) {
            System.out.print(count);
            System.out.print(" ");
        }
    }
}