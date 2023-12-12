package leetcode.数据结构;

/**
 * <p>标题: </p>
 * <p>功能描述: </p>
 *
 * <p>创建时间: 2021/8/16 6:57</p> 
 * <p>作者：yaoq</p>
 * <p>修改历史记录：</p>
 * 解题技巧：
 * 1.统计二进制1或者0的个数
 * ====================================================================<br>
 */
public class 位运算 {
    /**
     * 统计两个数的二进制表示有多少位不同
     */
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int cnt = 0;
        while(z != 0) {
            if ((z & 1) == 1) cnt++;
            z = z >> 1;
        }
        return cnt;
    }

    public int hammingDistance2(int x, int y) {
        int z = x ^ y;
        int cnt = 0;
        while (z != 0) {
            z &= (z - 1);
            cnt++;
        }
        return cnt;
    }
    /**
     * 数组中唯一一个不重复的元素
     */
    public int singleNumber(int[] nums) {
        int ret = 0;
        for (int n : nums) ret = ret ^ n;
        return ret;
    }
    /**
     * 找出数组中缺失的那个数
     */
    public int missingNumber(int[] nums) {
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            ret = ret ^ i ^ nums[i];
        }
        return ret ^ nums.length;
    }

    public static void main(String[] args) {
        位运算 testClass=new 位运算();
        int [] nums={0,1,2,4,5};
        System.out.println(testClass.missingNumber(nums));
    }
    /**
     * 数组中不重复的两个元素
     */
    public int[] singleNumber2(int[] nums) {
        int diff = 0;
        for (int num : nums) diff ^= num;
        diff &= -diff;  // 得到最右一位
        int[] ret = new int[2];
        for (int num : nums) {
            if ((num & diff) == 0) ret[0] ^= num;
            else ret[1] ^= num;
        }
        return ret;
    }
    /**
     * 翻转一个数的比特位
     */
    public int reverseBits(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            ret <<= 1;
            ret |= (n & 1);
            n >>>= 1;
        }
        return ret;
    }
    /**
     * 不用额外变量交换两个整数
     */
    public int[] swapNumbers(int[] numbers) {
        /*
         * 分析题意：不开辟额外空间，原地交换两个数，我们可以用到位运算的两个知识点
         * x ^ 0 = x, x ^ x = 0;
         * 例如第一个变量是a，第二个变量是b，那么我们先让 a = a ^ b，然后 b = a ^ b, 此时把前面 a 的新赋值带进来
         * 就得 b = a ^ b ^ b = a ^ 0 = a，这样 b = a 已经替换成功了，然后再让 a = a ^ b，把前面两个式子带入第
         * 三个式子中得：a = a ^ b ^ a ^ b ^ b，偶数个异或为0，0异或任何数都为任何数，得到结果 a = b。替换完毕。
         */
        numbers[0] = numbers[0] ^ numbers[1];
        numbers[1] = numbers[0] ^ numbers[1];
        numbers[0] = numbers[0] ^ numbers[1];
        return numbers;
    }


    /**
     * 判断一个数是不是 2 的 n 次方
     */
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
    /**
     * 判断一个数是不是 4 的 n 次方
     */
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num & 0b01010101010101010101010101010101) != 0;
    }
    /**
     * 判断一个数的位级表示是否不会出现连续的 0 和 1
     */
    public boolean hasAlternatingBits(int n) {
        int a = (n ^ (n >> 1));
        return (a & (a + 1)) == 0;
    }
    /**
     * 求一个数的补码
     */
    public int findComplement(int num) {
        if (num == 0) return 1;
        int mask = 1 << 30;
        while ((num & mask) == 0) mask >>= 1;
        mask = (mask << 1) - 1;
        return num ^ mask;
    }
    /**
     * 实现整数的加法
     */
    public int getSum(int a, int b) {
        return b == 0 ? a : getSum((a ^ b), (a & b) << 1);
    }
    /**
     * 字符串数组最大乘积
     */
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] val = new int[n];
        for (int i = 0; i < n; i++) {
            for (char c : words[i].toCharArray()) {
                val[i] |= 1 << (c - 'a');
            }
        }
        int ret = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((val[i] & val[j]) == 0) {
                    ret = Math.max(ret, words[i].length() * words[j].length());
                }
            }
        }
        return ret;
    }
    /**
     * 统计从 0 ~ n 每个数的二进制表示中 1 的个数
     */
    public int[] countBits(int num) {
        int[] ret = new int[num + 1];
        for(int i = 1; i <= num; i++){
            ret[i] = ret[i&(i-1)] + 1;
        }
        return ret;
    }
}
