package greedy;

public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length == 0 || cost.length == 0 || gas.length != cost.length) {
            return -1;
        }
        
        int sum = 0;
        int total = 0;
        
        int p = 0;
        
        for (int i = 0; i < gas.length; i++) {
            sum += (gas[i] - cost[i]);
            total += (gas[i] - cost[i]);
            
            if (sum < 0) {
                sum = 0;
                p = i + 1;
            }
        }
        
        return total >= 0 ? p : -1;
    }
}
