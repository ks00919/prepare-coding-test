import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [S2] 백준 11053 가장 긴 증가하는 부분 수열
 * 메모리 : 12360KB
 * 시간 : 100ms
 * 코드 길이 : 851B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/11053">
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = parseInt(br.readLine());
		int[] numbers = new int[N];
		int[] dp = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			// 현재 수를 기준으로 이전 탐색 (그렇지 않으면 순서를 고려하지 않은 부분 수열 완성)
			for (int j = 0; j < i; j++) {
				if (numbers[i] > numbers[j]) {
					// 현재 dp에 저장된 선택 수의 개수보다 작은 수의 개수가 더 클때 갱신
					dp[i] = dp[i] > dp[j] + 1 ? dp[i] : dp[j] + 1;
				}
			}
		}

		// 가장 긴 수열의 길이 선택
		int max = -1;
		for (int i = 0; i < N; i++) {
			if (dp[i] > max)
				max = dp[i];
		}

		System.out.println(max + 1);
	}
}
