import java.util.ArrayList;
import java.util.List;

public class nqueen2 {
    public static int totalNQueens(int n) {
        char [][] chessboard=new char[n][n];
        for (int i = 0; i <chessboard.length ; i++) {
            for (int j = 0; j <chessboard.length ; j++) {
                chessboard[i][j]='.';
            }
        }
        int res=goandback(chessboard,0);
        return res;
    }
    public static int goandback(char[][]chessboard,int index)
    {
        if (index==chessboard.length){
            return 1;
        }

        int tag=0;int res=0;
        for (int i = 0; i < chessboard.length; i++) {

            if (isvalid(chessboard,index,i)){
                chessboard[index][i]='Q';
                tag=1;
                int go=goandback(chessboard,index+1);
                res+=go;
                chessboard[index][i]='.';
                tag=0;
            }
        }
        return res;
    }
    public static boolean isvalid(char[][] chessboard,int i, int j){
        int tag=0;
        for (int k = 0; k <chessboard.length ; k++) {
            if (chessboard[k][j] == 'Q') {
                tag=1;
            }
        }
        int mem_i=i;
        int mem_j=j;
        while (i>-1&&j>-1){
            if (chessboard[i][j]=='Q')
                tag=1;
            i--;j--;
        }
        i=mem_i;j=mem_j;
        while (i>-1&&j<chessboard.length){
            if (chessboard[i][j]=='Q')
                tag=1;
            i--;j++;
        }
        return tag == 0;
    }

    public static void main(String[] args) {
        System.out.println(totalNQueens(4));
    }


}
//class Solution {
//    boolean[] col;
//    boolean[] diag;
//    boolean[] _diag;
//    int num = 0;
//    public int totalNQueens(int n) {
//        col = new boolean[n];
//        diag = new boolean[2*n-1];
//        _diag = new boolean[2*n-1];
//        dfs(n,0);
//        return num;
//    }
//
//    public void dfs(int n,int row){
//        if(row==n){
//            num++;
//            return;
//        }
//
//        for(int i = 0;i<n;i++){
//            int diagFlag = i-row+n-1;
//            int _diagFlag = i+row;
//            if(col[i]||diag[diagFlag]||_diag[_diagFlag])
//                continue;
//            col[i] = true;
//            diag[diagFlag] = true;
//            _diag[_diagFlag] = true;
//            dfs(n,row+1);
//            col[i] = false;
//            diag[diagFlag] = false;
//            _diag[_diagFlag] = false;
//        }
//    }
//}
