package hashtable;

import java.util.HashMap;

public class MaxPoints {
	class Point {
		int x;
		int y;

		Point() {
			x = 0;
			y = 0;
		}

		Point(int a, int b) {
			x = a;
			y = b;
		}
	}

	public int maxPoints(Point[] points) {
		int l = points.length;
		if (l < 3) {
			return l;
		}

		int gMax = 0;
		for (int i = 0; i + 1 < l; i++) {
			HashMap<Double, Integer> map = new HashMap<Double, Integer>();
			int lMax = 1;
			int dup = 0;
			for (int j = i + 1; j < l; j++) {
				if (points[i].x == points[j].x && points[i].y == points[j].y) {
					dup++;
				} else {
					double dx = points[i].x - points[j].x;
					double dy = points[i].y - points[j].y;
					double slope = (dx == 0) ? Integer.MAX_VALUE
							: (0.0 + dy / dx);

					if (!map.containsKey(slope)) {
						map.put(slope, 1);
					}

					map.put(slope, map.get(slope) + 1);
					lMax = Math.max(lMax, map.get(slope));
				}
			}
			gMax = Math.max(gMax, lMax + dup);
		}
		return gMax;
	}
	
	public static void main(String[] args) {
		MaxPoints mx = new MaxPoints();
		Point[] pts = new Point[3];
		pts[0] = mx.new Point(2, 3);
		pts[1] = mx.new Point(3, 3);
		pts[2] = mx.new Point(-5, 3);
		System.out.println(-0.0 + 0.0);
		System.out.println(mx.maxPoints(pts));
	}
}
