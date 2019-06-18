package com.ruaby.stack;



// 后进先出
// 从队尾入列，从队尾出列
public interface Stack<T> {


    int getSize();


    boolean isEmpty();

    // 入栈
    void push(T value);

    // 出栈
    T pop();

    // 查看栈顶元素
    T peek();

}
