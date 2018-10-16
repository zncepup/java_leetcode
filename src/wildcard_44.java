public class wildcard_44 {
    public static boolean isMatch(String s,String p){
        if (s==null|s.length()==0)
            if (p==null|p.length()==0)
                return true;
        if (s.equals(p))
            return true;
        else {
            if (!p.contains("?")&&!p.contains("*"))
                return false;
        }
//        char[] str_p=p.toCharArray();
        s+="a";
        p+="a";
        return dfs(s.toCharArray(),p.toCharArray(),0,0);
    }
    public static boolean dfs(char[] str_s,char[] str_p,int index_p,int index_s){
        if(index_p==str_p.length&&index_s==str_s.length)
            return true;
        if(index_p==str_p.length&&(index_s!=str_s.length))
            return false;
        if (index_p!=str_p.length&&index_s==str_s.length)
            return false;
        if (str_p[index_p]==str_s[index_s]|str_p[index_p]=='?')
            return dfs(str_s,str_p,index_p+1,index_s+1);
        if (str_p[index_p]=='*'){
            while (str_p[index_p+1]=='*')
                index_p++;
            boolean tag=false;
            for (int i = index_s; i <str_s.length ; i++) {
                if (cm(str_s[i],str_p[index_p+1])){
                    tag=dfs(str_s,str_p,index_p+1,i);
                    if (tag)
                        return tag;
                }
            }
            if (!tag)
                return tag;
        }
        return false;
    }
    public static boolean cm(char a, char b){
        if (a==b)
            return true;
        if (b=='?')
            return true;
        return false;
    }

    public static void main(String[] args) {
        String s="c";
        String p="*?*";
        boolean res=isMatch(s,p);
        System.out.println(res);
    }
}
