import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [G5] 백준 21610 마법사 상어와 비바라기
 * 메모리 : 13216KB
 * 시간 : 144ms
 * 코드 길이 : 2836B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/21610">
 */
public class Main {

	static int n;
	// 물 바구니 저장
	static int[][] baskets;
	// 이전에 구름이 사라졌던 칸인지 체크
	static boolean[][] isUsed;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = parseInt(st.nextToken());
		int m = parseInt(st.nextToken());

		// 입력값 초기화
		baskets = new int[n][n];
		isUsed = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				baskets[i][j] = parseInt(st.nextToken());
			}
		}

		int[][] order = new int[m][2];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			order[i][0] = parseInt(st.nextToken());
			order[i][1] = parseInt(st.nextToken());
		}

		// 처음 구름(2 감소하지 않음) 만들어서 이동 후 물 복사 마법 수행
		int d = order[0][0];
		int s = order[0][1];
		
		int[] ix = { n - 1, n - 1, n - 2, n - 2 };
		int[] iy = { 0, 1, 0, 1 };
		for (int i = 0; i < 4; i++) {
			int x = searchIndex(ix[i] + dx1[d] * s);
			int y = searchIndex(iy[i] + dy1[d] * s);
			baskets[x][y]++;
			isUsed[x][y] = true;
		}
		waterCopy();
		
		// 나머지 명령어 수행
		for (int i = 1; i < m; i++) {
			move(order[i][0], order[i][1]);
		}

		int sum = 0;
		// 구름 생성 후(이전에 구름이 사라지지 않고 물이 2 많은 곳 물 2 감소) 합산
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (baskets[i][j] >= 2 && !isUsed[i][j]) {
					baskets[i][j] -= 2;
				}
				sum += baskets[i][j];
			}
		}

		System.out.println(sum);
	}

	// 8방 탐색
	// ←, ↖, ↑, ↗, →, ↘, ↓, ↙
	static int[] dx1 = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dy1 = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };

	public static void move(int d, int s) {
		boolean[][] cloud = new boolean[n][n];

		// 명령대로 구름 생성 후 이동
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// 이전에 구름이 사라지지 않았고 물이 2보다 많은 곳
				if (baskets[i][j] >= 2 && !isUsed[i][j]) {
					baskets[i][j] -= 2;
					int x = searchIndex(i + dx1[d] * s);
					int y = searchIndex(j + dy1[d] * s);
					cloud[x][y] = true;
				}
			}
		}

		isUsed = cloud;
		// 구름이 있는 곳이라면 물 1 증가
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (isUsed[i][j]) {
					baskets[i][j]++;
				}
			}
		}
		waterCopy();
	}

	public static int searchIndex(int index) {
		// 배열의 인덱스가 뒤로 범위를 넘었을 때, 전체 길이에서 나머지 빼기
		if (index < 0 && index % n != 0) {
			return n + (index % n);
		}
		return index % n;
	}

	// 대각선만 탐색
	static int[] dx2 = { -1, -1, 1, 1 };
	static int[] dy2 = { -1, 1, 1, -1 };

	// 물 복사
	public static void waterCopy() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (isUsed[i][j]) {
					int count = 0;
					// 만약 대각선에 물이 있다면 count 증가
					for (int k = 0; k < 4; k++) {
						int x = i + dx2[k];
						int y = j + dy2[k];

						if (x < 0 || y < 0 || x >= n || y >= n)
							continue;
						if (baskets[x][y] == 0)
							continue;
						count++;
					}
					// 대각선에 물이 있는만큼 물 복사
					baskets[i][j] += count;
				}
			}
		}
	}
}
