package com.ruaby.queue;

import com.ruaby.array.ArraySlice;

/**
 * 基于数组 实现队列结构
 *
 * 先进先出
 * 从队尾入列，从队首出列
 *
 * 在数组移除元素的时候，会更新元素的位置
 * 出列导致 O(n)的时间复杂度
 */
public class ArrayQueue<T> implements Queue<T>{

    private ArraySlice<T> arraySlice;

    public ArrayQueue(int capacity) {
        arraySlice = new ArraySlice<>(capacity);
    }

    public ArrayQueue() {
        arraySlice = new ArraySlice<>();
    }


    @Override
    public int getSize() {
        return arraySlice.getSize();
    }

    @Override
    public boolean isEmpty() {
        return arraySlice.isEmpty();
    }

    public int getCapacity() {
        return arraySlice.getCapacity();
    }

    // 入列 O(1)
    @Override
    public void enqueue(T value) {
        arraySlice.addLast(value);
    }

    // 出列 O(N)
    @Override
    public T dequeue() {
        return arraySlice.removeFirst();
    }

    // 查看队首元素 O(1)
    @Override
    public T getFront() {
        return arraySlice.getFirst();
    }

    @Override
    public String toString()
    {

        StringBuilder sb = new StringBuilder();
        sb.append("Queue : front[");

        for (int i = 0;i < getSize();i++){
            sb.append(arraySlice.get(i));
            if(i != getSize() - 1){
                sb.append(", ");
            }
        }

        sb.append("] tail");

        return sb.toString();
    }
}
