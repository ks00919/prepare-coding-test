import static java.lang.Integer.*;

import java.util.*;
import java.io.*;

/**
 * [S5] 백준 2751 수 정렬하기 2
 * 메모리 : 160680KB
 * 시간 : 1440ms
 * 코드 길이 : 551B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/2751">
 */
public class Main {

	/*
	 * 왜 Arrays.sort는 시간초과가 되고, Collections.sort는 통과할까?
	 * https://www.baeldung.com/java-arrays-collections-sort-methods
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			list.add(parseInt(br.readLine()));
		}
		Collections.sort(list);

		StringBuilder sb = new StringBuilder();
		for (int number : list)
			sb.append(number).append("\n");

		System.out.println(sb);
	}
}
