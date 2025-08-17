import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 앱의 개수
        int m = Integer.parseInt(st.nextToken()); // 확보해야하는 메모리 용량

        int[] memory = new int[n + 1]; // 앱이 사용 중인 메모리
        int[] cost = new int[n + 1]; // 재실행하는데 드는 비용

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0; // 사용할 수 있는 비용의 최댓값
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
            sum += cost[i];
        }

        int[][] dp = new int[n + 1][sum + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (cost[i] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j - cost[i]] + memory[i], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        for (int j = 0; j <= sum; j++) {
            for (int i = 1; i <= n; i++) {
                if (dp[i][j] >= m) {
                    System.out.println(j);
                    System.exit(0);
                }
            }
        }
    }
}