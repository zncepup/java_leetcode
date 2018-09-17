public class Rotated_sorted_array {
    public static int search(int[] nums, int target){
        if (nums.length==0)
            return -1;
        return search_subarr(nums,0,nums.length-1,target);
    }
    private static int search_subarr(int[] nums, int left, int right, int target)
    {
        if (right-left<2){
            if (nums[right]==target)
                return right;
            else if (nums[left]==target)
                return left;
            else return -1;
        }
        int mid=(left+right)/2;
        if (nums[left]<nums[mid]){
            if (target>=nums[left]&&target<=nums[mid])
                return search_subarr(nums,left,mid,target);
            else return search_subarr(nums, mid, right, target);
        }
        else {
            if (target>=nums[mid]&&target<=nums[right])
                return search_subarr(nums,mid,right,target);
            else return search_subarr(nums,left,mid,target);
        }
    }

    public static void main(String[] args) {
        int[] nums={4,5,6,7,0,1,2};
        int res=search(nums,3);
        System.out.println(res);
    }
}
