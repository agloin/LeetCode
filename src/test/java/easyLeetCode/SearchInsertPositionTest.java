package easyLeetCode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchInsertPositionTest {

    @Test
    void searchInsert() {
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        int[] nums = new int[]{1, 3, 5, 6};
        int target1 = 5;
        int target2 = 7;
        int target3 = 0;

        assertEquals(2, searchInsertPosition.searchInsert(nums, target1));
        assertEquals(4, searchInsertPosition.searchInsert(nums, target2));
        assertEquals(0, searchInsertPosition.searchInsert(nums, target3));
    }
}