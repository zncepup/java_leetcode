public class MinimumPathSum {
    public static int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[] res=new int[m+1];
        for (int i = 1; i <m+1 ; i++) {
            res[i]=res[i-1]+grid[m-i][n-1];
        }
        out(res);
        for (int i = n-2; i >-1 ; i--) {
            for (int j = 1; j <m+1 ; j++) {
                if (j==1){
                    res[j]=res[j]+grid[m-j][i];
                }
                else res[j]=Math.min(res[j]+grid[m-j][i],res[j-1]+grid[m-j][i]);
            }
            out(res);
        }
        return res[m];
    }
    public static void out(int[] nums){
        for(int i:nums){
            System.out.print(i);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[][] nums={{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(nums));
    }
}
