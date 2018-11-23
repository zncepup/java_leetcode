public class addBinary {
    public static String addBinary(String a, String b) {
        if (a.length()<b.length())
        {
            String s="";
            s=a;
            a=b;
            b=s;
        }
        int i=0,tag=0;
        String res="";
        while (i<b.length()){
            res=String.valueOf((a.charAt(a.length()-i-1)-'0'-'0'+b.charAt(b.length()-i-1)+tag)%2)+res;
            tag=(a.charAt(a.length()-i-1)-'0'-'0'+b.charAt(b.length()-i-1)+tag)/2;
            i++;
        }
        while (i<a.length()){
            res=String.valueOf((a.charAt(a.length()-i-1)-'0'+tag)%2)+res;
            tag=(a.charAt(a.length()-i-1)-'0'+tag)/2;
            i++;
        }
        if (tag!=0)
            res=String.valueOf(tag)+res;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(addBinary("11","11"));
    }
}
