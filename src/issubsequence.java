public class issubsequence {
    public static int isSubsequence(String s, String t) {
        if (s.length() == 0) return -1;
        int indexS = 0, indexT = 0;
        while (indexT < t.length()) {
            if (t.charAt(indexT) == s.charAt(indexS)) {
                System.out.print(indexT);
                indexS++;
                System.out.println(indexS);
                if (indexS == s.length())
                    return indexT-s.length()+1;
            }
            else indexS=0;
            indexT++;
        }
        return -1;
    }

    public static void main(String[] args) {
        String s="abc";
        String t="122222ab1cd1abc1abc";
        int res=isSubsequence(s,t);
        System.out.println(res);
    }
}
