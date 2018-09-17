public class findnumofsubsquence {
    public static int isSubsequence(String s, String t) {
        if (s.length() == 0) return -1;
        int indexS = 0, indexT = 0,count=0,tag=0;
        while (indexT < t.length()) {
            if (t.charAt(indexT) == s.charAt(indexS)) {
                indexS++;
                if (indexS==1)
                    tag=indexT;
                if (indexS == s.length())
                {
                    System.out.println(tag);
                    count+=1;
                    indexS=0;
                    indexT=tag;
                }
            }

            indexT++;
        }
        return count;
    }

    public static void main(String[] args) {
        String s="aibank";
        String t="aibanakibank";
        int res=isSubsequence(s,t);
        System.out.println(res);
    }
}
