package com.ruaby.tree;

import java.util.Queue;
import java.util.LinkedList;


/**
 * 二分搜索树
 * binary search tree
 *
 * 传入的value需要有可比较性 必须实现 comparable
 */
public class Bstree<E extends Comparable<E>> {


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
    public Bstree() {
        root = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    // 添加原色
    public void add(E value){
        root = add(root,value);
    }

    // 包含元素
    public boolean contains(E value){
        return contains(root,value);
    }

    // 前序遍历
    public void preOrder(){
        preOrder(root);
    }

    // 中序遍历
    public void inOrder(){
        inOrder(root);
    }

    // 后序遍历
    public void postOrder(){
        postOrder(root);
    }

    // 层序遍历
    public void levelOrder(){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            Node node = q.remove();
            System.out.println(node.value);
            if(null != node.left){
                q.add(node.left);
            }
            if(null != node.right){
                q.add(node.right);
            }

        }
    }

    // 最小值
    public E minValue(){
        if(isEmpty()){
            throw new IllegalArgumentException("tree is empty");
        }
        return minNode(root).value;
    }

    // 最大值
    public E maxValue(){
        if(isEmpty()){
            throw new IllegalArgumentException("tree is empty");
        }
        return maxNode(root).value;
    }

    // 删除最小元素
    public E removeMin(){
        E delValue = minValue();
        root.left = removeMinNode(root);
        return delValue;
    }

    // 删除最大元素
    public E removeMax(){
        E delValue = maxValue();
        root.right = removeMaxNode(root);
        return delValue;
    }

    // 删除元素
    public void remove(E value){
        root = remove(root,value);
    }


    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        generateBsTreeString(root,0,sb);
        return sb.toString();
    }


    private void generateBsTreeString(Node node,int depth,StringBuilder sb){

        if(null == node){
            sb.append(generateDepthString(depth) + "null\r\n");
            return;
        }
        sb.append(generateDepthString(depth) + node.value + "\r\n");
        generateBsTreeString(node.left,depth+1,sb);
        generateBsTreeString(node.right,depth+1,sb);
    }


    private String generateDepthString(int depth){
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i< depth;i++){
            sb.append("--");
        }
        return sb.toString();
    }

    private void preOrder(Node node){

        if(null == node){
            return;
        }
        System.out.println(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    private void inOrder(Node node){
        if(null == node){
            return;
        }
        inOrder(node.left);
        System.out.println(node.value);
        inOrder(node.right);
    }

    private void postOrder(Node node){
        if(null == node){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value);
    }

    private Node add(Node node,E value){

        if(null == node){
            size++;
            return new Node(value);
        }
        // 不处理相等的情况
        if(value.compareTo(node.value) > 0){
            node.right = add(node.right,value);
        }else if(value.compareTo(node.value) < 0){
            node.left = add(node.left,value);
        }
        return node;
    }

    private boolean contains(Node node,E value){

        if(null == node){
            return false;
        }
        if(value.compareTo(node.value) == 0){
            return true;
        }else if(value.compareTo(node.value) > 0){
            return contains(node.right,value);
        }else{
            return contains(node.left,value);
        }
    }


    //
    private Node minNode(Node node){

        if(null == node.left){
            return node;
        }
        return minNode(node.left);
    }

    private Node maxNode(Node node){
        if(null == node.right){
            return node;
        }
        return maxNode(node.right);
    }

    // 如果有右节点，需要被上一级引用
    private Node removeMinNode(Node node){

        if(null == node.left){
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        return removeMinNode(node.left);
    }

    //如果有左节点，需要被上一级引用
    private Node removeMaxNode(Node node){

        if(null == node.right){
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        return removeMaxNode(node.right);
    }



    private Node remove(Node node, E value){

        if(null == node){
            return null;
        }

        if(value.compareTo(node.value) == 0){

            if(null == node.left){
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            if(null == node.right){
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            // 左右都有节点情况
            Node minRightNode   = minNode(node.right);
            minRightNode.right  = removeMinNode(node.right);
            minRightNode.left   = node.left;
            node.left   = null;
            node.right  = null;
            return minRightNode;
        }
        //
        if(value.compareTo(node.value) > 0){
            node.right = remove(node.right,value);
            return node;
        }else{
            node.left = remove(node.left,value);
            return node;
        }
    }

}
