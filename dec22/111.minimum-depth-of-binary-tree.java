import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=111 lang=java
 *
 * [111] Minimum Depth of Binary Tree
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
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {

    //  ******** DFS ********
    // public int minDepth(TreeNode root) {
        
    //     if (root == null) {
    //         return 0;
    //     }

    //     if (root.left == null && root.right == null) {
    //         return 1;
    //     }
    //     if (root.left == null) {
    //         return 1 + minDepth(root.right);
    //     }
    //     if (root.right == null) {
    //         return 1 + minDepth(root.left);
    //     }
    //     return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    // }

    //  ******** BFS ********
    public int minDepth(TreeNode root) {
        
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 1;

        while (!queue.isEmpty()) {
            int len = queue.size();

            while(len-- > 0) {
                root = queue.poll();
                if (root.left == null && root.right == null) {
                    return depth;
                }
                if (root.left != null) {
                    queue.add(root.left);
                }
                if (root.right != null) {
                    queue.add(root.right);
                }
            }
            depth++;
        }
        return 0;
    }
}
// @lc code=end

