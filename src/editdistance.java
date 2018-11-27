public class editdistance {
    public static int minDistance(String word1, String word2) {
        int len1=word1.length();
        int len2=word2.length();
        int[][] res=new int[len1+1][len2+1];
        res[0][0]=0;
        for (int i = 1; i <len1+1 ; i++) {
            res[i][0]=i;
        }
        for (int i = 1; i <len2+1 ; i++) {
            res[0][i]=i;
        }

        for (int i = 1; i < len2+1; i++) {
            for (int j = 1; j <len1+1 ; j++) {
                int a1=Math.min(res[j-1][i],res[j][i-1])+1;
                int a2=(word2.charAt(i-1)==word1.charAt(j-1))? res[j-1][i-1]:res[j-1][i-1]+1;
                res[j][i]=Math.min(a1,a2);
            }
        }UniquePathsII.out(res);
        return res[len1][len2];

    }

    public static void main(String[] args) {
        String a1="pneumonoultramicroscopicsilicovolcanoconiosis";
        String a2="ultramicroscopically";
        System.out.println(minDistance(a2,a1));
    }
}
