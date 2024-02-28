import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

/**
 * SWEA 1767 [SW Test 샘플문제] 프로세서 연결하기
 * 메모리 : 23752KB
 * 실행시간 : 819ms
 * 코드길이 : 2056
 * 
 * @author 김민주
 *
 */
public class Solution {

	static int N;
	static int min;

	static int[][] map;
	static List<Pair> list;

	static class Pair {
		int x, y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = parseInt(br.readLine());
			min = MAX_VALUE;
			max = MIN_VALUE;
			map = new int[N][N];
			list = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = parseInt(st.nextToken());

					if (i == 0 || j == 0 || i == N - 1 || j == N - 1)
						continue;

					if (map[i][j] == 1) {
						list.add(new Pair(i, j));
					}
				}
			}

			dfs(0, 0, 0);
			sb.append(String.format("#%d %d%n", tc, min));
		}

		System.out.println(sb);
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	static int max;

	public static void dfs(int depth, int core, int count) {
		if (depth == list.size()) {
			if (core > max) {
				max = core;
				min = count;
			} else if (core == max)
				min = min(count, min);
			return;
		}

		int x = list.get(depth).x;
		int y = list.get(depth).y;

		for (int i = 0; i < 4; i++) {
			int cnt = 0;
			int tx = x + dx[i];
			int ty = y + dy[i];

			while (tx >= 0 && ty >= 0 && tx < N && ty < N) {

				if (map[tx][ty] == 1) {
					cnt = 0;
					break;
				}

				cnt++;

				tx += dx[i];
				ty += dy[i];
			}

			tx = x;
			ty = y;

			for (int j = 0; j < cnt; j++) {
				tx += dx[i];
				ty += dy[i];

				map[tx][ty] = 1;
			}

			if (cnt == 0)
				dfs(depth + 1, core, count);
			else
				dfs(depth + 1, core + 1, count + cnt);

			tx = x;
			ty = y;
			for (int j = 0; j < cnt; j++) {
				tx += dx[i];
				ty += dy[i];

				map[tx][ty] = 0;
			}
		}
	}

}
