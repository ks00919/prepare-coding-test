import static java.lang.Integer.*;

import java.util.*;
import java.io.*;

/**
 * [S1] 백준 9465 스티커
 * 메모리 : 122900KB
 * 시간 : 868ms
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/9465"/>
 */
public class Main {

	// DP
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int n = parseInt(br.readLine());
			int[][] stickers = new int[2][n + 1];

			for (int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= n; j++) {
					stickers[i][j] = parseInt(st.nextToken());
				}
			}

			// 만약 스티커가 1열일 때, 바로 결과 출력
			if (n == 1) {
				sb.append(Math.max(stickers[0][1], stickers[1][1])).append("\n");
				continue;
			}

			// dp 저장 배열 생성
			int[][] dp = new int[2][n + 1];
			// 1열 스티커 초기화
			dp[0][1] = stickers[0][1];
			dp[1][1] = stickers[1][1];
			for (int i = 2; i <= n; i++) {
				// 왼쪽 대각선 칸의 스티커와 한칸을 사이에 둔 스티커 중 점수가 더 큰 스티커 선택해서 붙히기
				dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + stickers[0][i];
				dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + stickers[1][i];
			}
			
			// 마지막에 저장된 스티커 점수 출력
			sb.append(Math.max(dp[0][n], dp[1][n])).append("\n");
		}
		System.out.println(sb);
	}
}
