import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [D4] SWEA 1861 정사각형 방
 * 메모리 : 110772KB
 * 실행시간 : 1847ms
 * 코드길이 : 1922
 * 
 * @author 김민주
 */
public class Solution {

	static int[][] rooms;
	static StringBuilder sb = new StringBuilder();
	static int room = 0;
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = parseInt(br.readLine());
		for (int test = 1; test <= tc; test++) {
			int n = parseInt(br.readLine());
			rooms = new int[n][n];
			room = 0;
			max = 0;

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					rooms[i][j] = parseInt(st.nextToken());
				}
			}
			// 모든 방을 출발점으로 bfs 연산
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					bfs(n, i, j);
				}
			}
			// 결과 출력
			sb.append(String.format("#%d %d %d%n", test, room, max));
		}
		System.out.println(sb);
	}

	// 상하좌우 이동 저장 배열
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	// bfs
	public static void bfs(int n, int start, int end) {
		// 방문 체크할 배열
		int[][] visited = new int[n][n];
		Queue<int[]> q = new ArrayDeque<>();

		// 첫 시작하는 방 저장
		q.offer(new int[] { start, end });
		visited[start][end] = 1;
		int count = 0;

		while (!q.isEmpty()) {
			int[] current = q.poll();
			for (int i = 0; i < 4; i++) {
				int x = current[0] + dx[i];
				int y = current[1] + dy[i];
				// 만약 인덱스를 넘어가고 방문한 방이라면 넘어가기
				if (x < 0 || x >= n || y < 0 || y >= n || visited[x][y] == 1)
					continue;
				// 현재 방보다 1 차이가 나지 않는다면 넘어가기
				if (rooms[x][y] - rooms[current[0]][current[1]] != 1)
					continue;
				// 조건에 맞는 방 추가
				q.add(new int[] { x, y });
				visited[x][y] = 1;
			}
			// 1 전진
			count++;
		}
		// 만약 최대값보다 크다면 최대값 갱신
		if (count > max) {
			max = count;
			room = rooms[start][end];
		} else if (count == max) { // 최대값이 같을때 방의 숫자가 더 작은 걸로 갱신
			room = room < rooms[start][end] ? room : rooms[start][end];
		}
	}
}
