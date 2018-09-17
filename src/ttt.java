import java.util.*;

public class ttt {
    static int[][] rect = null;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String res = sc.nextLine();
        char []ss=res.toCharArray();
//        rect = new int[n][n];
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < n; j++){
//                rect[i][j] = sc.nextInt();
//            }
//        }
//        int count = 0;
//
//        count=solution(n,rect);
//        System.out.println(count);
//        int x=0;
//        x|=8;
//        x='9'-'8';
//        String res=Integer.toBinaryString(-1>>>1);
//        System.out.println(res);
//        System.out.println(6>>>1);
//        System.out.println(1<<31);
    }
    public static int solution(int m,int[][]nums){
        ArrayList<int[]> indexs=new ArrayList<int[]>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (nums[i][j]==1){
                    int[] temp={i,j};
                    indexs.add(temp);
                }
            }
        }
        int count=0;
        Queue<int[]> temp=new LinkedList<int[]>() ;
        while (!indexs.isEmpty()){
            if (temp.isEmpty()){
                temp.add(indexs.get(0));
                indexs.remove(0);
                count+=1;
            }
            while (!temp.isEmpty()){
                int[] temp_now=temp.poll();
                for (int i=0;i<indexs.size();i++){
                    if (isneighbor(temp_now[0],temp_now[1],indexs.get(i)[0],indexs.get(i)[1]))
                    {
                        temp.add(indexs.get(i));
                        indexs.remove(i);
                        i--;
                    }
                }
            }
        }
        return count;

    }
    static boolean isneighbor(int x1, int y1, int x2, int y2){
        if (x1==x2&&Math.abs(y1-y2)==1)
            return true;
        else if (y1==y2&&Math.abs(x1-x2)==1)
            return true;
        else return false;
    }
}