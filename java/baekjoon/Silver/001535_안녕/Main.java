import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/**
 * [S2] 백준 1535 안녕
 * 메모리 : 11596KB
 * 시간 : 80ms
 * 코드 길이 : 1120B
 * <p>
 * knapsack
 *
 * @see <a href="https://www.acmicpc.net/problem/1535"></a>
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());

        int[][] dp = new int[n + 1][100];
        int[] joy = new int[n + 1];
        int[] life = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            life[i] = parseInt(st.nextToken());
            joy[i] = parseInt(st2.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < 100; j++) {
                if (life[i] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - life[i]] + joy[i]);
                } else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        System.out.println(dp[n][99]);
    }
}
