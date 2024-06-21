import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

/**
 * [B1] 백준 2748 피보나치 수 2
 * 메모리 : 11524KB
 * 시간 : 80ms
 * 코드 길이 : 431B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/2748">
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력의 제한이 90까지이기 때문에 정수형은 오버플로우 가능성이 있음 - long 타입 사용
		int n = parseInt(br.readLine());

		long[] memo = new long[n + 1];
		memo[1] = 1;
		for (int i = 2; i <= n; i++) {
			memo[i] = memo[i - 2] + memo[i - 1];
		}

		System.out.println(memo[n]);

	}
}
