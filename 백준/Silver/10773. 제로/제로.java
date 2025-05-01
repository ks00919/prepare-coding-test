import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int[] stack = new int[10_0000];
        int index = -1;

        for (int i = 0; i < k; i++) {
            int input = Integer.parseInt(br.readLine());

            if (input == 0) {
                if (index == -1) continue;
                index--;
            } else {
                stack[++index] = input;
            }
        }

        int sum = 0;
        for (int i = 0; i <= index; i++) {
            sum += stack[i];
        }

        System.out.println(sum);
    }
}