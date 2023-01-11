import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 */

// @lc code=start
class Solution {
    Map<Integer, Integer> map = new HashMap<>();

    public int climbStairs(int n) {

        return calc(n);
    }

    private int calc(int n) {

        if (n == 0 || n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int oneJump = calc(n-1);
        int twoJump = calc(n-2);
        int res = oneJump + twoJump;
        map.put(n, res);
        return res;
    }
    
}
// @lc code=end

