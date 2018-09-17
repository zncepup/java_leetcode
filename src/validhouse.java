public class validhouse {
    public static int valid_house(int n, int k){
        if (k>n-1)
            return 0;
        int wei=n-k;
        int res=Math.min(wei,k-1);
        return Math.max(res,0);
    }

    public static void main(String[] args) {
        int res=valid_house(1,1);
        System.out.println(res);
    }
}
