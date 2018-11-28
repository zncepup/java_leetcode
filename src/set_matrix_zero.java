public class set_matrix_zero {
    public static void setZeroes(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] >= 0 && matrix[i][j] != 2147483647)
                    matrix[i][j]++;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1)
                    setzero(i, j, matrix);
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] > 0 && matrix[i][j] != 2147483647)
                    matrix[i][j]--;
            }
        }
    }

    public static void setzero(int i, int j, int[][] nums) {
        nums[i][j] = 0;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k][j] != 1)
                nums[k][j] = 0;
            else setzero(k, j, nums);
        }
        for (int k = 0; k < nums[0].length; k++) {
            if (nums[i][k] != 1)
                nums[i][k] = 0;
            else setzero(i, k, nums);
        }
    }

    public static void main(String[] args) {
        int[][] nums = {{2147483647, 1, 2}};
        setZeroes(nums);
        UniquePathsII.out(nums);
    }
}
