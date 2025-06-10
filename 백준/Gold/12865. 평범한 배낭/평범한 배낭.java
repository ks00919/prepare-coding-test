import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// dp - knapsack problem
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 물품의 수
        int k = Integer.parseInt(st.nextToken()); // 준서가 버틸 수 있는 무게

        int[] w = new int[n + 1]; // 물건들의 무게
        int[] v = new int[n + 1]; // 물건들의 가치

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n + 1][k + 1]; // x - 물건 번호 y - 현재 가방의 수용량(무게)

        for (int i = 1; i <= n; i++) { // 물건 index
            for (int j = 1; j <= k; j++) { // 현재 기록할 가방의 무게
                if (w[i] <= j) {
                    // (현재 수용량 - 현재 물건의 무게)의 최대 가치 + 현재 물건의 가치 vs 현재 수용량의 최대 가치
                    dp[i][j] = Math.max(dp[i - 1][j - w[i]] + v[i], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}