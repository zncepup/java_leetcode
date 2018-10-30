public class jumpgame55 {
    public static boolean canJump(int[] nums){
        if (nums[nums.length-1]==0){
            int[] nums2=new int[nums.length-1];
            for (int i = 0; i < nums2.length; i++) {
                nums2[i]=nums[i];
            }
            return canJump_fei0(nums2);
        }
        else {
            return canJump_fei0(nums);
        }
    }
    public static boolean canJump_fei0(int[] nums){
        if (nums==null|nums.length==0)
            return true;
        int i=nums.length-1;
        while (nums[i]!=0 ){
            i--;
            if (i == -1) {
                return true;
            }
        }
        int last=find_last(nums,i);
        if (last==-1)
            return false;
        while (last!=-1){
            while (nums[last]!=0)
            {
                last--;
                if (last==-1)
                    return true;
            }

            last=find_last(nums,last);
            if (last==-1)
                return false;
        }
        return true;
    }
    public static int find_last(int[] nums,int zero){
        for (int i = zero; i >-1 ; i--) {
            if (nums[i]+i>zero)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] s={120};
        System.out.println(canJump(s));
    }
}
//
//class Solution {
//    public boolean canJump(int[] nums) {
//        int len = nums.length;
//        int last = len - 1;
//        for(int i = len-2; i >= 0; i--) {
//            if (nums[i]+i >= last) last = i;
//        }
//        return last == 0;
//    }
//}
