import static java.lang.Integer.*;
import java.io.*;
import java.math.BigInteger;

/**
 * [S1] 백준 1914 하노이 탑
 * 메모리 : 44852KB
 * 시간 : 308ms
 * 코드 길이 : 1134B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/1914">
 */
class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = parseInt(br.readLine());

        if (N <= 20) {
            // 하노이 탑에서 옮기는 횟수는 2^N -1
            sb.append((int) (Math.pow(2, N) - 1)).append("\n");
            hanoi(N, 1, 2, 3);
        } else {
            // 20 이상이면 overflow 발생하므로 BigInteger 사용
            BigInteger K = new BigInteger("1");
            for (int i = 0; i < N; i++) {
                K = K.multiply(new BigInteger("2"));
            }
            K = K.subtract(new BigInteger("1"));
            sb.append(K);
        }
        System.out.println(sb);
    }

    // n개의 원반을 start에서 to로 옮기기
    // mid = 가운데 장대
    public static void hanoi(int n, int start, int mid, int to) {
        if (n == 1) { // 옮길 원반이 한 개(기저조건)
            sb.append(start).append(" ").append(to).append("\n");
            return;
        }

        // n-1개의 원판을 시작 장대에서 가운데 장대로 옮기기
        hanoi(n - 1, start, to, mid);

        sb.append(start).append(" ").append(to).append("\n");

        // n-1개의 원판을 가운데 장대에서 목적 장대로 옮기기
        hanoi(n - 1, mid, start, to);
    }
}