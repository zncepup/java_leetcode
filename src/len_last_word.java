public class len_last_word {
    public int lengthOfLastWord(String s) {
        if (s==null||s.length()==0)
            return 0;
        int i1=s.length()-1;
        while (s.charAt(i1)==' '&&i1>0)
            i1--;
        int res=0;
        for (int i = i1; i >=0 ; i--) {
            if (s.charAt(i)==' ')
                return res;
            if (s.charAt(i)!=' ')
                res++;
        }
        return res;
    }
}
