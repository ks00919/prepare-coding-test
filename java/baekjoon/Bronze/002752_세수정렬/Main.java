import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [B4] 백준 2752 세수정렬
 * 
 * 메모리 : 11564KB
 * 시간 : 88ms
 * 코드 길이 : 771B
 * 
 * @see <a href="https://www.acmicpc.net/problem/2752"/>
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] numbers = new int[3];
        for (int i = 0; i < 3; i++) {
            numbers[i] = parseInt(st.nextToken());
        }
        Arrays.sort(numbers);

        StringBuilder sb = new StringBuilder();
        for (int number : numbers) {
            sb.append(number).append(" ");
        }
        System.out.println(sb);
    }
}