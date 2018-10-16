public class Mutiply_43 {
    public String multiply(String num1,String num2){
        if (num1.equals("0")|num2.equals("0"))
            return "0";
//         int[][] tem=new int[num1.length()+num2.length()][num2.length()];
         return "";
    }
    public static String string_add(String num1,String num2){
        String res="";
//        System.out.println(res);
        if (num1.length()<num2.length()){
            String temp="";
            temp=num1;
            num1=num2;
            num2=temp;
        }
        if (num1.length()-num2.length()!=0)
        {
            char[] pre=new char[num1.length()-num2.length()];
            num2=pre.toString()+num2;
        }



        int len_min=num1.length();
        int tag=0;
        for (int i = 0; i < len_min; i++) {
            int sum=num1.charAt(num1.length()-i-1)+num2.charAt(num2.length()-i-1)+tag;
//            System.out.println(sum);
            if (sum>105){
                res=(char)(sum-106+48)+res;
                tag=1;
//                System.out.println(res);
            }
            else {
                res=(char)(sum-96+48)+res;
                tag=0;
//                System.out.println(res);
            }
        }
        if (tag==1)
            res='1'+res;
        return res;
    }

    public static void main(String[] args) {
        String re=string_add("1123","1456");
        System.out.println(re);
    }
}
