package easyLeetCode.MergeTwoSortedLists;

import java.util.Collections;
import java.util.LinkedList;

public class MergeTwoSortedLists {
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
