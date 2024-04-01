import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

/**
 * [D3] SWEA 5607 [Professional] 조합
 * 메모리 : 24880KB
 * 실행시간 : 133ms
 * 코드 길이 : 1207
 * 
 * @author 김민주
 */
public class Solution {
	// 페르마의 소정리!!!
	
	// 나머지 값을 구할 P값
	static int P = 1234567891;
	// 팩토리얼 메모이제이션용 배열
	static long[] factorial = new long[1000001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = parseInt(br.readLine());
		// factorial(0) 초기화
		factorial[0] = 1;

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = parseInt(st.nextToken());
			int R = parseInt(st.nextToken());
			
			// 조합 공식에 페르마의 소정리와 모듈러 분배법칙을 적용하면 (n! * (((n-r)!r!)%p)^(p-2))%p
			long result = (factorial(N) * pow((factorial(R) * factorial(N - R) % P), P - 2)) % P;
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

	
	// 모듈러 분배법칙 사용한 팩토리얼 메서드
	// N의 최대값이 100_0000이기 때문에 값을 저장하기 위해서는 분배법칙을 적용해야함!!!!
	public static long factorial(int n) {
		if (factorial[n] != 0)
			return factorial[n];

		for (int i = 1; i <= n; i++) {
			if (factorial[i] != 0)
				continue;
			factorial[i] = (factorial[i - 1] * i) % P;
		}
		return factorial[n];
	}

	// 모듈러 분배법칙 사용한 제곱 구하는 메서드
	// N의 최대값이 100_0000이기 때문에 값을 저장하기 위해서는 분배법칙을 적용해야함!!!!
	public static long pow(long a, long p) {
		if (p == 0) {
			return 1;
		}

		long number = pow(a, p / 2);
		long next = (number * number) % P;
		return p % 2 == 0 ? next : (next * a) % P;
	}

}
