package com.ruaby.queue;

/**
 * 基于数组 实现队列结构
 *
 * 先进先出
 * 从队尾入列，从队首出列
 *
 * 在数组移除元素的时候，不去更新元素的位置，由front tail控制队列的头和尾
 */
public class ArrayLoopQueue<T> implements Queue<T> {

    private T[] data;
    private int front;
    private int tail;
    private int size;

    // 构造器
    public ArrayLoopQueue(int capacity) {
        data = (T[])new Object[capacity+1];
        front = 0;
        tail = 0; // 最后一个空值
        size = 0;
    }

    // 构造器
    public ArrayLoopQueue() {
        this(10);
    }


    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front != tail;
    }

    public int getCapacity()
    {
        return data.length - 1;
    }

    // 入列 O(1)
    @Override
    public void enqueue(T value) {
        // 扩容
        if((tail + 1) % data.length == front ){
            resize(data.length * 2);
        }

        data[tail] = value;
        tail = (tail+1) % data.length;

        size++;
    }

    // 出列 O(1)
    @Override
    public T dequeue() {
        if(!isEmpty()){
            throw new IllegalArgumentException("队列为空");
        }

        T value = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;

        // 缩容
        if(size == getCapacity() / 4 && getCapacity() / 2 != 0){
            resize(getCapacity() / 2);
        }
        return value;
    }

    // O(1)
    @Override
    public T getFront() {
        return data[front];
    }

    // 扩容
    private void resize(int length)
    {
        T[] _data = (T[])new Object[length];
        for (int i=0;i<size;i++){
            // 循环队列的实现
            _data[i] = data[(front+i) % data.length];
        }
        data = _data;
        front = 0;
        tail = size;
    }

    @Override
    public String toString()
    {

        StringBuilder sb = new StringBuilder();
        sb.append("LoopQueue cap= "+getCapacity()+" : front[");

        for (int i = 0;i < getSize();i++){

            sb.append(data[(front + i) % data.length]);
            if(i != getSize() - 1){
                sb.append(", ");
            }
        }

        sb.append("] tail");
        return sb.toString();
    }

}
