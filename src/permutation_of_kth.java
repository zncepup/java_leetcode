import java.lang.reflect.Array;
import java.util.Arrays;

public class permutation_of_kth {
    public static String getPermutation(int n, int k) {
        int[] nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=i+1;
        }
        int left=0,right=n;
        int[] changes=new int[n];
        while (k!=0){
            changes[n-right]=k/jiecheng(right-1);
            System.out.println(changes[n-right]);
            k=k%jiecheng(right-1)+jiecheng(right-1);right--;

            System.out.println(k);
        }

        String res="";
        for (int i = 0; i < nums.length; i++) {
            res=res+nums[i];
        }
        return res;
    }
    public static void swap(int[] nums,int left,int right){
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    }
    public static int jiecheng(int n){
        int res=1;
        while (n>0){
            res=res*n;
            n--;
        }
        return res;
    }

    public static void main(String[] args) {
        String res=getPermutation(3,6);
        System.out.println(res);
    }
}
