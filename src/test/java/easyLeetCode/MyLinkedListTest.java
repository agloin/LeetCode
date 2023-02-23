package easyLeetCode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

class MyLinkedList<E> {

    private Node<E> head;
    private int size = 1;

    public void add(E element) {
        if (head == null) head = new Node<>(element, null);
        else {
            Node<E> tmp = head;

            while (tmp.next != null) tmp = tmp.next;
            tmp.next = new Node<>(element, null);
            size++;
        }
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

        for (int i = 0; i < index - 1; i++) {
            tmp = tmp.next;
        }
        tmp.next = tmp.next.next;
        size--;
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

    public int size() {
        if (head == null) return 0;
        return size;
    }

    public MyLinkedList<E> reverse() {
        MyLinkedList<E> tmp = new MyLinkedList<>();

        for (int i = size - 1; i >= 0; i--) {
            tmp.add(get(i));
        }
        return tmp;
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

        LinkedList<Integer> compareList  = new LinkedList<>();
        compareList.addAll(Arrays.asList(1, 2, 3, 4));

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


        MyLinkedList<Integer> listReverse = list.reverse();


        compare(listCompare, listReverse);


    }

    @Test
    void testRemove() {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.addAll(1, 2, 3, 4);

        list.remove(3);

        LinkedList<Integer> compareList = new LinkedList<>(Arrays.asList(1, 2, 3));


        Assertions.assertEquals(compareList.size(), list.size());


       compare(compareList, list);

    }

    private void compare(List<?> compareList, MyLinkedList<?> list) {
        int compareListLastIndex = compareList.size() - 1;

        for (int i = 0; i <= compareListLastIndex; i++) {
            Assertions.assertEquals(compareList.get(i), list.get(i));
        }
    }


}
