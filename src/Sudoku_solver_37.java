public class Sudoku_solver_37 {
    public static int solvesudoku(char[][] board){
        char[] chosen={'1','2','3','4','5','6','7','8','9'};
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j]=='.'){
                    int res=0;
                    for (int k =0; k < 9; k++) {
                        if (isvalid(i,j,board,chosen[k])){
                            board[i][j]=chosen[k];
                            System.out.println(i+" "+j+chosen[k]);
                            res= solvesudoku(board);
                            if (res!=0)
                                return 1;
                        }
                    }
                    if (res==0)
                    {
                        System.out.println(i+" "+j+"can't found");
                        board[i][j]='.';
                        return 0;
                    }

                }
            }
        }
return 1;
    }
    public  static boolean isvalid(int i,int j,char[][] board,char target){
        for (int k = 0; k < 9; k++) {
            if(board[i][k]==target)
                return false;
        }
        for (int k = 0; k < 9; k++) {
            if(board[k][j]==target)
                return false;
        }
        for (int k=(i/3)*3;k<(i/3)*3+3;k++){
            for (int l = (j/3)*3; l < (j/3)*3+3; l++) {
                if (board[k][l]==target)
                    return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        char[][] board={{'5','3','.','.','7','.','.','.','.'},
                        {'6','.','.','1','9','5','.','.','.'},
                        {'.','9','8','.','.','.','.','6','.'},
                        {'8','.','.','.','6','.','.','.','3'},
                        {'4','.','.','8','.','3','.','.','1'},
                        {'7','.','.','.','2','.','.','.','6'},
                        {'.','6','.','.','.','.','2','8','.'},
                        {'.','.','.','4','1','9','.','.','5'},
                        {'.','.','.','.','8','.','.','7','9'}};
        solvesudoku(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

}
