import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [S4] 백준 1158 요세푸스 문제 
 * 메모리 : 12840KB 
 * 시간 : 284ms 
 * 코드 길이 : 922B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/1158">
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 출력형식 초기화
		StringBuilder sb = new StringBuilder("<");

		int n = parseInt(st.nextToken());
		int k = parseInt(st.nextToken());

		Queue<Integer> people = new ArrayDeque<>(n);

		// 먼저 수열 초기화
		for (int i = 1; i <= n; i++) {
			people.add(i);
		}

		for (int i = 1; !people.isEmpty(); i++) {
			// 만약 K번째 사람이라면
			if (i % k == 0) {
				// 제거하여 결과값 저장
				sb.append(people.poll()).append(", ");
				continue;
			}
			// K번째 사람이 아니라면 제거한 사람 다시 큐에 저장
			people.add(people.poll());
		}

		// 마지막 쉼표 제거
		sb.setLength(sb.length() - 2);
		sb.append('>');
		// 출력
		System.out.println(sb);
	}
}
