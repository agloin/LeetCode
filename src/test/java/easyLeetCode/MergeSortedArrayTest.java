package easyLeetCode;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// https://leetcode.com/problems/merge-sorted-array/
class MergeTwoSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m--;
        n--;
        int r = nums1.length - 1;

        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[r--] = nums1[m--];
            } else {
                nums1[r--] = nums2[n--];
            }
        }
        while (n >= 0) {
            nums1[r--] = nums2[n--];
        }
    }
}
public class MergeSortedArrayTest {

    @Test
    void mergeTowSortedArrays() {
        MergeTwoSortedArrays mergeTwoSortedArrays = new MergeTwoSortedArrays();
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{1, 3, 5};

        mergeTwoSortedArrays.merge(nums1, 3, nums2, 3);

        Assertions.assertArrayEquals(new int[]{1, 1, 2, 3, 3, 5}, nums1);

    }

    @Test
    void mergeTowSortedArraysWithOneEmptyArray() {
        MergeTwoSortedArrays mergeTwoSortedArrays = new MergeTwoSortedArrays();
        int[] nums1 = new int[]{1, 2, 3};
        int[] nums2 = new int[]{};

        mergeTwoSortedArrays.merge(nums1, 3, nums2, 0);

        Assertions.assertArrayEquals(new int[]{1, 2, 3}, nums1);

    }

    @Test
    void mergeTowSortedArraysWithTwoEmptyArray() {
        MergeTwoSortedArrays mergeTwoSortedArrays = new MergeTwoSortedArrays();
        int[] nums1 = new int[]{};
        int[] nums2 = new int[]{};

        mergeTwoSortedArrays.merge(nums1, 0, nums2, 0);

        Assertions.assertArrayEquals(new int[]{}, nums1);

    }
}
