package sort.dataStructure.swapsort;

import sort.dataStructure.Sort;
import sort.dataStructure.SortUtils;

/**
 * <p>标题: </p>
 * <p>功能描述: </p>
 *
 * <p>创建时间: 2019/3/13 13:15</p> 
 * <p>作者：yaoq</p>
 * <p>修改历史记录：</p>
 * ====================================================================<br>
 */
public class SwapSort implements Sort {
    public int[] sort(int[] data) {
        for(int i=0;i<data.length-1;i++){
            for(int j=0;j<data.length-1-i;j++){
                //如果左边的元素大于右边的元素
                if(data[j]>data[j+1]){
                    //交换位置
                    SortUtils.swap(data, j, j+1);
                }
            }
        }
        return data;
    }
}
