import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 7; i++) {
            int number = Integer.parseInt(br.readLine());
            if (number % 2 != 0) {
                sum += number;
                min = Math.min(min, number);
            }
        }

        if (min == Integer.MAX_VALUE) {
            System.out.println("-1");
            System.exit(0);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(sum).append("\n");
        sb.append(min);
        System.out.println(sb);
    }

}
