import java.util.ArrayList;
import java.util.List;
class Interval implements Comparable<Interval>{
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }

    @Override
    public int compareTo(Interval o) {
        return this.start-o.start;
    }
}
public class merge_interval {
    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals.isEmpty())
            return new ArrayList<Interval>();
        int max=intervals.get(0).end;
        int min=intervals.get(0).start;
        for (Interval x:intervals){
            if (x.end>max)
                max=x.end;
            if (x.start<min)
                min=x.start;
        }
        int[] nums=new int[max-min+3];
        for (Interval x:intervals){
            for (int i = x.start; i <x.end+1 ; i++) {
                nums[i-min+1]=1;
            }
        }
        List<Interval> res=new ArrayList<>();
        int end=0,start=0;
        for (int i = 1; i <max-min+3 ; i++) {
            if (nums[i-1]==0&&nums[i]==1)
                start=i+min-1;
            if (nums[i]==1&&nums[i+1]==0)
            {
                end=i+min-1;
                res.add(new Interval(start,end));
            }

        }
        return res;
    }

    public static void main(String[] args) {
        List<Interval> oral=new ArrayList<>();
        oral.add(new Interval(1,3));
        oral.add(new Interval(2,6));
        oral.add(new Interval(8,10));
        oral.add(new Interval(15,18));
        List<Interval> res=merge(oral);
        for (Interval x:res){
            System.out.print(x.start);
            System.out.println(x.end);
        }
    }
}
