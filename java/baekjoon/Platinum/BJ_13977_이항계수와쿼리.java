import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

/**
 * [P5] 백준 13977 이항 계수와 쿼리
 * 메모리 : 76912KB
 * 시간 : 616Bms
 * 코드 길이 : 1082B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/13977">
 */
public class Main {

	// 페르마의 소정리와 모듈러 분배법칙을 사용해서 풀기!(수가 매우 크다..)
	static long[] memo;
	static int P = 1_000_000_007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		factorial();

		int M = parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = parseInt(st.nextToken());
			int k = parseInt(st.nextToken());

			// 조합 공식에 페르마의 소정리 적용
			// a^(p-2) = a^-1
			// a = (n-r)!r!
			long result = (memo[n] * pow(memo[n - k] * memo[k] % P, P - 2)) % P;
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

	// 분할 제곱
	public static long pow(long number, long n) {
		if (n == 0)
			return 1;
		long result = pow(number, n / 2);
		long next = (result * result) % P;
		return n % 2 == 0 ? next : (next * number) % P;
	}

	// 모듈러 분배법칙이 적용되기 때문에 팩토리얼도 나머지연산하면서 저장해두기
	public static void factorial() {
		memo = new long[4_000_001];

		memo[0] = 1;
		memo[1] = 1;

		for (int i = 2; i <= 4_000_000; i++) {
			memo[i] = (memo[i - 1] * (i % P)) % P;
		}
	}
}
