package easyLeetCode;

// nums = [2,7,11,15], target = 9

// Given an array of integers nums and an integer target,
// return indices of the two numbers such that they add up to target.
//
// You may assume that each input would have exactly one solution,
// and you may not use the same element twice.
//
// You can return the answer in any order.
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int j = nums.length - 1;
        int[] answer = new int[0];

        for (int i = 0; i < nums.length; i++) {
            while (j != i) {
                if (nums[i] + nums[j] == target) {
                    answer = new int[]{i, j};
                    return answer;
                }
                j--;
            }
            j = nums.length - 1;
        }
        return answer;
    }
}
