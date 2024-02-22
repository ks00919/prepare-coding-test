import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [G4] 백준 17471 게리맨더링
 * 메모리 : 12928KB
 * 시간 : 88ms
 * 코드 길이 : 2513B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/17471">
 */
public class Main {

	/*
	 * 1. dfs로 지역구 선정(구역 당 최소 1 지역 선정)
	 * 2. 2지역으로 나눴다면 선택 지역/선택하지 않은 지역 각각 bfs로 노드가 연결되어 있는지 확인
	 * 3. 각각 노드가 연결되어 있다면 총합 - 선택 지역 총 인구수의 절댓값과 최소값 비교 후 갱신
	 * 4. 만약 최소값이 갱신된 적이 없다면(= 두 지역으로 나눌 수 없는 경우) -1 출력
	 */
	
	// 전체 지역의 개수
	static int N;
	// 지역 인구수 총합
	static int total;
	// 지역별 인구 수
	static int[] population;
	static int[][] map;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = parseInt(br.readLine());

		population = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			// 인구수 저장 배열 초기화 및 합산
			population[i] = parseInt(st.nextToken());
			total += population[i];
		}

		selected = new int[N + 1];

		// N이 최대 10이므로 인접 행렬 사용
		map = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = parseInt(st.nextToken());

			for (int j = 0; j < n; j++) {
				int to = parseInt(st.nextToken());
				// 무방향 그래프
				map[i][to] = 1;
				map[to][i] = 1;
			}
		}
		
		// dfs로 지역을 2 구역으로 분배
		dfs(1, 0);
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

	static int[] selected;

	public static void dfs(int depth, int count) {
		// 모든 구역을 선택한 경우에는 검사하지 않음
		if (count == N)
			return;

		if (depth == N + 1) {
			
			// 모든 구역을 선택하지 않은 경우 검사하지 않음
			if (count == 0)
				return;

			// 두 구역이 각각 서로 연결되어 있다면 인구수 계산
			if (isValid(count)) {
				calculate();
			}

			return;
		}
		// 현재 depth의 구역을 선택한 경우
		selected[depth] = 1;
		dfs(depth + 1, count + 1);
		// 현재 depth의 구역을 선택하지 않은 경우
		selected[depth] = 0;
		dfs(depth + 1, count);
	}

	public static boolean isValid(int size) {
		boolean valid = false;
		
		// 1부터 N까지 중에서 맨 앞의 선택된 구역부터 bfs 시작
		for (int i = 1; i <= N; i++) {
			if (selected[i] == 1) {
				valid = bfs(i, size, 1);
				break;
			}
		}
		
		// 1부터 N까지 중에서 맨 앞의 선택된 구역부터 bfs 시작
		for (int i = 1; i <= N; i++) {
			if (selected[i] == 0) {
				valid &= bfs(i, N - size, 0);
				break;
			}
		}

		return valid;
	}

	// 총 인구수 계산
	public static void calculate() {
		int sum = 0;

		for (int i = 1; i <= N; i++) {
			if (selected[i] == 1) {
				sum += population[i];
			}
		}

		int d = Math.abs(total - sum * 2);
		// 최소값 갱신
		if (d < min)
			min = d;
	}

	// 선택된 구역, 선택되지 않은 구역이 각각 서로 연결되어있는지 bfs로 확인
	// 코드 중복을 막기 위해 select 변수로 선택 여부 확인 
	public static boolean bfs(int node, int size, int select) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(node);
		int count = 1;

		boolean[] visited = new boolean[N + 1];
		visited[node] = true;

		while (!q.isEmpty()) {
			int index = q.poll();

			for (int i = 1; i <= N; i++) {
				if (visited[i])
					continue;
				// 인접 노드 중에 선택여부가 같은 노드를 탐색
				if (map[index][i] == 1 && selected[i] == select) {
					visited[i] = true;
					q.add(i);
					count++;
				}
			}
		}
		return size == count;
	}

}
