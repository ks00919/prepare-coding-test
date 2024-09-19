import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [S5] 백준 11723 집합
 * https://www.acmicpc.net/problem/11723
 */
public class Main {
    public static boolean[] numbers = new boolean[21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            switch (order) {
                case "add":
                    int number = Integer.parseInt(st.nextToken());
                    numbers[number] = true;
                    break;
                case "remove":
                    number = Integer.parseInt(st.nextToken());
                    numbers[number] = false;
                    break;
                case "check":
                    number = Integer.parseInt(st.nextToken());
                    sb.append(numbers[number] ? 1 : 0).append("\n");
                    break;
                case "toggle":
                    number = Integer.parseInt(st.nextToken());
                    numbers[number] = !numbers[number];
                    break;
                case "all":
                    Arrays.fill(numbers, true);
                    break;
                case "empty":
                    numbers = new boolean[21];
            }

        }

        System.out.println(sb);
    }
}
