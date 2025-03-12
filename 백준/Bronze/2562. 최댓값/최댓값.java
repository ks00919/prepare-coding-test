import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = Integer.parseInt(br.readLine());
        int index = 1;

        for (int i = 2; i <= 9; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input > max) {
                max = input;
                index = i;
            }
        }

        System.out.println(max);
        System.out.println(index);
    }
}