package easyLeetCode.MergeTwoSortedLists;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.LinkedList;

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
        LinkedList<Integer> arrayList = new LinkedList<>();
        var answer = new ListNode();


        if (list1 == null && list2 == null) {
            return null;
        }
        else if (list1 == null) {
            return list2;
        }
        else if (list2 == null) {
            return list1;
        }
        else {
            while (list1 != null) {
                while (list2 != null) {
                    int val2 = list2.val;

                    arrayList.add(val2);
                    list2 = list2.next;
                }
                int val1 = list1.val;

                arrayList.add(val1);
                list1 = list1.next;

            }
            Collections.sort(arrayList);

            LinkedList<ListNode> listOfAnswer = new LinkedList<>();

            for (Integer integer : arrayList) {
                answer = new ListNode(integer);
                listOfAnswer.add(answer);
            }
            for (int i = 0; i < listOfAnswer.size() - 1; i++) {
                listOfAnswer.get(i).next = listOfAnswer.get(i + 1);
            }
            return listOfAnswer.get(0);
        }

    }
}
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