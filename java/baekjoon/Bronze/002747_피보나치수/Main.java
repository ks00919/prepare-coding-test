import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

/**
 * [B2] 백준 2747 피보나치 수
 * 메모리 : 11484KB
 * 시간 : 80ms
 * 코드 길이 : 429B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/2747">
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = parseInt(br.readLine());
		
		// 메모이제이션 사용
		int[] memo = new int[n + 1];
		// fibonacci(1) = 1
		memo[1] = 1;
		for (int i = 2; i <= n; i++) {
			memo[i] = memo[i - 2] + memo[i - 1];
		}

		System.out.println(memo[n]);

	}
}
