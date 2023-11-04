import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine();
        String B = br.readLine();
        String C = br.readLine();

        String result = String.valueOf(Integer.parseInt(A) * Integer.parseInt(B) * Integer.parseInt(C));
        int[] counts = new int[10];

        for (int i = 0; i < result.length(); i++) {
            counts[result.charAt(i) - '0']++;
        }

        for (int i = 0; i < counts.length; i++) {
            System.out.println(counts[i]);
        }
    }
}