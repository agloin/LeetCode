package easyLeetCode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

class MyLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    public void add(E element) {
        Node<E> newNode = new Node<>(element, null);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
        size++;
    }

    @SafeVarargs // не понимаю, почему здесь нужна эта аннотация и модификатор final
    public final void addAll(E... values) {
        for (var element : values) {
            add(element);
        }
    }

    public void remove(int index) {
        Node<E> tmp = head;

        if (size == 0 || index >= size || index < 0) throw new NoSuchElementException();


        if (index == size - 1) {
            while (tmp.next.next != null) {
                tmp = tmp.next;
            }
            tail = tmp;
            tail.next = null;
        } else if (index == 0) {
            head = head.next;
        } else if (index == 1) {
           head.next = head.next.next;
        } else { // remove(1)          1-2-3-4
            for (int i = 0; i < index; ++i) {
                tmp = tmp.next;
            }
            tmp.next = tmp.next.next;
        }
        size--;
    }

    public E get(int index) {
        if (head == null) throw new IndexOutOfBoundsException("this Index is null");
        if (index == size - 1) return tail.element;

        Node<E> tmp = head;

        while (index-- > 0) {
            if (tmp == null) throw new IndexOutOfBoundsException("this Index is null");
            tmp = tmp.next;
        }
        return tmp.element;
    }

    public int size() {
        if (head == null) return 0;
        return size;
    }

    public void reverse() {
        Node<E> curr = head;
        Node<E> prev = null;

        while (curr != null) {
            Node<E> next = curr.next; //4-5
            curr.next = prev; //3-2-1
            prev = curr; //
            curr = next;
        }

        Node<E> tmp = head;
        head = tail;
        tail = tmp;
    }


    private static class Node<E> {
        E element;
        Node<E> next;


        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }
}

public class MyLinkedListTest {

    @Test
    void testAdd() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        LinkedList<Integer> compareList = new LinkedList<>(Arrays.asList(1, 2, 3, 4));

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);


        Assertions.assertEquals(compareList.size(), list.size());

        compare(compareList, list);
    }

    @Test
    void testAddAll() {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.addAll(1, 2, 3, 4);

        LinkedList<Integer> compareList = new LinkedList<>(Arrays.asList(1, 2, 3, 4));

        int size = list.size();


        Assertions.assertEquals(compareList.size(), size);


        compare(compareList, list);


    }

    @Test
    void testSize() {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.addAll(1, 2, 3, 4);

        LinkedList<Integer> compareList = new LinkedList<>(Arrays.asList(1, 2, 3, 4));

        int size = list.size();


        Assertions.assertEquals(compareList.size(), size);


    }

    @Test
    void testReverse() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        LinkedList<Integer> listCompare = new LinkedList<>(Arrays.asList(4, 3, 2, 1));

        list.addAll(1, 2, 3, 4);


        list.reverse();


        compare(listCompare, list);
        compare(Arrays.asList(4, 3, 2, 1), list);

    }

    @Test
    void testRemoveMiddle() {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.addAll(1, 2, 3, 4);
        list.remove(1);


        Assertions.assertEquals(3, list.size());


        compare(Arrays.asList(1, 3, 4), list);

    }

    @Test
    void testRemoveFirst() {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.addAll(1, 2, 3, 4);
        list.remove(0);


        Assertions.assertEquals(3, list.size());


        compare(Arrays.asList(2, 3, 4), list);

    }

    @Test
    void testRemoveLast() {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.addAll(1, 2, 3, 4);
        list.remove(3);


        Assertions.assertEquals(3, list.size());


        compare(Arrays.asList(1, 2, 3), list);

    }

    private void compare(List<?> compareList, MyLinkedList<?> list) {
        int compareListLastIndex = compareList.size() - 1;

        for (int i = 0; i <= compareListLastIndex; i++) {
            Assertions.assertEquals(compareList.get(i), list.get(i));
        }
    }


}
