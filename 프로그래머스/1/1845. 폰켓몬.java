import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        int number = nums.length / 2;
        Set<Integer> pick = new HashSet<>();

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count >= number)
                break;
            int poncketmon = nums[i];
            if (!pick.contains(poncketmon)) {
                pick.add(poncketmon);
                count++;
            }
        }
        return count;
    }
}