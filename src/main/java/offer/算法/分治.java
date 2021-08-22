package offer.算法;

/**
 * <p>标题: </p>
 * <p>功能描述: </p>
 *
 * <p>创建时间: 2021/8/23 6:32</p> 
 * <p>作者：yaoq</p>
 * <p>修改历史记录：</p>
 * ====================================================================<br>
 */
public class 分治 {
    /**
     * 数值的整数次方
     */
    public double Power(double x, int n) {
        boolean isNegative = false;
        if (n < 0) {
            n = -n;
            isNegative = true;
        }
        double res = pow(x, n);
        return isNegative ? 1 / res : res;
    }

    private double pow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        double res = pow(x, n / 2);
        res = res * res;
        if (n % 2 != 0) res *= x;
        return res;
    }
}
