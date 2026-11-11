package DFS_OR_TreeDP;
import BinaryTrees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BoundaryTraversalofBT
{
    public static ArrayList<Integer> boundaryTraversal(TreeNode root)
    {
        ArrayList<Integer> res = new ArrayList<>();
        if(root==null) return res;
        res.add(root.val);
        if(root.isLeaf()==true)
            return res;
        leftBoundaryTraversal(root.left,res);
        leafNodes(root,res);
        rightBoundaryTraversal(root.right,res);
        System.out.println(res);
        return res;
    }

    public static void leftBoundaryTraversal(TreeNode root,ArrayList<Integer> res)
    {
        if(root.isLeaf()==true)
            return;
        res.add(root.val);
        if(root.left==null)
            leftBoundaryTraversal(root.right,res);
        else
            leftBoundaryTraversal(root.left,res);
    }
    public static void leafNodes(TreeNode root,ArrayList<Integer> res)
    {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i=0;i<size;i++)
            {
                TreeNode node = queue.poll();
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
                if(node.isLeaf())
                    res.add(node.val);
            }
        }
        return;
    }
    public static void rightBoundaryTraversal(TreeNode root,ArrayList<Integer> res)
    {
        Stack<Integer> stack = new Stack<>();
        if(root.isLeaf()==true)
            return;
        stack.push(root.val);
        if(root.right==null)
            leftBoundaryTraversal(root.left,res);
        else
            leftBoundaryTraversal(root.right,res);

        while(!stack.isEmpty())
        {
            res.add(stack.pop());
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        boundaryTraversal(root);
        }
}
