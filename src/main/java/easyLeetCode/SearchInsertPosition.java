package easyLeetCode;

// nums = [1,3,5,6], target = 5

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int i = 0;
        int length = nums.length;


        if (target > nums[length -1]) {
            return length;
        }
        else if (target < nums[0]) {
            return 0;
        }
        while (i < length) {
            if (nums[i] == target) {
                return i;
            }
            else if (target > nums[i] && target < nums[i + 1]) {
                return i + 1;
            }
            i++;
        }
        return -1;
    }
}

// Given a sorted array of distinct integers and a target value,
// return the index if the target is found.
// If not, return the index where it would be if it were inserted in order.
//
//You must write an algorithm with O(log n) runtime complexity.