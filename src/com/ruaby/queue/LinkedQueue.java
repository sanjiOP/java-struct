package com.ruaby.queue;

/**
 * 基于链表 实现队列结构
 *
 * 先进先出
 * 从队尾入列，从队首出列
 *
 * 正常情况下，入列时间复杂度是O(N)
 *
 *
 *
 * 改进
 * 维护一个head tail节点；
 * 队首 | (head)1->2->3->4(tail) | 队尾
 *
 * 在head端添加和删除节点，时间复杂度O(1)
 * 在tail添加节点，相当于tail.next = node;时间复杂度为O(1)
 * 将tail做队首，head端做队尾
 */
public class LinkedQueue<T> implements Queue<T> {


    // 节点
    private class Node{
        public T value;
        public Node next;

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(T value){
            this.value = value;
            this.next = null;
        }
    }


    private Node head,tail;
    private int size;


    public LinkedQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    // 入队 O(1)
    @Override
    public void enqueue(T value) {

        if(isEmpty()){
            head = tail = new Node(value);
        }else{
            tail.next = new Node(value);
            tail = tail.next;
        }
        size++;
    }

    // 出队 O(1)
    @Override
    public T dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("队列为空");
        }

        Node delNode = head;
        head = head.next;
        delNode.next = null;

        //最后一个元素出队,不然tail仍指向delNode
        if(head == null){
            tail = null;
        }
        size--;
        return delNode.value;
    }

    @Override
    public T getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("队列为空");
        }
        return head.value;
    }

    @Override
    public String toString()
    {

        StringBuilder sb = new StringBuilder();
        sb.append("LinkedQueue : front [ ");

        Node current = head;
        while (current != null){
            sb.append(current.value + "->");
            current = current.next;
        }

        sb.append("null ] tail");
        return sb.toString();
    }
}
