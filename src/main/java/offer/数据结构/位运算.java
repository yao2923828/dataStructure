package offer.数据结构;

/**
 * <p>标题: </p>
 * <p>功能描述: </p>
 *
 * <p>创建时间: 2021/8/23 6:31</p> 
 * <p>作者：yaoq</p>
 * <p>修改历史记录：</p>
 * ====================================================================<br>
 */
public class 位运算 {
    /**
     * 二进制中 1 的个数
     */
    public int NumberOf1(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt++;
            n &= (n - 1);
        }
        return cnt;
    }
    /**
     * 数组中只出现一次的数字
     */
    public int[] FindNumsAppearOnce (int[] nums) {
        int[] res = new int[2];
        int diff = 0;
        for (int num : nums)
            diff ^= num;
        diff &= -diff;
        for (int num : nums) {
            if ((num & diff) == 0)
                res[0] ^= num;
            else
                res[1] ^= num;
        }
        if (res[0] > res[1]) {
            swap(res);
        }
        return res;
    }

    private void swap(int[] nums) {
        int t = nums[0];
        nums[0] = nums[1];
        nums[1] = t;
    }
}
