package easyLeetCode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

class MyLinkedList<E> {

    private Node<E> head;

    public void add(E element) {
        if (head == null) head = new Node<>(element, null);
        else {
            Node<E> tmp = head;

            while (tmp.next != null) tmp = tmp.next;
            tmp.next = new Node<>(element, null);
        }
    }

    public E get(int index) {
        if (head == null) throw new IndexOutOfBoundsException("this Index is null");

        Node<E> tmp = head;

        while (index-- > 0) {
            if (tmp == null) throw new IndexOutOfBoundsException("this Index is null");
            tmp = tmp.next;
        }
        return tmp.element;
    }

    int size() {
        if (head == null) return 0;

        Node<E> tmp = head;
        int size = 1;
        while (tmp.next != null) {
            size++;
            tmp = tmp.next;
        }
        return size;
    }

    MyLinkedList<E> reverse() {
        Stack<E> stack = new Stack<>();
        Node<E> tmp = head;

        while (tmp != null) {
            stack.push(tmp.element);
            tmp = tmp.next;
        }

        MyLinkedList<E> myLinkedList = new MyLinkedList<>();

        while (!stack.empty()) {
            myLinkedList.add(stack.pop());
        }
        return myLinkedList;
    }

    private static class Node<E> {
        E element;
        Node<E> next;

        Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }
}

public class MyLinkedListTest {

    @Test
    void testAdd() {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        Assertions.assertEquals(4, list.size());


    }

    @Test
    void testSize() {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        int size = list.size();
        Assertions.assertEquals(4, size);

        for (int i = 0; i < size; i++) {
            Assertions.assertEquals(1 + i, list.get(i));
        }


    }

    @Test
    void testReverse() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        MyLinkedList<Integer> listCompare = new MyLinkedList<>();


        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        listCompare.add(4);
        listCompare.add(3);
        listCompare.add(2);
        listCompare.add(1);

        MyLinkedList<Integer> listReverse = list.reverse();
        for (int i = 0; i < list.size(); i++) {
            Assertions.assertEquals(listCompare.get(i), listReverse.get(i));
        }


    }


}
