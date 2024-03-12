/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-03-12
 */
public class Gas_Station_134 {
    /**
     * @param gas the amount of gas at the ith station is gas[i]
     * @param cost costs cost[i] of gas to travel from the ith station to its next (i + 1)th station
     * @return int - the starting gas station's index if you can travel around the circuit once
     * @implSpec There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
     * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.
     * Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique
     * @author Brian Qu
     * @since 2024-03-12 18:06
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalTank = 0, curTank = 0, startIndex = 0;
        for (int i = 0; i <= gas.length - 1; i++) {
            totalTank += gas[i] - cost[i];
            curTank += gas[i] - cost[i];
            if (curTank < 0) {
                curTank = 0;
                startIndex = i + 1;
            }
        }

        return totalTank >= 0 ? startIndex : -1;
    }
}
