import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] cards = new int[21];
        for (int i = 1; i <= 20; i++) {
            cards[i] = i;
        }

        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            while (from < to) {
                int tmp = cards[from];
                cards[from] = cards[to];
                cards[to] = tmp;

                from++;
                to--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 20; i++) {
            sb.append(cards[i]).append(" ");
        }
        System.out.println(sb);
    }
}