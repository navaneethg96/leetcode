/*
 * @lc app=leetcode id=124 lang=java
 *
 * [124] Binary Tree Maximum Path Sum
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
    int maxValue = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findMaxPathSum(root);
        return maxValue;
    }
    private int findMaxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSum = Math.max(0, findMaxPathSum(root.left));
        int rightSum = Math.max(0, findMaxPathSum(root.right));
        maxValue = Math.max(maxValue, (leftSum + rightSum + root.val));

        return Math.max(root.val, root.val + Math.max(leftSum, rightSum));
    }
}
// @lc code=end

