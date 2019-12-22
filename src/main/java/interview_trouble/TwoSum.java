package interview_trouble;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangll
 * @create 2019-12-17 21:25
 */
public class TwoSum {
    public static void main(String[] args) {
        TwoSum solution = new TwoSum();
        System.out.println(solution.twoSum(new int[]{3, 10, 7, 9, 14, 0, 8, 2, 5, 11}, 11));
    }

    public List<String> twoSum(int[] nums, int target) {
        List<String> result = new ArrayList<String>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                result.add("(" + map.get(complement) + "," + complement + ")");
            }
            map.put(nums[i], complement);
        }

        return result;
    }
}
