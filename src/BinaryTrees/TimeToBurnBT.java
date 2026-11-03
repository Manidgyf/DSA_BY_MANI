package BinaryTrees;

import com.sun.source.tree.Tree;

import java.util.*;

public class TimeToBurnBT {
    public static TreeNode mapParents(TreeNode node , Map<TreeNode,TreeNode> parentsMap,int start)
    {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(node);
        TreeNode startNode = null;
        while(!queue.isEmpty())
        {

            TreeNode temp = queue.poll();
            if(temp.val == start)
            {
                startNode = temp;
            }
            if(temp.left != null)
            {
                queue.add(temp.left);
                parentsMap.put(temp.left, temp);
            }
            if(temp.right != null)
            {
                queue.add(temp.right);
                parentsMap.put(temp.right, temp);
            }
        }
        return startNode;
    }
    public static int timeToBurnTree(TreeNode root, int start)
    {
        //your code goes here
        if(root == null)
        {
            return 0;
        }
        Map<TreeNode,TreeNode> parentsMap = new HashMap<>();
        TreeNode startnode = mapParents(root,parentsMap,start);
        if(startnode==null)
            return 0;
        int time=0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(startnode);
        Map<TreeNode,Boolean> visitedNodes = new HashMap<>();
        visitedNodes.put(startnode,true);
        int maxi=0;
        int fl =0;
        while(!queue.isEmpty()) {
            while (!queue.isEmpty()) {
                TreeNode temp = queue.poll();
                queue.poll();
                if (temp.left != null && !visitedNodes.containsKey(temp.left)) {
                    queue.add(temp.left);
                    visitedNodes.put(temp.left, true);
                }

            if (temp.right != null && !visitedNodes.containsKey(temp.right)) {
                queue.add(temp.right);
                visitedNodes.put(temp.right, true);
            }
            if (parentsMap.get(temp) != null && !visitedNodes.containsKey(parentsMap.get(temp))) {
                queue.add(parentsMap.get(temp));
                visitedNodes.put(parentsMap.get(temp), true);
            }
        }
        }
        return maxi;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(timeToBurnTree(root,4));
    }
}
