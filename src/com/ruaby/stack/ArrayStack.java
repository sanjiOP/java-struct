package com.ruaby.stack;

import com.ruaby.array.ArraySlice;

/**
 * 基于数组 实现栈结构
 *
 * 后进先出
 * 从队尾入列，从队尾出列
 */
public class ArrayStack<T> implements Stack<T> {

    private ArraySlice<T> arraySlice;

    // 构造器
    public ArrayStack(int capacity) {
        arraySlice = new ArraySlice<>(capacity);
    }
    // 构造器
    public ArrayStack(){
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

    // O(1)
    @Override
    public void push(T value) {
        arraySlice.addLast(value);
    }

    // O(1)
    @Override
    public T pop() {
        return arraySlice.removeLast();
    }

    // O(1)
    @Override
    public T peek() {
        return arraySlice.getLast();
    }

    @Override
    public String toString()
    {

        StringBuilder sb = new StringBuilder();
        sb.append("ArrayStack : [");

        for (int i = 0;i < getSize();i++){
            sb.append(arraySlice.get(i));
            if(i != getSize() - 1){
                sb.append(", ");
            }
        }

        sb.append("] top");

        return sb.toString();
    }
}
