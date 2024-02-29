import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

/**
 * [S2] 백준 10971 외판원 순회 2
 * 메모리 : 12160KB
 * 시간 : 88ms
 * 코드 길이 : 1165B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/10971">
 */
public class Main {

	static int N, start;
	// 간선의 가중치가 100_0000이 최대값이므로 long 선택!!
	static long min = Long.MAX_VALUE;
	static int[][] array;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = parseInt(br.readLine());

		array = new int[N+1][N+1];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				array[i][j] = parseInt(st.nextToken());
			}
		}
		visited = new boolean[N];

		plan();
		System.out.println(min);
	}
	
	// ~ 백트래킹 사용 ~
	// 시작점에 따른 순회 최소값을 찾기 위해서 전부 시작점으로 삼아서 순회해보기 
	public static void plan() {
		for (start = 0; start < N; start++) {
			visited[start] = true;
			dfs(start, 0, 0l);
		}
	}

	public static void dfs(int n, int depth, long cost) {
		// 만약 지금까지의 비용이 최소값보다 크다면 유망하지 않음!! = 가지치기
		if (cost >= min)
			return;
		
		// 다 순회했다면 마지막 노드가 시작점으로 가는 경로가 있을때 최소값 갱신
		if (depth == N - 1) {
			if (array[n][start] > 0) {
				min = Math.min(min, cost + array[n][start]);
			}
			return;
		}
		
		// dfs 재귀 사용
		for (int i = 0; i < N; i++) {
			if (!visited[i] && array[n][i] > 0) {
				visited[i] = true;
				dfs(i, depth + 1, cost + array[n][i]);
				visited[i] = false;
			}
		}
	}
}
