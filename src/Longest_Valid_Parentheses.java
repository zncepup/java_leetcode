import java.util.Stack;

public class Longest_Valid_Parentheses {
    //Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
    static class Solution{
        public int longestValidParentheses(String s){
            if(s==null|s.equals(""))
                return 0;
            int len=s.length();
            int[] index=new int[len/2];
            int j=0;
            for(int i=0;i<len-1;i++)
            {
                if("()".equals(s.substring(i, i + 2)))
                {
                    index[j]=i;
                    j++;
                    i++;
                }
            }
            int[][] ints = new int[j][2];
            for(int i=0;i<j;i++)
            {
                ints[i]=extend_len(index[i],index[i]+1,s);
            }
            boolean x=true;
            while (x){
                x=change(ints);
            }
            int max=0;
            for(int i=0;i<j;i++){
                int res=ints[i][1]-ints[i][0];
                if (res>max)
                    max=res;
            }
return max;
        }
        private boolean is_valid(String s){
            if(s.charAt(0)==')')
                return false;
            Stack<Character> st=new Stack<>();
            for(int i=0,len=s.length();i<len;i++){
                char sign=s.charAt(i);
                if(sign=='(')
                    st.push(sign);
                else {
                    if (st.empty())
                        return false;
                    else st.pop();
                };
            }
            return st.empty();
        }
        private int[] extend_len(int left,int right,String s){
            int len=s.length();
            int tag=1;
            while (left>=0&&right<len&&tag==1){
                tag=0;
                if (left>=2){
                    if (s.substring(left - 2, left).equals("()")){
                        System.out.println(1);
                        System.out.println(s.substring(left - 2, left));
                        left-=2;
                        tag=1;

                    }
                }
                if (right<=len-1-2){
                    if (s.substring(right + 1, right + 3).equals("()"))
                    {
                        System.out.println(2);
                        System.out.println(s.substring(right + 1, right + 3));
                        right+=2;
                        tag=1;

                    }
                }
                if (left>0&&right<len-1){
                    if (s.charAt(left-1)=='('&&s.charAt(right+1)==')'){
                        System.out.println(3);
                        System.out.println(s.charAt(left-1));
                        System.out.println(s.charAt(right+1));
                        left--;
                        right++;
                        tag=1;


                    }
                }
            }
            System.out.println(right);
            int[] res={left,right};
            return res;
        }
        private boolean change(int[][] s){
            boolean tag=false;
            for(int i=0,len=s.length;i<len;i++){
                for(int j=i+1;j<len;j++){
                    if(s[i][0]==s[j][0]&&s[i][1]==s[j][1]){

                    }
                    else if(s[i][1]>s[j][0]-2)
                    {
                        s[j][0]=s[j][0]<s[i][0]?s[j][0]:s[i][0];
                        s[j][1]=s[j][1]>s[i][1]?s[j][1]:s[i][1];
                        s[i][0]=s[j][0];s[i][1]=s[j][1];
                        tag=true;
                    }
                }
            }
            return tag;
        }
    }
    public static void main(String arg[]){
        Solution s=new Solution();
        String str= ")(((((()())()()))()(()))(";
//        int res=s.extend_len(6,7,str);
//        System.out.println(res);
    }
}
