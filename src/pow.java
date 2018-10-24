public class pow {
    private static double myPow(double x, int n) {
        double res;
        int tag=0;
        if (n==0)
            return 1.0;
        if (n<0)
        {
            tag=1;
            n=-n;
        }
        double[] mi=new double[64];
        mi[0]=x;
        for (int i = 1; i <64 ; i++) {
            mi[i]=mi[i-1]*mi[i-1];
        }
        String binary=Integer.toBinaryString(n);
        res=mi[binary.length()-1];
//        System.out.println(res);
        for (int i = 1; i < binary.length(); i++) {
            if (binary.charAt(i)=='1')
            {
                res=res*mi[binary.length()-1-i];
//                System.out.println(i);
            }
        }
        if (tag==1)
            return 1/res;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.0,11));
    }
}
