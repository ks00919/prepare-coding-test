import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [G5] 백준 15486 퇴사 2 
 * 메모리 : 343512KB 
 * 시간 : 760ms 
 * 코드 길이 : 881B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/15486">
 */
class Main {
	// dp 하향식
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = parseInt(br.readLine());
		StringTokenizer st;
		int[][] plan = new int[n + 2][2];
		// 중간 계산값 저장
		int[] dp = new int[n + 2];

		// 배열 초기화
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			plan[i][0] = parseInt(st.nextToken());
			plan[i][1] = parseInt(st.nextToken());
		}

		for (int i = n; i >= 0; i--) {
			// 근무기간을 넘으면 dp 이전 저장값을 저장
			if (i + plan[i][0] > n) {
				dp[i] = dp[i + 1];
				continue;
			}
			// 다음부터 마지막 날까지의 이익 vs 현재부터 마지막 날까지의 이익
			int prev = dp[i + plan[i][0]] + plan[i][1];
			dp[i] = dp[i + 1] > prev ? dp[i + 1] : prev;
		}
		// 최대값 출력
		System.out.println(dp[0]);
	}
}
