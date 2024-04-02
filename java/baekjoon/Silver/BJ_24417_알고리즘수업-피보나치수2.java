import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

/**
 * [S4] 백준 24417 알고리즘 수업 - 피보나치 수 2
 * 메모리  : 796044KB
 * 시간 : 2532ms
 * 코드 길이 : 554B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/24417">
 */
public class Main {

	static int P = 1_000_000_007;

	// n이 10^8까지인데 실제로 시뮬레이션을 돌리면 메모리 초과 발생!!
	// dp로 피보나치를 계산하는 횟수만 구하자
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = parseInt(br.readLine());

		// 1번 피보나치 수 재귀호출 의사 코드의 실행 횟수
		// 재귀호출 의사 코드의 호출 수는 n=1과 n=2의 호출 횟수와 같음!!
		int[] dp = new int[n + 1];

		dp[1] = 1;
		dp[2] = 1;

		for (int i = 3; i <= n; i++) {
			// fibonacci(n)의 호출 수는 fibonacci(n-1) + fibonacci(n-2)와 같음
			// 모듈러 분배 법칙을 사용해서 마지막에만 나눠주지 않고 모든 연산에 나누기 - overflow 방지
			dp[i] = (dp[i - 1] + dp[i - 2]) % P;
		}

		StringBuilder sb = new StringBuilder();
		sb.append(dp[n]).append(" ").append(n - 2);
		System.out.println(sb);
	}
}
