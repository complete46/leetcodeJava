package tree;
import java.util.Arrays;
public class Candy {
	public int candy(int[] ratings) {
        int[] can = new int[ratings.length];
        
        Arrays.fill(can, 1);
        
        for (int i = 1; i < can.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                can[i] = can[i - 1] + 1;
            }
        }
        
        for (int i = can.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && can[i] <= can[i + 1]) {
                can[i] = can[i + 1] + 1;
            }
        }
        
        int sum = 0;
        for (int i : can) {
            sum += i;
        }
        
        return sum;
    }
}
