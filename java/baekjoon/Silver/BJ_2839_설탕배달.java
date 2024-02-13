import static java.lang.Integer.*;
import java.io.*;

/**
 * [S4] 백준 2839 설탕 배달
 * 메모리 : 11508KB
 * 시간 : 80ms
 * 코드 길이 : 594B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/2839">
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = parseInt(br.readLine());
        int count = 0;

        // 남은 설탕이 있을때
        while (N > 0) {
            // 남은 설탕이 5kg로 나누어 떨어지면 끝
            if (N % 5 == 0) {
                count += N / 5;
                break;
            }
            // 3kg 봉지에 담기
            N -= 3;
            count += 1;
        }

        if (N < 0) {
            System.out.println(-1);
        } else {
            System.out.println(count);
        }
    }
}