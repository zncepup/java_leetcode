import java.lang.reflect.Array;
import java.util.Arrays;

public class QuickSort {
    static void solution(int[] nums, int left, int right){
        if (right-left<1)
            return;
        int mid=qc(nums,left,right);
        solution(nums,left,mid-1);
        solution(nums,mid+1,right);

    }
    private static int qc(int[] nums, int left, int right)
    {
        int temp=nums[left],index=left,tag=0;
        while (left<right){
            while (nums[right]<=temp)
                right--;
            if (right>index){
                nums[index]=nums[right];
                nums[right]=temp;
                index=right;
                left+=1;
            }
            while (nums[left]>=temp)
                left++;
            if (left<index){
                nums[index]=nums[left];
                nums[left]=temp;
                index=left;

            }
        }
        return index;
    }
    public static void main(String arg[]){

        int[] a={4,9,6,3,8,2,7,1,3,5};
        System.out.println(Arrays.toString(a));
        solution(a,0,a.length-1);
//        System.out.println(res);
        System.out.println(Arrays.toString(a));
    }
}
