package com.ruaby;

import com.ruaby.tree.Bstree;

public class TreeMain {


    public static void main(String[] args) {

        Bstree<Integer> bsTree = new Bstree<>();
        int[] nums = {5,3,6,8,4,2};
        for (int i : nums){
            bsTree.add(i);
        }


        bsTree.preOrder();
        System.out.println("-------");
        bsTree.inOrder();
        System.out.println("-------");
        bsTree.postOrder();
        System.out.println("-------");
        bsTree.levelOrder();
        //System.out.println(bsTree);

    }

}
