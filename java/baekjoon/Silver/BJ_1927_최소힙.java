import static java.lang.Integer.*;

import java.util.*;
import java.io.*;

/**
 * [S2] 백준 1927 최소 힙
 * 메모리 : 25536KB
 * 시간 : 308ms
 * 코드 길이 : 618B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/1927"/>
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = parseInt(br.readLine());
		Queue<Integer> q = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			int order = parseInt(br.readLine());

			if (order == 0) {
				if (q.isEmpty())
					sb.append(0).append("\n");
				else
					sb.append(q.poll()).append("\n");
			} else {
				q.add(order);
			}
		}
		System.out.println(sb);
	}
}
