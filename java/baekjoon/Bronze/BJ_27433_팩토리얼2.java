import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * [B5] 백준 27433 팩토리얼 2
 * 메모리 : 11464KB
 * 시간 : 76ms
 * 코드 길이 : 475B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/27433">
 */
class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 출력
        System.out.println(factorial(Integer.parseInt(br.readLine())));
    }

    static long factorial(int n) {
        // 0! = 1
        if (n <= 0) {
            return 1;
        }
        // 재귀
        return n * factorial(n - 1);
    }
}