package leetcode;
import leetcode.算法思想.动态规划leetcode;
import org.junit.Test;

import java.util.Arrays;

/**
 * <p>标题: </p>
 * <p>功能描述: </p>
 *
 * <p>创建时间: 2021/8/15 8:48</p>
 * <p>作者：yaoq</p>
 * <p>修改历史记录：</p>
 * ====================================================================<br>
 */
public class 动态规划leetcodeTest {

    private 动态规划leetcode solution=new 动态规划leetcode();

    @Test
    public void climbStairs() {
        solution.climbStairs(3);
    }

    @Test
    public void rob() {
        solution.rob(new int[]{2,7,9,3,1});
    }

    @Test
    public void rob2() {
        solution.rob2(new int[]{1,2,3,1});
    }

    @Test
    public void MailMisalignment() {
        solution.MailMisalignment(3);
    }


    @Test
    public void cowNums() {
        solution.cowNums(3);
    }

    @Test
    public void minPathSum() {
        solution.minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}});
    }

    @Test
    public void uniquePaths() {
        solution.uniquePaths(3,7);
    }

    @Test
    public void sumRange() {
        动态规划leetcode.NumArray numArray=solution.new NumArray(new int[]{-2,0,3,-5,2,-1});
        numArray.sumRange(0, 2);
    }

    @Test
    public void numberOfArithmeticSlices() {
        solution.numberOfArithmeticSlices(new int[]{0,1,2,3,4});
    }

    @Test
    public void integerBreak() {
        solution.integerBreak(10);
    }

    @Test
    public void numSquares() {
        solution.numSquares(12);
    }

    @Test

    public void numDecodings() {
        solution.numDecodings("226");
    }

    @Test
    public void lengthOfLIS() {
        solution.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
    }

    @Test
    public void findLongestChain() {
        solution.findLongestChain(new int[][]{{1,2},{2,3},{3,4}});
    }

    @Test
    public void wiggleMaxLength() {
        solution.wiggleMaxLength(new int[]{1,17,5,10,13,15,10,5,16,8});
    }

    @Test
    public void longestCommonSubsequence() {
        solution.longestCommonSubsequence("abcde", "ace");
    }

    @Test
    public void knapsack() {
        solution.knapsack(4, 3, new int[]{2,1,3},new int[]{4,2,3} );

    }

    @Test
    public void canPartition() {
        solution.canPartition(new int[]{1, 5, 11, 5});
    }

    @Test
    public void findTargetSumWays() {
        solution.findTargetSumWays(new int[]{1, 1, 1, 1, 1},3 );
    }

    @Test
    public void findMaxForm() {
        solution.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3);
    }

    @Test
    public void coinChange() {
        solution.coinChange(new int[]{1, 2, 5},11 );
    }

    @Test
    public void change() {
        solution.change(5, new int[]{1, 2, 5});
    }

    @Test
    public void wordBreak() {
        solution.wordBreak("leetcode", Arrays.asList(new String[]{"leet", "code"}));
    }

    @Test
    public void combinationSum4() {
        solution.combinationSum4(new int[]{1,2,3}, 4);
    }

    @Test
    public void maxProfit() {
        solution.maxProfit(new int[]{1,2,3,0,2});
    }

    @Test
    public void maxProfit2() {
        solution.maxProfit2(new int[]{1, 3, 2, 8, 4, 9}, 2);
    }

    @Test
    public void maxProfit3() {
        solution.maxProfit3(new int[]{3,3,5,0,0,3,1,4});
    }

    @Test
    public void maxProfit4() {
        solution.maxProfit4(2, new int[]{3,2,6,5,0,3});
    }

    @Test
    public void minDistance() {
        solution.minDistance("sea", "eat");
    }

    @Test
    public void minDistance2() {
        solution.minDistance2("horse","ros" );
    }


    @Test
    public void minSteps() {
        solution.minSteps(3);
    }
}