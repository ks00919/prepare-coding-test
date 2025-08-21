import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<String> set = new HashSet<>();
        set.add("Never gonna give you up");
        set.add("Never gonna let you down");
        set.add("Never gonna run around and desert you");
        set.add("Never gonna make you cry");
        set.add("Never gonna say goodbye");
        set.add("Never gonna tell a lie and hurt you");
        set.add("Never gonna stop");

        int n = Integer.parseInt(br.readLine());
        boolean answer = false;
        for (int i = 0; i < n; i++) {
            if (!set.contains(br.readLine())) {
                answer = true;
                break;
            }
        }

        System.out.println(answer ? "Yes" : "No");
    }
}