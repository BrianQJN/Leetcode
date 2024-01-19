import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-01-19
 */
public class Course_Schedule_207 {
    /**
     * @param numCourses the number of courses you have to take
     * @param prerequisites an array indicates the prerequisite of courses
     * @return boolean - return true if you can finish all courses, otherwise, return false
     * @implSpec There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
     * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
     * Return true if you can finish all courses. Otherwise, return false.
     * @author Brian Qu
     * @since 2024-01-19 16:48
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();

        // create graph and compute in-degrees
        for (int[] pair : prerequisites) {
            inDegree[pair[0]]++;
        }

        // initialize queue with courses having zero in-degrees
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // process the queue
        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;

            for (int[] pair : prerequisites) {
                if (pair[1] == course) {
                    inDegree[pair[0]]--;
                    if (inDegree[pair[0]] == 0) {
                        queue.add(pair[0]);
                    }
                }
            }
        }

        return count == numCourses;
    }
}
