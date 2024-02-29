import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

/**
 * SWEA 1767 [SW Test 샘플문제] 프로세서 연결하기
 * 메모리 : 23752KB
 * 실행시간 : 819ms
 * 코드길이 : 2056
 * 
 * @author 김민주
 *
 */
public class Solution {

	static int N;
	static int min;

	static int[][] map;
	static List<Pair> list;

	static class Pair {
		int x, y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = parseInt(br.readLine());
			min = MAX_VALUE;
			max = MIN_VALUE;
			map = new int[N][N];
			list = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = parseInt(st.nextToken());
					
					// 만약 테두리에 붙어있는 코어라면 dfs 범위에 포함하지 않음(0이 최소!)
					if (i == 0 || j == 0 || i == N - 1 || j == N - 1)
						continue;
					
					// 코어의 위치를 리스트에 추가하여 코어마다 탐색
					if (map[i][j] == 1) {
						list.add(new Pair(i, j));
					}
				}
			}

			dfs(0, 0, 0);
			sb.append(String.format("#%d %d%n", tc, min));
		}

		System.out.println(sb);
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	static int max;

	/* 시간초과 주의할 것!!!!
	 처음 풀 때는 모든 방향을 선택한 후에 depth가 core 수와 같으면 시뮬레이션 진행 = 시간초과
	 최적화를 위해서 모든 방향 선택 후가 아니라, 코어 하나씩 시뮬레이션 진행
	 만약 해당 방향이 전선을 놓을 수 없다면 전선을 놓지 않고 depth + 1으로 넘김(이때, 전선을 연결한 코어수는 증가하지 않음)
	 전선을 놓았다면 전선을 연결한 코어수 증가, count에 전선의 길이 합산
	 만약 이전보다 많이 놓았다면 최대 코어수, 최소 길이 갱신 / 최대 코어수와 같게 놓았다면 최소 길이만 갱신
	 */
	public static void dfs(int depth, int core, int count) {
		if (depth == list.size()) {
			if (core > max) {
				max = core;
				min = count;
			} else if (core == max)
				min = min(count, min);
			return;
		}

		int x = list.get(depth).x;
		int y = list.get(depth).y;
		
		// 4방향 탐색
		for (int i = 0; i < 4; i++) {
			int cnt = 0;
			int tx = x + dx[i];
			int ty = y + dy[i];

			while (tx >= 0 && ty >= 0 && tx < N && ty < N) {
				// 만약 전선을 놓는 경로에 다른 코어나, 전선이 있다면 전선을 놓을 수 없는 방향이므로 전선을 놓지 않음
				if (map[tx][ty] == 1) {
					cnt = 0;
					break;
				}
				// 전선의 길이 증가
				cnt++;

				tx += dx[i];
				ty += dy[i];
			}

			tx = x;
			ty = y;
			
			// 카운트한 전선 길이 만큼 전선 연결하기
			for (int j = 0; j < cnt; j++) {
				tx += dx[i];
				ty += dy[i];

				map[tx][ty] = 1;
			}
			
			// 다음 코어 방향 탐색
			if (cnt == 0)
				dfs(depth + 1, core, count);
			else
				dfs(depth + 1, core + 1, count + cnt);
			
			// 연결한 전선 복원
			tx = x;
			ty = y;
			for (int j = 0; j < cnt; j++) {
				tx += dx[i];
				ty += dy[i];

				map[tx][ty] = 0;
			}
		}
	}

}
