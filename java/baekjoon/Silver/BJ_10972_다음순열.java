import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [S3] 백준 10972 다음 순열
 * 메모리 : 13584KB 
 * 시간 : 120ms 
 * 코드 길이 : 1110B
 * 
 * @author 김민주
 * @see <a href = "https://www.acmicpc.net/problem/10972">
 */
public class Main {
	// next permutation 사용
	static int[] nums;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = parseInt(br.readLine());
		nums = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = parseInt(st.nextToken());
		}

		// 뒤에서 부터 뒤보다 앞에 더 작은 경우(꼭대기) 찾기
		int index = n - 1;
		while (index > 0 && nums[index - 1] >= nums[index]) {
			index--;
		}

		// 사전 순 다음 순열이 있는 경우
		if (index != 0) {
			int j = n - 1;
			// 교환 위치 찾기
			// 뒤에서부터 꼭대기보다 큰 수 중에서 가장 작은 수 찾기
			while (nums[index - 1] >= nums[j]) {
				j--;
			}

			// 수 교환하기
			swap(index - 1, j);
			int k = n - 1;

			// 꼭대기 뒤부터 오름차순 정렬
			while (k > index) {
				swap(index++, k--);
			}

			for (int i = 0; i < n; i++) {
				sb.append(nums[i]).append(' ');
			}

		} else {
			// 다음 순열이 없는 경우(내림차순) -1 출력
			sb.append(-1);
		}
		System.out.println(sb);
	}

	public static void swap(int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
