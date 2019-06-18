package com.ruaby.link;



public class LinkedList<T> {

    private class Node{
        public T value;
        public Node next;

        public Node(T value,Node next){
            this.value = value;
            this.next = next;
        }

        public Node(T value){
            this.value = value;
            this.next = null;
        }

        public Node(){
            value = null;
            next = null;
        }

    }

    // 虚拟头节点
    private Node dummyHead;
    private int size;

    public LinkedList(){
        dummyHead = new Node(null,null);
        size = 0;
    }

    public int getSize()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    // 链表一般不使用索引的方式添加元素（数组较多）
    public void add(int index,T value)
    {
        if(index < 0 || index > size){
            throw new IllegalArgumentException("index 范围错误");
        }

        Node prev = dummyHead;
        for(int i=0;i < index;i++){
            prev = prev.next;
        }

//       Node node = new Node(value);
//       node.next = prve.next;
//       prve.next = node;
        prev.next = new Node(value,prev.next);
        size++;

    }

    // 链表一般不使用索引的方式查询元素（数组较多）
    public T get(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("index 范围错误");
        }
        Node current = dummyHead.next;
        for (int i=0;i<index;i++){
            current = current.next;
        }
        return current.value;
    }

    public void set(int index,T value)
    {
        if(index < 0 || index > size){
            throw new IllegalArgumentException("index 范围错误");
        }

        Node current = dummyHead.next;
        for (int i = 0;i < index;i++){
            current = current.next;
        }
        current.value = value;
    }

    public boolean contains(T value)
    {
        Node node = dummyHead.next;
        while (node != null){
            if(node.value.equals(value)){
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public T remove(int index)
    {
        if(index < 0 || index > size){
            throw new IllegalArgumentException("index 范围错误");
        }

        Node prev = dummyHead;
        for (int i = 0;i<index;i++){
            prev = prev.next;
        }

        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.value;
    }

    public void addLast(T value)
    {
        add(size,value);
    }

    public void addFirst(T value)
    {
        add(0,value);
    }


    public T getFirst()
    {
        return get(0);
    }

    public T getLast()
    {
        return get(size - 1);
    }

    public T removeFirst()
    {
        return remove(0);
    }

    public T removeLast()
    {
        return remove(size-1);
    }


    public String toString()
    {

        StringBuilder sb = new StringBuilder();

//        Node node = dummyHead;
//        while (node != null){
//            sb.append(node + "->");
//            node = node.next;
//        }
        for (Node node = dummyHead.next;node != null;node = node.next){
            sb.append(node.value + "->");
        }
        sb.append("null");

        return sb.toString();
    }


}
