import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [G4] 백준 2636 치즈 
 * 메모리 : 12764KB 
 * 시간 : 100ms 
 * 코드 길이 : 2059B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/2636">
 */
public class Main {

	public static int h, w;
	public static int[][] cheese;
	public static boolean[][] visited;

	// 치즈로 둘러싸인 구멍은 녹으면 안되니까 판의 가장자리부터 탐색하여 치즈의 전체 테두리 찾기
	// Flood Fill 알고리즘 사용
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		h = parseInt(st.nextToken());
		w = parseInt(st.nextToken());

		cheese = new int[h][w];

		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < w; j++) {
				cheese[i][j] = parseInt(st.nextToken());
			}
		}

		int hour = 0;
		int count = 1;

		do {
			// 치즈가 다 녹을때까지 시뮬레이션
			simulate();
			hour++;
		} while ((count = count()) > 0);

		StringBuilder sb = new StringBuilder();
		sb.append(hour).append("\n");
		sb.append(count * -1);
		System.out.println(sb);
	}

	public static void simulate() {
		visited = new boolean[h][w];

		// 배열의 전체 테두리만 탐색
		for (int i = 0; i < h; i++) {
			if (i == 0 || i == h - 1) { // 배열의 첫 줄과 마지막 줄
				for (int j = 0; j < w; j++) {
					if (!visited[i][j]) {
						dfs(i, j);
					}
				}
			} else {
				if (!visited[i][0])
					dfs(i, 0);
				if (!visited[i][w - 1])
					dfs(i, w - 1);
			}
		}
	}

	static int[][] idx = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

	public static void dfs(int x, int y) {
		visited[x][y] = true;

		// 만약 치즈의 테두리를 만났다면 녹은 치즈로 체크하고 탐색 종료
		if (cheese[x][y] == 1) {
			cheese[x][y] = -1;
			return;
		}

		for (int i = 0; i < 4; i++) {
			int dx = x + idx[i][0];
			int dy = y + idx[i][1];

			// 인덱스 범위를 넘었거나 방문한 위치라면 넘기기
			if (dx < 0 || dy < 0 || dx >= h || dy >= w || visited[dx][dy]) {
				continue;
			}
			// 녹은 치즈가 아닐때 탐색
			if (cheese[dx][dy] != -1)
				dfs(dx, dy);
		}

	}

	// 판에 남아있는 치즈 칸 수 세기
	public static int count() {
		int count = 0;
		int melt = 0;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (cheese[i][j] == 1)
					count++;

				if (cheese[i][j] == -1) {
					cheese[i][j] = 0;
					melt--;
				}
			}
		}
		// 만약 녹은 치즈만 남았다면 녹은 치즈 칸의 개수를 음수로 반환
		return count == 0 ? melt : count;
	}
}
