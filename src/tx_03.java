import java.util.Scanner;

public class tx_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m=sc.nextInt();
        int[] res=new int[m];
        int a,b,c,n=m;
        while (m!=0){
            a=sc.nextInt();
            b=sc.nextInt();
            c=sc.nextInt();
            res[n-m]=find(a,b,c);
            m--;
        }
        for (int i = 0; i < n; i++) {
            if (res[i]==1)
                System.out.println("YES");
            else System.out.println("NO");
        }
    }
    public static int find(int a,int b,int c){
        for (int i = 1; i < 100; i++) {
            if ((a*i+c)%b == 0) {
                return 1;
            }
        }
        return 0;
    }
}
