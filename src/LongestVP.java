import java.util.Arrays;
import java.util.Stack;

public class LongestVP {
    public static int longestValidParentheses(String s) {
        Stack<Character> st=new Stack<>();
        Stack<Integer> stnum=new Stack<>();

        int num=0;
        for (int i=0,j=s.length();i<j;i++){
            if (s.charAt(i)=='('){
                st.push('(');
                stnum.push(i);
            }
            if (s.charAt(i)==')'){
                if (!st.empty()&&st.peek()=='(')
                {
                    st.pop();
                    stnum.pop();
                }
                else {
                    stnum.push(i);
                }
            }
        }

        int max=0;
        Integer[] a=new Integer[s.length()];
        int stlen=stnum.size();
        stnum.toArray(a);
        max=a[0]+1;
        int tem=0;
        for (int i=1;i<stlen;i++)
        {
            tem=a[i]-a[i-1];
            if (tem>max)
                max=tem;
        }
        max=s.length()-a[stlen-1]>max?s.length()-a[stlen-1]:max;
        return max-1;
    }
    public static  void main(String arg[]){
        String s="()()()((()";
        int res=longestValidParentheses(s);
        System.out.println(res);
    }
}
