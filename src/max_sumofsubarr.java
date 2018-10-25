public class max_sumofsubarr {
//    public static int maxSubArray(int[] nums) {
//        if (nums.length==1)
//            return nums[0];
//        int sum=0;
//        int max=nums[0];
//        for (int i = 0; i <nums.length ; i++) {
//            if (sum<0)
//                sum=0;
//            sum=sum+nums[i];
//            if (sum>max)
//                max=sum;
//        }
//        return max;
//    }
public static int maxSubArray(int[] nums) {
    if (nums.length==1)
        return nums[0];
    int sum=0;
    int max=nums[0];
    for (int i = 0; i <nums.length ; i++) {
        if (sum<0)
            sum=0;
        sum=sum+nums[i];
        if (sum>max)
            max=sum;
    }
    return max;
}

    public static void main(String[] args) {
        int[] nums={-2,-1};
        System.out.println(maxSubArray(nums));
    }
}
