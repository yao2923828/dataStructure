package algorithm.sort.selectsort;

import algorithm.sort.Sort;
import algorithm.sort.SortUtils;

/**
 * <p>标题: </p>
 * <p>功能描述: 选择排序</p>
 *
 * <p>创建时间: 2019/3/13 13:15</p> 
 * <p>作者：yaoq</p>
 * <p>修改历史记录：</p>
 * ====================================================================<br>
 */
public class SelectSort implements Sort {
    public int[] sort(int[] data) {
        for (int i=0;i<data.length-1;i++){
            int temp=data[i];  //最小值
            int index=i;  //最小值的位置
            //找出最小的值和位置
            for(int j=i+1;j<data.length;j++){
                if(data[j]<temp){
                    temp=data[j];
                    index=j;
                }
            }
            SortUtils.swap(data,i ,index );
        }
        return data;
    }
}
