package easyLeetCode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {

    @Test
    void twoSum() {
        int[] nums = new int[]{2,7,11,15};
        int target1 = 9;
        int target2 = 17;
        TwoSum twoSum = new TwoSum();

        assertArrayEquals(new int[]{0, 1}, twoSum.twoSum(nums, target1));
        assertArrayEquals(new int[]{0, 3}, twoSum.twoSum(nums, target2));
    }
}