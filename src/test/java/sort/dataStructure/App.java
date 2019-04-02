package sort.dataStructure;

import org.junit.Test;
import sort.dataStructure.selectsort.HeapSort2;

/**
 * <p>标题: </p>
 * <p>功能描述: </p>
 *
 * <p>创建时间: 2019/3/13 7:13</p> 
 * <p>作者：yaoq</p>
 * <p>修改历史记录：</p>
 * ====================================================================<br>
 */
public class App {
    @Test
    public void sort(){
        int [] data={70,30,40,10,80,20,90,100,75,60,55};
        System.out.println("原始的数字序列：");
        for (int i=0;i<data.length;i++){
            System.out.print(data[i]+" ");
        }
        System.out.println();

        Sort sort=new HeapSort2();
        data=sort.sort(data);
        System.out.println("排序后的数字序列：");
        for (int i=0;i<data.length;i++){
            System.out.print(data[i]+ " ");
        }
    }
}
