import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

/**
 * [G1] 백준 16134 조합(Combination)
 * 메모리 : 19712KB
 * 시간 : 108ms
 * 코드 길이 : 867B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/16134">
 */
public class Main {
	
	// 페르마의 소정리와 모듈러 분배법칙 사용하기
	static int P = 1_000_000_007;
	// 팩토리얼 메모이제이션용 배열
	static long[] factorial = new long[100_0001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = parseInt(st.nextToken());
		int R = parseInt(st.nextToken());
		
		// 팩토리얼 제한 수 100_0000까지 구해두기
		factorial[0] = 1;
		for (int i = 1; i <= 100_0000; i++) {
			factorial[i] = (factorial[i - 1] * i) % P;
		}
		
		// 페르마 소정리와 모듈러 분배법칙을 조합 공식에 적용
		long result = (factorial[N] * pow((factorial[R] * factorial[N - R] % P), P - 2)) % P;
		// 결과 출력
		System.out.println(result);
	}

	// 분할 거듭제곱과 모듈러 분배법칙으로 overflow 방지
	public static long pow(long a, long p) {
		if (p == 0)
			return 1;

		long result = (pow(a, p / 2));
		long next = (result * result) % P;
		return p % 2 == 0 ? next : (next * a) % P;
	}

}
