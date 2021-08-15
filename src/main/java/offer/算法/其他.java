package offer.算法;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>标题: </p>
 * <p>功能描述: </p>
 *
 * <p>创建时间: 2021/7/28 7:58</p> 
 * <p>作者：yaoq</p>
 * <p>修改历史记录：</p>
 * ====================================================================<br>
 */
public class 其他 {
    /**
     * 打印从 1 到最大的 n 位数
     */
    public void print1ToMaxOfNDigits(int n) {
        if (n <= 0)
            return;
        char[] number = new char[n];
        print1ToMaxOfNDigits(number, 0);
    }

    private void print1ToMaxOfNDigits(char[] number, int digit) {
        if (digit == number.length) {
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[digit] = (char) (i + '0');
            print1ToMaxOfNDigits(number, digit + 1);
        }
    }

    private void printNumber(char[] number) {
        int index = 0;
        while (index < number.length && number[index] == '0')
            index++;
        while (index < number.length)
            System.out.print(number[index++]);
        System.out.println();
    }

    /**
     * 正则表达式匹配
     * f[i][j] 表示 str 的前 i 个字符与 pattern 中的前 j 个字符是否能够匹配
     * 解题思路https://leetcode-cn.com/problems/regular-expression-matching/solution/hen-rong-yi-li-jie-de-zheng-ze-biao-da-s-cpgp/
     */
    public boolean match(String str, String pattern) {

        int m = str.length(), n = pattern.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;  //空字符串与空字符串是匹配的
        for (int i = 1; i <= n; i++)
            if (pattern.charAt(i - 1) == '*')
                dp[0][i] = dp[0][i - 2];

        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                if (str.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '.')
                    dp[i][j] = dp[i - 1][j - 1];
                else if (pattern.charAt(j - 1) == '*')
                    if (pattern.charAt(j - 2) == str.charAt(i - 1) || pattern.charAt(j - 2) == '.') {
                        dp[i][j] |= dp[i][j - 1]; // a* counts as single a
                        dp[i][j] |= dp[i - 1][j]; // a* counts as multiple a
                        dp[i][j] |= dp[i][j - 2]; // a* counts as empty
                    } else
                        dp[i][j] = dp[i][j - 2];   // a* only counts as empty

        return dp[m][n];
    }

    /**
     * 表示数值的字符串
     * https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/solution/mian-shi-ti-20-biao-shi-shu-zhi-de-zi-fu-chuan-y-2/
     */
    public boolean isNumber(String s) {
        Map<Character,Integer>[] states = new Map[] {new HashMap<Character, Integer>() {{
            put(' ', 0);
            put('s', 1);
            put('d', 2);
            put('.', 4);
        }}, // 0.
                new HashMap<Character, Integer>() {{
                    put('d', 2);
                    put('.', 4);
                }},                           // 1.
                new HashMap<Character, Integer>() {{
                    put('d', 2);
                    put('.', 3);
                    put('e', 5);
                    put(' ', 8);
                }}, // 2.
                new HashMap<Character, Integer>() {{
                    put('d', 3);
                    put('e', 5);
                    put(' ', 8);
                }},              // 3.
                new HashMap<Character, Integer>() {{
                    put('d', 3);
                }},                                        // 4.
                new HashMap<Character, Integer>() {{
                    put('s', 6);
                    put('d', 7);
                }},                           // 5.
                new HashMap<Character, Integer>() {{
                    put('d', 7);
                }},                                        // 6.
                new HashMap<Character, Integer>() {{
                    put('d', 7);
                    put(' ', 8);
                }},                           // 7.
                new HashMap<Character, Integer>() {{
                    put(' ', 8);
                }}                                         // 8.
        };
        int p = 0;
        char t;
        for(char c : s.toCharArray()) {
            if(c >= '0' && c <= '9') t = 'd';
            else if(c == '+' || c == '-') t = 's';
            else if(c == 'e' || c == 'E') t = 'e';
            else if(c == '.' || c == ' ') t = c;
            else t = '?';
            if(!states[p].containsKey(t)) return false;
            p = (int)states[p].get(t);
        }
        return p == 2 || p == 3 || p == 7 || p == 8;
    }

    /**
     * 数字序列中的某一位数字
     */
    public int getDigitAtIndex(int index) {
        if (index < 0)
            return -1;
        int place = 1;  // 1 表示个位，2 表示 十位...
        while (true) {
            int amount = getAmountOfPlace(place);
            int totalAmount = amount * place;
            if (index < totalAmount)
                return getDigitAtIndex(index, place);
            index -= totalAmount;
            place++;
        }
    }

    /**
     * place 位数的数字组成的字符串长度
     * 10, 90, 900, ...
     */
    private int getAmountOfPlace(int place) {
        if (place == 1)
            return 10;
        return (int) Math.pow(10, place - 1) * 9;
    }

    /**
     * place 位数的起始数字
     * 0, 10, 100, ...
     */
    private int getBeginNumberOfPlace(int place) {
        if (place == 1)
            return 0;
        return (int) Math.pow(10, place - 1);
    }

    /**
     * 在 place 位数组成的字符串中，第 index 个数
     */
    private int getDigitAtIndex(int index, int place) {
        int beginNumber = getBeginNumberOfPlace(place);
        int shiftNumber = index / place;
        String number = (beginNumber + shiftNumber) + "";
        int count = index % place;
        return number.charAt(count) - '0';
    }

    /**
     * 把数字翻译成字符串
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= n; i++) {
            int one = Integer.valueOf(s.substring(i - 1, i));
            if (one != 0)
                dp[i] += dp[i - 1];
            if (s.charAt(i - 2) == '0')
                continue;
            int two = Integer.valueOf(s.substring(i - 2, i));
            if (two <= 26)
                dp[i] += dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 扑克牌顺子
     */
    public boolean isContinuous(int[] nums) {

        if (nums.length < 5)
            return false;

        Arrays.sort(nums);

        // 统计癞子数量
        int cnt = 0;
        for (int num : nums)
            if (num == 0)
                cnt++;

        // 使用癞子去补全不连续的顺子
        for (int i = cnt; i < nums.length - 1; i++) {
            if (nums[i + 1] == nums[i])
                return false;
            cnt -= nums[i + 1] - nums[i] - 1;
        }

        return cnt >= 0;
    }

    /**
     * 求 1+2+3+...+n
     */
    public int Sum_Solution(int n) {
        int sum = n;
        boolean b = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);
        return sum;
    }

    /**
     * 把字符串转换成整数
     */
    public int StrToInt(String str) {
        if (str == null || str.length() == 0)
            return 0;
        boolean isNegative = str.charAt(0) == '-';
        int ret = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == 0 && (c == '+' || c == '-'))  /* 符号判定 */
                continue;
            if (c < '0' || c > '9')                /* 非法输入 */
                return 0;
            ret = ret * 10 + (c - '0');
        }
        return isNegative ? -ret : ret;
    }

    public static void main(String[] args) {
        其他 solution=new 其他();

        solution.StrToInt(
                "+2147483647"
        );
    }
}
