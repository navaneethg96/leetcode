import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

class Pair {
    int num;
    TreeNode node;

    public Pair() {
    }

    public Pair(int num) {
        this.num = num;
    }

    public Pair(int num, TreeNode node) {
        this.num = num;
        this.node = node;
    }
}

public class AllOrderTraversals {

        // T - O(N)
        // S - O(N)
    public static void main(String args[]) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        allTraversal(root, pre, in, post);

        System.out.println("The preorder Traversal is : ");
        for (int nodeVal : pre) {
            System.out.print(nodeVal + " ");
        }
        System.out.println();
        System.out.println("The inorder Traversal is : ");
        for (int nodeVal : in) {
            System.out.print(nodeVal + " ");
        }
        System.out.println();
        System.out.println("The postorder Traversal is : ");
        for (int nodeVal : post) {
            System.out.print(nodeVal + " ");
        }
        System.out.println();
    }

    private static void allTraversal(TreeNode root, List<Integer> pre, List<Integer> in, List<Integer> post) {

        if (root == null) {
            return;
        }
        
        Stack<Pair> st = new Stack<>();
        st.add(new Pair(1, root));

        while (!st.isEmpty()) {

            Pair pair = st.pop();

            // this is part of pre
            // increment 1 to 2 
            // push the left side of the tree
            if (pair.num == 1) {
                pre.add(pair.node.val);
                pair.num++;
                st.add(pair);
                if (pair.node.left != null) {
                    st.add(new Pair(1, pair.node.left));
                }
            }

            // this is a part of in 
            // increment 2 to 3 
            // push right 
            else if (pair.num == 2) {
                in.add(pair.node.val);
                pair.num++;
                st.add(pair);
                if (pair.node.right != null) {
                    st.add(new Pair(1, pair.node.right));
                }
            }

            // don't push it back again 
            else {
                post.add(pair.node.val);
            }
        }
    }
}
