import java.util.Scanner;

public class iqiyi_minprocess {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str =sc.nextLine();
        char[] nums=str.toCharArray();
        int sum1=nums[0]+nums[1]+nums[2]-'0'-'0'-'0';
        int sum2=nums[3]+nums[4]+nums[5]-'0'-'0'-'0';
        int[] nums_int=new int[6];
        for (int i = 0; i < 6; i++) {
            nums_int[i]=nums[i]-'0';
        }
        if (sum1==sum2)
            System.out.println(0);
        else if (sum1<sum2)
        {
            int c1=x_d(nums_int[0],nums_int[1],nums_int[2],sum2);
            int c2=d_x(nums_int[3],nums_int[4],nums_int[5],sum1);
            System.out.println(Math.min(c1,c2));
        }
        else {
            int c1=x_d(nums_int[3],nums_int[4],nums_int[5],sum1);
            int c2=d_x(nums_int[0],nums_int[1],nums_int[2],sum2);
            System.out.println(Math.min(c1,c2));
        }


    }
    public static int x_d(int a,int b,int c,int target){
        int need=target-a-b-c;
        if(a < b) {
            int t = a;
            a = b;
            b = t;
        }
        if(a < c) {
            int t = a;
            a = c;
            c = t;
        }
        if(b < c) {
            int t = b;
            b = c;
            c = t;
        }
        int[] give={9-c,9-b,9-a};
        int count=0;
        for (int i = 0; i < 3; i++) {
            need-=give[i];
            count+=1;
            if (need<=0)
                break;
        }
        return count;
    }
    public static int d_x(int a,int b,int c,int target){
        int need=-(target-a-b-c);
        if(a < b) {
            int t = a;
            a = b;
            b = t;
        }
        if(a < c) {
            int t = a;
            a = c;
            c = t;
        }
        if(b < c) {
            int t = b;
            b = c;
            c = t;
        }
        int[] give={a,b,c};
        int count=0;
        for (int i = 0; i < 3; i++) {
            need-=give[i];
            count+=1;
            if (need<=0)
                break;
        }
        return count;
    }
}
