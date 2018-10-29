import java.util.ArrayList;
import java.util.List;

public class spiralmatrix {
    public static List<Integer> spiralorder(int[][] matrix){
        List res= new ArrayList<Integer>();
        if(matrix==null||matrix.length==0)
            return res;
        int m=matrix.length;
        int n=matrix[0].length;
        if(m>n){return res;}
        int i=0;
        do {
            for (int j = i; j < n-i; j++) {
                res.add(matrix[i][j]);
            }
            for (int j = i+1; j < m-i; j++) {
                res.add(matrix[j][n-1-i]);
            }
            if (m!=i+i+1){
                for (int j = n-1-i-1; j >i-1 ; j--) {
                    res.add(matrix[m-i-1][j]);
                }
            }
            for (int j = m-i-1-1; j >i ; j--) {
                res.add(matrix[j][i]);
            }
            i++;
        } while (i-1<m/2);
        return res;
    }

    public static void main(String[] args) {
//        int[][] nums={{1,2,3},{4,5,6},{7,8,9}};
        int[][] nums={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> res=spiralorder(nums);
        for(Integer i:res){
            System.out.print(i);
        }
    }
}

//public List<Integer> spiralOrder(int[][] matrix) {
//
//    List<Integer> res = new ArrayList<Integer>();
//
//    if (matrix.length == 0) {
//        return res;
//    }
//
//    int rowBegin = 0;
//    int rowEnd = matrix.length-1;
//    int colBegin = 0;
//    int colEnd = matrix[0].length - 1;
//
//    while (rowBegin <= rowEnd && colBegin <= colEnd) {
//        // Traverse Right
//        for (int j = colBegin; j <= colEnd; j ++) {
//            res.add(matrix[rowBegin][j]);
//        }
//        rowBegin++;
//
//        // Traverse Down
//        for (int j = rowBegin; j <= rowEnd; j ++) {
//            res.add(matrix[j][colEnd]);
//        }
//        colEnd--;
//
//        if (rowBegin <= rowEnd) {
//            // Traverse Left
//            for (int j = colEnd; j >= colBegin; j --) {
//                res.add(matrix[rowEnd][j]);
//            }
//        }
//        rowEnd--;
//
//        if (colBegin <= colEnd) {
//            // Traver Up
//            for (int j = rowEnd; j >= rowBegin; j --) {
//                res.add(matrix[j][colBegin]);
//            }
//        }
//        colBegin ++;
//    }
//
//    return res;
//}
