import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {

        Set<Integer> pick = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            pick.add(nums[i]);
        }

        int number = nums.length / 2;
        int size = pick.size();

        if (pick.size() > number) {
            return number;
        }
        return size;
    }
}