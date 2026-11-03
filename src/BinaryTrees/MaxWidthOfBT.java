package BinaryTrees;

import com.sun.source.tree.Tree;

import java.sql.Array;
import java.util.*;

public class MaxWidthOfBT {
    public static class Pair
    {
        TreeNode node;
        int pos;
        public Pair(TreeNode node,int pos)
        {
            this.node = node;
            this.pos = pos;
        }
    }
        public static int widthOfBinaryTree(TreeNode root)
        {

            Queue<Pair> lt = new ArrayDeque<>();
            lt.offer(new Pair(root,0));
            if(root==null)
                return 0;

            int ans=0;
            while(!lt.isEmpty())
            {
                int left=0;
                int right=0;
                int mmin = lt.peek().pos;
                int size = lt.size();
                for(int i=0;i<size;i++)
                {
                    int curr_id = lt.peek().pos-mmin;
                    if (i==0)
                        left = lt.peek().pos-mmin;
                    if(i==size-1)
                        right = lt.peek().pos-mmin;
                    TreeNode node = lt.poll().node;
                    if(node.left!=null)
                        lt.offer(new Pair(node.left,2*curr_id+1));
                    if(node.right!=null)
                        lt.offer(new Pair(node.right,2*curr_id+2));
                }
                ans = Math.max(ans,right-left+1);
            }
            return ans;
        }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(widthOfBinaryTree(root));
    }

}
