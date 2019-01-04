public class zheban {
    public static int search(int[] nums, int x) {
        int min = 0, mid = 0, max = nums.length - 1;
        mid = (max + min) / 2;
        while (min < max) {
            if (nums[mid] == x)
                return mid;
            else if (nums[mid] > x) {
                max = mid;
            } else min = mid;
            mid = (max + min) / 2;
            System.out.println(mid);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        System.out.println(search(nums, 5));
    }
}
