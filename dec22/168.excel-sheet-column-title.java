/*
 * @lc app=leetcode id=168 lang=java
 *
 * [168] Excel Sheet Column Title
 */

// @lc code=start
class Solution {
    public String convertToTitle(int columnNumber) {
        
        StringBuilder builder = new StringBuilder();
        while (columnNumber != 0) {
            int rem = columnNumber % 26;

            if (rem == 0) {
                builder.append("Z");
                columnNumber = columnNumber / 26 - 1;
            } else {
                builder.append((char) ('A' + rem - 1));
                columnNumber = columnNumber / 26;
            }
        }
        return builder.reverse().toString();
    }
}
// @lc code=end

