import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [S5] 백준 1010 다리 놓기
 * 메모리 : 12400KB
 * 시간 : 84ms
 * 코드 길이 : 895B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/1010">
 */
class Main {
	
	// M개의 다리 중에서 N개를 순서 상관없이 놓는다고 생각하면 조합이다!(mCn)
  	// 시간 제한이 0.5초이고 조합이므로 DP로 풀이
	// 파스칼의 삼각형을 사용해서 풀이
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = parseInt(st.nextToken());
			int M = parseInt(st.nextToken());

			int[][] D = new int[M + 1][N + 1];

			for (int i = 0; i <= M; i++) {
				for (int j = 0, end = Math.min(i, N); j <= end; j++) {
					if (j == 0 || i == j)
						D[i][j] = 1;
					else
						D[i][j] = D[i - 1][j - 1] + D[i - 1][j];
				}
			}
			sb.append(D[M][N]).append("\n");
		}

		System.out.println(sb);
	}
}
