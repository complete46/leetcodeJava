import java.util.List;
import java.util.ArrayList;

public class InsertInterval {
	class Interval {
		int start;
		int end;
		Interval() {
			start = 0;
			end = 0;
		}
		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}
	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<Interval>();
        if (intervals.size() == 0) {
            res.add(newInterval);
            return res;
        }
        
        int i = 0;
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            res.add(intervals.get(i));
            i++;
        }
        if (i < intervals.size()) {
            newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
        }
        res.add(newInterval);
        
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
            i++;
        }
        while (i < intervals.size()) {
            res.add(intervals.get(i));
            i++;
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<Interval>();
		InsertInterval ii = new InsertInterval();
		intervals.add(ii.new Interval(1, 2));
		intervals.add(ii.new Interval(3, 5));
		intervals.add(ii.new Interval(6, 7));
		intervals.add(ii.new Interval(8, 10));
		intervals.add(ii.new Interval(12, 16));
		Interval x = ii.new Interval(4, 9);
		List<Interval> res = insert(intervals, x);
		for (Interval i : res) {
			System.out.println(i.start + " " + i.end);	
		}
	}
}
