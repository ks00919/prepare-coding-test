import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [S4] 백준 1920 수 찾기 
 * 메모리 : 50140KB 
 * 시간 : 492ms 
 * 코드 길이 : 1223B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/1920">
 */
public class Main {

	static int[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		int M = parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {
			sb.append(BinarySearch(N, parseInt(st.nextToken()))).append("\n");
		}
		System.out.println(sb);
	}

	public static int BinarySearch(int length, int key) {
		int start = 0;
		int end = length - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] == key) { // 찾았다면 1 return
				return 1;
			} else if (key < arr[mid]) { // 작다면 왼쪽 블럭으로 축소
				end = mid - 1;
			} else { // 크다면 오른쪽 블럭으로 축소
				start = mid + 1;
			}
		}
		return 0;
	}
}
