import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [S2] 백준 1260 DFS와 BFS
 * 메모리 : 17804KB
 * 시간 : 212ms
 * 코드 길이 : 1925B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/1260">
 */
public class Main {

	static int N, M;
	static StringBuilder sb = new StringBuilder();
	static List<Integer>[] graph;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = parseInt(st.nextToken());
		M = parseInt(st.nextToken());
		int V = parseInt(st.nextToken());

		graph = new ArrayList[1001];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int left = parseInt(st.nextToken());
			int right = parseInt(st.nextToken());

			// 만약 연결된 노드가 없다면 배열 생성
			if (graph[left] == null)
				graph[left] = new ArrayList<>();

			if (graph[right] == null)
				graph[right] = new ArrayList<>();
			
			// 무방향이므로 양쪽 모두 추가
			graph[left].add(right);
			graph[right].add(left);
		}

		// 오름차순으로 정렬
		for (int i = 0; i < graph.length; i++) {
			if (graph[i] != null)
				Collections.sort(graph[i]);
		}

		visited = new boolean[1001];
		dfs(V);
		sb.append("\n");

		visited = new boolean[1001];
		bfs(V);

		System.out.println(sb);
	}

	// dfs 
	static void dfs(int v) {
		// 방문 체크
		visited[v] = true;
		sb.append(v).append(" ");

		// 이어진 노드가 없다면 종료
		if (graph[v] == null)
			return;

		// 방문하지 않은 이어진 노드 방문
		for (int number : graph[v]) {
			if (visited[number])
				continue;
			dfs(number);
		}
	}

	// bfs
	static void bfs(int v) {

		Queue<Integer> q = new ArrayDeque<>();
		q.offer(v);

		while (!q.isEmpty()) {
			int number = q.poll();
			
			// 방문한 노드 넘기기
			if (visited[number])
				continue;
			
			// 방문 체크
			visited[number] = true;
			sb.append(number).append(" ");

			// 이어진 노드가 없다면 넘기기
			if (graph[number] == null)
				continue;

			// 큐에 넣기
			for (int num : graph[number]) {
				q.offer(num);
			}

		}
	}

}
