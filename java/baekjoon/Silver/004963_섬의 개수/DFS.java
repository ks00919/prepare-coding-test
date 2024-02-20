import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [S2] 백준 4963 섬의 개수
 * 메모리 : 13500KB
 * 시간 : 120ms
 * 코드 길이 : 1520B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/4963">
 */
public class Main {

	static int h, w;
	// 8방 탐색 방향
	static int[][] idx = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 } };
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			String input = br.readLine();

			if (input.equals("0 0"))
				break;

			StringTokenizer st = new StringTokenizer(input);
			w = parseInt(st.nextToken());
			h = parseInt(st.nextToken());

			// 지도 초기화
			map = new int[h][w];
			visited = new boolean[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = parseInt(st.nextToken());
				}
			}

			// 섬의 개수 변수
			int count = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					// 만약 방문하지 않은 육지이면 dfs 탐색
					if (map[i][j] == 1 && !visited[i][j]) {
						dfs(i, j);
						count++;
					}
				}
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}

	public static void dfs(int x, int y) {
		// 현재 있는 육지 방문 체크
		visited[x][y] = true;
    
		// 8방 탐색
		for (int i = 0; i < 8; i++) {
			int dx = x + idx[i][0];
			int dy = y + idx[i][1];
			// 인덱스 범위를 넘어가거나 방문한 육지라면 탐색하지 않음
			if (dx < 0 || dy < 0 || dx >= h || dy >= w || visited[dx][dy])
				continue;
			// 만약 땅이라면 탐색(재귀 호출)
			if (map[dx][dy] == 1)
				dfs(dx, dy);
		}

	}
}
