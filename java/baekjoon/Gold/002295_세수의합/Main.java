import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

/**
 * [G4] 백준 2295 세 수의 합
 * 메모리 ; 72232KB
 * 시간 : 304ms
 * 코드 길이 : 1116B
 *
 * @see <a href="https://www.acmicpc.net/problem/2295"/>
 */
public class Main {

    /*
    x + y + z = k 일때, x + y = k - z와 같음을 이용하는 문제
    이를 이용해서 조건에 맞는 최댓값 k를 찾으면 된다!
    
    왼쪽 방정식을 이용해서 풀이했다가 3중 for문으로 메모리 초과 발생
    오른쪽 방정식을 사용해서 최적화
    수학 공부를 하자..
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = parseInt(br.readLine());
        long max = Long.MIN_VALUE;

        Set<Long> set = new HashSet<>();
        long[] numbers = new long[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = parseLong(br.readLine());
            set.add(numbers[i]);
        }

        for (int x = 0; x < n; x++) {
            for (int y = x; y < n; y++) {
                set.add(numbers[x] + numbers[y]);
            }
        }

        for (int k = 0; k < n; k++) {
            for (int z = 0; z < n; z++) {
                if (set.contains(numbers[k] - numbers[z])) {
                    max = Math.max(max, numbers[k]);
                }
            }
        }

        System.out.println(max);
    }
}
