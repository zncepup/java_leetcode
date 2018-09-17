public class findabcd {
    public static void main(String[] args) {
        int sum_i=0;
        for (int i = 1000; i < 7888; i++) {
            sum_i=(i%1000)*10+i/1000+i;
            if (sum_i==8888) {
                int a=i/1000;
                int b=(i%1000)/100;
                int c=i%100/10;
                int d=i%10;



                System.out.print(a+" ");
                System.out.print(b+" ");
                System.out.print(c+" ");
                System.out.print(d+" ");
                System.out.println();
            }
        }
    }
}
