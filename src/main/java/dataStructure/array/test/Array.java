package dataStructure.array.test;

/**
 * <p>标题: </p>
 * <p>功能描述: </p>
 *
 * <p>创建时间: 2022/9/1 23:25</p> 
 * <p>作者：yaoq</p>
 * <p>修改历史记录：</p>
 * ====================================================================<br>
 */
public class Array {
    //保存数据
    private int [] data;
    //实际元素的数量
    private int count;
    //数据的大小
    private int n;

    public Array(int capcity){
        if(capcity < 0){
            return;
        }
        this.n=capcity;
        this.data=new int[capcity];
        this.count=0;
    }

    public void add(int index,int value){
        //校验index，非法直接返回，非法存在两种情况，一种是数组已满，一种是index太大或者太小

        //判定index的位置，如果是最后一位，则不需要移动元素

        //如果是最后一位，则需要将index后面的元素，向后自动，腾出来的空间
    }

    public int delete(int index){
        //1.校验删除的index是否合规

        //2.将index之后的元素，前移，覆盖原有值即可
        return -1;
    }

    public int get(int index){
        //直接利用下标，或者相应的元素
        return -1;
    }
}
