public class jumpgame45 {
    public static int jump(int[] nums){
        if (nums.length==1)
            return 0;
        int i=0;
        int steps=0;
        while (i<nums.length){

            i=findnext(i,nums);
            steps++;
            if (i==nums.length-1)
                return steps;
            if (nums[i]+i==nums.length-1)
                return steps+1;
            if (nums[i]+i>nums.length-1)
                return steps+1;
        }
        return 0;
    }
    public static int findnext(int now,int[] nums){
        int max=0;
        int res=0;
        if (nums[now]+now >= nums.length-1) {
            return nums.length-1;
        }
        for (int i = now+1; i < Math.min(now+nums[now]+1,nums.length); i++) {
            if (nums[i]+i>=max){
                max=nums[i]+i;
                res=i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a={2,3,1};
        int res=jump(a);
        System.out.println(res);
    }
}


//class Solution {
//    public int jump(int[] nums) {
//        int jumps = 0, currEnd = 0, currFarthest = 0;
//        for (int i = 0; i < nums.length - 1; i++) {
//            currFarthest = Math.max(currFarthest, i + nums[i]);
//            if (i == currEnd) {
//                jumps++;
//                currEnd = currFarthest;
//            }
//        }
//        return jumps;
//    }
//}

