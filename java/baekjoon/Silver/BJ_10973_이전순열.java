import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [S3] 백준 10973 이전 수열
 * 메모리 : 14384KB
 * 시간 : 124ms
 * 코드 길이 : 1060B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/10973">
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = parseInt(br.readLine());

		int[] arr = new int[N];
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = parseInt(st.nextToken());
		}
		
		// 뒤에서부터 현재보다 앞이 더 큰 곳 찾기
		int i = N - 1;
		while (i > 0 && arr[i] >= arr[i - 1]) {
			i--;
		}
		
		// 만약 전부 앞이 더 작다면 오름차순 정렬이므로 맨 처음 수열
		// -1 출력 후 프로그램 정상종료
		if (i == 0) {
			System.out.println("-1");
			System.exit(0);
		}
		
		// 뒤에서부터 찾은 곳보다 작은 수 찾기(작은 수들 중에서 가장 큰 수)
		int j = N - 1;
		while (arr[j] >= arr[i - 1]) {
			j--;
		}
		// 교환 위치와 교환
		swap(arr, i - 1, j);
		
		// 찾은 곳 뒤를 내림차순 정렬
		int k = N - 1;
		while (i < k) {
			swap(arr, i++, k--);
		}
		
		// 결과 출력
		StringBuilder sb = new StringBuilder();
		for (int num : arr) {
			sb.append(num).append(' ');
		}

		System.out.println(sb);
	}

	public static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}
