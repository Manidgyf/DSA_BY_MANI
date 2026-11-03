package BinaryTrees;


import java.util.*;

public class DistanceKFromTarget
{
    public static void mapParents(TreeNode node,Map<TreeNode,TreeNode> parentsMap)
    {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(node);
        while(!q.isEmpty())
        {
            TreeNode node1 = q.poll();
            if(node1.left != null)
            {
                q.offer(node1.left);
                parentsMap.put(node1.left,node1);
            }
            if(node1.right != null)
            {
                q.offer(node1.right);
                parentsMap.put(node1.right,node1);
            }
        }
    }
    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k)
    {
        Map<TreeNode,TreeNode> parentsMap = new HashMap<>();
        mapParents(root,parentsMap);
        //Now I am ready with Node and Parent's Mapping
        // My Next task is to iterate through the graph and find the nodes with K distance
        // For this Second BFS I need an extra array to keep track of all the visited nodes
        Queue<TreeNode> q = new ArrayDeque<>();
        Map<TreeNode,Boolean> visitedNodes = new HashMap<>();
        q.offer(target);
        visitedNodes.put(target,true);
        int curr_dist =0;
        while(!q.isEmpty())
        {
            if(curr_dist ==k)
                break;
            curr_dist++;
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode node = q.poll();
                if(node.left!=null && visitedNodes.get(node.left)==null)
                {
                    q.offer(node.left);
                    visitedNodes.put(node.left,true);
                }
                if(node.right!=null && visitedNodes.get(node.right)==null)
                {
                    q.offer(node.right);
                    visitedNodes.put(node.right,true);
                }
                if(parentsMap.get(node)!=null && visitedNodes.get(parentsMap.get(node))==null)
                {
                    q.offer(parentsMap.get(node));
                    visitedNodes.put(parentsMap.get(node),true);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty())
        {
            res.add(q.poll().val);
        }
        return res;
    }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        TreeNode target = new TreeNode(5);
        root.left.right = target;
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(distanceK(root,target,3));
    }
}
