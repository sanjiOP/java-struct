package com.ruaby;

import com.ruaby.array.ArraySlice;
import com.ruaby.link.LinkedList;
import com.ruaby.queue.ArrayLoopQueue;
import com.ruaby.queue.ArrayQueue;
import com.ruaby.queue.LinkedQueue;
import com.ruaby.queue.Queue;
import com.ruaby.stack.ArrayStack;
import com.ruaby.stack.LinkedStack;

import java.util.Random;


public class Main {

    public static void main(String[] args) {

        //testArrayStack();
        //
        // testArrayLoopQueue();
        //testQueue();

        //testLinkedStack();

        testLinkedQueue();
    }


    // 1 基础：动态数组
    private static void testArraySlice()
    {
        ArraySlice<Integer> as = new ArraySlice<>();

        for(int i=0;i<10;i++){
            as.addLast(i);
        }

        System.out.println(as);

        for(int j=0;j<8;j++){
            as.removeFirst();
        }

        System.out.println(as);
    }


    // 2 基础：链表
    private static void testLinkedList(){
        LinkedList<Integer> ll = new LinkedList<>();

        for ( int i = 0;i<10;i++){
            ll.addLast(i);
        }
        System.out.println(ll);
        ll.addFirst(-1);
        System.out.println(ll);


        System.out.println(ll.get(4));
        System.out.println(ll.getFirst());
        System.out.println(ll.getLast());

        ll.set(2,11);
        System.out.println(ll);


        System.out.println(ll.contains(10));
        System.out.println(ll.contains(9));

        ll.removeFirst();
        ll.removeLast();
        System.out.println(ll);
    }

    // 3-1 栈（数组，后进先出）
    private static void testArrayStack()
    {

        ArrayStack<Integer> arrayStack = new ArrayStack<>();

        for (int i = 0;i<10;i++){
            arrayStack.push(i);
        }

        System.out.println(arrayStack);
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack);
        System.out.println(arrayStack.peek());
    }

    // 3-2 栈（链表，后进先出）
    private static void testLinkedStack(){
        LinkedStack<Integer> linkedStack = new LinkedStack<>();

        for (int i = 0;i<10;i++){
            linkedStack.push(i);
        }

        System.out.println(linkedStack);
        System.out.println(linkedStack.pop());
        System.out.println(linkedStack.peek());
        System.out.println(linkedStack);

    }


    // 4-1 队列 （数组，先进先出）
    private static void testArrayQueue()
    {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        for (int i=0;i<10;i++){
            arrayQueue.enqueue(i);
        }

        System.out.println(arrayQueue);
        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue);
        System.out.println(arrayQueue.getFront());
        System.out.println(arrayQueue.getSize());

    }


    // 4-2 队列（循环数组，先进先出）
    private static void testArrayLoopQueue()
    {
        ArrayLoopQueue<Integer> arrayLoopQueue = new ArrayLoopQueue<>(10);

        for (int i=0;i<5;i++){
            arrayLoopQueue.enqueue(i);
        }

        System.out.println(arrayLoopQueue);
        System.out.println(arrayLoopQueue.dequeue());
        System.out.println(arrayLoopQueue);
        System.out.println(arrayLoopQueue.getSize());
        System.out.println(arrayLoopQueue.getFront());

    }


    // 4-3 队列（链表，先进先出）
    private static void testLinkedQueue()
    {
        LinkedQueue<Integer> linkedQueue = new LinkedQueue<>();

        for (int i=0;i<5;i++){
            linkedQueue.enqueue(i);
        }

        System.out.println(linkedQueue);
        System.out.println(linkedQueue.dequeue());
        System.out.println(linkedQueue);
        System.out.println(linkedQueue.getFront());
        System.out.println(linkedQueue.getSize());

    }


    // 4-4 比较数组队列和循环队列
    private static void testQueue(){

        int count = 100000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = _queue(arrayQueue,count);

        ArrayLoopQueue<Integer> arrayLoopQueue = new ArrayLoopQueue<>();
        double time2 = _queue(arrayLoopQueue,count);

        System.out.println(time1+"s");
        System.out.println(time2 + "s");

    }

    // 4-5 计算队列时间
    private static double _queue(Queue<Integer> q,int count){

        Random random = new Random();
        long startTime = System.nanoTime();
        for (int i = 0;i < count;i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0;i < count;i++) {
            q.dequeue();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }


}
