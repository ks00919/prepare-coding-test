import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * [S1] 백준 11286 절댓값 힙
 * 메모리 : 28664KB
 * 시간 : 428ms
 * 코드 길이 : 896B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/11286">
 */
public class Main {

	static int[] tree;
	static int count = 0;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = parseInt(br.readLine());

		// 절댓값 순으로 최소 힙, 만약 절댓값이 같다면 더 작은 수가 우선순위 높음
		Queue<Integer> q = new PriorityQueue<>((n1, n2) -> {
			int result = Math.abs(n1) - Math.abs(n2);
			return result == 0 ? n1 - n2 : result;
		});

		for (int i = 0; i < n; i++) {
			int input = parseInt(br.readLine());
			// 0이 입력되었을때
			if (input == 0) {
				// 우선순위 큐가 비어있다면 0 출력
				if (q.isEmpty()) {
					sb.append("0\n");
					continue;
				}
				// 절댓값이 가장 작은 수 삭제 및 출력
				sb.append(q.poll()).append("\n");
				continue;
			}
			// 입력값 추가
			q.add(input);
		}
		System.out.println(sb);
	}
}
