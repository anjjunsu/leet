// WIP

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int length = gas.length;

        for (int startIdx = 0; startIdx < length; startIdx++) {

            if (gas[startIdx] < cost[startIdx])
                continue;

            int count = 1;
            int tank = gas[startIdx] - cost[startIdx];
            int idx = startIdx + 1;

            while (true) {
                if (count == length)
                    return startIdx;

                if (idx == length) 
                    idx -= length;

                tank = tank + gas[idx] - cost[idx];

                if (tank < 0)
                    break;

                count++;
                idx++;
            }
        }

        return -1;
    }
}
