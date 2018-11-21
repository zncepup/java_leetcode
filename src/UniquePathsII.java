public class UniquePathsII {
    public static void out(int[][] nums){
        for (int i = 0; i <nums.length ; i++) {
            for (int j = 0; j <nums[0].length ; j++) {
                System.out.print(nums[i][j]);
            }
            System.out.println();
        }
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] nums=new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j]==1)
                    nums[i][j]=0;
            }
        }
        int tag1=0,tag2=0;
        for (int i = obstacleGrid.length-1; i > -1; i--) {
            if(obstacleGrid[i][obstacleGrid[0].length-1]==1|tag1==1)
            {
                nums[i][obstacleGrid[0].length-1]=0;
                tag1=1;
            }
            else nums[i][obstacleGrid[0].length-1]=1;
        }
        for (int i = obstacleGrid[0].length-1; i > -1; i--) {
            if(obstacleGrid[obstacleGrid.length-1][i]==1|tag2==1)
            {
                nums[obstacleGrid.length-1][i]=0;
                tag2=1;
            }
            else nums[obstacleGrid.length-1][i]=1;
        }
//        out(nums);
        for (int i = obstacleGrid.length-1-1; i >-1 ; i--) {
            for (int j = obstacleGrid[0].length-1-1; j >-1 ; j--) {
                if (obstacleGrid[i][j]==1)
                    nums[i][j]=0;
                else {nums[i][j]=nums[i+1][j]+nums[i][j+1];}
            }
        }
        return nums[0][0];
    }


    public static void main(String[] args) {
        int[][] nums={{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(nums));
    }
}
//    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
//        int m = obstacleGrid.length;
//        int n = obstacleGrid[0].length;
//        int[] dp = new int[n + 1];
//        dp[1] = 1;
//        for (int i = 0; i < m ; i++) {
//            for (int j = 1; j <=n; j++) {
//                if(obstacleGrid[i][j-1] == 1){
//                    dp[j] = 0;
//                }else {
//                    dp[j] += dp[j -1];
//                }
//            }
//        }
//        return dp[n];
//    }
