import static java.lang.Integer.*;

import java.util.*;
import java.io.*;

/**
 * [S2] 백준 1012 유기농 배추
 * 메모리 : 13796KB
 * 시간 : 120ms
 * 코드 길이 : 1549
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/1012">
 */
public class Main {

	static int M, N, K;
	static int[][] map;

	public static class Pair {
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
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = parseInt(st.nextToken());
			N = parseInt(st.nextToken());
			K = parseInt(st.nextToken());

			map = new int[M][N];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				map[parseInt(st.nextToken())][parseInt(st.nextToken())] = 1;
			}

			int count = 0;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 1) {
						bfs(i, j);
						count++;
					}
				}
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void bfs(int x, int y) {
		map[x][y] = -1;
		Queue<Pair> q = new ArrayDeque<>();
		q.add(new Pair(x, y));

		while (!q.isEmpty()) {
			Pair curr = q.poll();

			for (int i = 0; i < 4; i++) {
				int tx = curr.x + dx[i];
				int ty = curr.y + dy[i];

				if (tx >= M || ty >= N || tx < 0 || ty < 0 || map[tx][ty] != 1)
					continue;
				map[tx][ty] = -1;

				q.add(new Pair(tx, ty));
			}
		}
	}

}
