import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

/**
 * [D4] SWEA 1249 [S/W 문제해결 응용] 4일차 - 보급로
 * 메모리 : 33440KB
 * 실행시간 : 163ms
 * 코드길이 : 1670
 * 
 * @author 김민주
 */
public class Solution {

	static int N;
	static int[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	// 우선순위 큐 사용을 위해 Comparable implements - 복구 시간이 가장 적게 걸리는 순서대로 정렬
	static class Pair implements Comparable<Pair> {
		int x;
		int y;
		int time;

		public Pair(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}

		@Override
		public int compareTo(Pair o) {
			return this.time - o.time;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = parseInt(br.readLine());
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = input.charAt(j) - '0';
				}
			}
			sb.append("#").append(tc).append(" ").append(bfs()).append("\n");
		}
		System.out.println(sb);
	}

	// 출발지부터 도착지까지 bfs로 탐색
	public static int bfs() {
		Queue<Pair> q = new PriorityQueue<>();
		q.add(new Pair(0, 0, 0));
		// 방문 체크 배열 - 어차피 나중에 방문한 노드들은 첫 방문 노드보다 비용이 큰 노드들이다!!라고 가정
		boolean[][] visited = new boolean[N][N];

		while (!q.isEmpty()) {
			// 현재 저장된 경로 중에 가장 비용이 적은 경로 먼저 뽑기
			Pair curr = q.poll();
			
			// 만약 도착했다면 현재 도착지까지 경로의 복구 비용 return
			if (curr.x == N - 1 && curr.y == N - 1)
				return curr.time;

			for (int i = 0; i < 4; i++) {
				int x = curr.x + dx[i];
				int y = curr.y + dy[i];

				if (x < 0 || y < 0 || x >= N || y >= N || visited[x][y])
					continue;
				visited[x][y] = true;
				// 현재 시간 + 새로운 경로의 비용 더해서 큐에 넣기
				q.add(new Pair(x, y, curr.time + map[x][y]));
			}
		}

		return -1;
	}

}
