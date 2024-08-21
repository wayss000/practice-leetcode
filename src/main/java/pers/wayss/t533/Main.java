package pers.wayss.t533;

/**
 * 533. 孤独像素 II
 * https://github.com/doocs/leetcode/blob/main/solution/0500-0599/0533.Lonely%20Pixel%20II/README.md
 * https://leetcode.cn/problems/lonely-pixel-ii/description/
 * <p>
 * 数据结构：数组
 * 算法：数据遍历
 *
 * @author Wayss.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("practice leetcode.");
        Solution lp = new Solution();
        char[][] picture = {
                {'W', 'B', 'W', 'W'},
                {'W', 'W', 'B', 'B'},
                {'B', 'W', 'W', 'W'}
        };
        int result = lp.findLonelyPixel(picture);
        System.out.println("黑色孤独像素的数量: " + result); // 输出: 2
    }
}

class Solution {
    /**
     * 时间复杂度：O(m*n) (2*m*n)
     * 空间复杂度：O(m+n)
     *
     * @param picture
     * @return
     */
    public int findLonelyPixel(char[][] picture) {
        if (picture == null || picture.length == 0 || picture[0].length == 0) {
            return 0;
        }

        int m = picture.length;
        int n = picture[0].length;
        int[] rowCount = new int[m];
        int[] colCount = new int[n];
        int lonelyCount = 0;

        // 统计每行和每列中黑色像素的数量
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'B') {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }

        // 检查每个黑色像素是否是孤独的
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'B' && rowCount[i] == 1 && colCount[j] == 1) {
                    lonelyCount++;
                }
            }
        }

        return lonelyCount;
    }
}
