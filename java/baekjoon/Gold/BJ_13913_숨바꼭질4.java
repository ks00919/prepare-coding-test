import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [G4] 백준 13913 숨바꼭질 4
 * 메모리 : 310104KB
 * 시간 : 3228MS
 * 코드 길이 : 1819B
 * 
 * @author 김민주
 * @see <a href ="https://www.acmicpc.net/problem/13913">
 */
public class Main {
	static class Node {
		// 현재 노드의 위치
		int location;
		// 현재 노드까지 이동하는데 걸리는 시간
		int degree;
		// 현재 노드까지의 효율적인 이동 경로
		ArrayList<Integer> next;

		public Node(int location, int degree, ArrayList<Integer> next) {
			this.location = location;
			this.degree = degree;
			this.next = next;
			this.next.add(location);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = parseInt(st.nextToken());
		int K = parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();

		// 만약 현재 위치가 목표위치보다 클때에는 -1 연산만 가장 효율적이기 때문에 탐색 생략
		if (N > K) {
			sb.append(N - K).append("\n");
			for (int i = N; i >= K; i--) {
				sb.append(i).append(" ");
			}
		} else {
			Queue<Node> q = new ArrayDeque<>();
			// 현재 위치
			Node curr = new Node(N, 0, new ArrayList<>());
			q.add(curr);
			boolean[] visited = new boolean[20_0001];
			
			// bfs
			while (!q.isEmpty()) {
				curr = q.poll();
				// 방문체크할 범위를 넘어가는 경우나 이미 해당 노드를 방문했을 경우 효율적이지 않은 경로이기 때문에 스킵
				if (curr.location < 0 || curr.location >= visited.length || visited[curr.location]) {
					continue;
				}
				// 방문체크
				visited[curr.location] = true;

				if (curr.location == K) {
					break;
				}
				// 모든 경우 추가
				// 이전 이동 경로 배열을 복사해서 저장
				q.add(new Node(curr.location - 1, curr.degree + 1, (ArrayList<Integer>) curr.next.clone()));
				q.add(new Node(curr.location + 1, curr.degree + 1, (ArrayList<Integer>) curr.next.clone()));
				q.add(new Node(curr.location * 2, curr.degree + 1, (ArrayList<Integer>) curr.next.clone()));
			}

			// 이동하는데 걸린 시간
			sb.append(curr.degree).append('\n');
			// 이동 경로
			for (int num : curr.next) {
				sb.append(num).append(' ');
			}
		}
		System.out.println(sb);
	}
}
