import java.util.ArrayList;
import java.util.List;

public class nqueens {
    public static List<List<String>> solveNQueens(int n){
        List<List<String>> res=new ArrayList<>();
        char [][] chessboard=new char[n][n];
        for (int i = 0; i <chessboard.length ; i++) {
            for (int j = 0; j <chessboard.length ; j++) {
                chessboard[i][j]='.';
            }
        }
        goandback(res,chessboard,0);
        return res;

    }
    public static boolean goandback(List<List<String>> res,char[][]chessboard,int index)
    {
//        System.out.println("index"+index);
        if (index==chessboard.length){
            List<String> tem=new ArrayList<>();
            twodarr2list(chessboard,tem);
//            System.out.println("prefect");
            res.add(tem);return true;
        }

        int tag=0;
        for (int i = 0; i < chessboard.length; i++) {
            if (isvalid(chessboard,index,i)){
                chessboard[index][i]='Q';
//                for (int i_ = 0; i_ <chessboard.length ; i_++) {
//                    for (int j = 0; j <chessboard.length ; j++) {
//                        System.out.print(chessboard[i_][j]);
//                    }
//                    System.out.println();
//                }
                tag=1;
                boolean go=goandback(res,chessboard,index+1);
                if (!go)
                {
                    chessboard[index][i]='.';
//                    System.out.println("wrongindex:"+index);
                    tag=0;
                }
                if (go){
                    chessboard[index][i]='.';
//                    System.out.println("wrongindex:"+index);
                    tag=0;
                }
            }
        }
//        System.out.println("can't found");
        return tag==1;

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
    public static void twodarr2list(char[][] chessboard,List<String> list){
        for (int i = 0; i <chessboard.length ; i++) {
            String temp="";
            for (int j = 0; j <chessboard.length ; j++) {
                temp=temp+chessboard[i][j];
            }
            list.add(temp);
        }
    }

    public static void main(String[] args) {
        List<List<String>> res=solveNQueens(4);
        for (List<String> solu:res){
            for(String s:solu)
                System.out.println(s);
        }
    }
}
