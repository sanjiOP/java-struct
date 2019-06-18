package com.ruaby.array;



/**
 * 基于底层数组实现动态数组
 */
public class ArraySlice<T> {

    // 元素载体
    private T[] data;

    // 元素数量
    private int size;

    /**
     * 构造器
     */
    public ArraySlice(int capacity){
        data = (T[])new Object[capacity];
        size = 0;
    }

    public ArraySlice(){
        data = (T[])new Object[10];
        size = 0;
    }

    // 元素个数
    public int getSize(){
        return size;
    }

    // 元素容量
    public int getCapacity(){
        return data.length;
    }

    // 是否为空
    public boolean isEmpty(){
        return size == 0;
    }


    public void add(int index,T value)
    {

        if(index < 0 || index > size){
            throw new IllegalArgumentException("索引错误");
        }

        // 动态扩容
        if(size == data.length){
            resize(2*data.length);
        }

        for(int i = size -1;i>=index;i--){
            data[i + 1] = data[i];
        }
        data[index] = value;
        size++;
    }

    // 根据索引获取
    public T get(int index){

        if(isEmpty()){
            throw new IllegalArgumentException("数组为空");
        }

        if(index >= size || index <0){
            throw new IllegalArgumentException("数组越界 [ size="+size+",index="+index+"]");
        }

        return data[index];
    }

    // 更新
    public void set(int index,T value){

        if(isEmpty()){
            throw new IllegalArgumentException("数组为空");
        }

        if(index >= size || index <0){
            throw new IllegalArgumentException("数组越界 [ size="+size+",index="+index+"]");
        }
        data[index] = value;
    }

    // 移除
    public T remove(int index){

        if(index >= size || index <0){
            throw new IllegalArgumentException("数组越界 [ size="+size+",index="+index+"]");
        }

        T _value = data[index];
        for(int i=index+1;i<size;i++){
            data[i-1] = data[i];
        }
        size--;
        data[size] = null;// 移除最后一个元素的引用，可以gc

        // 变为1／4时，缩容一半
        if(size == data.length / 4){
            resize(data.length / 2);
        }
        return _value;
    }


    // 包含
    public boolean contains(T value){
        for(int i =0;i<size;i++){
            if(data[i] == value){
                return true;
            }
        }
        return false;
    }

    // 查找
    public int find(T value){
        for(int i =0;i<size;i++){
            if(data[i].equals(value)){
                return i;
            }
        }
        return -1;
    }

    public void removeValue(T value){
        int index = find(value);
        if(-1 != index){
            remove(index);
        }

    }


    public void addLast(T value){
        add(size,value);
    }

    public void addFirst(T value){
        add(0,value);
    }

    public T getFirst(){
        return get(0);
    }

    public T getLast(){
        return get(size-1);
    }

    public void setFirst(T value)
    {
        set(0,value);
    }

    public void setLast(T value)
    {
        set(size-1,value);
    }

    public T removeFirst(){
        return remove(0);
    }

    public T removeLast(){
        return remove(size-1);
    }

    // 动态扩容
    private void resize(int length){
        T[] _data = (T[])new Object[length];
        for (int i=0;i<size;i++){
            _data[i] = data[i];
        }
        data = _data;
    }

    @Override
    public String toString() {

        StringBuilder sb  = new StringBuilder();
        sb.append("\r\n");
        sb.append("ArraySlice: size="+size+",capacity="+getCapacity()+"\r\n");
        sb.append("[");

        for (int i = 0;i<size;i++){
            sb.append(i+"=>"+data[i]);
            if(i != size -1){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
