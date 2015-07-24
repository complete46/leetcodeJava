import java.util.List;
import java.util.ArrayList;

public class PascalTriangle {
	public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (numRows < 1) {
        	return res;
        }
        
        List<Integer> item = new ArrayList<Integer>();
        item.add(1);
        res.add(item);
        numRows--;
        while (numRows-- > 0) {
        	List<Integer> a = res.get(res.size() - 1);
        	List<Integer> b = new ArrayList<Integer>();
        	b.add(1);
        	for (int i = 0; i < a.size() - 1; i++) {
        		b.add(a.get(i) + a.get(i + 1));
        	}
        	b.add(1);
        	res.add(b);
//        	for (int j : b) {
//        		System.out.print(j + " ");
//        		System.out.println();
//        	}
        }
        
        return res;
	}
	
	public static void main(String[] args) {
		List<List<Integer>> res = generate(10);
		for (List<Integer> i : res) {
			for (int j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}
}
