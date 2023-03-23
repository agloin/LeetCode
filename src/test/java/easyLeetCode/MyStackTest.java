package easyLeetCode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Stack;


//push(E element), pop(); peek()
class MyStack<E> {
    private Node<E> head;
    private Node<E> tail;

    public void push(E element) {

        Node<E> newNode = new Node<>(element, null);
        if (tail == null) {
            head = newNode;
            tail = head;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
    }



    // 1-2-null
    public E pop() {
        if (tail == null) throw new NoSuchElementException();

        if (head.next == null) {
            return head.element;
        }

        Node<E> tmp = head;
        while(tmp.next.next != null) {
            tmp = tmp.next;
        }
        E res = tmp.next.element;
        tail = tmp;
        tail.next = null;
        return res;
    }

    public E peek() {
        if (tail == null) throw new NoSuchElementException();
        return tail.element;
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

public class MyStackTest {
    @Test
    public void testPopPush() {
        MyStack<Integer> myStack = new MyStack<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 10; i++) {
            myStack.push(i);
            stack.push(i);
            Assertions.assertEquals(stack.pop(), myStack.pop());
        }
    }


    @Test
    public void testPeek() {
        MyStack<Integer> myStack = new MyStack<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 10; i++) {
            myStack.push(i);
            stack.push(i);
        }

        myStack.peek();
        stack.peek();

        Assertions.assertEquals(stack.peek(), myStack.peek());

    }
}
