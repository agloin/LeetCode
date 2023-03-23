package easyLeetCode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Stack;


//push(E element), pop(); peek()
class MyStack<E> {
    private Node<E> tail;
    private int size = 0;

    public void push(E element) {
        tail = new Node<>(element, tail);
        size++;
    }


    public E pop() {
        if (tail == null) throw new NoSuchElementException();

        E res = tail.element;
        tail = tail.prev;
        size--;
        return res;
    }


    public E peek() {
        if (tail == null) throw new NoSuchElementException();
        return tail.element;
    }


    public int size() {
        return size;
    }


    private static class Node<E> {
        E element;
        Node<E> prev;

        public Node(E element, Node<E> prev) {
            this.element = element;
            this.prev = prev;
        }
    }

}

public class MyStackTest {
    @Test
    public void testPopSize() {
        MyStack<Integer> myStack = new MyStack<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 10; i++) {
            myStack.push(i);
            stack.push(i);
        }

        Assertions.assertEquals(stack.size(), myStack.size());
    }

    @Test
    public void testPopPush() {
        MyStack<Integer> myStack = new MyStack<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 10; i++) {
            myStack.push(i);
            stack.push(i);
        }
        Assertions.assertEquals(stack.pop(), myStack.pop());
        Assertions.assertEquals(stack.size(), myStack.size());
    }


    @Test
    public void testPopPushPopOneLastElement() {
        MyStack<Integer> myStack = new MyStack<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 10; i++) {
            myStack.push(i);
            stack.push(i);
            Assertions.assertEquals(stack.pop(), myStack.pop());
        }
        Assertions.assertEquals(stack.size(), myStack.size());
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
        Assertions.assertEquals(stack.size(), myStack.size());
    }
}
