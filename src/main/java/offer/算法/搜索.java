package offer.算法;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * <p>标题: </p>
 * <p>功能描述: </p>
 *
 * <p>创建时间: 2021/8/23 6:32</p> 
 * <p>作者：yaoq</p>
 * <p>修改历史记录：</p>
 * ====================================================================<br>
 */
public class 搜索 {
    /**
     * 矩阵中的路径
     */
    private final static int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    private int rows;

    private int cols;

    public boolean hasPath(String val, int rows, int cols, String path) {
        if (rows == 0 || cols == 0)
            return false;
        this.rows = rows;
        this.cols = cols;
        char[] array = val.toCharArray();
        char[][] matrix = buildMatrix(array);
        char[] pathList = path.toCharArray();
        boolean[][] marked = new boolean[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (backtracking(matrix, pathList, marked, 0, i, j))
                    return true;

        return false;
    }

    private boolean backtracking(char[][] matrix, char[] pathList, boolean[][] marked, int pathLen, int r, int c) {

        if (pathLen == pathList.length)
            return true;
        if (r < 0 || r >= rows || c < 0 || c >= cols || matrix[r][c] != pathList[pathLen] || marked[r][c]) {

            return false;
        }
        marked[r][c] = true;
        for (int[] n : next)
            if (backtracking(matrix, pathList, marked, pathLen + 1, r + n[0], c + n[1]))
                return true;
        marked[r][c] = false;
        return false;
    }

    private char[][] buildMatrix(char[] array) {
        char[][] matrix = new char[rows][cols];
        for (int r = 0, idx = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                matrix[r][c] = array[idx++];
        return matrix;
        }

    /**
     * 机器人的运动范围
     */
    private static final int[][] next2 = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private int cnt = 0;
    private int rows2;
    private int cols2;
    private int threshold;
    private int[][] digitSum;

    public int movingCount(int threshold, int rows, int cols) {
        this.rows2 = rows;
        this.cols2 = cols;
        this.threshold = threshold;
        initDigitSum();
        boolean[][] marked = new boolean[rows][cols];
        dfs(marked, 0, 0);
        return cnt;
    }

    private void dfs(boolean[][] marked, int r, int c) {
        if (r < 0 || r >= rows2 || c < 0 || c >= cols2 || marked[r][c])
            return;
        marked[r][c] = true;
        if (this.digitSum[r][c] > this.threshold)
            return;
        cnt++;
        for (int[] n : next2)
            dfs(marked, r + n[0], c + n[1]);
    }

    private void initDigitSum() {
        int[] digitSumOne = new int[Math.max(rows2, cols2)];
        for (int i = 0; i < digitSumOne.length; i++) {
            int n = i;
            while (n > 0) {
                digitSumOne[i] += n % 10;
                n /= 10;
            }
        }
        this.digitSum = new int[rows2][cols2];
        for (int i = 0; i < this.rows2; i++)
            for (int j = 0; j < this.cols2; j++)
                this.digitSum[i][j] = digitSumOne[i] + digitSumOne[j];
    }
    /**
     * 字符串的排列
     */
    private ArrayList<String> ret = new ArrayList<>();

    public ArrayList<String> Permutation(String str) {
        if (str.length() == 0)
            return ret;
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        backtracking(chars, new boolean[chars.length], new StringBuilder());
        return ret;
    }

    private void backtracking(char[] chars, boolean[] hasUsed, StringBuilder s) {
        if (s.length() == chars.length) {
            ret.add(s.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (hasUsed[i])
                continue;
            if (i != 0 && chars[i] == chars[i - 1] && !hasUsed[i - 1]) /* 保证不重复 */
                continue;
            hasUsed[i] = true;
            s.append(chars[i]);
            backtracking(chars, hasUsed, s);
            s.deleteCharAt(s.length() - 1);
            hasUsed[i] = false;
        }
    }
}
