import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

/**
 * [D6] SWEA 1263 [S/W 문제해결 응용] 8일차 - 사람 네트워크2
 * 메모리 : 107092KB
 * 실행시간 : 2943ms
 * 코드길이 : 1290
 * 
 * @author 김민주
 */
public class Solution {
	
	// 플로이드 워셜 알고리즘
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = parseInt(st.nextToken());

			int[][] network = new int[N][N];
			
			// 인접노드가 아니라면 큰 수 넣어두기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					network[i][j] = parseInt(st.nextToken());

					if (network[i][j] == 0 && i != j)
						network[i][j] = 99999999;
				}
			}

			for (int m = 0; m < N; m++) {
				for (int x = 0; x < N; x++) {
					if (m == x)
						continue;

					for (int y = 0; y < N; y++) {
						if (m == y || x == y)
							continue;
						
						// 바로 가는 것보다 중간 노드를 거쳐가는 것이 더 짧으면 갱신
						if (network[x][y] > network[x][m] + network[m][y]) {
							network[x][y] = network[x][m] + network[m][y];
						}
					}
				}
			}

			// CC값 중 최소값 출력
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < N; j++) {
					sum += network[i][j];
				}
				if (min > sum) {
					min = sum;
				}
			}

			sb.append(String.format("#%d %d%n", tc, min));
		}

		System.out.println(sb);
	}
}
