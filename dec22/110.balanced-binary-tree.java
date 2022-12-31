/*
 * @lc app=leetcode id=110 lang=java
 *
 * [110] Balanced Binary Tree
 */

// @lc code=start
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
    public boolean isBalanced(TreeNode root) {
        
        int depth = validateDepth(root);
        return depth != -1;
    }

    private int validateDepth(TreeNode root) {
        
        if (root == null) {
            return 0;
        }
        int leftHt = validateDepth(root.left);
        if (leftHt == -1) {
            return -1;
        }
        int rightHt = validateDepth(root.right);
        if (rightHt == -1) {
            return -1;
        }
        if (Math.abs(rightHt - leftHt) > 1) {
            return -1;
        }
        return 1 + Math.max(leftHt, rightHt);
    }
}
// @lc code=end

