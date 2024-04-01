import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

/**
 * [G5] 백준 11729 하노이 탑 이동순서
 * 메모리 : 45896KB
 * 시간 : 336ms
 * 코드 길이 : 717B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/11729">
 */
public class Main {

	static int K, count;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = parseInt(br.readLine());

		hanoi(K, 1, 2, 3);

		System.out.println(count);
		System.out.println(sb);
	}

	public static void hanoi(int n, int start, int mid, int to) {
		// 옮길 원판이 1개 남았다면 종료
		if (n == 1) {
			count++;
			sb.append(start).append(" ").append(to).append("\n");
			return;
		}
		
		// 제일 큰 원판을 제외한 모든 원판을 가운데 기둥으로 이동
		hanoi(n - 1, start, to, mid);
		count++;
		// 제일 큰 원판을 목적 기둥으로 이동
		sb.append(start).append(" ").append(to).append("\n");
		// 나머지 원판을 다시 목적 기둥으로 이동
		hanoi(n - 1, mid, start, to);
	}

}
