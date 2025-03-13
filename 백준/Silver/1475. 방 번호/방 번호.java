import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String roomNumber = br.readLine();
        int length = roomNumber.length();

        int[] counts = new int[9];

        for (int i = 0; i < length; i++) {
            if (roomNumber.charAt(i) == '9') counts[6]++;
            else counts[roomNumber.charAt(i) - '0']++;
        }
        counts[6] = (counts[6] + 1) / 2;
        System.out.println(Arrays.stream(counts).max().getAsInt());
    }
}