/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // public TreeNode buildTree(int[] preorder, int[] inorder) {
    //     Map<Integer, Integer> inMap= new HashMap<>();

    //     for(int i=0; i<inorder.length; i++){
    //         inMap.put(inorder[i], i);
    //     }

    //     return Helper(preorder, 0, preorder.length -1, inorder, 0, inorder.length -1, inMap);
    // }

    // public TreeNode Helper(int[] preorder, int prest, int preend, int[] inorder, int inst, int inend, Map<Integer, Integer> inMap){
    //     if(prest>preend || inst>inend) return null;

    //     TreeNode root= new TreeNode(preorder[prest]);

    //     int inRoot= inMap.get(root.val);

    //     int numsleft= inRoot-inst;

    //     root.left= Helper(preorder, prest+1, prest+numsleft, inorder, inst, inRoot-1, inMap );
    //     root.right=  Helper(preorder, prest+numsleft+1, preend, inorder, inRoot+1, inend, inMap );

    //     return root;
    // }



    public TreeNode buildTree(int[] preorder, int[] inorder){
        Map<Integer, Integer> inMap= new HashMap<>();
        int pr=preorder.length;
        int in=inorder.length;

        for(int i=0; i<in; i++){
            inMap.put(inorder[i], i);
        }

        return Helper(preorder, 0, pr-1, inorder, 0, in-1, inMap);
    }

    public TreeNode Helper(int[] pre, int prest, int preend, int[] inor, int inst, int inend, Map<Integer, Integer> inMap){
        if(prest>preend || inst>inend) return null;

        TreeNode root= new TreeNode (pre[prest]);

        //ind of root in inorder array
        int inroot= inMap.get(root.val);

        int numsleft= inroot-inst;

        root.left= Helper(pre, prest+1, prest+ numsleft, inor, inst, inroot-1, inMap);
        root.right=Helper(pre, prest+numsleft+1, preend, inor, inroot+1, inend, inMap);

        return root;
    }
}