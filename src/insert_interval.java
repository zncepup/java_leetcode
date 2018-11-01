import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class insert_interval {
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res=new ArrayList<>();
        for (Interval x:intervals){
            if (location(newInterval,x)==1)
                res.add(x);
            if (location(newInterval,x)==0)
                newInterval=new Interval(Math.min(x.start,newInterval.start),Math.max(newInterval.end,x.end));
        }
        res.add(newInterval);
        List<Interval> res1=new ArrayList<>();
        Collections.sort(res);
        return res;
    }
    public static int location(Interval newi,Interval is){
        if (is.end<newi.start)
            return 1;
        if (is.start>newi.end)
            return 1;
        return 0;
    }
}

//class Solution {
//    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
//        List<Interval> merged = new ArrayList<Interval>();
//        if (intervals == null || newInterval == null)
//            return intervals;
//        int insertPos = 0;
//        while (insertPos < intervals.size() && intervals.get(insertPos).start < newInterval.start) {
//            insertPos++;
//        }
//        intervals.add(insertPos, newInterval);
//        Interval prev = null;
//        for (int i = 0; i < intervals.size(); i++) {
//            if (prev == null || intervals.get(i).start > prev.end) {
//                merged.add(intervals.get(i));
//                prev = intervals.get(i);
//            } else {
//                prev.end = Math.max(intervals.get(i).end, prev.end);
//            }
//        }
//        return merged;
//    }
//}
