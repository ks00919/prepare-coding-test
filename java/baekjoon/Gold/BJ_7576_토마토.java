import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [G5] 백준 7576 토마토 
 * 메모리 : 101464KB 
 * 시간 : 604ms 
 * 코드 길이 : 1596B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/7576">
 */
public class Main {

	static class Pair {
		int x;
		int y;
		int degree;

		public Pair(int x, int y, int degree) {
			this.x = x;
			this.y = y;
			this.degree = degree;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = parseInt(st.nextToken());
		int N = parseInt(st.nextToken());

		int[][] tomato = new int[N][M];
		Queue<Pair> q = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				tomato[i][j] = parseInt(st.nextToken());
				if (tomato[i][j] == 1) {
					// 같은 차수의 시작점이 여러개 일 수 있음
					q.offer(new Pair(i, j, 0));
				}
			}
		}

		// 왼쪽, 위, 오른쪽, 아래
		int[] dx = { 0, -1, 0, 1 };
		int[] dy = { -1, 0, 1, 0 };

		Pair curr = null;
		while (!q.isEmpty()) {
			curr = q.poll();
			// 위아래양옆 탐색
			for (int i = 0; i < 4; i++) {
				int tx = curr.x + dx[i];
				int ty = curr.y + dy[i];

				if (tx < 0 || ty < 0 || tx >= N || ty >= M)
					continue;
				// 안익은 토마토라면 큐에 추가
				if (tomato[tx][ty] == 0) {
					q.add(new Pair(tx, ty, curr.degree + 1));
					tomato[tx][ty] = 1;
				}
			}
		}

		// 익은 토마토가 하나도 없다면 flag false
		boolean flag = !(curr == null);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tomato[i][j] == 0) {
					flag = false;
				}
			}
		}

		// 익지 않은 토마토가 있다면 -1, 아니면 최소 일수 출력
		System.out.println(flag ? curr.degree : -1);
	}

}
