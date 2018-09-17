import java.util.Scanner;

public class tx_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int res=findm(n);
        System.out.println(res);
    }
    public static int findm(int n){
        int mutilpe=1;
        for (int i = 1; i < n+1; i++) {
            mutilpe*=(i);
        }

        int res=0;
        mutilpe=mutilpe<=0?2147483647-1:mutilpe;

        for (int i = 2; i < n+1; i++) {
            for (int j = n+1; j < mutilpe+1; j++) {
                if (j%i==0){
                    if (j>res)
                        res=j;
                    break;
                }
            }
        }
        return res;
    }
}
