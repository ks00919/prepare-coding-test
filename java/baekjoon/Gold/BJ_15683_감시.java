import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * [G4] 백준 15683 감시
 * 메모리 : 45364KB
 * 시간 : 284ms
 * 코드 길이 : 2680B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/15683">
 */
public class Main {

	static int N, M;
	static int min = Integer.MAX_VALUE;
	// 기본 지도 저장
	static int[][] map;
	// 방향 선택 저장 배열
	static int[] selected;
	// cctv 좌표 저장 배열
	static List<Location> cctv;
	// 이동 방향 값 저장 배열
	// 0 : 위 / 1 : 오른쪽  2 : 아래 / 3 : 왼쪽
	static int[][] idx = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	// cctv 좌표 클래스
	static class Location {
		int x;
		int y;

		public Location(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = parseInt(st.nextToken());
		M = parseInt(st.nextToken());

		map = new int[N][M];
		cctv = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = parseInt(st.nextToken());

				// cctv라면 좌표 저장
				if (map[i][j] != 0 && map[i][j] != 6) {
					cctv.add(new Location(i, j));
				}
			}
		}

		selected = new int[cctv.size()];
		dfs(cctv.size(), 0);

		System.out.println(min);
	}

	// dfs로 방향을 크게 4가지로 나눠서 선택
	public static void dfs(int number, int depth) {
		if (depth == number) {
			simulate();
			return;
		}

		for (int i = 0; i < 4; i++) {
			selected[depth] = i;
			dfs(number, depth + 1);
		}
	}

	public static void simulate() {
		int[][] matrix = new int[N][];
		for (int i = 0; i < N; i++) {
			matrix[i] = Arrays.copyOf(map[i], M);
		}

		for (int i = 0; i < cctv.size(); i++) {
			int x = cctv.get(i).x;
			int y = cctv.get(i).y;
			int number = map[x][y];
			
			// 방향별로 메서드 호출
			if (number == 1) {

				turnOn(matrix, selected[i], x, y);

			} else if (number == 2) {

				turnOn(matrix, selected[i], x, y);
				turnOn(matrix, selected[i] >= 2 ? selected[i] - 2 : selected[i] + 2, x, y);

			} else if (number == 3 || number == 4) {
				for (int j = 0; j < number - 1; j++) { // 지정 방향대로 켜기
					int select = selected[i] + j > 3 ? selected[i] + j - 4 : selected[i] + j;
					turnOn(matrix, select, x, y);
				}

			} else if (number == 5) { // 모든 방향으로 cctv 켜기
				for (int j = 0; j < 4; j++) {
					turnOn(matrix, j, x, y);
				}
			}
		}

		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (matrix[i][j] == 0)
					count++;
			}
		}

		min = Math.min(min, count);
	}

	// 지정된 방향대로 벽(6)을 만나거나 인덱스 범위 넘어갈 때까지 cctv 범위 체크 
	public static void turnOn(int matrix[][], int index, int x, int y) {
		int dx = idx[index][0];
		int dy = idx[index][1];

		while (true) {
			if (x < 0 || y < 0 || x >= N || y >= M)
				break;

			if (matrix[x][y] == 6)
				break;

			matrix[x][y] = 7;

			x += dx;
			y += dy;
		}
	}

}
