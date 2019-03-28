package sort.dataStructure.insertsort;

import sort.dataStructure.Sort;
import sort.dataStructure.SortUtils;

/**
 * <p>标题: </p>
 * <p>功能描述: </p>
 *
 * <p>创建时间: 2019/3/13 7:15</p> 
 * <p>作者：yaoq</p>
 * <p>修改历史记录：</p>
 * ====================================================================<br>
 */
public class SortArithMetic implements Sort {
    public int [] sort(int [] data){
        for(int i=0;i<data.length;i++){
            int temp=data[i];
            int j=0;
            //移动位置
            for(j=i-1;j>=0;j--){
                if(data[j]>temp){
                    SortUtils.swap(data, j, j+1);
                }
            }
        }
        return data;
    }

}
