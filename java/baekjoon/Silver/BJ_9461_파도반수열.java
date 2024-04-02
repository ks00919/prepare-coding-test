import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

/**
 * [S3] 백준 9461 파도반 수열
 * 메모리 : 11448KB
 * 시간 : 76ms
 * 코드 길이 : 706B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/9461">
 */
public class Main {

	// 메모이제이션 사용
	static long[] memo;

	// f(1) = f(2) = f(3) = 1
	// f(n) = f(n-2) + f(n-3)
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = parseInt(br.readLine());
		// 최대이 100이므로 합이 int 오버플로우 발생됨
		memo = new long[101];
		for (int i = 1; i < 4; i++) {
			memo[i] = 1;
		}

		for (int tc = 1; tc <= T; tc++) {
			int N = parseInt(br.readLine());
			sb.append(getLength(N)).append("\n");
		}
		System.out.println(sb);

	}

	public static long getLength(int n) {
		if (n <= 3 || memo[n] != 0)
			return memo[n];
		return memo[n] = getLength(n - 2) + getLength(n - 3);
	}
}
