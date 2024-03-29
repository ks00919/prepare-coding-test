import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

/**
 * [G4] 11404 플로이드 
 * 메모리 : 41464KB
 * 시간 : 352ms
 * 코드 길이 : 1332B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/11404">
 */
public class Main {

	// 최소 거리합이 INF를 넘어버리면 결과값이 틀리므로 충분히 큰 숫자를 사용하자..
	static int INF = 9999999;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = parseInt(br.readLine());
		int m = parseInt(br.readLine());

		int[][] array = new int[n + 1][n + 1];

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = parseInt(st.nextToken());
			int end = parseInt(st.nextToken());

			if (array[start][end] != 0) {
				array[start][end] = Math.min(array[start][end], parseInt(st.nextToken()));
			} else {
				array[start][end] = parseInt(st.nextToken());
			}
		}
		
		// 직통으로 갈 수 없는 곳은 INF로 초기화
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (array[i][j] == 0)
					array[i][j] = INF;
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int x = 1; x <= n; x++) {
				for (int y = 1; y <= n; y++) {
					// 출발도시와 도착도시가 같을 수 없음
					if (i == x || x == y || y == i)
						continue;

					array[x][y] = Math.min(array[x][y], array[x][i] + array[i][y]);
				}
			}
		}

		// 결과 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				sb.append(array[i][j] == INF ? 0 : array[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
