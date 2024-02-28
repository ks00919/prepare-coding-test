import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

/**
 * [G3] 백준 1600 말이 되고픈 원숭이
 * 메모리 : 64468KB
 * 시간 : 544KB
 * 코드 길이 : 1921B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/1600">
 */
public class Main {

	static class Pair {
		// 현재 위치, 잔여 점프 횟수 저장
		int x, y, k;
		int degree;

		public Pair(int x, int y, int degree, int k) {
			this.x = x;
			this.y = y;
			this.k = k;
			this.degree = degree;
		}

	}

	static int[] jx = { 2, 2, 1, -1, -2, -2, 1, -1 };
	static int[] jy = { 1, -1, 2, 2, 1, -1, -2, -2 };

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	// bfs로 말처럼 이동한 경로와 원숭이처럼 이동한 경로 탐색
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = parseInt(st.nextToken());
		int H = parseInt(st.nextToken());

		int[][] map = new int[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = parseInt(st.nextToken());
			}
		}

		Queue<Pair> q = new ArrayDeque<>();
		q.add(new Pair(0, 0, 0, K));
		// 점프 횟수에 따라서 갈 수 있는 경로의 경우가 달라지므로 한번 방문으로 최적임을 알 수 없음
		// 이전에 풀었던 bfs처럼 풀이하면 경우에 따라서 무한루프에 빠지거나, 오답 출력
		// 잔여 점프 횟수(경우)에 따라서 각각 방문 체크하기!!!!
		int[][][] visited = new int[H][W][K + 1];

		Pair curr = null;
		while (!q.isEmpty()) {
			curr = q.poll();

			if (curr.x == H - 1 && curr.y == W - 1)
				break;

			if (curr.k > 0) {
				for (int i = 0; i < 8; i++) {
					int x = curr.x + jx[i];
					int y = curr.y + jy[i];

					if (x < 0 || y < 0 || x >= H || y >= W || map[x][y] == 1 || visited[x][y][curr.k - 1] == 1)
						continue;
					visited[x][y][curr.k - 1] = 1;
					q.add(new Pair(x, y, curr.degree + 1, curr.k - 1));
				}
			}

			for (int i = 0; i < 4; i++) {
				int x = curr.x + dx[i];
				int y = curr.y + dy[i];

				if (x < 0 || y < 0 || x >= H || y >= W || map[x][y] == 1 || visited[x][y][curr.k] == 1)
					continue;
				visited[x][y][curr.k] = 1;
				q.add(new Pair(x, y, curr.degree + 1, curr.k));
			}
		}

		if (curr.x == H - 1 && curr.y == W - 1)
			System.out.println(curr.degree);
		else
			System.out.println(-1);
	}
}
