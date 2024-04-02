import static java.lang.Integer.*;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 * [S5] 백준 10826 피보나치 수 4
 * 메모리 : 18096KB
 * 시간 : 120ms
 * 코드 길이 : 510B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/10826">
 */
public class Main {

	static BigInteger[] dp = new BigInteger[10001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// n이 10000까지.. long overflow
		int n = parseInt(br.readLine());

		dp[0] = BigInteger.ZERO;
		dp[1] = BigInteger.ONE;

		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1].add(dp[i - 2]);
		}

		System.out.println(dp[n]);
	}
}
