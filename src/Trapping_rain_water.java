import java.util.Arrays;

public class Trapping_rain_water {
//    public static int trap(int[] height){  //	Time Limit Exceeded
//        if(height==null|height.length==0)
//            return 0;
//        int max=height[0];
//        for (int i = 0; i < height.length; i++) {
//            if (height[i]>max)
//                max=height[i];
//        }
//        int res=0,num_1=0;
//        int[] floor=new int[height.length];
//        for (int i = 0; i < max; i++) {
//            for (int j = 0; j < height.length; j++) {
//                if (height[j]>i)
//                {
//                    floor[j]=1;
//                    num_1+=1;
//                }
//            }
////            System.out.println(Arrays.toString(floor));
//            int tem=tarp_onefloor(floor);
//            res+=tem;
//            if (num_1==1)
//                break;
//            for (int j = 0; j < height.length; j++) {
//
//                    floor[j]=0;
//            }
//            num_1=0;
//        }
//        return res;
//    }
//    public static int tarp_onefloor(int[] tags){
//        int len=tags.length;
//        int l=0,r=len-1,res=0;
//        while (tags[r]==0)
//            r--;
//        while (tags[l]==0)
//            l++;
//        while (l<=r)
//        {
//            if (tags[l]==0)
//                res++;
//            l++;
//        }
//        return res;
//    }
    public static int trap(int[] height){
        int len=height.length;
        int[] left_max=new int[len];
        left_max[0]=height[0];
        int[] right_max=new int[len];
        right_max[len-1]=height[len-1];
        for (int i = 1; i < len; i++) {
            left_max[i]=Math.max(height[i],left_max[i-1]);
            right_max[len-i-1]=Math.max(height[len-i-1],right_max[len-i]);
        }
        int res=0;
        for (int i = 0; i < len; i++) {
            res+=Math.min(left_max[i],right_max[i])-height[i];
        }
        return res;
    }
    public static void main(String[] args) {
        int[] height={4,2,3};
        int res=trap(height);
        System.out.println(res);
    }
}
