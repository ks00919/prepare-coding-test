import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * [G5] 백준 13023 ABCDE
 * 메모리 : 18296KB
 * 시간 : 232ms
 * 코드 길이 : 1371B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/13023">
 */
public class Main {

	static List<Integer>[] array;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = parseInt(st.nextToken());
		int M = parseInt(st.nextToken());
		array = new ArrayList[N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = parseInt(st.nextToken());
			int b = parseInt(st.nextToken());
			
			// 무방향 그래프이므로 현재 연결된 노드가 없었다면 ArrayList 생성하고 양쪽 모두 add
			if (array[a] == null)
				array[a] = new ArrayList<>();
			if (array[b] == null)
				array[b] = new ArrayList<>();

			array[a].add(b);
			array[b].add(a);
		}

		// 모든 노드를 시작점으로 dfs 탐색
		for (int i = 0; i <= N; i++) {
			dfs(N, 0, i);
		}

		// 가능한 경우 1, 불가능한 경우 0 출력
		System.out.println(flag ? 1 : 0);
	}

	static boolean[] visited;
	static boolean flag;

	public static void dfs(int N, int depth, int node) {
		// 문제의 조건인 간선 4개를 달성했다면 가능한 경우로 결과 저장
		if (depth == 4) {
			flag = true;
			return;
		}

		// 이미 결과가 나왔거나, depth가 4가 되지 못했는데 연결노드가 없는 경우 return
		if (array[node] == null || flag)
			return;

		// 현재 노드 방문 체크
		visited[node] = true;
		// 연결노드들 방문 여부 체크 후 
		for (int number : array[node]) {
			// 방문 여부 체크를 dfs 호출 시점에 하지 않고 dfs 호출 후에 하면 cycle이 발생하여 불가능한 경우도 가능하다고 뜸!!
			if (!visited[number])
				dfs(N, depth + 1, number);
		}
		// 다른 경우의 수를 위해서 방문 체크 해제
		visited[node] = false;
	}
}
