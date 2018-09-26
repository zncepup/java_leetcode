import java.util.LinkedList;
import java.util.List;
import java.util.Collections;

public class Combinationsum_039 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> res= new LinkedList<>();
        List<Integer> record=new LinkedList<>();

        addonecombination(res,candidates,record,target);
        return res;
    }
    public static void addonecombination(List<List<Integer>> res,int[] candidates,List<Integer> last, int target){
        int len=candidates.length;
        for (int i = 0; i < len; i++) {
            if (getsum(last)+candidates[i]==target){
                List<Integer> record=new LinkedList<>();
                for (int j=0,len_=last.size();j<len_;j++)
                {
                    record.add(last.get(j));
                }
                record.add(candidates[i]);

                int tag=0;
                for (int j = 0,len_=res.size(); j < len_; j++) {
                    if (equallists(record,res.get(j)))
                        tag=1;
                }
                if (tag==0)
                    res.add(record);


            }
            else if (getsum(last)+candidates[i]<target){

                List<Integer> record=new LinkedList<>();
                for (int j=0,len_=last.size();j<len_;j++)
                {
                    record.add(last.get(j));
                }
                record.add(candidates[i]);

                addonecombination(res,candidates,record,target);
            }
            else {

            }
        }
    }
    public static int getsum(List<Integer> list){
        int sum=0;
        for (int i = 0,len=list.size(); i < len ; i++) {
            sum+=list.get(i);
        }
        return sum;
    }
    private static boolean equallists(List a,List b){
        if (a.size() !=b.size())
            return false;
        Collections.sort(a);
        Collections.sort(b);
        for (int i = 0; i <a.size(); i++) {
            if(!a.get(i).equals(b.get(i)))
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int[] candidates={7,3,2};
        List<List<Integer>> res= new LinkedList<>();
        res=combinationSum(candidates,18);
        System.out.println(res);
    }
}


//10ms submission
//class Solution {
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        List<List<Integer>> res = new ArrayList<>();
//        if (candidates == null || candidates.length == 0) return res;
//        helper(res, new ArrayList<>(), candidates, target, 0);
//        return res;
//    }
//
//    public void helper(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int start) {
//        if (target < 0) return;
//        if (target == 0) {
//            res.add(new ArrayList<>(list));
//            return;
//        }
//        for (int i = start; i < candidates.length; i++) {
//            list.add(candidates[i]);
//            helper(res, list, candidates, target - candidates[i], i); i防止重复
//            list.remove(list.size() - 1); 恢复原状态
//        }
//    }
//}
