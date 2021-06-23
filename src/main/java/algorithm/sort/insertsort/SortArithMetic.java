package algorithm.sort.insertsort;

import algorithm.sort.Sort;

/**
 * <p>标题: </p>
 * <p>功能描述:插入排序 </p>
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
            int j=i-1;
            while (j>=0 && data[j]>temp){
               data[j+1]=data[j--];
            }
            data[j+1]=temp;

        }
        return data;
    }

}
