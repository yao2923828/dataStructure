package offer.算法;

import org.junit.Test;

/**
 * <p>标题: </p>
 * <p>功能描述: </p>
 *
 * <p>创建时间: 2021/8/15 11:35</p> 
 * <p>作者：yaoq</p>
 * <p>修改历史记录：</p>
 * ====================================================================<br>
 */
public class 动态规划Test {
    private 动态规划 solution=new 动态规划();

    @Test
    public void fibonacci() {
        solution.Fibonacci(4);
    }

    @Test
    public void rectCover() {
        solution.rectCover(4);
    }

    @Test
    public void jumpFloor() {
        solution.JumpFloor(7);
    }

    @Test
    public void jumpFloorII() {
        solution.jumpFloorII(3);
    }

    @Test
    public void findGreatestSumOfSubArray() {
        solution.FindGreatestSumOfSubArray(new int[]{1,-2,3,10,-4,7,2,-5});
    }

    @Test
    public void getMost() {
        solution.getMost(new int[][]{{1,3,1},{1,5,1},{4,2,1}});
    }

    @Test
    public void lengthOfLongestSubstring() {
        solution.lengthOfLongestSubstring("abcabcbb");
    }

    @Test
    public void getUglyNumber_Solution() {
        solution.GetUglyNumber_Solution(7);
    }

    @Test
    public void dicesSum() {
        solution.dicesSum(2);
    }

    @Test
    public void multiply() {
        solution.multiply(new int[]{1,2,3,4,5});
    }
}