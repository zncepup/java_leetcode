import java.util.Arrays;

public class spiralmatrixii {
    public static int[][] generateMatrix(int n) {
        int[][] res=new int[n][n];
        int left=0,right=n-1,up=0,down=n-1,value=1;
        while (left<right&&up<down)
        {
            for (int i = left; i <=right ; i++) {
                res[up][i]=value;
                value++;

            }
            up++;
            for (int i = up; i <=down ; i++) {
                res[i][right]=value;
                value++;
            }
            right--;
            for (int i = right; i >=left ; i--) {
                res[down][i]=value;
                value++;
            }
            down--;
            for (int i =down; i>=up;i--){
                res[i][left]=value;
                value++;
            }
            left++;
        }
        if (n%2 != 0) {
            res[n/2][n/2]=n*n;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] res=generateMatrix(3);
        for (int [] x:res ) {
            System.out.println(Arrays.toString(x));
        }
    }
}
