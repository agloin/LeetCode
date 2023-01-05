package easyLeetCode.MergeTwoSortedLists;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// https://leetcode.com/problems/merge-two-sorted-lists/description/
class ListNode {
    int val;
    easyLeetCode.MergeTwoSortedLists.ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, easyLeetCode.MergeTwoSortedLists.ListNode next) {
        this.val = val;
        this.next = next;
    }
}


class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        ListNode head = new ListNode();

        if (list1.val < list2.val) {
            head.next = list1;
            list1 = list1.next;
        } else {
            head.next = list2;
            list2 = list2.next;
        }
        if (list1 == null) {
            head.next.next = list2;
        }
        if (list2 == null) {
            head.next.next = list1;
        }

        ListNode tmp = head.next;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tmp.next = list1;
                list1 = list1.next;
            } else {
                tmp.next = list2;
                list2 = list2.next;
            }
            tmp = tmp.next;

            if (list1 == null) {
                tmp.next = list2;
            }
            if (list2 == null) {
                tmp.next = list1;
            }
        }
        return head.next;
    }

}


class MergeTwoSortedListsTest {

    @Test
    void mergeTwoSortedListsTest() {
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        int[] nums1 = new int[]{1, 2, 4};
        int[] nums2 = new int[]{1, 3, 4};

        int[] commonNums = new int[]{1, 1, 2, 3, 4, 4};
        ListNode list1 = intSortedArrayToListNode(nums1);
        ListNode list2 = intSortedArrayToListNode(nums2);


        var res = mergeTwoSortedLists.mergeTwoLists(list1, list2);


        ListNode head;
        head = intSortedArrayToListNode(commonNums);

        while (head != null) {
            assertEquals(head.val, res.val);
            head = head.next;
            res = res.next;
        }
    }

    @Test
    void test(){
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();

        int[] nums3 = new int[]{2};
        int[] nums4 = new int[]{1};
        int[] commonNums = new int[]{1, 2};

        ListNode list1 = intSortedArrayToListNode(nums3);
        ListNode list2 = intSortedArrayToListNode(nums4);

        var res = mergeTwoSortedLists.mergeTwoLists(list1, list2);

        ListNode head;
        head = intSortedArrayToListNode(commonNums);

        while (head != null) {
            assertEquals(head.val, res.val);
            head = head.next;
            res = res.next;
        }
    }

    @Test
    void mergeTwoSortedListsWithEmptyLists() {
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        int[] nums1 = new int[]{};
        int[] nums2 = new int[]{};
        int[] commonNums = new int[]{};
        ListNode list1 = intSortedArrayToListNode(nums1);
        ListNode list2 = intSortedArrayToListNode(nums2);


        var res = mergeTwoSortedLists.mergeTwoLists(list1, list2);


        ListNode head;
        head = intSortedArrayToListNode(commonNums);

        while (head != null) {
            assertEquals(head.val, res.val);
            head = head.next;
            res = res.next;
        }
    }

    @Test
    void mergeTwoSortedListsWithOneEmptyLists() {
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        int[] nums1 = new int[]{};
        int[] nums2 = new int[]{0};
        int[] commonNums = new int[]{0};
        ListNode list1 = intSortedArrayToListNode(nums1);
        ListNode list2 = intSortedArrayToListNode(nums2);


        var res = mergeTwoSortedLists.mergeTwoLists(list1, list2);


        ListNode head;
        head = intSortedArrayToListNode(commonNums);

        while (head != null) {
            assertEquals(head.val, res.val);
            head = head.next;
            res = res.next;
        }
    }


    ListNode intSortedArrayToListNode(int[] nums) {
        ListNode head = new ListNode();
        ListNode tmp = new ListNode();
        int length = nums.length;

//        int i = 0;
        for (int i = 0; i < length; i++) {
            head.val = nums[i];
            head.next = new ListNode();
            if (i == 0) tmp = head;


            if (i != length - 1) head = head.next;
            else head.next = null;
        }
        return tmp;
    }

}