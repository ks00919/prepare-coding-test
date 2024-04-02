import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

/**
 * [B1] 백준 24416 알고리즘 수업 - 피보나치 수 1
 * 메모리 : 11552KB
 * 시간 : 80ms
 * 코드 길이 : 516B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/24416">
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = parseInt(br.readLine());

		int[] dp = new int[n + 1];

		dp[1] = 1;
		dp[2] = 1;

		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		StringBuilder sb = new StringBuilder();
		sb.append(dp[n]).append(" ").append(n - 2);
		System.out.println(sb);
	}
}
