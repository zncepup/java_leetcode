import java.lang.reflect.Array;
import java.util.*;

public class permutations46 {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        add(res,nums,0);

        return res;
    }
    public static void add(List<List<Integer>> res,int[] nums,int begin){
        if (begin==nums.length){
            List<Integer> temp=new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                temp.add(nums[j]);
            }
            res.add(temp);
        }
        for (int i = begin; i < nums.length; i++) {
            swap(nums,begin,i);

            add(res,nums,begin+1);

            swap(nums,begin,i);
        }
    }
    public static void swap(int[] nums,int i,int j){
        int tem=0;
        tem=nums[i];
        nums[i]=nums[j];
        nums[j]=tem;
    }

    public static void main(String[] args) {
        List<List<Integer>> res=new ArrayList<>();
        int[] nums={1,2,3,4};
        res=permute(nums);
        Iterator it1=res.iterator();
        while (it1.hasNext()){
            System.out.println(it1.next());
        }
    }
}
