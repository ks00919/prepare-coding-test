import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [G3] 백준 17135 캐슬 디펜스 
 * 메모리 : 21508KB 
 * 시간 : 144ms 
 * 코드 길이 : 2408B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/17135">
 */
public class Main {

	static int N, M, D;
	static int[][] map; // 원래 격자판
	static int[][] board; // 시뮬레이션용 격자판
	static int[] location = new int[3]; // 궁수 배치 위치
	static int max;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = parseInt(st.nextToken()); // 행의 수
		M = parseInt(st.nextToken()); // 열의 수
		D = parseInt(st.nextToken()); // 궁수 공격 거리 제한

		map = new int[N][M]; // 격자판

		// 격자판 초기화
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = parseInt(st.nextToken());
			}
		}

		dfs(0, 0);
		System.out.println(max);
	}

	// 궁수의 위치 3개 dfs로 선택
	public static void dfs(int depth, int index) {
		if (depth == 3) {
			// 3개를 선택하였다면 해당 위치 시뮬레이션
			simulate();
			if (max < count)
				max = count;
			return;
		}

		for (int i = index; i < M; i++) {
			location[depth] = i;
			dfs(depth + 1, i + 1);
		}
	}

	// 현재 시뮬레이션에서 궁수에게 제외된 적의 수
	static int count;

	public static void simulate() {
		board = new int[N][];
		for (int i = 0; i < N; i++) {
			board[i] = Arrays.copyOf(map[i], M);
		}
		// count 변수 초기화!!
		count = 0;
		do {
			// 격자판에서 적이 모두 제외될때까지 턴 반복
			for (int i = 0; i < 3; i++) {
				shoot(i, N, location[i]);
			}
		} while (forward());
	}

	public static boolean shoot(int index, int x, int y) {
		// 거리가 가까운 순으로 탐색하기
		for (int i = 1; i <= D; i++) {
			// 같은 거리에서 제일 왼쪽 좌표
			int dx = N - 1;
			int dy = y - i + 1;

			// 좌표가 격자판을 벗어난다면 격자판 내의 좌표로 수정
			if (dy < 0) {
				dx += dy;
				dy = 0;
			}

			// 왼쪽에서부터 오른쪽 위 대각선으로 탐색
			while (dx >= 0 && dy < M && dy != y) {
				if (board[dx][dy] > 0) {
					board[dx][dy]++;
					return true;
				}
				dx -= 1;
				dy += 1;
			}

			// 왼쪽에서부터 오른쪽 아래 대각선으로 탐색
			while (dx >= 0 && dx < N && dy < M) {
				if (board[dx][dy] > 0) {
					board[dx][dy]++;
					return true;
				}
				dx += 1;
				dy += 1;
			}
		}
		return false;
	}

	public static boolean forward() {
		boolean exist = false;
		int[][] tmp = new int[N][M];

		// 한 턴이 끝났을 때 남아있는 적들을 아래 행으로 이동
		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < M; j++) {
				// 수가 1이상이라면 제외된 적 -> count + 1
				if (board[i][j] > 1) {
					board[i][j] = 0;
					count++;
				}

				// 만약 적이 있다면 아래 줄로 이동
				if (board[i][j] == 1) {
					exist = true;
					tmp[i + 1][j] = 1;
				}
			}
		}

		// 마지막 열에 제외된 적들 count
		int x = N - 1;
		for (int i = 0; i < M; i++) {
			if (board[x][i] > 1) {
				count++;
			}
		}

		board = tmp;
		return exist;
	}
}
