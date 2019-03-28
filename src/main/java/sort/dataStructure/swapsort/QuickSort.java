package sort.dataStructure.swapsort;

import sort.dataStructure.Sort;

/**
 * <p>标题: </p>
 * <p>功能描述: </p>
 *
 * <p>创建时间: 2019/3/13 16:15</p> 
 * <p>作者：yaoq</p>
 * <p>修改历史记录：</p>
 * ====================================================================<br>
 */
public class QuickSort implements Sort {
    public int[] sort(int[] data) {
        return QuickSort(data,0,data.length);
    }
    int partition(int [] v, int left, int right)
    {
        int begin = left;
        int end = right - 1;
        int key = v[end];          // 选基准

        while (begin < end)
        {
            while (begin < end && v[begin] <= key)
                begin++;
            if (begin < end)
                v[end--] = v[begin];
            while (begin < end && v[end] >= key)
                end--;
            if (begin < end)
                v[begin++] = v[end];
        }
        v[end] = key;
        return end;
    }
    int[] QuickSort(int [] v, int left, int right)
    {
        if (left < right)
        {
            int boundary = partition(v, left, right);
            QuickSort(v, left, boundary);
            QuickSort(v, boundary + 1, right);
        }
        return v;
    }
}
