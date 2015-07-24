import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeInterval {

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

	public List<Interval> merge(List<Interval> intervals) {
		if (intervals == null || intervals.size() == 0) {
			return intervals;
		}
		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				if (i1.start - i2.start != 0) {
					return i1.start - i2.start;
				} else {
					return i1.end - i2.end;
				}
			}
		});

		List<Interval> res = new ArrayList<Interval>();
		res.add(intervals.get(0));
		for (int i = 1; i < intervals.size(); i++) {
			Interval item1 = intervals.get(i);
			Interval item2 = res.get(res.size() - 1);
			if (item1.start > item2.end) {
				res.add(item1);
			} else {
				if (item1.end > item2.end) {
					item2.end = item1.end;
				} else {
					continue;
				}
			}
		}

		return res;
	}
	
	public static void main(String[] args) {
		MergeInterval mer = new MergeInterval();
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(mer.new Interval(1, 3));
		intervals.add(mer.new Interval(2, 6));
		intervals.add(mer.new Interval(8, 10));
		intervals.add(mer.new Interval(15, 18));

		List<Interval> res = mer.merge(intervals);
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i).start + " " + res.get(i).end);
		}
	}
}
