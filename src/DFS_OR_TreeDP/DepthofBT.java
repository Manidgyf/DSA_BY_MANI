package DFS_OR_TreeDP;
import BinaryTrees.TreeNode;

public class DepthofBT
{
    public static int maxDepth(TreeNode root)
    {
        if(root==null)
            return 0;
        int lh = maxDepth(root.left);
        int rh =maxDepth(root.right);

        return 1+Math.max(lh,rh);
    }

    public static int diameterofBT(TreeNode root,int maxi)
    {
        if(root==null)
            return 0;
        int lh = maxDepth(root.left);
        int rh =maxDepth(root.right);
        maxi = Math.max(maxi,lh+rh);
        return 1+Math.max(lh,rh);
    }
}
