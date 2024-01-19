import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-01-19
 */
public class Course_ScheduleII_210 {
    /**
     * @param numCourses the number of courses you have to take
     * @param prerequisites the array of prerequisites of courses
     * @return int[] the order of courses you should take to finish all courses
     * @implSpec There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
     * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
     * Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
     * @author Brian Qu
     * @since 2024-01-19 17:49
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegrees = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();

        // create graph and compute in-degrees
        for (int[] prerequisite : prerequisites) {
            inDegrees[prerequisite[0]]++;
        }

        // add the course with 0 in-degrees to queue
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                queue.add(i);
            }
        }

        int count = 0;
        int[] res = new int[numCourses];
        // process the queue
        while (!queue.isEmpty()) {
            int course = queue.poll();
            res[count++] = course;

            for (int[] prerequisite : prerequisites) {
                if (prerequisite[1] == course) {
                    inDegrees[prerequisite[0]]--;
                    if (inDegrees[prerequisite[0]] == 0) {
                        queue.add(prerequisite[0]);
                    }
                }
            }
        }

        return count == numCourses ? res : new int[0];
    }
}
