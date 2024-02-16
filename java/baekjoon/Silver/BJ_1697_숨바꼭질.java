import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [S1] 백준 1697 숨바꼭질
 * 메모리 : 19536KB
 * 시간 : 132ms
 * 코드 길이 : 1295B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/1697">
 */
public class Main {
	static class Node {
		int value;
		int degree;

		public Node(int value, int degree) {
			this.value = value;
			this.degree = degree;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = parseInt(st.nextToken());
		int K = parseInt(st.nextToken());

		// 만약 N(출발)이 K(도착)보다 크다면 -1이 가장 효율적이므로 계산 후 프로그램 종료
		if (N > K) {
			System.out.println(N - K);
			return;
		}

		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(N, 0));
		boolean[] visited = new boolean[10_0001];

		Node number = null;
		// bfs
		while (!q.isEmpty()) {
			number = q.poll();
			// 도착노드라면 반복문 종료
			if (number.value == K) {
				break;
			}
			// 만약 배열의 범위를 넘거나 이미 방문한 배열이라면 비효율적인 경로이므로 넘김
			if (number.value >= visited.length || number.value < 0 || visited[number.value]) {
				continue;
			}
			// 방문 체크 후 같은 너비 모두 큐에 추가
			visited[number.value] = true;
			q.add(new Node(number.value - 1, number.degree + 1));
			q.add(new Node(number.value + 1, number.degree + 1));
			q.add(new Node(number.value * 2, number.degree + 1));
		}

		System.out.println(number.degree);
	}
}
