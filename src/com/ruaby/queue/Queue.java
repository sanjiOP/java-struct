package com.ruaby.queue;


// 先进先出
// 从队尾入列，从队首出列
public interface Queue<T> {

    int getSize();

    boolean isEmpty();

    // 入队
    void enqueue(T value);

    // 出队
    T dequeue();

    // 查看队首元素
    T getFront();

}
