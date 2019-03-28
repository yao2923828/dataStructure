package sort.dataStructure.insertsort;

import sort.dataStructure.Sort;

/**
 * <p>标题: </p>
 * <p>功能描述: 希尔排序</p>
 *
 * <p>创建时间: 2019/3/13 10:40</p> 
 * <p>作者：yaoq</p>
 * <p>修改历史记录：</p>
 * ====================================================================<br>
 */
public class ShellSort implements Sort {

    public int [] sort(int a[]) {
        int i, j, gap;
        int n = a.length;
        for (gap = n / 2; gap > 0; gap /= 2) //步长
            for (i = 0; i < gap; i++)        //直接插入排序
            {
                for (j = i + gap; j < n; j += gap)
                    if (a[j] < a[j - gap]) {
                        int temp = a[j];
                        int k = j - gap;
                        while (k >= 0 && a[k] > temp) {
                            a[k + gap] = a[k];
                            k -= gap;
                        }
                        a[k + gap] = temp;
                    }
            }
        return a;
    }

}
