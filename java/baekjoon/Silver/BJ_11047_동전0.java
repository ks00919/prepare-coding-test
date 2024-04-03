import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

/**
 * [S4] 백준 11047 동전 0
 * 메모리 : 11540KB
 * 시간 : 80ms
 * 코드 길이 : 637B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/11047">
 */
public class Main {

	// 그리디
	// 가장 작은 동전의 가치는 무조건 1이기때문에 그리디 사용할 수 있음!
	// 그렇다면 최소 동전은 큰 가치 부터 K를 채워나가면 최소가 된다고 가정하고 진행
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = parseInt(st.nextToken());
		int K = parseInt(st.nextToken());

		int[] coins = new int[N];
		for (int i = 0; i < N; i++) {
			coins[i] = parseInt(br.readLine());
		}

		int count = 0;
		for (int i = N - 1; i >= 0; i--) {
			if (coins[i] <= K) {
				count += K / coins[i];
				K %= coins[i];
			}
		}

		System.out.println(count);
	}
}
