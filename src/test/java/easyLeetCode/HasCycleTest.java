package easyLeetCode;


import org.javatuples.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// https://leetcode.com/problems/linked-list-cycle/description/
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class HasCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode h = head;
        if (head.next == null || head.next.next == null) return false;
        ListNode listNext = head.next.next;

        while (true) {
            h = h.next;
            if (listNext.next == null || listNext.next.next == null) return false;
            listNext = listNext.next.next;
            if (listNext.val == h.val) return true;
        }
    }
}

public class HasCycleTest {

    @Test
    public void testHasCycle() {
        Pair<ListNode, ListNode> pair = listAdd(new Integer[]{1, 2, 3, 4});
        ListNode head = pair.getValue0();
        ListNode tail = pair.getValue1();


        tail.next = head.next;
        Assertions.assertTrue(new HasCycle().hasCycle(head));
    }

    @Test
    public void testHasNoCycle() {
        Pair<ListNode, ListNode> pair = listAdd(new Integer[]{1, 2, 3, 4});
        ListNode head = pair.getValue0();


        Assertions.assertFalse(new HasCycle().hasCycle(head));
    }


    private Pair<ListNode, ListNode> listAdd(Integer[] values) {
        ListNode tmp = new ListNode(0);
        ListNode head = tmp;
        ListNode tail;

        if (values.length < 2) {
            head = new ListNode(values[0]);
            tail = head;
        } else {
            for (int i = 0; i < values.length - 1; i++) {
                tmp.val = values[i];
                tmp.next = new ListNode(values[i + 1]);
                tmp = tmp.next;
            }
            tail = tmp;
        }

        return new Pair<ListNode, ListNode>(head, tail);
    }
}
