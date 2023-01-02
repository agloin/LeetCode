package easyLeetCode.MergeTwoSortedLists;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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
        } else if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else {
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

        int[] nums1 = new int[]{1, 2, 3};
        int[] nums2 = new int[]{1, 3, 4};
        int[] commonNums = new int[]{1, 1, 2, 3, 3, 4};
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

        int i = 0;
        for (int num : nums) {
            head.val = num;
            head.next = new ListNode();
            if (i == 0) {
                tmp = head;
                i++;
            }
            head = head.next;
        }
        tmp.next = null;
        return tmp;
    }

}