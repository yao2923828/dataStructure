package offer.算法;

/**
 * <p>标题: </p>
 * <p>功能描述: </p>
 *
 * <p>创建时间: 2021/7/27 7:37</p> 
 * <p>作者：yaoq</p>
 * <p>修改历史记录：</p>
 * ====================================================================<br>
 */
public class 数学 {
    /**
     * 数组中出现次数超过一半的数字
     */
    public static int MoreThanHalfNum_Solution(int[] nums) {
        int majority = nums[0];
        for (int i = 1, cnt = 1; i < nums.length; i++) {
            cnt = nums[i] == majority ? cnt + 1 : cnt - 1;
            if (cnt == 0) {
                majority = nums[i];
                cnt = 1;
            }
        }
        int cnt = 0;
        for (int val : nums)
            if (val == majority)
                cnt++;
        return cnt > nums.length / 2 ? majority : 0;
    }

    /**
     * 圆圈中最后剩下的数
     */
    public static int LastRemaining_Solution(int n, int m) {
        if (n == 0)     /* 特殊输入的处理 */
            return -1;
        if (n == 1)     /* 递归返回条件 */
            return 0;
        return (LastRemaining_Solution(n - 1, m) + m) % n;
    }

    /**
     * 从 1 到 n 整数中 1 出现的次数
     */
    public static int NumberOf1Between1AndN_Solution(int n) {
        int cnt = 0;
        for (int m = 1; m <= n; m *= 10) {
            int a = n / m, b = n % m;
            cnt += (a + 8) / 10 * m + (a % 10 == 1 ? b + 1 : 0);
        }
        return cnt;
    }

    public static int countDigitOne(int n) {
        //高位
        int high = n;
        //低位
        int low = 0;
        //当前位
        int cur = 0;
        int count = 0;
        int num = 1;
        while (high != 0 || cur != 0) {
            cur = high % 10;
            high /= 10;
            //这里我们可以提出 high * num 因为我们发现无论为几，都含有它
            if (cur == 0) count += high * num;
            else if (cur == 1) count += high * num + 1 + low;
            else count += (high + 1) * num;
            //低位
            low = cur * num + low;
            num *= 10;
        }
        return count;
    }

}
