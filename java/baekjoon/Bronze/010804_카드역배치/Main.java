import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [B2] 백준 10804 카드 역배치
 * 
 * 메모리 : 11560KB
 * 시간 : 76ms
 * 코드 길이 : 1177B
 */
public class Main {

    static int[] cards = new int[21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init();

        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = parseInt(st.nextToken());
            int b = parseInt(st.nextToken());

            reverse(a, b);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < cards.length; i++) {
            sb.append(cards[i]).append(" ");
        }
        System.out.println(sb);
    }

    public static void init() {
        for (int i = 1; i < cards.length; i++) {
            cards[i] = i;
        }
    }

    public static void reverse(int start, int end) {
        while (start < end) {
            int tmp = cards[start];
            cards[start] = cards[end];
            cards[end--] = tmp;
            start++;
        }
    }
}