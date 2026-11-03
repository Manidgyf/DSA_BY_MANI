package BinaryTrees;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class TopViewOfBT
{
    public static void  topView(TreeNode root)
    {
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode node = root;
        if(node == null) {
            System.out.println("Tree is empty");
            return;
        }
        queue.offer(node);
        Vector<Integer> res = new Vector<>();
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                TreeNode nd = queue.poll();
                if (i == 0) {
                    res.add(nd.val);
                }
                if (i == size - 1 && i != 0) {
                    res.add(nd.val);
                }
                if (nd.left != null)
                    queue.add(nd.left);
                if (nd.right != null)
                    queue.add(nd.right);
            }
        }
        System.out.println(res);
        return;
    }
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        topView(root);
    }
}
