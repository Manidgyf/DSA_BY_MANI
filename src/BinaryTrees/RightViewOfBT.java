package BinaryTrees;

import java.util.*;

public class RightViewOfBT {

    public static List<Integer> rightViewOfBT(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null)
            return res;
        Queue<TreeNode> list = new ArrayDeque<TreeNode>();
        list.add(root);
        while(!list.isEmpty())
        {
            int size = list.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = list.poll();
                if (i == size - 1) {
                    res.add(node.val);
                }
                if (node.left != null)
                    list.add(node.left);
                if (node.right != null)
                    list.add(node.right);
            }
        }
        return res;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(rightViewOfBT(root));
    }
}
