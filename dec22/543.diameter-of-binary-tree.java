
/*
 * @lc app=leetcode id=543 lang=java
 *
 * [543] Diameter of Binary Tree
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
    int dia = 0;
    public int diameterOfBinaryTree(TreeNode root) {

        findDiameter(root);
        return dia;
    }

    private int findDiameter(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHt = findDiameter(root.left);
        int rightHt = findDiameter(root.right);
        dia = Math.max(dia, (leftHt + rightHt));
        return 1 + Math.max(leftHt, rightHt);
    }
}
// @lc code=end

