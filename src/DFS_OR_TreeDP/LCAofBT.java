package DFS_OR_TreeDP;
import BinaryTrees.TreeNode;
import com.sun.source.tree.Tree;

public class LCAofBT {
    public static TreeNode LCA(TreeNode root, TreeNode p, TreeNode q)
    {
        if(root==null || root==p || root==q)
            return root;

        TreeNode left = LCA(root.left,p,q);
        TreeNode right = LCA(root.right,p,q);

        if(left==null)
            return right;
        else if(right==null)
            return left;
        else
            return root;
    }
}
