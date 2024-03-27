import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

/**
 * [G3] 백준 7579 앱
 * 메모리 : 15940KB
 * 시간 : 104ms
 * 코드 길이 : 1014B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/7579">
 */
public class Main {
	
	// dp - knapsack
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = parseInt(st.nextToken());
		int M = parseInt(st.nextToken());

		int[] m = new int[N + 1];
		int[] c = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			m[i] = parseInt(st.nextToken());
			c[i] = parseInt(st2.nextToken());
		}
		
		// 비활성화 해야하는 총 메모리를 기준으로 dp 테이블을 작성하면 메모리초과 발생
		// 비활성화하는데 드는 비용을 기준으로 테이블을 작성하여 비용은 최소, 생기는 메모리는 최대
		// 해당 비용에서 필요한 메모리가 넘거나 같으면 반복문 종료
		int[][] dp = new int[N + 1][10001];
		
		// 여기서 주의해야할 점은 앱이 비활성화 했을 경우 비용이 0일 수 있음을 고려해야함!!!!
		for (int price = 0; price < 10001; price++) {
			for (int i = 1; i <= N; i++) {
				// 현재 앱을 끌 수있는 비용 범위 내라면
				if (price - c[i] >= 0) {
					// 현재 앱을 고려하지 않은 경우의 메모리와 현재 앱 메모리 + 현재 앱을 고려하지 않은 경우에서 비용이 현재 앱만큼 적은것 중 최대값
					dp[i][price] = Math.max(dp[i - 1][price], dp[i - 1][price - c[i]] + m[i]);
				} else {
					// 현재 앱을 끌 수 있는 비용 범위 밖이라면
					// 현재 앱을 고려하지 않은 경우의 최대 메모리 가져오기
					dp[i][price] = dp[i - 1][price];
				}
			}
			
			// 만약 현재 비용의 비울 수 있는 최대 메모리가 필요한 메모리라면 현재 비용이 최소값
			// 반복문 종료
			if (dp[N][price] >= M) {
				System.out.println(price);
				break;
			}
		}
	}
}
