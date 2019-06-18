package com.ruaby.stack;


import com.ruaby.link.LinkedList;

/**
 * 基于链表 实现栈结构
 *
 * 后进先出
 * 从队尾入列，从队尾出列
 *
 * 把链表的头当做栈顶，可以实现 O(1) 复杂度
 */
public class LinkedStack<T> implements Stack<T> {


    private LinkedList<T> linkedList;

    public LinkedStack() {
        linkedList = new LinkedList<>();
    }

    // O(1)
    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    // O(1)
    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    // O(1)
    @Override
    public void push(T value) {
        linkedList.addFirst(value);
    }

    // O(1)
    @Override
    public T pop() {
        return linkedList.removeFirst();
    }

    // O(1)
    @Override
    public T peek() {
        return linkedList.getFirst();
    }

    @Override
    public String toString()
    {
        String sb = "LinkedStack : top " + linkedList;
        return sb;
    }
}
