public class Findfirstlast {
    public static int[] searchRange(int nums[], int target){
        int first=findfirst(nums,0,nums.length-1,target);
        int last=findlast(nums,0,nums.length-1,target);
        int[] a={first,last};
        return a;
    }
    public static int findfirst(int[] nums, int left, int right, int target){
        if (right-left<2){
            if (nums[left]==target)
                return left;
            else if (nums[right]==target)
                return right;
            else return -1;
        }
        int mid=(left+right)/2;
        if(target<=nums[mid])
            return findfirst(nums,left,mid,target);
        else return findfirst(nums,mid+1,right,target);
    }

    public static int findlast(int[] nums, int left, int right, int target){
        if (right-left<2){
            if (nums[right]==target)
                return right;
            else if (nums[left]==target)
                return left;
            else return -1;
        }
        int mid=(left+right)/2;
        if(target>=nums[mid])
            return findlast(nums,mid,right,target);
        else return findlast(nums,left,mid-1,target);
    }

    public static void main(String[] args) {
        int[] a={1,4,4,4,4,4,5};
        int res=findlast(a,0,a.length,4);
        System.out.println(res);
    }
}
