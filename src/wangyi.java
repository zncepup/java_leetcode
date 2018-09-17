import java.util.Scanner;

public class wangyi{
    public static int valid_house(int n, int k){
        if (k>n-1)
            return 0;
        int wei=n-k;
        int res=Math.min(wei,k-1);
        return Math.max(res,0);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        System.out.println(k);
        int i = 0;
        String [] c = new String[k];
        while (i<k){
            c[i]=sc.nextLine();
            i++;
        }
        for (i=0;i<k;i++){

        }


    }
}

