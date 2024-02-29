import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

// 백준 17070 파이프옮기기1
public class Main {

	static int N;

	static int[] dx = { 0, 1, 1 };
	static int[] dy = { 1, 1, 0 };

	static int[][] map;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = parseInt(br.readLine());

		map = new int[N][N];
		dp = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = parseInt(st.nextToken());
			}
		}

		fill();

		for (int[] n : dp) {
			System.out.println(Arrays.toString(n));
		}
	}

	public static void fill() {
		if (map[0][2] == 0) {
			dp[0][2] = 1;

			int y = 3;
			while (y < N && dp[0][y] == 0) {
				dp[0][y] = dp[0][(y++) - 1];
			}

			if (map[1][2] == 0 && map[1][1] == 0) {
				dp[1][2] = 1;

				int x = 2;
				while (x < N && dp[x][2] == 0) {
					dp[x][2] = dp[(x++) - 1][2];
				}
			}
		}

	}
}
