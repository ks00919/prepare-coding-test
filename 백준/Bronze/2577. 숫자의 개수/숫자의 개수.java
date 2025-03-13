import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String value = String.valueOf(Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine()));

        int[] counts = new int[10];
        int length = value.length();

        for (int i = 0; i < length; i++) {
            counts[value.charAt(i) - '0']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(counts[i]).append("\n");
        }
        System.out.println(sb);
    }
}