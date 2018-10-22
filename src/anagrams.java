import com.sun.org.apache.xerces.internal.xs.StringList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
        for (String str:strs){
            String str_nums=string2string(str);
            if (hashMap.containsKey(str_nums))
                hashMap.get(str_nums).add(str);
            else {
                hashMap.put(str_nums,new ArrayList<>());
                hashMap.get(str_nums).add(str);
            }
        }
        List<List<String>> res= new ArrayList<>();
        for (ArrayList one:hashMap.values()){
            res.add(one);
        }
        return  res;
    }
    public static String string2string(String s){
        int[] res=new int[26];
        for (int i = 0; i < s.length(); i++) {
//            System.out.println((int)s.charAt(i));
            res[((int)s.charAt(i))-97]++;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < res.length; i++) {
            sb.append(res[i]+",");
        }
        String res1=sb.toString();
        return res1;
    }

    public static void main(String[] args) {
        String s="aaaaaaaaaaab";
        String s1="abbbbbbbbbbb";
        String res=string2string(s);
        System.out.println(res);
        System.out.println(string2string(s1));
    }
}
