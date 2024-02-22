import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [G4] 백준 2573 빙산
 * 메모리 : 161996KB
 * 시간 : 540ms
 * 코드 길이 : 2388B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/2573">
 */
public class Main {

	public static int N, M;
	public static int[][] iceberg;
	public static int[][] idx = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = parseInt(st.nextToken());
		M = parseInt(st.nextToken());

		iceberg = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				iceberg[i][j] = parseInt(st.nextToken());
			}
		}

		System.out.println(melt());
	}

	// 구현은 항상 쪼개서 생각할 것!! (디버깅 시간이 너무 오래걸렸음..)
	public static int melt() {

		int year = 0;
		int count = 1;

		// 빙산의 개수가 1개일 경우 계속 반복
		while (count == 1) {
			// 현재 빙산이 녹은 후 결과를 저장하기 위한 배열
			int[][] temp = new int[N][M];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					// 얼음일 때, 주변 바다의 칸 수 만큼 녹이기
					if (iceberg[i][j] > 0) {
						temp[i][j] = iceberg[i][j] - countSea(i, j);
						if (temp[i][j] < 0)
							temp[i][j] = 0;
					}
				}
			}
			// 배열에 저장
			iceberg = temp;
			// 녹은 후 빙산 개수 세기
			count = countIce();
			// 시간 증가
			year++;
		}
		
		// 만약 빙산이 2개 이상으로 쪼개지지 않고 다 녹았다면 0 반환
		// 2개로 쪼개졌다면 걸린 시간 반환
		return count == 0 ? 0 : year;
	}

	// 위, 아래, 양, 옆의 바다 칸 수 세기
	public static int countSea(int x, int y) {
		int count = 0;

		for (int i = 0; i < 4; i++) {
			int dx = x + idx[i][0];
			int dy = y + idx[i][1];

			if (dx < 0 || dy < 0 || dx >= N || dy >= M)
				continue;
			if (iceberg[dx][dy] == 0)
				count++;
		}

		return count;
	}

	// 빙산 수 세기 - bfs 사용
	public static int countIce() {
		// 이번 시간의 방문 배열 생성
		boolean[][] visited = new boolean[N][M];
		// 빙산의 수
		int count = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (iceberg[i][j] == 0 || visited[i][j])
					continue;
				// 방문하지 않은 얼음을 발견했다면 그 지점을 시작으로 bfs
				bfs(visited, i, j);
				// 빙산 수 증가
				count++;
			}
		}

		return count;
	}

	public static void bfs(boolean[][] visited, int x, int y) {
		Queue<int[]> q = new ArrayDeque<>();
		// 현재 얼음의 좌표 저장
		q.offer(new int[] { x, y });
		visited[x][y] = true;

		while (!q.isEmpty()) {
			int[] coordinate = q.poll();

			for (int i = 0; i < 4; i++) {
				int dx = coordinate[0] + idx[i][0];
				int dy = coordinate[1] + idx[i][1];
				
				// 인덱스 범위를 넘지 않고, 이전에 방문하지 않았는지 체크
				if (dx < 0 || dy < 0 || dx >= N || dy >= M || visited[dx][dy])
					continue;
				
				// 얼음이라면 방문체크 후 큐에 넣기
				if (iceberg[dx][dy] > 0) {
					visited[dx][dy] = true;
					q.offer(new int[] { dx, dy });
				}
			}

		}
	}
}
