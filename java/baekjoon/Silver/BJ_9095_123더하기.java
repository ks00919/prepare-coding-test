import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

/**
 * [S3] 백준 9095 1,2,3 더하기
 * 메모리 : 11524KB
 * 시간 : 72ms
 * 코드 길이 : 635B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/9095"/>
 */
public class Main {

	// dp
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = parseInt(br.readLine());
		int dp[] = new int[12];
		// n = 1일때 합의 경우의 수 1
		dp[1] = 1;
		// n = 2일때 경우의 수 2 (1+1, 2)
		dp[2] = 2;
		// n = 3일때 경우의 수 3 (1+1+1, 2+1, 1+2, 3)
		dp[3] = 4;

		// n의 1, 2, 3으로 만들 수 있는 경우의 수는 f(n-3) + f(n-2) + f(n-1)
		for (int tc = 0; tc < T; tc++) {
			int n = parseInt(br.readLine());

			for (int i = 4; i <= n; i++) {
				if (dp[i] == 0) {
					dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
				}
			}

			sb.append(dp[n]).append("\n");
		}

		System.out.println(sb);
	}

}
