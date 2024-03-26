import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

/**
 * [G5] 백준 12856 평범한 배낭
 * 메모리 : 51352KB
 * 시간 : 180ms
 * 코드길이 : 1060B
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 물건 개수, 최대 배낭 무게
        int N = parseInt(st.nextToken());
        int K = parseInt(st.nextToken());

        // 물건들의 무게와 가치
        int[] W = new int[N + 1];
        int[] V = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = parseInt(st.nextToken());
            V[i] = parseInt(st.nextToken());
        }

        // dp : 가로 열이 무게, 세로 열 물건 인덱스
        int[][] dp = new int[N + 1][K + 1];
        for (int i = 1; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                // 만약 현재 물건을 넣을 수 있는 무게일때
                if (i - W[j] >= 0) {
                    // 현재 물건을 포함하지 않는 경우와 현재 물건을 포함한 가치 비교
                    dp[j][i] = Math.max(dp[j - 1][i], dp[j - 1][i - W[j]] + V[j]);
                } else {
                    // 만약 넣을 수 없다면 이전 아이템 인덱스의 최대 가치 가져오기
                    dp[j][i] = dp[j - 1][i];
                }
            }
        }

        System.out.println(dp[N][K]);
    }

}
