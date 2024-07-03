import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

/**
 * [B5] 백준 25314 코딩은 체육과목 입니다
 * 메모리 : 11520KB
 * 시간 : 76ms
 * 코드 길이 : 570B
 *
 * @see <a href="https://www.acmicpc.net/problem/25314"/>
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());

        int count = n / 4;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append("long ");
        }
        sb.append("int");
        System.out.println(sb);
    }
}
