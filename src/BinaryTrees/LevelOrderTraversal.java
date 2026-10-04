package BinaryTrees;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Vector;


public class LevelOrderTraversal
{
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        printLevelOrder(root);
    }

    public static void printLevelOrder(TreeNode root)
    {
        Queue<TreeNode> queue = new ArrayDeque<>();
        Vector<Vector<Integer>> v = new Vector<>();
        TreeNode node = root;
        if(node == null) {
            System.out.println("Tree is empty");
            return;
        }
        queue.offer(node);
        while(!queue.isEmpty())
        {
            int levelnum = queue.size();
            Vector<Integer> level = new Vector<>();
            for(int i=0;i<levelnum;i++)
            {
                if(queue.peek().left != null)
                    queue.offer(queue.peek().left);
                if(queue.peek().right != null)
                    queue.offer(queue.peek().right);

                level.add(queue.poll().val);
            }
            v.add(level);
        }
        System.out.println(v);
        return;
    }
}
