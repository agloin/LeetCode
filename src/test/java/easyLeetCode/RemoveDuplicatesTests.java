package easyLeetCode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

// Input: head = [1,1,2]
// Output: [1,2]

class RemoveDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode begin = new ListNode();
        begin.next = head;

        while (head != null) {
            while (head.next != null && head.val == head.next.val) {
                head.next = head.next.next;
            }
            head = head.next;
        }

        return begin.next;
    }
}

class RemoveDuplicatesTests {

    @Test
    void deleteDuplicatesSimpleTest() {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int[] in = new int[]{1, 1, 2, 3, 3};
        int[] out = new int[]{1, 2, 3};

        ListNode listNodeIn = intArrayToListnode(in);
        ListNode listNodeOut = intArrayToListnode(out);

        while (listNodeOut != null) {
            Assertions.assertEquals(listNodeOut.val, removeDuplicates.deleteDuplicates(listNodeIn).val);
            listNodeOut = listNodeOut.next;
            listNodeIn = listNodeIn.next;
        }
    }
    @Test
    void deleteDuplicatesWithOneNumber() {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int[] in = new int[]{1};
        int[] out = new int[]{1};

        ListNode listNodeIn = intArrayToListnode(in);
        ListNode listNodeOut = intArrayToListnode(out);

        while (listNodeOut != null) {
            Assertions.assertEquals(listNodeOut.val, removeDuplicates.deleteDuplicates(listNodeIn).val);
            listNodeOut = listNodeOut.next;
            listNodeIn = listNodeIn.next;
        }
    }

    ListNode intArrayToListnode(int[] toListNode) {
        ListNode head = new ListNode();
        ListNode tmp = new ListNode();
        tmp.next = head;
        int length = toListNode.length - 1;

        for (int i = 0; i <= length; i++) {
            if (i == length) {
                head.val = toListNode[i];
                head.next = null;
                break;
            } else {
                head.val = toListNode[i];
                head.next = new ListNode();
                head = head.next;
            }
        }
        return tmp.next;
    }
}


