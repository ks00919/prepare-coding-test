import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

/**
 * [S4] 백준 1026 보물
 * 메모리 : 11628KB
 * 시간 : 80ms
 * 코드 길이 : 738B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/1026">
 */
public class Main {
	// 그리디
	// 가장 작은 S값을 만들기 위해서는 큰 수 * 작은수 순서대로의 곱셈의 합이 가장 작을 것이라고 가정
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = parseInt(br.readLine());
		int[] A = new int[N];
		int[] B = new int[N];

		StringTokenizer a = new StringTokenizer(br.readLine());
		StringTokenizer b = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = parseInt(a.nextToken());
			B[i] = parseInt(b.nextToken());
		}

		Arrays.sort(A);
		Arrays.sort(B);

		int sum = 0;
		int index = N - 1;
		for (int i = 0; i < N; i++) {
			sum += A[i] * B[index--];
		}

		System.out.println(sum);
	}
}
