import java.util.Arrays;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2023-12-27
 */
public class car_fleet_853 {
    /**
     * @implSpec There are n cars going to the same destination along a one-lane road. The destination is target miles away.
     * You are given two integer array position and speed, both of length n, where position[i] is the position of the ith car and speed[i] is the speed of the ith car (in miles per hour).
     * A car can never pass another car ahead of it, but it can catch up to it and drive bumper to bumper at the same speed. The faster car will slow down to match the slower car's speed. The distance between these two cars is ignored (i.e., they are assumed to have the same position).
     * A car fleet is some non-empty set of cars driving at the same position and same speed. Note that a single car is also a car fleet.
     * If a car catches up to a car fleet right at the destination point, it will still be considered as one car fleet.
     * Return the number of car fleets that will arrive at the destination.
     * @author Brian Qu
     * @param target the miles of destination
     * @param position the position of the ith car
     * @param speed the speed of the ith car
     * @return int - the number of car fleets that will arrive at the destination
     * @since 2023-12-27 21:11
     */
    public int carFleet(int target, int[] position, int[] speed) {
        // initialization
        int n = position.length;
        Car[] cars = new Car[n];
        int fleets = 0;
        double curMaxTime = 0;

        // create and populate the car objects
        for (int i = 0; i < n; i++) {
            cars[i] = new Car(position[i], (double) (target - position[i]) / speed[i]);
        }

        // sort the car objects by their starting position in descending order
        Arrays.sort(cars, (a, b) -> Integer.compare(b.position, a.position));

        // Iterate through sorted cars
        for (Car car: cars) {
            if (car.time > curMaxTime) {
                fleets++;
                curMaxTime = car.time;
            }
        }

        return fleets;
    }


    public static class Car {
        public int position;
        public double time;

        public Car(int position, double time) {
            this.position = position;
            this.time = time;
        }
    }
}
