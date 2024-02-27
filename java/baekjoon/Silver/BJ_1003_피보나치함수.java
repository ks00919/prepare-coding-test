import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [S3] 백준 1003 피보나치 함수
 * 메모리 : 11492KB
 * 시간 : 76ms
 * 코드 길이 : 916B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/1003">
 */
public class Main {
	
	// 0이 호출되는 횟수 이전 값 저장
	static long[] memo0;
	// 1이 호출되는 횟수 이전 값 저장
	static long[] memo1;

	// 제한시간이 0.25초로 매우 짧음 → 메모이제이션 사용으로 중복계산 생략하기!!
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < T; i++) {
			int N = parseInt(br.readLine());
			memo0 = new long[N + 1];
			memo1 = new long[N + 1];

			// 입력값이 0도 들어올 수 있어서 배열 범위를 체크해줘야함
			memo0[0] = 1;
			
			if (N >= 1)
				memo1[1] = 1;
			// n이 2 이상일 때만 함수 호출
			if (N > 1) {
				fibo(N);
			}

			sb.append(memo0[N]).append(" ").append(memo1[N]).append("\n");
		}
		System.out.println(sb);
	}
	
	// n번째 0이나 1이 호출되는 횟수 = n-1번째 호출 횟수 + n-2번째 호출 횟수
	static void fibo(int n) {
		// 만약 저장이 안되어있다면 이전 값으로 재귀 호출
		if (memo0[n - 1] == 0 && memo1[n - 1] == 0) {
			fibo(n - 1);
		}

		memo0[n] = memo0[n - 1] + memo0[n - 2];
		memo1[n] = memo1[n - 1] + memo1[n - 2];
	}
}
