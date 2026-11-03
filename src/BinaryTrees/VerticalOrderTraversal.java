package BinaryTrees;

import com.sun.source.tree.Tree;

import java.util.*;

class Tuple {
    TreeNode node;
    int row;
    int col;
    Tuple(TreeNode node, int row, int col)
    {
        this.node = node;
        this.row = row;
        this.col = col;
    }
}

public class VerticalOrderTraversal
{
    public static void verticalOrderTraversal(TreeNode root)
    {
        TreeMap<Integer,TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        TreeNode node = root;
        if(node == null) {
            System.out.println("Tree is empty");
            return;
        }
        Queue<Tuple> q = new ArrayDeque<>();
        q.offer(new Tuple(node, 0, 0));

        while(!q.isEmpty())
        {
            Tuple t = q.poll();
            TreeNode node1 = t.node;
            int x = t.row;
            int y = t.col;

            if(!map.containsKey(x))
            {
                map.put(x, new TreeMap<>());
            }
            if(!map.get(x).containsKey(y))
            {
                map.get(x).put(y,new PriorityQueue<>());
            }
            map.get(x).get(y).offer(node1.val);
            if(node1.left != null)
            {
                q.offer(new Tuple(node1.left, x-1, y+1));
            }
            if(node1.right != null)
            {
                q.offer(new Tuple(node1.left, x+1, y+1));
            }
        }
    }
}
