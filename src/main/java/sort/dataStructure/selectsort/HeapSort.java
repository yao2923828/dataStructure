package sort.dataStructure.selectsort;

import sort.dataStructure.Sort;
import sort.dataStructure.SortUtils;

/**
 * <p>标题: </p>
 * <p>功能描述: </p>
 *
 * <p>创建时间: 2019/3/13 15:02</p> 
 * <p>作者：yaoq</p>
 * <p>修改历史记录：</p>
 * ====================================================================<br>
 */
public class HeapSort implements Sort {
    public int[] sort(int[] data) {
        int len = data.length -1;
        for(int i = len/2 - 1; i >=0; i --){ //堆构造
            heapAdjust(data,i,len);
        }
        while (len >=0){
            SortUtils.swap(data,0,len--);    //将堆顶元素与尾节点交换后，长度减1，尾元素最大
            heapAdjust(data,0,len);    //再次对堆进行调整
        }
        return data;
    }


    public  void heapAdjust(int[] arr,int i,int len){
        int left,right,j ;
        while((left = 2*i+1) <= len){    //判断当前父节点有无左节点（即有无孩子节点，left为左节点）
            right = left + 1;  //右节点
            j = left;   //j"指针指向左节点"
            if(j < len && arr[left] < arr[right])    //右节点大于左节点
                j ++;     //当前把"指针"指向右节点
            if(arr[i] < arr[j])    //将父节点与孩子节点交换（如果上面if为真，则arr[j]为右节点，如果为假arr[j]则为左节点）
                SortUtils.swap(arr,i,j);
            else         //说明比孩子节点都大，直接跳出循环语句
                break;
            i = j;
        }
    }
}
