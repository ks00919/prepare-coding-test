import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [G5] 백준 7569 토마토
 * 메모리 : 104500KB
 * 실행시간 : 668ms
 * 코드 길이 : 1922B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/7569">
 */
class Main {

	// 3차원 배열, dfs
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = parseInt(st.nextToken());
		int N = parseInt(st.nextToken());
		int H = parseInt(st.nextToken());

		int[][][] boxes = new int[H][N][M];
		Queue<int[]> q = new ArrayDeque<>();

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					boxes[i][j][k] = parseInt(st.nextToken());
					// 만약 처음부터 익은 토마토라면 큐에 추가
					if (boxes[i][j][k] == 1)
						// 좌표 + 차수
						q.add(new int[] { i, j, k, 0 });
				}
			}
		}

		// 모든 토마토가 큐에 들어가 있다면 처음부터 다 익은 토마토
		// 0 출력 후 프로그램 종료
		if (q.size() == N * M * H) {
			System.out.println(0);
			return;
		}

		// 6방 탐색 : 위, 아래, 왼쪽, 오른쪽, 앞, 뒤
		int[][] idx = { { 0, -1, 0 }, { 0, 1, 0 }, { 0, 0, -1 }, { 0, 0, 1 }, { -1, 0, 0 }, { 1, 0, 0 } };

		int[] location = null;
		while (!q.isEmpty()) {
			location = q.poll();

			int z = location[0];
			int x = location[1];
			int y = location[2];
			// 현재 위치 기준 6방향 탐색
			for (int i = 0; i < 6; i++) {
				int dz = z + idx[i][0];
				int dx = x + idx[i][1];
				int dy = y + idx[i][2];
				
				// 인덱스 범위 체크
				if (dz < 0 || dx < 0 || dy < 0 || dz >= H || dx >= N || dy >= M)
					continue;
				// 안익은 토마토라면 큐에 추가
				if (boxes[dz][dx][dy] == 0) {
					q.add(new int[] { dz, dx, dy, location[3] + 1 });
					// 들어갈 때 방문체크를 하지 않으면 큐에 계속 쌓여서 메모리초과 발생!!!
					boxes[dz][dx][dy] = 1;
				}
			}
		}

		// 배열 안에 안 익은 토마토가 남아있다면 -1 출력 후 프로그램 종료
 		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (boxes[i][j][k] == 0) {
						System.out.println(-1);
						return;
					}
				}
			}
		}
 		
 		// 마지막 익은 토마토의 차수 출력
		System.out.println(location[3]);
	}

}
