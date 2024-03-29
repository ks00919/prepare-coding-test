import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

/**
 * SWEA 5656 [모의 SW 역량테스트] 벽돌깨기
 * 메모리 : 117716kb
 * 실행시간 : 1485ms
 * 코드 길이 : 3114
 * 
 * @author 김민주
 */
public class Solution {

	public static int N, W, H;
	public static int min;
	public static int[] selected;
	public static int[][] map;

	// 벽돌 클래스(위치, 상하좌우로 깨야하는 칸수 저장)
	static class Brick {
		int x, y, num;

		public Brick(int x, int y, int num) {
			this.x = x;
			this.y = y;
			this.num = num;
		}
	}

	// 문제를 똑바로 읽자....
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = parseInt(st.nextToken());
			W = parseInt(st.nextToken());
			H = parseInt(st.nextToken());

			min = Integer.MAX_VALUE;

			selected = new int[N];
			map = new int[H][W];
			
			// 입력 받기
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = parseInt(st.nextToken());

				}
			}

			dfs(0);
			sb.append(String.format("#%d %d%n", tc, min));
		}
		System.out.println(sb);
	}

	// dfs로 구슬 떨어뜨릴 위치 선택(중복 순열(0~N-1))
	public static void dfs(int depth) {
		if (depth == N) {
			simulation();
			return;
		}

		for (int i = 0; i < W; i++) {
			selected[depth] = i;
			dfs(depth + 1);
		}
	}

	// 구슬 떨어뜨리기
	public static void simulation() {
		// 원본 배열 복사
		int[][] copy = new int[H][W];
		for (int i = 0; i < H; i++) {
			copy[i] = Arrays.copyOf(map[i], W);
		}
		
		for (int i = 0; i < N; i++) {
			// 만약 떨어뜨릴 위치에 깨질 벽돌이 없다면 스킵
			int x = breakPointOf(copy, selected[i]);
			if (x == -1)
				continue;
			// 벽돌 깨기
			breakOf(copy, x, selected[i]);
			// 벽돌 사이사이 빈칸 없애기
			organize(copy);
		}
		
		// 현재 케이스의 최소 벽돌 개수 갱신
		min = Math.min(min, remainOf(copy));
	}

	// 지정된 위치의 맨 위의 벽돌 인덱스 반환
	public static int breakPointOf(int[][] map, int y) {
		for (int i = 0; i < H; i++) {
			if (map[i][y] == 0)
				continue;
			return i;
		}
		return -1;
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	
	// 상하좌우 방문 배열에 없어져야할 벽돌 체크
	// 큐에 벽돌을 넣으면서 영향을 주는 길이 저장
	public static void breakOf(int[][] map, int x, int y) {
		Queue<Brick> q = new ArrayDeque<>();
		q.add(new Brick(x, y, map[x][y] - 1));

		boolean[][] visited = new boolean[H][W];
		visited[x][y] = true;

		while (!q.isEmpty()) {
			Brick curr = q.poll();
			for (int i = 1; i <= curr.num; i++) {
				for (int j = 0; j < 4; j++) {
					int nx = curr.x + i * dx[j];
					int ny = curr.y + i * dy[j];

					if (nx < 0 || ny < 0 || nx >= H || ny >= W || visited[nx][ny]) {
						continue;
					}

					visited[nx][ny] = true;
					q.add(new Brick(nx, ny, map[nx][ny] - 1));
				}
			}

		}

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (visited[i][j]) {
					map[i][j] = 0;
				}
			}
		}
	}

	// 위에 있는 벽돌 아래로 내리기
	public static void organize(int[][] map) {
		for (int y = 0; y < W; y++) {
			int index = H - 1;
			int[] tmp = new int[H];

			for (int x = H - 1; x >= 0; x--) {
				if (map[x][y] <= 0)
					continue;

				tmp[index--] = map[x][y];
			}

			for (int x = 0; x < H; x++) {
				map[x][y] = tmp[x];
			}
		}
	}

	// 남아있는 벽돌 세기
	public static int remainOf(int[][] map) {
		int count = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] > 0)
					count++;
			}
		}
		return count;
	}
}
