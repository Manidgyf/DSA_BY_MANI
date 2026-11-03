package DFS_OR_TreeDP;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import BinaryTrees.TreeNode;

public class RootToLeafPath
{
    public static Boolean getPath(TreeNode root , ArrayList<Integer> arr , int target )
    {
         if(root==null)
         {
             return false;
         }
        arr.add(root.val);
         if(root.val==target)
            return true;
        if(getPath(root.left,arr,target)||getPath(root.right,arr,target))
            return true;
        arr.remove(arr.size()-1);
        return false;
    }

    public static void getAllPaths(TreeNode root,ArrayList<Integer> currentPath , ArrayList<ArrayList<Integer>> allPaths)
    {
        if(root==null)
        {
            return ;
        }
        currentPath.add(root.val);

        if(root.left==null&&root.right==null) {
            allPaths.add(new ArrayList<>(currentPath));
            return;
        }
        getAllPaths(root.left,new ArrayList<>(currentPath),allPaths);
        getAllPaths(root.right,new ArrayList<>(currentPath),allPaths);

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

        ArrayList<Integer> list = new ArrayList<>();
        int b = 4;
        getPath(root,list,b);
        System.out.println(list);
    }
}
