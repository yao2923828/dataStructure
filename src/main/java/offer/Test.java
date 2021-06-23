package offer;

import java.util.ArrayList;
import java.util.BitSet;

/**
 * <p>标题:剑指offer </p>
 * <p>功能描述:可参考：https://www.cyc2018.xyz </p>
 *
 * <p>创建时间: 2021/5/30 22:06</p> 
 * <p>作者：yaoq</p>
 * <p>修改历史记录：</p>
 * ====================================================================<br>
 */
public class Test {
    public int duplicate(int [] nums){
        for(int i=0;i<nums.length;i++){
            while (nums[i]!=i){
                if(nums[i]==nums[nums[i]]){
                    return nums[i];
                }
                swap(nums, i, nums[i]);
            }
            swap(nums, i, nums[i]);
        }
        return -1;
    }

    private void swap(int [] nums,int i,int j){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }

    public boolean Find(int target,int [][] matrix){
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return false;
        }
        int row=matrix.length,cols=matrix[0].length;
        int r=0,c=cols-1;
        while (r<=row-1&&c>=0){
            if(target==matrix[r][c]){
                return true;
            }else if(target>matrix[r][c]){
                r++;
            }else {
                c--;
            }
        }
        return false;
    }

    public String replaceSpace(StringBuffer str){
        int p1=str.length()-1;
        for(int i=0;i<=p1;i++){
            if(str.charAt(i)==' '){
                str.append("  ");
            }
        }
        int p2=str.length()-1;
        while (p1>=0&&p2>p1){
            char c=str.charAt(p1--);
            if(c==' '){
                str.setCharAt(p2--,'0' );
                str.setCharAt(p2--,'2' );
                str.setCharAt(p2--,'%' );
            }else {
                str.setCharAt(p2--,c );
            }
        }
        return str.toString();
    }

    public ArrayList<Integer> printMatrix(int [][] matrix){
        ArrayList ret=new ArrayList();
        int r1=0,r2=matrix.length-1,c1=0,c2=matrix[0].length-1;
        while (r1<=r2&&c1<=c2){
            //上
            for(int i=c1;i<=c2;i++){
                ret.add(matrix[r1][i]);
            }
            //右
            for (int i=r1;i<=r2;i++){
                ret.add(matrix[i][c2]);
            }

            //下
            if(r1!=r2){
                for (int i=c2;i>=c1;i--){
                    ret.add(matrix[r2][i]);
                }
            }

            //左
            if(c1!=c2){
                for (int i=r2;i>=r1;i--){
                    ret.add(matrix[i][c1]);
                }
            }
        }
        return ret;
    }

    public int FirstNotRepeatingChar(String str){
        int [] cnts=new int[128];
        for (int i=0;i<str.length();i++){
            cnts[str.charAt(i)]++;
        }
        for (int i=0;i<str.length();i++){
            if(cnts[str.charAt(i)]==1){
                return i;
            }
        }
        return -1;
    }

    public int FirstNotRepeatingChar2(String str){
        BitSet bitSet1=new BitSet(128);
        BitSet bitSet2=new BitSet(128);
        for (char c:str.toCharArray()){
            if(!bitSet1.get(c) && !bitSet2.get(c)){
                bitSet1.set(c);
            }
            if(bitSet1.get(c)&&!bitSet2.get(c)){
                bitSet2.set(c);
            }
        }

        for (int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(bitSet1.get(c)&&!bitSet2.get(c)){
                return i;
            }
        }
        return -1;
    }

}
