package DFS_OR_TreeDP;

import BinaryTrees.TreeNode;
import BinaryTrees.LevelOrderTraversal;
import java.sql.ClientInfoStatus;
import java.util.HashMap;

public class BT_From_Inorder_and_Preorder {
    public static TreeNode buildTree(int[] inorder, int[] preorder)
    {
        //Build a hashmpa using the preorder list
        HashMap<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        TreeNode root = buildTree(inorder,0,inorder.length-1,preorder,0,preorder.length-1,inMap);
        return root;
    }
    public static TreeNode buildTree(int[] inorder,int inStart,int inEnd
            ,int[] preorder,int preStart ,int preEnd,HashMap<Integer, Integer> inMap)
    {
        if (inStart > inEnd || preStart > preEnd)
            return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = inMap.get(root.val);
        int numsleft = inRoot - inStart;
        root.left=buildTree(inorder,inStart,inRoot-1,preorder,preStart+1,preStart+numsleft,inMap);
        root.right=buildTree(inorder,inRoot+1,inEnd,preorder,preStart+numsleft+1,preEnd,inMap);
        return root;
    }

    public static void main(String[] args) {
        int[] inorder = new int[]{3,9,20,15,7};
        int[] preorder = new int[]{9,3,15,20,7};
        TreeNode node = buildTree(inorder,preorder);
        LevelOrderTraversal.printLevelOrder(node);
    }
}
