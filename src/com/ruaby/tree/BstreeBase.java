package com.ruaby.tree;


/**
 * 二分搜索树
 * binary search tree
 *
 * 传入的value需要有可比较性 必须实现 comparable
 */
public class BstreeBase<E extends Comparable<E>> {


    // 内部节点
    private class Node{
        E value;
        Node left,right;

        public Node(E value){
            this.value = value;
            left = right = null;
        }

    }

    private Node root;
    private int size;

    /**
     * 构造器
     */
    public BstreeBase() {
        root = null;
        size = 0;
    }


    public int size(){
        return size;
    }


    public boolean isEmpty(){
        return size == 0;
    }


    public void add(E value){
        if(null == root){
            root = new Node(value);
            size++;
            return;
        }
        add(root,value);
    }



    // 向某个节点中添加子节点
    private void add(Node node,E value){

        // 不支持相同元素的写入
        if(value.equals(node.value)){
            return;
        }
        if(value.compareTo(node.value) > 0 && node.right == null){
            node.right = new Node(value);
            size++;
            return;
        }
        if(value.compareTo(node.value) < 0 && node.left == null){
            node.left = new Node(value);
            size++;
            return;
        }

        // 递归写入
        if(value.compareTo(node.value) > 0){
            add(node.right,value);
        }else{
            add(node.left,value);
        }

    }


}
