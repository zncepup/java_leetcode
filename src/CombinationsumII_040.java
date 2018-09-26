import java.util.*;

public class CombinationsumII_040 {
    public static List<List<Integer>> combinationSum2(int[] candidates,int target){
        List<List<Integer>> res=new LinkedList<>();
        helper(res,new LinkedList<>(),target,candidates,0);
        return res;
    }
    public static  void helper(List<List<Integer>> res,List<Integer> last,int target,int[] candidates,int start){
        if (start==candidates.length)
            return ;
        int tag=0;
        for (int i = 0; i < 2; i++) {
           if (i==0){
               if (target-candidates[start]==0){
                   last.add(candidates[start]);
                   for (int j = 0; j < res.size(); j++) {
                       if (equallists(last,res.get(j))){
                           tag=1;
                       }
                   }
                   if (tag==0)
                       res.add(new LinkedList<>(last));
                   last.remove(last.size()-1);
               }
               if (target-candidates[start]>0){
                   {
                       last.add(candidates[start]);
                       helper(res,last,target-candidates[start],candidates,start+1);
                       last.remove(last.size()-1);
                   }

               }
               if (target-candidates[start]<0)
               {}
           }
           if (i==1){
               helper(res,last,target,candidates,start+1);
           }
        }

    }
    private static boolean equallists(List a1,List b1){
        List a=new LinkedList(a1);
        List b=new LinkedList(b1);
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
        int[] candidates={3,1,3,5,1,1};
        int target=8;
        List<List<Integer>> res=combinationSum2(candidates,target);
        System.out.println(res);
    }
}







class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        dfs(result, candidates, target, new ArrayList<>(), 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, int[] candidates, int remaining, List<Integer> list, int index) {
        if (remaining == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i == index || candidates[i] != candidates[i - 1]) {
                if (candidates[i] > remaining) {
                    break;
                }
                list.add(candidates[i]);
                dfs(result, candidates, remaining - candidates[i], list, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
