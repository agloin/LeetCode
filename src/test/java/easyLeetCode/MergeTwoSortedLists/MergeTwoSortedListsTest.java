package easyLeetCode.MergeTwoSortedLists;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MergeTwoSortedListsTest {

    @Test
    void mergeTwoSortedListsTest() {
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        ListNode list1 = new ListNode(3, null);
        ListNode list2 = new ListNode(2, list1);
        ListNode list3 = new ListNode(1, list2);

        ListNode list4 = new ListNode(1, null);
        ListNode list5 = new ListNode(3, list4);
        ListNode list6 = new ListNode(4, list5);

        ListNode resCompare1 = new ListNode(4, null);
        ListNode resCompare2 = new ListNode(3, resCompare1);
        ListNode resCompare3 = new ListNode(3, resCompare2);
        ListNode resCompare4 = new ListNode(2, resCompare3);
        ListNode resCompare5 = new ListNode(1, resCompare4);
        ListNode resCompare6 = new ListNode(1, resCompare5);

        var res = mergeTwoSortedLists.mergeTwoLists(list3, list6);

        ListNode head;
        head = resCompare6;

        while (head != null) {

            assertEquals(head.val, res.val);
            head = head.next;
            res = res.next;
        }
    }

}