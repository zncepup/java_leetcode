public class fanpai {
    public static int numoffushu(int n,int m){
        int[][] nums=new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i][j]=1;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = -1; k < 2; k++) {
                    if (i+k<0)
                        continue;
                    int c=Math.max(0,i+k);
                    if (k==1)
                    {c=Math.min(n-1,i+k);
                    if (i+k>n-1)continue;}

                    for (int l = -1; l < 2; l++) {
                        if (l+j<0)
                            continue;

                        int r=Math.max(0,l+j);
                        if (l==1){
                            r=Math.min(m-1,l+j);
                            if (l+j>m-1)
                                continue;
                        }
                        nums[c][r]=-nums[c][r];
                    }
                }
            }
        }
        int res=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (nums[i][j]==-1)
                    res+=1;
            }
        }
    return res;
    }

    public static void main(String[] args) {
        System.out.println(numoffushu(2,2));
    }
}
