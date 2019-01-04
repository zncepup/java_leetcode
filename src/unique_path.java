public class unique_path {

    public static int uniquePaths(int m, int n){
        int[][] nums=new int[m][n];
        for (int i = 0; i < n; i++) {
            nums[m-1][i]=1;
        }
        for (int i = 0; i < m; i++) {
            nums[i][n-1]=1;
        }
        for (int i = m-2; i >=0 ; i--) {
            for (int j = n-2; j >=0 ; j--) {
                nums[i][j]=nums[i][j+1]+nums[i+1][j];
            }
        }
        return nums[0][0];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(7,3));
        for (int i = 10; i > 0; i--) {
            System.out.println(i);
        }
    }
}
