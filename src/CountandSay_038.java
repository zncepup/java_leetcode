public class CountandSay_038 {
    public static String countAndSay(int n){
        if (n <= 0) {
            return "";
        }
        String first_term="1";
        for (int i = 1; i < n; i++) {
            first_term=getnext(first_term);
//            System.out.println((i+1)+" "+first_term);
        }
        return first_term;
    }
    private static String getnext(String s){
        if (s.equals("1"))
            return "11";
        s+="#";
        char[] nums=s.toCharArray();
        String res="";
        int count=0;int len=nums.length;
        for (int i = 0; i < len-1; i++) {
            if (nums[i] == nums[i+1]) {
                count++;
            }
            else {
                res+=(count+1);
                res+=nums[i];
                count=0;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String res=countAndSay(4);
        System.out.println(res);
    }
}
