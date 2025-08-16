import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] joy = new int[n + 1]; // 인사를 했을 때 얻는 기쁨
        int[] energy = new int[n + 1]; // 인사를 했을 때 잃는 체력

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            energy[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            joy[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n + 1][101];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 100; j++) {
                if (energy[i] < j) {
                    dp[i][j] = Math.max(dp[i - 1][j - energy[i]] + joy[i], dp[i - 1][j]);
                } else dp[i][j] = dp[i - 1][j];
            }
        }


        System.out.println(dp[n][100]);
    }
}